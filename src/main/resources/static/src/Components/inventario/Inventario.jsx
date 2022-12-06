import React, { Component, } from 'react';
import { DataTable } from 'primereact/datatable';
import { Column } from 'primereact/column';
import { InputText } from 'primereact/inputtext';
import { FilterMatchMode } from 'primereact/api';
import { TabView, TabPanel } from 'primereact/tabview';
import axios from 'axios';
import Select from 'react-select'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faClose, faEdit, faEye, faGear, faPlus, faTrashAlt } from '@fortawesome/free-solid-svg-icons';
import Validacion from '../../Utils/Validacion';
import { Alert, Badge, Button, Col, FormFeedback, FormGroup, FormText, Input, Label, ListGroup, ListGroupItem, Modal, ModalBody, ModalFooter, ModalHeader, Row } from 'reactstrap';
import { autorizacion, baseUrl, autorizacionFiles } from '../../Utils/Api';
import swal from 'sweetalert';


import 'primeicons/primeicons.css';
import 'primereact/resources/themes/lara-light-indigo/theme.css';
import 'primereact/resources/primereact.css';
import 'primeflex/primeflex.css';

export default class Inventario extends Component {

    state = {}
    //CONSTRUCTOR
    constructor(props) {
        super(props);
        this.state = {
            dataproducto: [],
            datainsumo: [],
            producto: {},
            insumo: {},
            entradaSalida: {},
            filters: {
                'global': { value: null, matchMode: FilterMatchMode.CONTAINS }
            },
            globalFilterValue: '',
            loadingProducto: true,
            loadingInsumo: true,
        }
        this.Botones = this.Botones.bind(this);
        this.Stock = this.Stock.bind(this);
        this.onGlobalFilterChange = this.onGlobalFilterChange.bind(this);
    }

    //PETICION GET INVENTARIOS
    peticionGetInventarios = () => {
        axios.get(baseUrl + 'producto/inventario', autorizacion).then(response => {
            this.setState({ dataproducto: response.data, loadingProducto: false });
        }).catch(error => {
            console.log(error.message);
            this.setState({ loadingProducto: false });
            swal({ title: "ERROR AL CONSULTAR", text: " ", icon: "error", buttons: false, timer: 1500 })
        })
        axios.get(baseUrl + 'insumo/inventario', autorizacion).then(response => {
            this.setState({ datainsumo: response.data, loadingInsumo: false });
        }).catch(error => {
            console.log(error.message);
            this.setState({ loadingInsumo: false });
            swal({ title: "ERROR AL CONSULTAR", text: " ", icon: "error", buttons: false, timer: 1500 })
        })
    }

    //MODAL DE INSERTAR
    modalInsertarInventario = () => {
        this.setState({ modalInsertarInventario: !this.state.modalInsertarInventario });
    }
    //MODAL DE INSERTAR crear1
    modalInsertarInsumo = () => {
        this.setState({ modalInsertarInsumo: !this.state.modalInsertarInsumo});
    }
    //MODAL DE INSERTAR crear2
    modalInsertarProducto = () => {
        this.setState({ modalInsertarProducto: !this.state.modalInsertarProducto});
    }

    //RENDERIZADO DE ENCABEZADO DE PRODUCTO
    renderHeaderProducto() {
        return (
            <React.Fragment>
                <div className="flex block justify-content-between align-items-center">
                    <h5 className="m-0 h5"> </h5>
                    <span className="p-input-icon-left">
                        <i className="pi pi-search" />
                        <InputText value={this.state.globalFilterValue} onChange={this.onGlobalFilterChange} placeholder="Buscar" style={{ "width": "100%" }} />
                    </span>
                </div>
            </React.Fragment>
        )
    }
    //RENDERIZADO DE ENCABEZADO DE PRODUCTO
    renderHeaderInsumo() {
        return (
            <React.Fragment>
                <div className="flex block justify-content-between align-items-center">
                    <h5 className="m-0 h5"> </h5>
                    <span className="p-input-icon-left">
                        <i className="pi pi-search" />
                        <InputText value={this.state.globalFilterValue} onChange={this.onGlobalFilterChange} placeholder="Buscar" style={{ "width": "100%" }} />
                    </span>
                </div>
            </React.Fragment>
        )
    }
    //RENDERIZADO DE STOCK
    Stock(dato) {
        return dato.entrada - dato.salida
    }

    //RENDERIZAR BOTONES
    Botones(dato) {
        return <div className="btn-group btn-group-sm" role="group">
            <button className='btn btn-primary' onClick={() => { this.seleccionarDatos(dato); this.modalViewDatos() }} ><FontAwesomeIcon icon={faGear} /></button>
        </div>;
    }

    //RENDERIZAR IMAGEN
    Imagen(dato) {
        return <div >
            {dato.img
                ? <img src={baseUrl + "files/" + dato.img} style={{ "width": "45px", "borderRadius": "10%" }} alt={dato.id} />
                : <img src={baseUrl + "files/error.png"} style={{ "width": "45px", "borderRadius": "10%" }} alt={dato.id} />
            }
        </div>;
    }

    //FILTRADO GLOBAL
    onGlobalFilterChange(e) {
        const value = e.target.value;
        let filters = { ...this.state.filters };
        filters['global'].value = value;
        console.log(value)
        this.setState({ filters, globalFilterValue: value });
    }

    //FUNCION DE ARRANQUE
    componentDidMount() {
        this.peticionGetInventarios();
    };
    render() {
        const { insumo, datainsumo, dataproducto, loadingInsumo, loadingProducto } = this.state;
        const headerProducto = this.renderHeaderProducto();
        const headerInsumo = this.renderHeaderInsumo();
        const toggle = () => this.modalInsertarInventario();
        const toggle2 = () => this.modalInsertarInsumo();    
        const toggle3 = () => this.modalInsertarProducto();
        return (
            <div className="card">
                <div className="flex justify-content-between align-items-center">
                    <h3 className="m-0 h5">Inventario</h3>
                    <button className='btn btn-primary' onClick={() => { this.setState({ Inventario: {}, files: null, profileImg: this.state.img }); this.modalInsertarInventario() }} ><FontAwesomeIcon icon={faPlus} style={{ "marginRight": "1rem" }} /><span className='menu-title'>Agregar</span></button>
                </div>
                <TabView>
                    <TabPanel header="Producto">
                        <DataTable className='table-hover' value={dataproducto} header={headerProducto} responsiveLayout="stack"
                            dataKey="id" filters={this.state.filters} loading={loadingProducto}
                            paginatorTemplate="FirstPageLink PrevPageLink PageLinks NextPageLink LastPageLink CurrentPageReport RowsPerPageDropdown"
                            breakpoint="800px" paginator rows={10} rowsPerPageOptions={[10, 25, 50]} emptyMessage="Productos no encontrados..."
                            currentPageReportTemplate="Registro {first} - {last} de {totalRecords} Productos">
                            <Column header="Image" body={this.Imagen} />
                            <Column field="producto" header="Nombre" />
                            <Column field='entrada' header='Entradas' />
                            <Column field='salida' header='Salidas' />
                            <Column header="Stock" body={this.Stock} />
                            <Column body={this.Botones} />
                        </DataTable>
                    </TabPanel>


                    <TabPanel header="Insumo" >
                        <DataTable className='table-hover' value={datainsumo} header={headerInsumo} responsiveLayout="stack"
                            dataKey="id" filters={this.state.filters} loading={loadingInsumo}
                            paginatorTemplate="FirstPageLink PrevPageLink PageLinks NextPageLink LastPageLink CurrentPageReport RowsPerPageDropdown"
                            breakpoint="800px" paginator rows={10} rowsPerPageOptions={[10, 25, 50]} emptyMessage="Productos no encontrados..."
                            currentPageReportTemplate="Registro {first} - {last} de {totalRecords} Productos">
                            <Column header="Image" body={this.Imagen} />
                            <Column field="insumo" header="Nombre" />
                            <Column field='entrada' header='Entradas' />
                            <Column field='salida' header='Salidas' />
                            <Column header="Stock" body={this.Stock} />
                            <Column body={this.Botones} />
                        </DataTable>
                    </TabPanel>
                </TabView>

                <div>
                    {/* MODALES */}

                    {/* MODAL PARA SELECCIONAR CREAR */}
                    <Modal isOpen={this.state.modalInsertarInventario} toggle={() => { toggle(); this.setState({ profileImg: this.state.img }) }} size='lg'>
                        <ModalHeader toggle={toggle}>
                            <span>Agregar Inventario</span>
                            <button type="button" className="close" onClick={() => { this.setState({ profileImg: this.state.img }); this.modalInsertarInventario(); }} >
                                <FontAwesomeIcon icon={faClose} />
                            </button>

                        </ModalHeader>
                        <ModalBody>
                            <FormGroup>
                                <Row>
                                    <Col md={6}>
                                        <button className='btn btn-primary' onClick={() => { this.modalInsertarInsumo(insumo); this.modalInsertarInsumo() }} >Crear</button>
                                    </Col>
                                    <Col md={6}>
                                        <button className='btn btn-primary' onClick={() => { this.modalInsertarInsumo(insumo); this.modalInsertarProducto() }}>Crear2</button>
                                    </Col>
                                </Row>
                            </FormGroup>
                        </ModalBody>
                        <ModalFooter>
                            <button className='btn btn-danger' onClick={() => this.modalInsertarInventario()}>
                                Cancelar
                            </button>
                        </ModalFooter>
                    </Modal>

                      {/* MODAL PARA crear 1 */}
                      <Modal isOpen={this.state.modalInsertarInsumo} toggle={() => { toggle(); this.setState({ profileImg: this.state.img }) }} size='lg'>
                      <ModalHeader toggle={toggle2}>
                        <span>Agregar Insumo</span>
                        <button type="button" className="close" onClick={() => { this.setState({ profileImg: this.state.img }); this.modalInsertarInsumo(); }} >
                            <FontAwesomeIcon icon={faClose} />
                        </button>

                    </ModalHeader>
                    <ModalBody>
                        <FormGroup>
                            <Row>
                                <Col md={12}>
                                <Label htmlFor='insumo'>insumo:</Label>
                                    <br />
                                    <Select options={datainsumo} name='insumo' onChange={this.handleChangeEspecialidad} placeholder="Seleccione el insumo" />
                                    <FormText>
                                        insumo del inventario.
                                    </FormText>
                                    <FormFeedback>
                                        Complete el campo
                                    </FormFeedback>
                                </Col>
                                <Col md={12}>
                                <Label htmlFor='insumo'>insumoxd:</Label>
                                    <br />
                                    <Select options={datainsumo} name='insumo' onChange={this.handleChangeEspecialidad} placeholder="Seleccione el insumo" />
                                    <FormText>
                                        insumoxd del inventario.
                                    </FormText>
                                    <FormFeedback>
                                        Complete el campo
                                    </FormFeedback>
                                </Col>
                                <Col md={12}>
                                <Label htmlFor='cantidad'>Cantidad:</Label>
                                    <Input invalid type='number' name='cantidad' id='cantidad' onChange={this.handleChangeEmpresa} />
                                    <FormText>
                                        Descripción del inventario.
                                    </FormText></Col>
                            </Row>
                        </FormGroup>
                    </ModalBody>
                    <ModalFooter>
                        <button className='btn btn-primary' onClick={() => this.peticionPostInsuumo()}>
                            Insertar
                        </button>
                        <button className='btn btn-danger' onClick={() => this.modalInsertarInsumo()}>
                            Cancelar
                        </button>
                    </ModalFooter>
                </Modal>

                 {/* MODAL PARA crear 2 */}
                 <Modal isOpen={this.state.modalInsertarProducto} toggle={() => { toggle(); this.setState({ profileImg: this.state.img }) }} size='lg'>
                      <ModalHeader toggle={toggle3}>
                        <span>Agregar Producto</span>
                        <button type="button" className="close" onClick={() => { this.setState({ profileImg: this.state.img }); this.modalInsertarProducto(); }} >
                            <FontAwesomeIcon icon={faClose} />
                        </button>

                    </ModalHeader>
                    <ModalBody>
                        <FormGroup>
                            <Row>
                                <Col md={12}>
                                <Label htmlFor='producto'>producto:</Label>
                                    <br />
                                    <Select options={dataproducto} name='producto' onChange={this.handleChangeEspecialidad} placeholder="Seleccione el producto" />
                                    <FormText>
                                    producto del inventario.
                                    </FormText>
                                    <FormFeedback>
                                        Complete el campo
                                    </FormFeedback>
                                </Col>
                                <Col md={12}>
                                <Label htmlFor='producto'>productoxd:</Label>
                                    <br />
                                    <Select options={dataproducto} name='producto' onChange={this.handleChangeEspecialidad} placeholder="Seleccione el producto" />
                                    <FormText>
                                    productoxd del inventario.
                                    </FormText>
                                    <FormFeedback>
                                        Complete el campo
                                    </FormFeedback>
                                </Col>
                                <Col md={12}>
                                <Label htmlFor='producto'>productoxd:</Label>
                                    <br />
                                    <Select options={dataproducto} name='producto' onChange={this.handleChangeEspecialidad} placeholder="Seleccione el producto" />
                                    <FormText>
                                    productoxd del inventario.
                                    </FormText>
                                    <FormFeedback>
                                        Complete el campo
                                    </FormFeedback>
                                </Col>
                                <Col md={12}>
                                <Label htmlFor='cantidad'>Cantidad:</Label>
                                    <Input invalid type='number' name='cantidad' id='cantidad' onChange={this.handleChangeEmpresa} />
                                    <FormText>
                                        producto del inventario.
                                    </FormText></Col>
                            </Row>
                        </FormGroup>
                    </ModalBody>
                    <ModalFooter>
                        <button className='btn btn-primary' onClick={() => this.peticionPostProducto()}>
                            Insertar
                        </button>
                        <button className='btn btn-danger' onClick={() => this.modalInsertarProducto()}>
                            Cancelar
                        </button>
                    </ModalFooter>
                </Modal>
                </div>
            </div>
        )
    }
}