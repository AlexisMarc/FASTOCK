import React, { Component } from 'react';
import axios from "axios";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faEdit, faTrashAlt, faClose } from '@fortawesome/free-solid-svg-icons';
import { autorizacion, baseUrl, autorizacionFiles } from '../../Utils/Api';
import { FilterMatchMode, FilterOperator } from 'primereact/api';
import { faEye, faPlus } from '@fortawesome/free-solid-svg-icons';
import Validacion from '../../Utils/Validacion';
import { DataTable } from 'primereact/datatable';
import { Column } from 'primereact/column';
import { Alert, Badge, Button, Collapse, ListGroup, ListGroupItem } from 'reactstrap';
import { Col, FormFeedback, FormGroup, FormText, Input, Label, Modal, ModalBody, ModalFooter, ModalHeader, Row } from 'reactstrap';
import { InputText } from 'primereact/inputtext';
import { MultiSelect } from 'primereact/multiselect';
import Select from 'react-select'
import swal from 'sweetalert';

import 'primeicons/primeicons.css';
import 'primereact/resources/themes/lara-light-indigo/theme.css';
import 'primereact/resources/primereact.css';
import 'primeflex/primeflex.css';

const url = baseUrl + "empresa/";


export default class Empresa extends Component {
    
    validacion = new Validacion();
    //DATOS
    state = {}
    //PETICIÓN GET
    peticionGetEmpresa = () => {
        axios.get(url, autorizacion).then(response => {
            console.log(response)
            this.setState({ data: response.data, loading: false });
        }).catch(error => {
            this.setState({ loading: false });
            swal({ title: "ERROR AL CONSULTAR", text: " ", icon: "error", buttons: false, timer: 1500 })
            console.log(error.message);
        })
    }
    //PETICIÓN GET ESPECIALIDAD
    peticionGetEspecialidad = () => {
        axios.get(url + 'especialidad/' , autorizacion).then(response => {
            const datos = [];
            response.data.map((especialidad) => {
                const dato = { value: especialidad.id, label: especialidad.nombre }
                datos.push(dato);
            })
            this.setState({ dataespecialidad: datos });
        }).catch(error => {
            console.log(error.message);
            swal({ title: "ERROR AL CONSULTAR ESPECIALIDAD", text: " ", icon: "error", buttons: false, timer: 1500 })
        })
    }
     //CONVERTIR ESPECIALIDAD DEL EMPRESA
    especialidadEmpresa = (e) => {
        const datos = [];
        e.forEach((empresa) => {
            datos.push({ value: empresa.id, label: empresa.nombre });
        });
        return datos;
    }
    //PETICIÓN POST
    peticionPostEmpresa = async () => {
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
        this.state.empresa.imagen = img;

        await axios.post(url, this.state.empresa, autorizacion).then(response => {
            this.modalInsertarEmpresa();
            this.peticionGetEmpresa();
            swal({ title: " Empresa " + response.data.nombre + " registrado", text: " ", icon: "success", buttons: false, timer: 1500 })

        }).catch(error => {
            console.log(error.message);
            swal({ title: "ERROR AL REGISTRAR", text: " ", icon: "error", buttons: false, timer: 1500 })
        })
    }
    //PETICION POST ESPECIALIDAD
    peticionPostEspecialidad = async () => {

        await axios.post(url + "especialidad", this.state.especialidad, autorizacion).then(response => {
            this.modalInsertarEspecialidad();
            this.peticionGetEspecialidad();
            swal({ title: "Especialidad " + response.data.nombre + " registrado", text: " ", icon: "success", buttons: false, timer: 1500 })
        }).catch(error => {
            console.log(error.message);
            swal({ title: "ERROR AL REGISTRAR ESPECIALIDAD", text: " ", icon: "error", buttons: false, timer: 1500 })
        })

    }
    //PETICIÓN PUT
    // peticionPutEmpresa = () => {
    //     var img = this.state.editEmpresa.imagen;
    //     axios.put(url + this.state.editEmpresa.id, this.state.editEmpresa, autorizacion).then(response => {
    //         this.modalEditarEmpresa();
    //         this.peticionGetEmpresa();
    //         swal({ title: "Empresa " + response.data.nombre + " editado", text: " ", icon: "success", buttons: false, timer: 1500 })
    //     }).catch(error => {
    //         console.log(error.message);
    //         swal({ title: "ERROR AL EDITAR", text: " ", icon: "error", buttons: false, timer: 1500 })
    //     })
    // }
    peticionPutEmpresa = async () => {
        var img = this.state.editEmpresa.imagen;
        if (this.state.files != null) {
            var bodyFormData = new FormData();
            bodyFormData.append('files', this.state.files);
            await axios.post(baseUrl + "files/upload", bodyFormData, autorizacionFiles).then(response => {
                img = response.data.message;
            }).catch(error => {
                console.log(error.message);
            })
        }
        this.state.editEmpresa.imagen = img;
        const lista = [];
        this.state.editEmpresa.especialidad.forEach((e) => {
            if (e.id != null) {
                lista.push(e.id)
            } else {
                lista.push(e)
            }
        });
        this.state.editEmpresa.especialidad = lista;

        // delete this.state.editEmpresa.inventario;
        console.log(this.state.editEmpresa)
        await axios.put(baseUrl + this.state.editEmpresa.id, this.state.editEmpresa, autorizacion).then(response => {
            this.peticionGetEmpresa();
            this.modalEditarEmpresa();

            swal({ title: "Empresa " + response.data.nombre + " editado", text: " ", icon: "success", buttons: false, timer: 1500 })
        }).catch(error => {
            console.log(error.message);
            swal({ title: "ERROR AL EDITAR", text: " ", icon: "error", buttons: false, timer: 1500 })
        })
    }

    //PETICIÓN ESTADO
    peticionEstadoEmpresa = (empresa) => {
        axios.put(url + 'estado/' + empresa.id, this.state.editEmpresa, autorizacion).then(response => {
            this.peticionGetEmpresa();
            swal({ title: "Empresa " + response.data.nombre + " eliminado", text: " ", icon: "success", buttons: false, timer: 1500 })
        }).catch(error => {
            console.log(error.message);
            swal({ title: "ERROR AL ELIMINAR", text: " ", icon: "error", buttons: false, timer: 1500 })
        })
    }

    //MODAL DE INSERTAR
    modalInsertarEmpresa = () => {
        this.setState({ modalInsertarEmpresa: !this.state.modalInsertarEmpresa });
    }
    //MODAL DE EDITAR
    modalEditarEmpresa = () => {
        this.setState({ modalEditarEmpresa: !this.state.modalEditarEmpresa,
            valid: {
                nombre: false,
                contacto: false,
                telefono: false,
                direccion: false,
                email: false,
                especialidad: false,
                estado: false
            },
            button: true,
        });
    }
    //MODAL DE INSERTAR ESPECIALIDAD
    modalInsertarEspecialidad = () => {
        this.setState({ modalInsertarEspecialidad: !this.state.modalInsertarEspecialidad });
    }
    //MODAL DE VIEW
    modalViewEmpresa = () => {
        this.setState({ modalViewEmpresa: !this.state.modalViewEmpresa });
    }
    //SELECCIONAR EMPRESA PARA EDICIÓN
    seleccionarEmpresa = (empresa) => {
        this.setState({
            editEmpresa: {
                id: empresa.id,
                nombre: empresa.nombre,
                contacto: empresa.contacto,
                telefono: empresa.telefono,
                direccion: empresa.direccion,
                email: empresa.email,
                imagen: empresa.imagen,
                especialidad: empresa.especialidad
            }
        })
    }
    //PASAR ESPECIALIDAD
    pasarEspecialidad = (especialidad) => {
        this.setState({
            especialidad: {
                nombre: especialidad.nombre,
                descripcion: especialidad.descripcion
            }
        })
    }

    //INGRESO DE FILES
    handleChangeFiles = (e) => {
        this.setState({
            files: e.target.files[0],
        })
    }
    //INGRESO DE DATOS DE ESPECIALIDAD A LA EMPRESA
    handleChangeEspecialidad = async (e) => {

        await this.setState({
            empresa: {
                ...this.state.empresa,
                especialidad: e.value 
            }
        });

        console.log(this.state.empresa);
    }
    //INGRESO DE DATOS DE ESPECIALIDAD 
    handleChangeInsertarEspecialidad = async (e) => {
        e.persist();
        await this.setState({
            especialidad: {
                ...this.state.especialidad,
                [e.target.name]: e.target.value
            }
        });
        console.log(this.state.especialidad);
    }
    //INGRESO DE DATOS AL empresa

    handleChangeEmpresa = async e => {
        e.persist();
        await this.setState({
            empresa: {
                ...this.state.empresa,
                [e.target.name]: e.target.value
            }
        });
        console.log(this.state.empresa);
    }
    //INGRESO DE DATOS AL EDITEMPRESA
    handleChangeEditEmpresa = async e => {
        e.persist();
        const valid = this.validacion.valid(e.target.name, e.target.value);
        const mensaje = this.validacion.mensaje(e.target.name, e.target.value);
        await this.setState({
            editEmpresa: {
                ...this.state.editEmpresa,
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
    }

    
    //FUNCION DE ARRANQUE
    componentDidMount() {
        this.peticionGetEmpresa();
        this.peticionGetEspecialidad();
    }
    constructor(props) {
        super(props);
        this.state = {
            img: baseUrl + "files/error.png",
            profileImg: baseUrl + "files/error.png",
            data: [],
            dataespecialidad: [],
            files: null,
            modalInsertarEmpresa: false,
            modalEditarEmpresa: false,
            modalInsertarEspecialidad: false,
            modalViewEmpresa: false,
            empresa: {
                nombre: '',
                contacto: '',
                telefono: 0,
                direccion: '',
                email: '',
                imagen: null,
                especialidad: 0
            },
            editEmpresa: {
                id: '',
                nombre: '',
                contacto: '',
                telefono: 0,
                direccion: '',
                email: '',
                imagen: null,
                especialidad: 0,
                estado: ''
            },
            especialidad: {
                nombre: '', 
                descripcion:''
            },

            customers: null,
            selectedCustomers: null,
            filters: {
                'global': { value: null, matchMode: FilterMatchMode.CONTAINS }
            },
            globalFilterValue: '',
            loading: true
        }
        this.Botones = this.Botones.bind(this);
        this.onGlobalFilterChangeEmpresa = this.onGlobalFilterChangeEmpresa.bind(this);
        this.headerTemplate = this.headerTemplate.bind(this);
        this.itemTemplate = this.itemTemplate.bind(this);
    }
    ValidButton = () => {
        delete this.state.valid.descripcion;
        delete this.state.valid.imagen;
        this.setState({
            button: this.validacion.ValidButton(this.state.valid),
        });
    }
    
    //RENDERIZAR IMAGEN
    Imagen(EmpresaeditEmpresa) {
        return <div >
            {EmpresaeditEmpresa.imagen
                ? <img src={baseUrl + "files/" + EmpresaeditEmpresa.imagen} style={{ "width": "45px", "borderRadius": "10%" }} alt={EmpresaeditEmpresa.id} />
                : <img src={baseUrl + "files/error.png"} style={{ "width": "45px", "borderRadius": "10%" }} alt={EmpresaeditEmpresa.id} />
            }
        </div>;
    }
    //RENDERIZAR BOTONES
    Botones(empresa) {
        return <div className="btn-group btn-group-sm" role="group">
            <button value={empresa.id} className='btn btn-primary' onClick={() => { swal({ title: "¿Desea editar al Empresa " + empresa.nombre + "?", icon: "warning", buttons: ["Cancelar", "Editar"], dangerMode: true, }).then((respuesta) => { if (respuesta) { this.seleccionarEmpresa(empresa); this.modalEditarEmpresa() } }); }}><FontAwesomeIcon icon={faEdit} /></button>
            <button className='btn btn-info' onClick={() => { this.seleccionarEmpresa(empresa); this.modalViewEmpresa() }} ><FontAwesomeIcon icon={faEye} /></button>
            <button className='btn btn-danger' onClick={() => { swal({ title: "¿Desea eliminar al empresa " + empresa.nombre + "?", icon: "warning", buttons: ["Cancelar", "Eliminar"], dangerMode: true, }).then((respuesta) => { if (respuesta) { this.peticionEstadoEmpresa(empresa) } }); }}><FontAwesomeIcon icon={faTrashAlt} /></button>
        </div>;
    }
    //FILTRADO GLOBAL
    onGlobalFilterChangeEmpresa(e) {
        const value = e.target.value;
        let filters = { ...this.state.filters };
        filters['global'].value = value;
        console.log(value)
        this.setState({ filters, globalFilterValue: value });
    }

    //RENDERIZAR ENCABEZADO DE LA DATATABLE
    renderHeader() {
        return (
            <div className="flex justify-content-between align-items-center">
                <h5 className="m-0 h5"></h5>
                <span className="p-input-icon-left">
                    <i className="pi pi-search" />
                    <InputText value={this.state.globalFilterValue} onChange={this.onGlobalFilterChangeEmpresa} placeholder="Buscar" />
                </span>
            </div>
        )
    }
    //EVENTOS DE SUBIR ARCHIVO
    headerTemplate(options) {
        const { className, chooseButton, cancelButton, uploadButton } = options;

        return (
            <div className={className} style={{ backgroundColor: 'transparent', display: 'flex', alignItems: 'center' }}>
                {chooseButton}
                {uploadButton}
                {cancelButton}
            </div>
        );
    }
    itemTemplate(file, props) {
        return (
            <div style={{ width: '100%' }}>
                <img alt={file.name} src={file.objectURL} width={"100%"} />
            </div>
        )
    }
    //ARCHIVO
    imageHandler = (e) => {
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
        const { editEmpresa, data, dataespecialidad, profileImg } = this.state;
        const header = this.renderHeader();
        const toggle = () => this.modalInsertarEmpresa();
        const toggle2 = () => this.modalEditarEmpresa();
        const toggle3 = () => this.modalViewEmpresa();
        const toggle4 = () => this.modalInsertarEspecialidad();
        const chooseOptions = { icon: 'pi pi-fw pi-images', iconOnly: true, className: 'btn-primary' };
        const uploadOptions = { icon: 'pi pi-fw pi-cloud-upload', iconOnly: true, className: 'custom-upload-btn p-button-success p-button-rounded p-button-outlined' };
        const cancelOptions = { icon: 'pi pi-fw pi-times', iconOnly: true, className: 'btn-danger' };
        return (
            <div className="datatable-doc-demo">
                <div className="flex justify-content-between align-items-center">
                    <h5 className="m-0 h5">empresa</h5>
                    <button className='btn btn-primary' onClick={() => { this.setState({ empresa: null, tipoModal: 'insertar' }); this.modalInsertarEmpresa() }}><FontAwesomeIcon icon={faPlus} style={{ "marginRight": "1rem" }} /><span className='menu-title'>Agregar</span></button>
                </div>
                <br />
                <div className='card'>
                    <DataTable className='table-hover' value={data} header={header} responsiveLayout="stack"
                        dataKey="id" selection={this.state.selectedCustomers} onSelectionChange={e => this.setState({ selectedCustomers: e.value })}
                        filters={this.state.filters} loading={this.state.loading}
                        paginatorTemplate="FirstPageLink PrevPageLink PageLinks NextPageLink LastPageLink CurrentPageReport RowsPerPageDropdown"
                        breakpoint="800px" paginator rows={10} rowsPerPageOptions={[10, 25, 50]} emptyMessage="Empresas no encontradas..."
                        currentPageReportTemplate="Registro {first} - {last} de {totalRecords} empresas">
                        <Column header="Imagen" body={this.Imagen} />
                        <Column field="nombre" header="Nombre" />
                        <Column field="contacto" header="Contacto" />
                        <Column field="especialidad" header="Especialidad" />
                        <Column field="estado" header="Botones" body={this.Botones} />
                    </DataTable>
                </div>
                {/*  MODAL INSERTAR */}
                <Modal isOpen={this.state.modalInsertarEmpresa} toggle={() => { toggle(); this.setState({ profileImg: this.state.img }) }} size='lg'>
                    <ModalHeader toggle={toggle}>
                        <span>Agregar Empresa</span>
                        <button type="button" className="close" onClick={() => { this.setState({ profileImg: this.state.img }); this.modalInsertarEmpresa(); }} >
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
                                    <Label htmlFor='especialidad'>especialidad:</Label>
                                    <br />
                                    <Select options={dataespecialidad} name='especialidad' onChange={this.handleChangeEspecialidad} placeholder="Seleccione la especialidad" />
                                    <FormText>
                                        especialidad del empresa.
                                    </FormText>
                                    <FormFeedback>
                                        Complete el campo
                                    </FormFeedback>
                                    <br />
                                    <button className='btn btn-primary' onClick={() => { this.setState({ especialidad: null }); this.modalInsertarEspecialidad() }}>
                                        Agregar Especialidad
                                    </button>
                                </Col>
                                <Col md={6}>
                                    <Label htmlFor='nombre'>Nombre:</Label>
                                    <Input invalid type='text' name='nombre' id='nombre' onChange={this.handleChangeEmpresa} />
                                    <FormText>
                                        Nombre del empresa.
                                    </FormText>
                                    <FormFeedback>
                                        Complete el campo
                                    </FormFeedback>
                                    <Label htmlFor='contacto'>Contato:</Label>
                                    <Input invalid type='text' name='contacto' id='contacto' onChange={this.handleChangeEmpresa} />
                                    <FormText>
                                        Descripción del empresa.
                                    </FormText>
                                    <Label htmlFor='telefono'>Telefono:</Label>
                                    <Input invalid type='number' name='telefono' id='telefono' onChange={this.handleChangeEmpresa} />
                                    <FormText>
                                        Descripción del empresa.
                                    </FormText>
                                    <Label htmlFor='direccion'>Direccion:</Label>
                                    <Input invalid type='text' name='direccion' id='direccion' onChange={this.handleChangeEmpresa} />
                                    <FormText>
                                        Descripción del empresa.
                                    </FormText>
                                    <Label htmlFor='email'>Email:</Label>
                                    <Input invalid type='email' name='email' id='email' onChange={this.handleChangeEmpresa} />
                                    <FormText>
                                        Descripción del empresa.
                                    </FormText>
                                </Col>
                            </Row>
                        </FormGroup>
                    </ModalBody>
                    <ModalFooter>
                        <button className='btn btn-primary' onClick={() => this.peticionPostEmpresa()}>
                            Insertar
                        </button>
                        <button className='btn btn-danger' onClick={() => this.modalInsertarEmpresa()}>
                            Cancelar
                        </button>
                    </ModalFooter>
                </Modal>


                {/*  MODAL Editar*/}
                <Modal isOpen={this.state.modalEditarEmpresa} toggle={toggle2} size='lg'>
                    <ModalHeader>
                        <span>Editar Empresa</span>
                        <button type="button" className="close" onClick={() =>{ this.setState({ profileImg: this.state.img }); this.modalEditarEmpresa(); }}>
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
                                    <Input invalid type='text' name='nombre' id='nombre' onChange={this.handleChangeEditEmpresa} value={editEmpresa.nombre || ''} />
                                    <FormFeedback>
                                    
                                    </FormFeedback>
                                    <Label htmlFor='contacto'>Contato:</Label>
                                    <Input type='textarea' name='contacto' id='contacto' onChange={this.handleChangeEditEmpresa} value={editEmpresa.contacto || ''} />                                    <FormText>
                                        Descripción del empresa.
                                    </FormText>
                                    <Label htmlFor='telefono'>Telefono:</Label>
                                    <Input type='textarea' name='telefono' id='telefono' onChange={this.handleChangeEditEmpresa} value={editEmpresa.telefono || ''} />
                                    <FormText>
                                        Descripción del empresa.
                                    </FormText>
                                    <Label htmlFor='direccion'>Direccion:</Label>
                                    <Input type='textarea' name='direccion' id='direccion' onChange={this.handleChangeEditEmpresa} value={editEmpresa.direccion || ''} />
                                    <FormText>
                                        Descripción del empresa.
                                    </FormText>
                                    <Label htmlFor='email'>Email:</Label>
                                    <Input type='textarea' name='email' id='email' onChange={this.handleChangeEditEmpresa} value={editEmpresa.email || ''} />
                                    <FormText>
                                        Descripción del empresa.
                                    </FormText>
                                </Col>
                            </Row>
                            <Row>
                                <Col md={6}>
                                <Label htmlFor='especialidad'>especialidad:</Label>
                                    <br />
                                    <Select options={dataespecialidad} isMulti name='especialidad' onChange={this.handleChangeEspecialidad} placeholder="Seleccione la especialidad" />
                                    <FormText>
                                        especialidad del empresa.
                                    </FormText>
                                    <FormFeedback>
                                        Complet el campo
                                    </FormFeedback>
                                    <br />
                                    <Button disabled={this.state.button} color='primary' onClick={() => this.peticionPostEspecialidad()}>
                                        Insertar Especialidad
                                    </Button>
                                </Col>
                            </Row>
                        </FormGroup>
                    </ModalBody>
                    <ModalFooter>
                        <button  color='primary'  onClick={() => this.peticionPutEmpresa()}>
                            Actualizar
                        </button>
                        <button className='btn btn-danger' onClick={() => this.modalEditarEmpresa()}>
                            Cancelar
                        </button>
                    </ModalFooter>
                </Modal>
                {/* MODAL DE VISTA EMPRESA */}
                <Modal isOpen={this.state.modalViewEmpresa} toggle={ toggle3}>
                    <ModalHeader >
                        <div><br /><h3>Empresa {editEmpresa.nombre}</h3></div>
                        <button type="button" className="close" onClick={() => this.modalViewEmpresa()}>
                            <FontAwesomeIcon icon={faClose} />
                        </button>
                    </ModalHeader>
                    <ModalBody>
                        <FormGroup>
                            <Row>
                                <Col md={12} >
                                    <ListGroup flush>
                                        <ListGroupItem style={{ "display": "flex", "justifyContent": "center" }}>
                                            {editEmpresa.imagen
                                                ? <img src={baseUrl + "files/" + editEmpresa.imagen} style={{ "width": "70%", "borderRadius": "10%" }} alt={editEmpresa.id} />
                                                : <img src={baseUrl + "files/error.png"} style={{ "width": "70%", "borderRadius": "10%" }} alt={editEmpresa.id} />
                                            }
                                        </ListGroupItem>
                                        <ListGroupItem>
                                            <p>Nombre:</p> <h5>{editEmpresa.nombre}</h5>
                                        </ListGroupItem>
                                        <ListGroupItem>
                                            <p>Contacto:</p> <h5>{editEmpresa.contacto}</h5>
                                        </ListGroupItem>
                                        <ListGroupItem>
                                            <p>Dirección:</p> <h5>{editEmpresa.direccion}</h5>
                                        </ListGroupItem>
                                        <ListGroupItem>
                                            <p>Teléfono:</p><h5>{editEmpresa.telefono}</h5>
                                        </ListGroupItem>
                                        <ListGroupItem>
                                            <p>Email:</p> <h5>{editEmpresa.email}</h5>
                                        </ListGroupItem>
                                        <ListGroupItem>
                                            <p>Especialidad:</p> <h5>{editEmpresa.especialidad}</h5>
                                        </ListGroupItem>
                                        
                                    </ListGroup>
                                </Col>

                            </Row>
                        </FormGroup>
                    </ModalBody>

                    <ModalFooter>
                        <button className='btn btn-primary' onClick={() => { this.modalViewEmpresa(); }}>
                            Cerrar
                        </button>
                    </ModalFooter>
                </Modal>
                {/* MODAL DE Especialidad */}
                <Modal isOpen={this.state.modalInsertarEspecialidad} toggle={toggle4} size="sm" >
                    <ModalHeader>
                        <span>Agregar Especialidad</span>
                        <button type="button" className="close" onClick={() => { this.modalInsertarEspecialidad(); }}>
                            <FontAwesomeIcon icon={faClose} />
                        </button>
                    </ModalHeader>

                    <ModalBody>
                        <FormGroup>
                            <Row>
                                <Col md={12}>
                                    <Label htmlFor='nombre'>Nombre:</Label>
                                    <Input invalid type='text' name='nombre' id='nombre' onChange={this.handleChangeInsertarEspecialidad} />
                                    <FormText>
                                        Nombre de la especialidad.
                                    </FormText>
                                    <FormFeedback>
                                        Complete el campo
                                    </FormFeedback>
                                    <Label htmlFor='descripcion'>Descripcion:</Label>
                                    <Input invalid type='text' name='descripcion' id='descripcion' onChange={this.handleChangeInsertarEspecialidad} />
                                    <FormText>
                                        Descripcion.
                                    </FormText>
                                    <FormFeedback>
                                        Complete el campo
                                    </FormFeedback>
                                </Col>
                            </Row>
                        </FormGroup>
                    </ModalBody>

                    <ModalFooter>
                        <button className='btn btn-primary' onClick={() => this.peticionPostEspecialidad()}>
                            Insertar
                        </button>
                        <button className='btn btn-danger' onClick={() => { this.modalInsertarEspecialidad(); }}>
                            Cancelar
                        </button>
                    </ModalFooter>
                </Modal>

            </div>
        );
    }
}

