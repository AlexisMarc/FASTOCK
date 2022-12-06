import React, { Component, } from 'react';
import { DataTable } from 'primereact/datatable';
import { Column } from 'primereact/column';
import { InputText } from 'primereact/inputtext';
import { FilterMatchMode } from 'primereact/api';
import axios from 'axios';
import Select from 'react-select'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faClose, faEdit, faEye, faPlus, faTrashAlt } from '@fortawesome/free-solid-svg-icons';
import Validacion from '../../Utils/Validacion';
import { Alert, Badge, Button, Col, FormFeedback, FormGroup, FormText, Input, Label, ListGroup, ListGroupItem, Modal, ModalBody, ModalFooter, ModalHeader, Row } from 'reactstrap';
import { autorizacion, baseUrl, autorizacionFiles } from '../../Utils/Api';
import swal from 'sweetalert';


import 'primeicons/primeicons.css';
import 'primereact/resources/themes/lara-light-indigo/theme.css';
import 'primereact/resources/primereact.css';
import 'primeflex/primeflex.css';

//URL PRINCIPAL
const url = baseUrl + 'insumo/';

export default class Insumo extends Component {

    validacion = new Validacion();

    //DATOS 
    state = {}

    //CONSTRUCTOR
    constructor(props) {
        super(props);
        this.state = {
            img: baseUrl + "files/error.png",
            profileImg: baseUrl + "files/error.png",
            data: [],
            files: null,
            modalInsertarInsumo: false,
            modalEditarInsumo: false,
            modalInsertarTipo: false,
            modalInsertarProveedor: false,
            modalViewInsumo: false,
            insumo: {
                nombre: '',
                material: '',
                proveedor: null,
                imagen: null,
                tipo: [],
            },
            editInsumo: {
                id: '',
                nombre: '',
                material: '',
                imagen: null,
                tipo: [],
                proveedor: null,
                estado: '',
                idProveedor: '',
                inventario: null,
            },
            valid: {
                nombre: null,
                material: null,
                tipo: null,
                proveedor: null
            },
            validTipo: {
                nombre: null,
            },
            validProveedor: {
                nombre: null,
                direccion: null, 
                contacto:null, 
                telefono: null, 
                email: null
            },
            mensaje: {
                nombre: null,
                material: null,
                tipo: null,
                proveedor:null
            },
            mensajeTipo: {
                nombre: null,
                tipo: null,
            },
            
            mensajeProveedor: {
                nombre: null,
                direccion: null, 
                contacto:null, 
                telefono: null, 
                email: null
            },
            button: true,
            buttonTipo: true,
            tipo: {
                id: '',
                nombre: ''
            },
            button: true,
            buttonProveedor: true,
            proveedor: {
                id:'',
                nombre: '',
                direccion: '', 
                contacto:'', 
                telefono: '', 
                email: ''
            },
            customers: null,
            selectedCustomers: null,
            filters: {
                'global': { value: null, matchMode: FilterMatchMode.CONTAINS }
            },
            globalFilterValue: '',
            loading: true
        }
        this.cities = [
            { value: 'chocolate', label: 'Chocolate' },
            { value: 'strawberry', label: 'Strawberry' },
            { value: 'vanilla', label: 'Vanilla' }
        ];
        this.Botones = this.Botones.bind(this);
        this.onGlobalFilterChangeInsumo = this.onGlobalFilterChangeInsumo.bind(this);
    }

    //PETICION GET
    peticionGetInsumo = () => {
        axios.get(url, autorizacion).then(response => {
            this.setState({ data: response.data, loading: false });
        }).catch(error => {
            console.log(error.message);
            this.setState({ loading: false });
            swal({ title: "ERROR AL CONSULTAR", text: " ", icon: "error", buttons: false, timer: 1500 })
        })
    }

    //PETICIÓN GET Tipo
    peticionGetTipo = () => {
        axios.get(url + 'tipo/', autorizacion).then(response => {
            const datos = [];

            response.data.forEach((Tipo) => {
                const dato = { value: Tipo.id, label: Tipo.nombre }
                datos.push(dato);
            })

            this.setState({ dataTipos: datos });
        }).catch(error => {
            console.log(error.message);
            swal({ title: "ERROR AL CONSULTAR TIPOS", text: " ", icon: "error", buttons: false, timer: 1500 })
        })
    }

     //PETICIÓN GET Proveedor
     peticionGetProveedor = () => {
        axios.get(baseUrl + 'proveedor/', autorizacion).then(response => {
            const datos = [];

            response.data.forEach((proveedor) => {
                const dato = { value: proveedor.id, label: proveedor.nombre }
                datos.push(dato);
            })

            this.setState({ dataProveedor: datos });
        }).catch(error => {
            console.log(error.message);
            swal({ title: "ERROR AL CONSULTAR PROVEEDORES", text: " ", icon: "error", buttons: false, timer: 1500 })
        })
    }

    //CONVERTIR TIPOS DEL INSUMO
    TiposInsumo = (e) => {
        const datos = [];
        e.forEach((Tipo) => {
            datos.push({ value: Tipo.id, label: Tipo.nombre });
        });
        return datos;
    }

    //CONVERTIR PROVEEDORES DEL INSUMO
    ProveedoresInsumo = (e) => {
        const datos = [];
        e.forEach((Proveedor) => {
            datos.push({ value: Proveedor.id, label: Proveedor.nombre });
        });
        return datos;
    }


    

    //PETICION POST
    peticionPostInsumo = async () => {
        var img = null;
        if (this.state.files != null) {
            var bodyFormData = new FormData();
            bodyFormData.append('files', this.state.files);
            await axios.post(baseUrl + "files/upload", bodyFormData, autorizacionFiles).then(response => {
                img = response.data.message;
            }).catch(error => {
                console.log(error.message);
            })
        }
        console.log(this.state.insumo)
        this.state.insumo.imagen = img;
        console.log( this.state.insumo)
        await axios.post(url, this.state.insumo, autorizacion).then(response => {
            this.modalInsertarInsumo();
            this.peticionGetInsumo();
            swal({ title: "Insumo " + response.data.nombre + " registrado", text: " ", icon: "success", buttons: false, timer: 1500 })

        }).catch(error => {
            console.log(error.message);
            swal({ title: "ERROR AL REGISTRAR", text: " ", icon: "error", buttons: false, timer: 1500 })
        })

    }

    //PETICION POST Tipo
    peticionPostTipo = async () => {

        await axios.post(url + "tipo", this.state.tipo, autorizacion).then(response => {
            this.modalInsertarTipo();
            this.peticionGetTipo();
            swal({ title: "Tipo " + response.data.nombre + " registrado", text: " ", icon: "success", buttons: false, timer: 1500 })
        }).catch(error => {
            console.log(error.message);
            swal({ title: "ERROR AL REGISTRAR TIPO", text: " ", icon: "error", buttons: false, timer: 1500 })
        })

    }
    
    //PETICION POST PROVEEDOR
    peticionPostProveedor = async () => {

        await axios.post(baseUrl + "proveedor", this.state.proveedor, autorizacion).then(response => {
            this.modalInsertarProveedor();
            this.peticionGetProveedor();
            swal({ title: "Proveedor " + response.data.nombre + " registrado", text: " ", icon: "success", buttons: false, timer: 1500 })
        }).catch(error => {
            console.log(error.message);
            swal({ title: "ERROR AL REGISTRAR PROVEEDOR", text: " ", icon: "error", buttons: false, timer: 1500 })
        })

    }

    //PETICION PUT
    peticionPutInsumo = async () => {
        var img = this.state.editInsumo.imagen;
        if (this.state.files != null) {
            var bodyFormData = new FormData();
            bodyFormData.append('files', this.state.files);
            await axios.post(baseUrl + "files/upload", bodyFormData, autorizacionFiles).then(response => {
                img = response.data.message;
            }).catch(error => {
                console.log(error.message);
            })
        }
        this.state.editInsumo.imagen = img;
        const lista = [];
        this.state.editInsumo.tipo.forEach((e) => {
            if (e.id != null) {
                lista.push(e.id)
            } else {
                lista.push(e)
            }
        });
        this.state.editInsumo.Tipo = lista;

        delete this.state.editInsumo.inventario;
        console.log(this.state.editInsumo)
        await axios.put(url + this.state.editInsumo.id, this.state.editInsumo, autorizacion).then(response => {
            this.peticionGetInsumo();
            this.modalEditarInsumo();

            swal({ title: "Insumo " + response.data.nombre + " editado", text: " ", icon: "success", buttons: false, timer: 1500 })
        }).catch(error => {
            console.log(error.message);
            swal({ title: "ERROR AL EDITAR", text: " ", icon: "error", buttons: false, timer: 1500 })
        })
    }

    //PASAR CATEGORIA
    pasarProveedor = (proveedor) => {
        this.setState({
            datosProveedor: {
                nombre: proveedor.nombre,
            }
        })
    }

    //PETICIÓN ESTADO
    peticionEstadoInsumo = (insumo) => {
        axios.put(url + 'estado/' + insumo.id, this.state.editInsumo, autorizacion).then(response => {
            this.peticionGetInsumo();
            swal({ title: "Insumo " + response.data.nombre + " eliminado", text: " ", icon: "success", buttons: false, timer: 1500 })
        }).catch(error => {
            console.log(error.message);
            swal({ title: "ERROR AL ELIMINAR", text: " ", icon: "error", buttons: false, timer: 1500 })
        })
    }

    //CAMBIO DE VALIDACIONES
    validFalse = () => {
        this.setState({
            button: true, valid: {
                nombre: null,
                tipo: null,
            }
        });
    }
    //MODAL DE INSERTAR
    modalInsertarInsumo = () => {
        this.setState({ modalInsertarInsumo: !this.state.modalInsertarInsumo });
        this.validFalse();
    }

    //MODAL DE INSERTAR TIPO
    modalInsertarTipo = () => {
        this.setState({ modalInsertarTipo: !this.state.modalInsertarTipo });
    }
    //MODAL DE INSERTAR TIPO
    modalInsertarProveedor = () => {
        this.setState({ modalInsertarProveedor: !this.state.modalInsertarProveedor });
    }


    //MODAL DE EDITAR
    modalEditarInsumo = () => {
        this.setState({
            modalEditarInsumo: !this.state.modalEditarInsumo, files: null,
            valid: {
                nombre: false,
                tipo: false,
            },
            button: true,
        });
    }

    //MODAL DE VIEW
    modalViewInsumo = () => {
        this.setState({ modalViewInsumo: !this.state.modalViewInsumo });
    }

    //SELECCIONAR INSUMO PARA EDICIÓN
    seleccionarInsumo = (insumo) => {
        console.log(insumo)
        this.setState({
            editInsumo: {
                id: insumo.id,
                nombre: insumo.nombre,
                material: insumo.material,
                inventario: insumo.inventario,
                imagen: insumo.imagen,
                tipo: insumo.tipo,
                estado: insumo.estado,
                proveedor: insumo.proveedor,
                idProveedor: insumo.idProveedor,

            }
        })
    }
    //SELECCIONAR PROVEEDOR PARA EDICIÓN
    seleccionarProveedor = (proveedor) => {
        this.setState({
            editForm: {
                id: proveedor.id,
                nombre: proveedor.nombre,
                contacto: proveedor.contacto,
                telefono: proveedor.telefono,
                direccion: proveedor.direccion,
                email: proveedor.email,
                estado: proveedor.estado
            }
        })
    }
    //SELECCIONAR PROVEEDOR PARA EDICIÓN
    seleccionarTipo = (tipo) => {
        this.setState({
            editForm: {
                id: tipo.id,
                nombre: tipo.nombre,
                filtro: tipo.filtro
            }
        })
    }

    //PASAR Tipo
    pasarTipo = (Tipo) => {
        this.setState({
            datosTipo: {
                nombre: Tipo.nombre,
                filtro: Tipo.filtro
            }
        })
    }

     //PASAR PROVEEDOR
     pasarProveedor = (Proveedor) => {
        this.setState({
            datosProveedor: {
                nombre: Proveedor.nombre,
                contacto: Proveedor.contacto,
                telefono: Proveedor.telefono,
                direccion: Proveedor.direccion,
                email: Proveedor.email,
                estado: Proveedor.estado
                
            }
        })
    }

    

    //INGRESO DE DATOS AL FORM
    handleChangeInsumo = async e => {
        e.persist();
        const valid = this.validacion.valid(e.target.name, e.target.value);
        const mensaje = this.validacion.mensaje(e.target.name, e.target.value);
        await this.setState({
            insumo: {
                ...this.state.insumo,
                [e.target.name]: e.target.value
            }
                ,
            valid: {
                ...this.state.valid,
                [e.target.name]: valid,
            },
            mensaje: {
                ...this.state.mensaje,
                [e.target.name]: mensaje,
            }
        });
        this.ValidButton();
        console.log(this.state.insumo);
    }

    //INGRESO DE DATOS DE TIPOD AL INSUMO
    handleChangeTipo = async (e) => {

        const lista = []
        e.forEach((e) => { lista.push(e.value) });
        const valid = this.validacion.valid("tipo", e);
        const mensaje = this.validacion.mensaje("tipo", e);
        await this.setState({
            insumo: {
                ...this.state.insumo,
                tipo: lista
            },
            valid: {
                ...this.state.valid,
                tipo: valid,
            },
            mensaje: {
                ...this.state.mensaje,
                tipo: mensaje,
            }
        });
        this.ValidButton();

        console.log(this.state.insumo);
    }

    //INGRESO DE DATOS DE PRODUCTO AL INSUMO
    handleChangeProveedor = async (e) => {
        console.log(e)
        const valid = this.validacion.valid("proveedor", e);
        const mensaje = this.validacion.mensaje("proveedor", e);
        await this.setState({
            insumo: {
                ...this.state.insumo,
                proveedor: e.value
            },
            valid: {
                ...this.state.valid,
                proveedor: valid,
            },
            mensaje: {
                ...this.state.mensaje,
                proveedor: mensaje,
            }
        });
        this.ValidButton();

        console.log(this.state.insumo);
    }

    //INGRESO DE DATOS DE ESPECIALIDAD 
    handleChangeInsertarProveedorp = async (e) => {
        e.persist();
        const valid = this.validacion.valid("proveedor", e);
        const mensaje = this.validacion.mensaje("proveedor", e);
        await this.setState({
            proveedor: {
                ...this.state.proveedor,
                [e.target.name]: e.target.value
            }, 
            validProveedor: {
                ...this.state.validProveedor,
                proveedor: valid,
            },
            mensajeProveedor: {
                ...this.state.mensajeProveedor,
                proveedor: mensaje,
            }
            
        });
        this.ValidButtonProveedor();
        console.log(this.state.proveedor);
    }
    

    //BOTON DESABILITADO DE REGISTRAR
    ValidButton = () => {
        delete this.state.valid.imagen;
        this.setState({
            button: this.validacion.ValidButton(this.state.valid),
        });
    }
    //BOTON DESABILITADO DE REGISTRAR
    ValidButtonTipo = () => {
        this.setState({
            buttonTipo: this.validacion.ValidButton(this.state.validTipo),
        });
    }

    //BOTON DESABILITADO DE REGISTRAR
    ValidButtonProveedor = () => {
        this.setState({
            buttonProveedor: this.validacion.ValidButton(this.state.validProveedor),
        });
    }
    //INGRESO DE FILES
    handleChangeFiles = (e) => {
        this.setState({
            files: e.target.files[0],
        })
    }


    //INGRESO DE DATOS DE TIPO AL EDITINSUMO
    handleChangeEditTipo = async (e) => {

        const lista = []
        const valid = this.validacion.valid("tipo", e);
        const mensaje = this.validacion.mensaje("tipo", e);
        e.forEach((e) => { lista.push(e.value) });
        console.log(lista)
        await this.setState({
            insumo: {
                ...this.state.insumo,
                tipo: lista
            },
            valid: {
                ...this.state.valid,
                tipo: valid,
            },
            mensaje: {
                ...this.state.mensaje,
                tipo: mensaje,
            }
        });
        this.ValidButton();

        console.log(this.state.editInsumo);
    }

     //INGRESO DE DATOS AL EDITFORM
     handleChangeEditProveedor = async e => {
        e.persist();
        const valid = this.validacion.valid(e.target.name, e.target.value);
        const mensaje = this.validacion.mensaje(e.target.name, e.target.value);
        await this.setState({
            proveedor: {
                ...this.state.proveedor,
                [e.target.name]: e.target.value
            },
            valid: {
                ...this.state.valid,
                [e.target.name]: valid,
            },
            mensaje:{
                ...this.state.mensaje,
                [e.target.name]: mensaje,
            },
        });
        this.ValidButton();
        console.log(this.state.proveedor);
    }

    
    
    //INGRESO DE DATOS DE Tipo 
    handleChangeInsertarTipo = async (e) => {
        e.persist();
        const valid = this.validacion.valid(e.target.name, e.target.value);
        const mensaje = this.validacion.mensaje(e.target.name, e.target.value);
        await this.setState({
            tipo: {
                ...this.state.tipo,
                [e.target.name]: e.target.value
            },
            valid: {
                ...this.state.validTipo,
                [e.target.name]: valid,
            },
            mensaje: {
                ...this.state.mensajeTipo,
                [e.target.name]: mensaje,
            },
        });
        this.ValidButtonTipo();

        console.log(this.state.tipo);
    }


    //INGRESO DE DATOS AL EDITINSUMO
    handleChangeInsumoEditInsumo = async e => {
        e.persist();
        const valid = this.validacion.valid(e.target.name, e.target.value);
        const mensaje = this.validacion.mensaje(e.target.name, e.target.value);
        await this.setState({
            editInsumo: {
                ...this.state.editInsumo,
                [e.target.name]: e.target.value
            },
            valid: {
                ...this.state.valid,
                [e.target.name]: valid,
            },
            mensaje: {
                ...this.state.mensaje,
                [e.target.name]: mensaje,
            }
        });
        this.ValidButton();
        console.log(this.state.editInsumo);
    }

    //FUNCION DE ARRANQUE
    componentDidMount() {
        this.peticionGetInsumo();
        this.peticionGetTipo();
        this.peticionGetProveedor();
    };


    //RENDERIZAR IMAGEN
    Imagen(Insumo) {
        return <div >
            {Insumo.imagen
                ? <img src={baseUrl + "files/" + Insumo.imagen} style={{ "width": "45px", "borderRadius": "10%" }} alt={Insumo.id} />
                : <img src={baseUrl + "files/error.png"} style={{ "width": "45px", "borderRadius": "10%" }} alt={Insumo.id} />
            }
        </div>;
    }

    //RENDERIZAR INVENTARIO
    Inventario(Insumo) {
        return <div>
            <h5>{!Insumo.inventario ? <Badge color="primary"> Tiene inventario</Badge> : <Badge color="danger">Sin inventario</Badge>}</h5>
        </div>;
    }

    //RENDERIZAR PROVEEDOR
    Inventario(Insumo) {
        return <div>
            <h5>{!Insumo.proveedor ? <Badge color="primary"> Tiene proveedor</Badge> : <Badge color="danger">Sin proveedor</Badge>}</h5>
        </div>;
    }

    //RENDERIZAR VISIBLE
    Visible(Insumo) {
        return <div >
            <h5>{Insumo.visible ? <Badge color="primary"> Es visible</Badge> : <Badge color="danger">No visible</Badge>}</h5>
        </div>;
    }

    //RENDERIZAR BOTONES
    Botones(Insumo) {
        return <div className="btn-group btn-group-sm" role="group">
            <button value={Insumo.id} className='btn btn-primary' onClick={() => { swal({ title: "¿Desea editar al Insumo " + Insumo.nombre + "?", icon: "warning", buttons: ["Cancelar", "Editar"], dangerMode: true, }).then((respuesta) => { if (respuesta) { this.seleccionarInsumo(Insumo); this.modalEditarInsumo() } }); }}><FontAwesomeIcon icon={faEdit} /></button>
            <button className='btn btn-info' onClick={() => { this.seleccionarInsumo(Insumo); this.modalViewInsumo() }} ><FontAwesomeIcon icon={faEye} /></button>
            <button className='btn btn-danger' onClick={() => { swal({ title: "¿Desea eliminar al Insumo " + Insumo.nombre + "?", icon: "warning", buttons: ["Cancelar", "Eliminar"], dangerMode: true, }).then((respuesta) => { if (respuesta) { this.peticionEstadoInsumo(Insumo) } }); }}><FontAwesomeIcon icon={faTrashAlt} /></button>
        </div>;
    }

    //FILTRADO GLOBAL
    onGlobalFilterChangeInsumo(e) {
        const value = e.target.value;
        let filters = { ...this.state.filters };
        filters['global'].value = value;
        console.log(value)
        this.setState({ filters, globalFilterValue: value });
    }

    //RENDERIZAR ENCABEZADO DE LA DATATABLE
    renderHeaderInsumo() {
        return (
            <React.Fragment>
                <div className="flex justify-content-between align-items-center">
                    <h5 className="m-0 h5"> </h5>
                    <span className="p-input-icon-left">
                        <i className="pi pi-search" />
                        <InputText value={this.state.globalFilterValue} onChange={this.onGlobalFilterChangeInsumo} placeholder="Buscar" />
                    </span>
                </div>
            </React.Fragment>
        )
    }
    //ARCHIVO
    imageHandler = (e) => {
        this.setState({ button: false, editInsumo: { ...this.state.editInsumo, imagen: null, } });
        this.handleChangeFiles(e);
        const reader = new FileReader();
        reader.onload = () => {
            if (reader.readyState === 2) {
                this.setState({ profileImg: reader.result })
            }
        }
        reader.readAsDataURL(e.target.files[0])
    };

    render() {
        const { editInsumo, data, dataTipos, dataProveedor, profileImg } = this.state;
        const header = this.renderHeaderInsumo();
        const toggle = () => this.modalInsertarInsumo();
        const toggle2 = () => this.modalEditarInsumo();
        const toggle3 = () => this.modalViewInsumo();
        const toggle4 = () => this.modalInsertarTipo();
        const toggle5 = () => this.modalInsertarProveedor();
        return (
            <div className="datatable-doc-demo">
                <div className="flex justify-content-between align-items-center">
                    <h5 className="m-0 h5">Insumo</h5>
                    <button className='btn btn-primary' onClick={() => { this.setState({ insumo: {}, files: null, profileImg: this.state.img }); this.modalInsertarInsumo() }} ><FontAwesomeIcon icon={faPlus} style={{ "marginRight": "1rem" }} /><span className='menu-title'>Agregar</span></button>
                </div>
                <br />
                <div className='card'>
                    <DataTable className='table-hover' value={data} header={header} responsiveLayout="stack"
                        dataKey="id" selection={this.state.selectedCustomers} onSelectionChange={e => this.setState({ selectedCustomers: e.value })}
                        filters={this.state.filters} loading={this.state.loading}
                        paginatorTemplate="FirstPageLink PrevPageLink PageLinks NextPageLink LastPageLink CurrentPageReport RowsPerPageDropdown"
                        breakpoint="800px" paginator rows={10} rowsPerPageOptions={[10, 25, 50]} emptyMessage="Insumos no encontrados..."
                        currentPageReportTemplate="Registro {first} - {last} de {totalRecords} Insumos">
                        <Column header="Imagen" body={this.Imagen} />
                        <Column field="nombre" header="Nombre" />
                        <Column field='material' header="Material"/>
                        <Column header="Inventario" body={this.Inventario} />
                        <Column header="Botones" body={this.Botones} />

                    </DataTable>
                </div>

                {/* MODAL DE REGISTRAR */}
                <Modal isOpen={this.state.modalInsertarInsumo} toggle={() => { toggle(); this.setState({ profileImg: this.state.img }) }} size="lg" >
                    <ModalHeader>
                        <span>Agregar Insumo</span>
                        <button type="button" className="close" onClick={() => { this.setState({ profileImg: this.state.img }); this.modalInsertarInsumo(); }}>
                            <FontAwesomeIcon icon={faClose} />
                        </button>

                    </ModalHeader>

                    <ModalBody>

                        <FormGroup>
                            <Row>
                                <Col md={6}>
                                    <Label htmlFor='imagen'>Imagen:</Label>
                                    <div className="custom-file">
                                        <input className='custom-file-input' type="file" name="files" accept="image/*" onChange={this.imageHandler} />
                                        <label data-browse="Seleccionar" className="custom-file-label" htmlFor="customFile">Seleccionar imagen...</label>
                                    </div>
                                    <img src={profileImg} alt="cargado" style={{ "width": "100%", "borderRadius": "0px 0px 10px 10px", "padding": "20px 20px 0px 20px" }} />
                                </Col>
                                <Col md={6}>
                                    <Label htmlFor='nombre'>Nombre:</Label>
                                    <Input valid={this.state.valid.nombre == null ? false : !this.state.valid.nombre} invalid={this.state.valid.nombre} type='text' name='nombre' id='nombre' onChange={this.handleChangeInsumo} />
                                    <FormText>
                                        Nombre del Insumo.
                                    </FormText>
                                    <FormFeedback>
                                        {this.state.mensaje.nombre}
                                    </FormFeedback>
                                    <Label htmlFor='material'>Material:</Label>
                                    <Input valid={this.state.valid.material == null ? false : !this.state.valid.material} invalid={this.state.valid.material} type='text' name='material' id='material' onChange={this.handleChangeInsumo} />
                                    <FormText>
                                        Descripción del Insumo.
                                    </FormText>
                                    <FormFeedback>
                                        {this.state.mensaje.material}
                                    </FormFeedback>
                                    <Label htmlFor='Tipo'>Tipo:</Label>
                                    <br />
                                    <Select className={this.state.valid.tipo === true ? 'invalid-select2 is-invalid' : ''} options={dataTipos} isMulti name='tipo' onChange={this.handleChangeTipo} placeholder="Seleccione los tipos" />
                                    <FormText>
                                        Tipo del Insumo.
                                    </FormText>
                                    <FormFeedback>
                                        {this.state.valid.tipo === true ?

                                            this.state.mensaje.tipo

                                            : ''}
                                    </FormFeedback>
                                    <br />
                                    <button className='btn btn-primary' onClick={() => { this.setState({ tipo: null }); this.modalInsertarTipo() }}>
                                        Agregar Tipo
                                    </button>
                                    <br/>
                                    <br/>
                                    <Label htmlFor='Proovedor'>Proveedor:</Label>
                                    <br />
                                    <Select className={this.state.valid.proveedor === true ? 'invalid-select2 is-invalid' : ''} options={dataProveedor} name='proveedor' onChange={this.handleChangeProveedor} placeholder="Seleccione los proveedores" />
                                    <FormText>
                                        Proveedor del Insumo.
                                    </FormText>
                                    <FormFeedback>
                                        {this.state.valid.proveedor === true ?

                                            this.state.mensajep.proveedor

                                            : ''}
                                    </FormFeedback>
                                    <br />
                                    <button className='btn btn-primary' onClick={() => { this.setState({ proveedor: null }); this.modalInsertarProveedor() }}>
                                        Agregar Proveedor
                                    </button>
                                </Col>
                            </Row>
                        </FormGroup>
                    </ModalBody>

                    <ModalFooter>
                        <Button disabled={this.state.button} color='primary' onClick={() => this.peticionPostInsumo()}>
                            Insertar
                        </Button>
                        <button className='btn btn-danger' onClick={() => { this.setState({ profileImg: this.state.img }); this.modalInsertarInsumo(); }}>
                            Cancelar
                        </button>
                    </ModalFooter>
                </Modal>

                {/* MODAL DE EDITAR */}

                <Modal isOpen={this.state.modalEditarInsumo} toggle={() => { toggle2(); this.setState({ profileImg: this.state.img }) }} size='lg'>
                    <ModalHeader>
                        <span>Agregar Insumo</span>
                        <button type="button" className="close" onClick={() => { this.setState({ profileImg: this.state.img }); this.modalEditarInsumo(); }}>
                            <FontAwesomeIcon icon={faClose} />
                        </button>
                    </ModalHeader>
                    <ModalBody>
                        <FormGroup>
                            <Row>
                                <Col md={6}>
                                    <Label htmlFor='imagen'>Imagen:</Label>
                                    <div className="custom-file">
                                        <input className='custom-file-input' type="file" name="files" accept="image/*" onChange={this.imageHandler} />
                                        <label data-browse="Seleccionar" className="custom-file-label" htmlFor="customFile">Seleccionar imagen...</label>
                                    </div>
                                    <img src={editInsumo.imagen != null ? baseUrl + "files/" + editInsumo.imagen : profileImg} alt="cargado" style={{ "width": "100%", "borderRadius": "0px 0px 10px 10px", "padding": "20px 20px 0px 20px" }} />
                                </Col>
                                <Col md={6}>
                                    <Label htmlFor='nombre'>Nombre:</Label>
                                    <Input valid={this.state.valid.nombre == null ? false : !this.state.valid.nombre} invalid={this.state.valid.nombre} type='text' name='nombre' id='nombre' onChange={this.handleChangeInsumoEditInsumo} value={editInsumo.nombre || ''} />
                                    <FormFeedback>
                                        {this.state.mensaje.nombre}
                                    </FormFeedback>
                                    <FormText>
                                        Nombre del Insumo.
                                    </FormText>

                                    <Label htmlFor='material'>Material:</Label>
                                    <Input valid={this.state.valid.material == null ? false : !this.state.valid.material} invalid={this.state.valid.material} type='text' name='material' id='material' onChange={this.handleChangeInsumoEditInsumo} value={editInsumo.material || ''} />
                                    <FormFeedback>
                                        {this.state.mensaje.material}
                                    </FormFeedback>
                                    <FormText>
                                        Material del Insumo.
                                    </FormText>
                                    <Label htmlFor='Tipo'>Tipo:</Label>
                                    <br />
                                    <Select className={this.state.valid.tipo === true ? 'invalid-select2 is-invalid' : ''} options={dataTipos} isMulti name='Tipo' defaultValue={this.TiposInsumo(editInsumo.tipo)} onChange={this.handleChangeEditTipo} placeholder="Seleccione los tipos" />
                                    <FormText>
                                        Tipo del Insumo.
                                    </FormText>
                                    <FormFeedback>
                                        {this.state.valid.tipo === true ?

                                            this.state.mensaje.tipo

                                            : ''}
                                    </FormFeedback>
                                    <br />
                                    <button className='btn btn-primary' onClick={() => { this.setState({ tipo: null }); this.modalInsertarTipo() }}>
                                        Agregar Tipo
                                    </button>
                                    <br/>
                                    <br/>
                                    <Label htmlFor='Tipo'>Proveedor:</Label>
                                    <br />
                                    <Select className={this.state.valid.proveedor === true ? 'invalid-select2 is-invalid' : ''} options={dataProveedor} name='Proveedor' defaultValue={this.ProveedoresInsumo(editInsumo.tipo)} onChange={this.handleChangeEditProveedor} placeholder="Seleccione los proveedores" />
                                    <FormText>
                                        Proveedor del Insumo.
                                    </FormText>
                                    <FormFeedback>
                                        {this.state.valid.proveedor === true ?

                                            this.state.mensaje.proveedor

                                            : ''}
                                    </FormFeedback>
                                    <br />
                                    <button className='btn btn-primary' onClick={() => { this.setState({ proveedor: null }); this.modalInsertarProveedor() }}>
                                        Agregar Proveedor
                                    </button>
                                </Col>
                            </Row>
                        </FormGroup>
                    </ModalBody>

                    <ModalFooter>
                        <Button disabled={this.state.button} color='primary' onClick={() => this.peticionPutInsumo()}>
                            Editar
                        </Button>

                        <button className='btn btn-danger' onClick={() => this.modalEditarInsumo()}>
                            Cancelar
                        </button>
                    </ModalFooter>
                </Modal>

                {/* MODAL DE VISTA */}
                <Modal isOpen={this.state.modalViewInsumo} toggle={toggle3}>
                    <ModalHeader >
                        <div><br /><h3>Insumo {editInsumo.nombre}</h3></div>
                        <button type="button" className="close" onClick={() => this.modalViewInsumo()}>
                            <FontAwesomeIcon icon={faClose} />
                        </button>
                    </ModalHeader>
                    <ModalBody>
                        <FormGroup>
                            <Row>
                                <Col md={12} >
                                    <ListGroup flush>
                                        <ListGroupItem style={{ "display": "flex", "justifyContent": "center" }}>
                                            {editInsumo.imagen
                                                ? <img src={baseUrl + "files/" + editInsumo.imagen} style={{ "width": "70%", "borderRadius": "10%" }} alt={editInsumo.id} />
                                                : <img src={baseUrl + "files/error.png"} style={{ "width": "70%", "borderRadius": "10%" }} alt={editInsumo.id} />
                                            }

                                        </ListGroupItem>
                                        <ListGroupItem>
                                            <p>Nombre:</p> <h5>{editInsumo.nombre}</h5>
                                        </ListGroupItem>
                                        <ListGroupItem>
                                            <p>Proveedor:</p> <h5>{editInsumo.proveedor ? editInsumo.proveedor : <Badge color="secondary">Sin proveedor</Badge>}</h5>
                                        </ListGroupItem>
                                        <ListGroupItem>
                                            <p>Material:</p> <h5>{editInsumo.material}</h5>
                                        </ListGroupItem>
                                        {/* <ListGroupItem>
                                            <p>Inventario:</p> {!editInsumo.inventario ? <Badge color="primary"> Tiene inventario</Badge> : <Badge color="danger">Sin inventario</Badge>}
                                        </ListGroupItem> */}
                                        <ListGroupItem>
                                            <p>Tipo:</p>
                                            <ListGroup>
                                                {editInsumo.tipo.length > 0 ?
                                                    editInsumo.tipo.map((tipo, index) => {
                                                        return (
                                                            <ListGroupItem key={index}>
                                                                <p >{tipo.nombre}</p>
                                                            </ListGroupItem>
                                                        )
                                                    }) :

                                                    <Alert color="primary">
                                                        No hay tipos registradas con el Insumo
                                                    </Alert>
                                                }
                                            </ListGroup>
                                        </ListGroupItem>
                                    </ListGroup>
                                </Col>
                            </Row>

                        </FormGroup>
                    </ModalBody>

                    <ModalFooter>
                        <button className='btn btn-primary' onClick={() => { this.modalViewInsumo(); }}>
                            Cerrar
                        </button>
                    </ModalFooter>
                </Modal>

                {/* MODAL DE TIPO */}
                <Modal isOpen={this.state.modalInsertarTipo} toggle={toggle4} size="sm" >
                    <ModalHeader>
                        <span>Agregar Tipo</span>
                        <button type="button" className="close" onClick={() => { this.modalInsertarTipo(); }}>
                            <FontAwesomeIcon icon={faClose} />
                        </button>
                    </ModalHeader>

                    <ModalBody>
                        <FormGroup>
                            <Row>
                                <Col md={12}>
                                    <Label htmlFor='nombre'>Nombre:</Label>
                                    <Input valid={this.state.valid.nombre == null ? false : !this.state.valid.nombre} invalid={this.state.valid.nombre} type='text' name='nombre' id='nombre' onChange={this.handleChangeInsertarTipo} />
                                    <FormText>
                                        Nombre del Insumo.
                                    </FormText>
                                    <FormFeedback>
                                        {this.state.mensaje.nombre}
                                    </FormFeedback>
                                </Col>
                            </Row>
                        </FormGroup>
                    </ModalBody>

                    <ModalFooter>
                    <button className='btn btn-primary' onClick={() => this.peticionPostTipo()}>
                            Insertar
                        </button>
                        <button className='btn btn-danger' onClick={() => { this.modalInsertarTipo(); }}>
                            Cancelar
                        </button>
                    </ModalFooter>
                </Modal>

                     {/* MODAL DE REGISTRAR */}
                <Modal isOpen={this.state.modalInsertarProveedor} toggle={toggle5} size='lg'>
                    <ModalHeader toggle={toggle5}>
                        <span>Agregar Proveedor</span>
                        <button type="button" className="close" onClick={() => this.modalInsertarProveedor()}>
                            <FontAwesomeIcon icon={faClose} />
                        </button>

                    </ModalHeader>

                    <ModalBody>

                        <FormGroup>
                            <Row>
                                <Col md={6}>
                                    <Label htmlFor='nombre'>Nombre:</Label>
                                    <Input  valid={this.state.validProveedor.nombre == null ? false : !this.state.validProveedor.nombre} invalid={this.state.validProveedor.nombre} type='text' name='nombre' id='nombre' onChange={this.handleChangeInsertarProveedorp} />
                                    <FormText>
                                            Nombre
                                    </FormText>
                                    <FormFeedback>
                                    {this.state.mensajeProveedor.nombre}
                                    </FormFeedback>
                                </Col>
                                <Col md={6}>
                                    <Label htmlFor='contacto'>Contacto:</Label>
                                    <Input valid={this.state.validProveedor.contacto == null ? false : !this.state.validProveedor.contacto} invalid={this.state.validProveedor.contacto} type='text' name='contacto' id='contacto' onChange={this.handleChangeInsertarProveedorp} />
                                    <FormText>
                                        Contacto
                                    </FormText>
                                    <FormFeedback>
                                    {this.state.mensajeProveedor.contacto}
                                    </FormFeedback>
                                </Col>
                            </Row>
                        </FormGroup>

                        <FormGroup>
                            <Row>
                                <Col md={6}>
                                    <Label htmlFor='direccion'>Dirección:</Label>
                                    <Input valid={this.state.validProveedor.direccion == null ? false : !this.state.validProveedor.direccion} invalid={this.state.validProveedor.direccion} type='text' name='direccion' id='direccion' onChange={this.handleChangeInsertarProveedorp} />
                                    <FormText>
                                        Direccion
                                    </FormText>
                                    <FormFeedback>
                                    {this.state.mensajeProveedor.direccion}
                                    </FormFeedback>
                                </Col>
                                <Col md={6}>
                                    <Label htmlFor='telefono'>Teléfono:</Label>
                                    <Input valid={this.state.validProveedor.telefono == null ? false : !this.state.validProveedor.telefono} invalid={this.state.validProveedor.telefono} type='number' name='telefono' id='telefono' onChange={this.handleChangeInsertarProveedorp} />
                                    <FormText>
                                        Telefono
                                    </FormText>
                                    <FormFeedback>
                                    {this.state.mensajeProveedor.telefono}
                                    </FormFeedback>
                                </Col>
                            </Row>
                        </FormGroup>
                        <FormGroup>
                            <Row>
                                <Col md={12}>
                                    <Label htmlFor='email'>Email:</Label>
                                    <Input valid={this.state.validProveedor.email == null ? false : !this.state.validProveedor.email} invalid={this.state.validProveedor.email} type='email' name='email' id='email' onChange={this.handleChangeInsertarProveedorp} />
                                    <FormText>
                                        Email
                                    </FormText>
                                    <FormFeedback>
                                    {this.state.mensajeProveedor.email}
                                    </FormFeedback>
                                </Col>
                            </Row>
                        </FormGroup>
                    </ModalBody>

                    <ModalFooter>
                        <Button color='primary' onClick={() => this.peticionPostProveedor()}>
                            Insertar
                        </Button>
                        <button className='btn btn-danger' onClick={() => this.modalInsertarProveedor()}>
                            Cancelar
                        </button>
                    </ModalFooter>
                </Modal>
            </div >
        );
    }




}


