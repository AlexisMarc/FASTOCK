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
const url = baseUrl + 'producto/';

export default class Producto extends Component {

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
            modalInsertarProducto: false,
            modalEditarProducto: false,
            modalInsertarCategoria: false,
            modalViewProducto: false,
            producto: {
                nombre: '',
                descripcion: '',
                imagen: null,
                categoria: []
            },
            editProducto: {
                id: '',
                nombre: '',
                descripcion: '',
                imagen: null,
                categoria: [],
                estado: '',
                inventario: null,
                visible: null,
            },
            valid: {
                nombre: null,
                categoria: null
            },
            validCategoria: {
                nombre: null,
            },
            mensaje: {
                nombre: null,
                categoria: null,
            },
            mensajeCategoria: {
                nombre: null,
                categoria: null,
            },
            button: true,
            buttonCategoria: true,
            categoria: {
                id: '',
                nombre: ''
            },
            customers: null,
            selectedCustomers: null,
            filters: {
                'global': { value: null, matchMode: FilterMatchMode.CONTAINS }
            },
            globalFilterValue: '',
            loading: true
        }
        this.visible = [
            { value: true, label: "Visible" },
            { value: false, label: "No visible" },
        ];
        this.Botones = this.Botones.bind(this);
        this.onGlobalFilterChangeProducto = this.onGlobalFilterChangeProducto.bind(this);
        this.headerTemplate = this.headerTemplate.bind(this);
        this.itemTemplate = this.itemTemplate.bind(this);
    }

    //PETICION GET
    peticionGetProducto = () => {
        axios.get(url, autorizacion).then(response => {
            this.setState({ data: response.data, loading: false });
        }).catch(error => {
            console.log(error.message);
            this.setState({ loading: false });
            swal({ title: "ERROR AL CONSULTAR", text: " ", icon: "error", buttons: false, timer: 1500 })
        })
    }

    //PETICIÓN GET CATEGORIA
    peticionGetCategoria = () => {
        axios.get(url + 'categoria/', autorizacion).then(response => {
            const datos = [];

            response.data.forEach((categoria) => {
                const dato = { value: categoria.id, label: categoria.nombre }
                datos.push(dato);
            })

            this.setState({ datacategorias: datos });
        }).catch(error => {
            console.log(error.message);
            swal({ title: "ERROR AL CONSULTAR CATEGORIAS", text: " ", icon: "error", buttons: false, timer: 1500 })
        })
    }

    //CONVERTIR CATEGORIAS DEL PRODUCTO
    categoriasProducto = (e) => {
        const datos = [];
        e.forEach((categoria) => {
            datos.push({ value: categoria.id, label: categoria.nombre });
        });
        return datos;
    }

    //PETICION POST
    peticionPostProducto = async () => {
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
        this.state.producto.imagen = img;

        await axios.post(url, this.state.producto, autorizacion).then(response => {
            this.modalInsertarProducto();
            this.peticionGetProducto();
            swal({ title: "Producto " + response.data.nombre + " registrado", text: " ", icon: "success", buttons: false, timer: 1500 })

        }).catch(error => {
            console.log(error.message);
            swal({ title: "ERROR AL REGISTRAR", text: " ", icon: "error", buttons: false, timer: 1500 })
        })

    }

    //PETICION POST CATEGORIA
    peticionPostCategoria = async () => {

        await axios.post(url + "categoria", this.state.categoria, autorizacion).then(response => {
            this.modalInsertarCategoria();
            this.peticionGetCategoria();
            swal({ title: "Categoria " + response.data.nombre + " registrado", text: " ", icon: "success", buttons: false, timer: 1500 })
        }).catch(error => {
            console.log(error.message);
            swal({ title: "ERROR AL REGISTRAR CATEGORIA", text: " ", icon: "error", buttons: false, timer: 1500 })
        })

    }

    //PETICION PUT
    peticionPutProducto = async () => {
        var img = this.state.editProducto.imagen;
        if (this.state.files != null) {
            var bodyFormData = new FormData();
            bodyFormData.append('files', this.state.files);
            await axios.post(baseUrl + "files/upload", bodyFormData, autorizacionFiles).then(response => {
                img = response.data.message;
            }).catch(error => {
                console.log(error.message);
            })
        }
        this.state.editProducto.imagen = img;
        const lista = [];
        this.state.editProducto.categoria.forEach((e) => {
            if (e.id != null) {
                lista.push(e.id)
            } else {
                lista.push(e)
            }
        });
        this.state.editProducto.categoria = lista;

        delete this.state.editProducto.inventario;
        console.log(this.state.editProducto)
        await axios.put(url + this.state.editProducto.id, this.state.editProducto, autorizacion).then(response => {
            this.peticionGetProducto();
            this.modalEditarProducto();

            swal({ title: "Producto " + response.data.nombre + " editado", text: " ", icon: "success", buttons: false, timer: 1500 })
        }).catch(error => {
            console.log(error.message);
            swal({ title: "ERROR AL EDITAR", text: " ", icon: "error", buttons: false, timer: 1500 })
        })
    }

    //PETICIÓN ESTADO
    peticionEstadoProducto = (producto) => {
        axios.put(url + 'estado/' + producto.id, this.state.editProducto, autorizacion).then(response => {
            this.peticionGetProducto();
            swal({ title: "Producto " + response.data.nombre + " eliminado", text: " ", icon: "success", buttons: false, timer: 1500 })
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
                categoria: null,
            }
        });
    }
    //MODAL DE INSERTAR
    modalInsertarProducto = () => {
        this.setState({ modalInsertarProducto: !this.state.modalInsertarProducto });
        this.validFalse();
    }

    //MODAL DE INSERTAR CATEGORIA
    modalInsertarCategoria = () => {
        this.setState({ modalInsertarCategoria: !this.state.modalInsertarCategoria });
    }

    //MODAL DE EDITAR
    modalEditarProducto = () => {
        this.setState({
            modalEditarProducto: !this.state.modalEditarProducto, files: null,
            valid: {
                nombre: false,
                categoria: false,
            },
            button: true,
        });
    }

    //MODAL DE VIEW
    modalViewProducto = () => {
        this.setState({ modalViewProducto: !this.state.modalViewProducto });
    }

    //SELECCIONAR producto PARA EDICIÓN
    seleccionarProducto = (producto) => {
        this.setState({
            editProducto: {
                id: producto.id,
                nombre: producto.nombre,
                descripcion: producto.descripcion,
                inventario: producto.inventario,
                imagen: producto.imagen,
                categoria: producto.categoria,
                estado: producto.estado,
                visible: producto.visible,

            }
        })
    }

    //PASAR CATEGORIA
    pasarCategoria = (categoria) => {
        this.setState({
            datoscategoria: {
                nombre: categoria.nombre,
                filtro: categoria.filtro
            }
        })
    }

    //INGRESO DE DATOS AL FORM
    handleChangeProducto = async e => {
        e.persist();
        const valid = this.validacion.valid(e.target.name, e.target.value);
        const mensaje = this.validacion.mensaje(e.target.name, e.target.value);
        await this.setState({
            producto: {
                ...this.state.producto,
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
        console.log(this.state.producto);
    }

    //BOTON DESABILITADO DE REGISTRAR
    ValidButton = () => {
        delete this.state.valid.descripcion;
        delete this.state.valid.imagen;
        this.setState({
            button: this.validacion.ValidButton(this.state.valid),
        });
    }
    //BOTON DESABILITADO DE REGISTRAR
    ValidButtonCategoria = () => {
        this.setState({
            buttonCategoria: this.validacion.ValidButton(this.state.validCategoria),
        });
    }
    //INGRESO DE FILES
    handleChangeFiles = (e) => {
        this.setState({
            files: e.target.files[0],
        })
    }

    //INGRESO DE DATOS DE CATEGORIA AL PRODUCTO
    handleChangeCategoria = async (e) => {

        const lista = []
        e.forEach((e) => { lista.push(e.value) });
        const valid = this.validacion.valid("categoria", e);
        const mensaje = this.validacion.mensaje("categoria", e);
        await this.setState({
            producto: {
                ...this.state.producto,
                categoria: lista
            },
            valid: {
                ...this.state.valid,
                categoria: valid,
            },
            mensaje: {
                ...this.state.mensaje,
                categoria: mensaje,
            }
        });
        this.ValidButton();

        console.log(this.state.producto);
    }
    //INGRESO DE DATOS DE CATEGORIA AL PRODUCTOEDIT
    handleChangeEditCategoria = async (e) => {

        const lista = []
        const valid = this.validacion.valid("categoria", e);
        const mensaje = this.validacion.mensaje("categoria", e);
        e.forEach((e) => { lista.push(e.value) });
        console.log(lista)
        await this.setState({
            producto: {
                ...this.state.producto,
                categoria: lista
            },
            valid: {
                ...this.state.valid,
                categoria: valid,
            },
            mensaje: {
                ...this.state.mensaje,
                categoria: mensaje,
            }
        });
        this.ValidButton();

        console.log(this.state.editProducto);
    }
    //INGRESO DE VISIBLE AL PRODUCTOEDIT
    handleChangeVisible = async (e) => {
        console.log(e.value)
        await this.setState({
            editProducto: {
                ...this.state.editProducto,
                visible: e.value,

            },
            button: false,
        });

        console.log(this.state.editProducto);
    }

    //INGRESO DE DATOS DE CATEGORIA 
    handleChangeInsertarCategoria = async (e) => {
        e.persist();
        const valid = this.validacion.valid(e.target.name, e.target.value);
        const mensaje = this.validacion.mensaje(e.target.name, e.target.value);
        await this.setState({
            categoria: {
                ...this.state.categoria,
                [e.target.name]: e.target.value
            },
            validCategoria: {
                ...this.state.validCategoria,
                [e.target.name]: valid,
            },
            mensajeCategoria: {
                ...this.state.mensajeCategoria,
                [e.target.name]: mensaje,
            },
        });
        this.ValidButtonCategoria();

        console.log(this.state.categoria);
    }

    //INGRESO DE DATOS AL EDITPRODUCTO
    handleChangeProductoEditProducto = async e => {
        e.persist();
        const valid = this.validacion.valid(e.target.name, e.target.value);
        const mensaje = this.validacion.mensaje(e.target.name, e.target.value);
        await this.setState({
            editProducto: {
                ...this.state.editProducto,
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
        console.log(this.state.editProducto);
    }

    //FUNCION DE ARRANQUE
    componentDidMount() {
        this.peticionGetProducto();
        this.peticionGetCategoria();
    };


    //RENDERIZAR IMAGEN
    Imagen(producto) {
        return <div >
            {producto.imagen
                ? <img src={baseUrl + "files/" + producto.imagen} style={{ "width": "45px", "borderRadius": "10%" }} alt={producto.id} />
                : <img src={baseUrl + "files/error.png"} style={{ "width": "45px", "borderRadius": "10%" }} alt={producto.id} />
            }
        </div>;
    }

    //RENDERIZAR INVENTARIO
    Inventario(producto) {
        return <div>
            <h5>{!producto.inventario ? <Badge color="primary"> Tiene inventario</Badge> : <Badge color="danger">Sin inventario</Badge>}</h5>
        </div>;
    }

    //RENDERIZAR VISIBLE
    Visible(producto) {
        return <div >
            <h5>{producto.visible ? <Badge color="primary"> Es visible</Badge> : <Badge color="danger">No visible</Badge>}</h5>
        </div>;
    }

    //RENDERIZAR BOTONES
    Botones(producto) {
        return <div className="btn-group btn-group-sm" role="group">
            <button value={producto.id} className='btn btn-primary' onClick={() => { swal({ title: "¿Desea editar al producto " + producto.nombre + "?", icon: "warning", buttons: ["Cancelar", "Editar"], dangerMode: true, }).then((respuesta) => { if (respuesta) { this.seleccionarProducto(producto); this.modalEditarProducto() } }); }}><FontAwesomeIcon icon={faEdit} /></button>
            <button className='btn btn-info' onClick={() => { this.seleccionarProducto(producto); this.modalViewProducto() }} ><FontAwesomeIcon icon={faEye} /></button>
            <button className='btn btn-danger' onClick={() => { swal({ title: "¿Desea eliminar al producto " + producto.nombre + "?", icon: "warning", buttons: ["Cancelar", "Eliminar"], dangerMode: true, }).then((respuesta) => { if (respuesta) { this.peticionEstadoProducto(producto) } }); }}><FontAwesomeIcon icon={faTrashAlt} /></button>
        </div>;
    }

    //FILTRADO GLOBAL
    onGlobalFilterChangeProducto(e) {
        const value = e.target.value;
        let filters = { ...this.state.filters };
        filters['global'].value = value;
        console.log(value)
        this.setState({ filters, globalFilterValue: value });
    }

    //RENDERIZAR ENCABEZADO DE LA DATATABLE
    renderHeaderProducto() {
        return (
            <React.Fragment>
                <div className="flex justify-content-between align-items-center">
                    <h5 className="m-0 h5"> </h5>
                    <span className="p-input-icon-left">
                        <i className="pi pi-search" />
                        <InputText value={this.state.globalFilterValue} onChange={this.onGlobalFilterChangeProducto} placeholder="Buscar" />
                    </span>
                </div>
            </React.Fragment>
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
        this.setState({ button: false, editProducto: { ...this.state.editProducto, imagen: null, } });
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
        const { editProducto, data, datacategorias, profileImg } = this.state;
        const header = this.renderHeaderProducto();
        const toggle = () => this.modalInsertarProducto();
        const toggle2 = () => this.modalEditarProducto();
        const toggle3 = () => this.modalViewProducto();
        const toggle4 = () => this.modalInsertarCategoria();
        
        return (
            <div className="datatable-doc-demo">
                <div className="flex justify-content-between align-items-center">
                    <h5 className="m-0 h5">Producto</h5>
                    <button className='btn btn-primary' onClick={() => { this.setState({ producto: {}, files: null, profileImg: this.state.img }); this.modalInsertarProducto() }} ><FontAwesomeIcon icon={faPlus} style={{ "marginRight": "1rem" }} /><span className='menu-title'>Agregar</span></button>
                </div>
                <br />
                <div className='card'>
                    <DataTable className='table-hover' value={data} header={header} responsiveLayout="stack"
                        dataKey="id" selection={this.state.selectedCustomers} onSelectionChange={e => this.setState({ selectedCustomers: e.value })}
                        filters={this.state.filters} loading={this.state.loading}
                        paginatorTemplate="FirstPageLink PrevPageLink PageLinks NextPageLink LastPageLink CurrentPageReport RowsPerPageDropdown"
                        breakpoint="800px" paginator rows={10} rowsPerPageOptions={[10, 25, 50]} emptyMessage="Productos no encontrados..."
                        currentPageReportTemplate="Registro {first} - {last} de {totalRecords} Productos">
                        <Column header="Imagen" body={this.Imagen} />
                        <Column field="nombre" header="Nombre" />
                        <Column header="Inventario" body={this.Inventario} />
                        <Column header="Visible" body={this.Visible} />
                        <Column header="Botones" body={this.Botones} />

                    </DataTable>
                </div>

                {/* MODAL DE REGISTRAR */}
                <Modal isOpen={this.state.modalInsertarProducto} toggle={() => { toggle(); this.setState({ profileImg: this.state.img }) }} size="lg" >
                    <ModalHeader>
                        <span>Agregar Producto</span>
                        <button type="button" className="close" onClick={() => { this.setState({ profileImg: this.state.img }); this.modalInsertarProducto(); }}>
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
                                    <Input valid={this.state.valid.nombre == null ? false : !this.state.valid.nombre} invalid={this.state.valid.nombre} type='text' name='nombre' id='nombre' onChange={this.handleChangeProducto} />
                                    <FormText>
                                        Nombre del producto.
                                    </FormText>
                                    <FormFeedback>
                                        {this.state.mensaje.nombre}
                                    </FormFeedback>
                                    <Label htmlFor='descripcion'>Descripción:</Label>
                                    <Input type='textarea' name='descripcion' id='descripcion' onChange={this.handleChangeProducto} />
                                    <FormText>
                                        Descripción del producto.
                                    </FormText>
                                    <Label htmlFor='categoria'>Categoria:</Label>
                                    <br />
                                    <Select className={this.state.valid.categoria === true ? 'invalid-select2 is-invalid' : ''} options={datacategorias} isMulti name='categoria' onChange={this.handleChangeCategoria} placeholder="Seleccione la categoria" />
                                    <FormText>
                                        Categoria del producto.
                                    </FormText>
                                    <FormFeedback>
                                        {this.state.valid.categoria === true ?

                                            this.state.mensaje.categoria

                                            : ''}
                                    </FormFeedback>
                                    <br />
                                    <button className='btn btn-primary' onClick={() => { this.setState({ categoria: null }); this.modalInsertarCategoria() }}>
                                        Agregar Categoría
                                    </button>
                                </Col>
                            </Row>
                        </FormGroup>
                    </ModalBody>

                    <ModalFooter>
                        <Button disabled={this.state.button} color='primary' onClick={() => this.peticionPostProducto()}>
                            Insertar
                        </Button>
                        <button className='btn btn-danger' onClick={() => { this.setState({ profileImg: this.state.img }); this.modalInsertarProducto(); }}>
                            Cancelar
                        </button>
                    </ModalFooter>
                </Modal>

                {/* MODAL DE EDITAR */}

                <Modal isOpen={this.state.modalEditarProducto} toggle={() => { toggle2(); this.setState({ profileImg: this.state.img }) }} size='lg'>
                    <ModalHeader>
                        <span>Agregar Producto</span>
                        <button type="button" className="close" onClick={() => { this.setState({ profileImg: this.state.img }); this.modalEditarProducto(); }}>
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
                                    <img src={editProducto.imagen != null ? baseUrl + "files/" + editProducto.imagen : profileImg} alt="cargado" style={{ "width": "100%", "borderRadius": "0px 0px 10px 10px", "padding": "20px 20px 0px 20px" }} />
                                </Col>
                                <Col md={6}>
                                    <Label htmlFor='nombre'>Nombre:</Label>
                                    <Input valid={this.state.valid.nombre == null ? false : !this.state.valid.nombre} invalid={this.state.valid.nombre} type='text' name='nombre' id='nombre' onChange={this.handleChangeProductoEditProducto} value={editProducto.nombre || ''} />
                                    <FormFeedback>
                                        {this.state.mensaje.nombre}
                                    </FormFeedback>
                                    <FormText>
                                        Nombre del producto.
                                    </FormText>

                                    <Label htmlFor='descripcion'>Descripción:</Label>
                                    <Input type='textarea' name='descripcion' id='descripcion' placeholder={editProducto.descripcion ? '' : "Sin Descripción registrada"} onChange={this.handleChangeProductoEditProducto} value={editProducto.descripcion || ''} />
                                    <FormText>
                                        Descripción del producto.
                                    </FormText>
                                    <Label htmlFor='categoria'>Categoria:</Label>
                                    <br />
                                    <Select className={this.state.valid.categoria === true ? 'invalid-select2 is-invalid' : ''} options={datacategorias} isMulti name='categoria' defaultValue={this.categoriasProducto(editProducto.categoria)} onChange={this.handleChangeEditCategoria} placeholder="Seleccione la categoria" />
                                    <FormText>
                                        Categoria del producto.
                                    </FormText>
                                    <FormFeedback>
                                        {this.state.valid.categoria === true ?

                                            this.state.mensaje.categoria

                                            : ''}
                                    </FormFeedback>

                                    <Label htmlFor='visible'>Visible:</Label>
                                    <br />
                                    {editProducto.imagen===null ?
                                        <Alert color="primary">No se puede regitrar la visibilidad, debe agregar una imagen primero</Alert> :
                                        <Select options={this.visible} name='visible' defaultValue={editProducto.visible ? { value: true, label: "Visible" } : { value: false, label: "No visible" }} onChange={this.handleChangeVisible} placeholder="Seleccione la categoria" />
                                    }

                                    <br />
                                    <button className='btn btn-primary' onClick={() => { this.setState({ categoria: null }); this.modalInsertarCategoria() }}>
                                        Agregar Categoría
                                    </button>
                                </Col>
                            </Row>
                        </FormGroup>
                    </ModalBody>

                    <ModalFooter>
                        <Button disabled={this.state.button} color='primary' onClick={() => this.peticionPutProducto()}>
                            Editar
                        </Button>

                        <button className='btn btn-danger' onClick={() => this.modalEditarProducto()}>
                            Cancelar
                        </button>
                    </ModalFooter>
                </Modal>

                {/* MODAL DE VISTA */}
                <Modal isOpen={this.state.modalViewProducto} toggle={toggle3}>
                    <ModalHeader >
                        <div><br /><h3>Producto {editProducto.nombre}</h3></div>
                        <button type="button" className="close" onClick={() => this.modalViewProducto()}>
                            <FontAwesomeIcon icon={faClose} />
                        </button>
                    </ModalHeader>
                    <ModalBody>
                        <FormGroup>
                            <Row>
                                <Col md={12} >
                                    <ListGroup flush>
                                        <ListGroupItem style={{ "display": "flex", "justifyContent": "center" }}>
                                            {editProducto.imagen
                                                ? <img src={baseUrl + "files/" + editProducto.imagen} style={{ "width": "70%", "borderRadius": "10%" }} alt={editProducto.id} />
                                                : <img src={baseUrl + "files/error.png"} style={{ "width": "70%", "borderRadius": "10%" }} alt={editProducto.id} />
                                            }

                                        </ListGroupItem>
                                        <ListGroupItem>
                                            <p>Nombre:</p> <h5>{editProducto.nombre}</h5>
                                        </ListGroupItem>
                                        <ListGroupItem>
                                            <p>Descripción:</p> <h5>{editProducto.descripcion ? editProducto.descripcion : <Badge color="secondary">Sin Descripción</Badge>}</h5>
                                        </ListGroupItem>
                                        <ListGroupItem>
                                            <p>Inventario:</p> {!editProducto.inventario ? <Badge color="primary"> Tiene inventario</Badge> : <Badge color="danger">Sin inventario</Badge>}
                                        </ListGroupItem>
                                        <ListGroupItem>
                                            <p>Visible:</p> {editProducto.visible ? <Badge color="primary"> Es visible</Badge> : <Badge color="danger">No visible</Badge>}
                                        </ListGroupItem>

                                        <ListGroupItem>
                                            <p>Categoria:</p>
                                            <ListGroup>
                                                {editProducto.categoria.length > 0 ?
                                                    editProducto.categoria.map((categoria, index) => {
                                                        return (
                                                            <ListGroupItem key={index}>
                                                                <p >{categoria.nombre}</p>
                                                            </ListGroupItem>
                                                        )
                                                    }) :

                                                    <Alert color="primary">
                                                        No hay categorias registradas con el producto
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
                        <button className='btn btn-primary' onClick={() => { this.modalViewProducto(); }}>
                            Cerrar
                        </button>
                    </ModalFooter>
                </Modal>

                {/* MODAL DE CATEGORIA */}
                <Modal isOpen={this.state.modalInsertarCategoria} toggle={toggle4} size="sm" >
                    <ModalHeader>
                        <span>Agregar Categoria</span>
                        <button type="button" className="close" onClick={() => { this.modalInsertarCategoria(); }}>
                            <FontAwesomeIcon icon={faClose} />
                        </button>
                    </ModalHeader>

                    <ModalBody>
                        <FormGroup>
                            <Row>
                                <Col md={12}>
                                    <Label htmlFor='nombre'>Nombre:</Label>
                                    <Input valid={this.state.validCategoria.nombre == null ? false : !this.state.validCategoria.nombre} invalid={this.state.validCategoria.nombre} type='text' name='nombre' id='nombre' onChange={this.handleChangeInsertarCategoria} />
                                    <FormText>
                                        Nombre del producto.
                                    </FormText>
                                    <FormFeedback>
                                        {this.state.mensajeCategoria.nombre}
                                    </FormFeedback>
                                </Col>
                            </Row>
                        </FormGroup>
                    </ModalBody>

                    <ModalFooter>
                        <Button disabled={this.state.buttonCategoria} color='primary' onClick={() => this.peticionPostCategoria()}>
                            Insertar
                        </Button>
                        <button className='btn btn-danger' onClick={() => { this.modalInsertarCategoria(); }}>
                            Cancelar
                        </button>
                    </ModalFooter>
                </Modal>
            </div >
        );
    }




}


