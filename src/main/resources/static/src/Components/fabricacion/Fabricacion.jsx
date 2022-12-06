import React, { Component, } from 'react';
import { DataTable } from 'primereact/datatable';
import { Column } from 'primereact/column';
import { Rating } from 'primereact/rating';
import { InputText } from 'primereact/inputtext';
import RLDD from "react-list-drag-and-drop/lib/RLDD";
import { FilterMatchMode } from 'primereact/api';
import axios from 'axios';
import Select from 'react-select'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faClose, faEdit, faEye, faGrip, faPlus, faTrashAlt } from '@fortawesome/free-solid-svg-icons';
import Validacion from '../../Utils/Validacion';
import { Alert, Badge, Button, Col, FormFeedback, FormGroup, FormText, Input, Label, ListGroup, ListGroupItem, Modal, ModalBody, ModalFooter, ModalHeader, Row } from 'reactstrap';
import { autorizacion, baseUrl, autorizacionFiles } from '../../Utils/Api';

import { Accordion, AccordionTab } from 'primereact/accordion';
import swal from 'sweetalert';
import { Toast } from 'primereact/toast';

import 'primeicons/primeicons.css';
import 'primereact/resources/themes/lara-light-indigo/theme.css';
import 'primereact/resources/primereact.css';
import 'primeflex/primeflex.css';

//URL PRINCIPAL
const url = baseUrl + 'fabricacion/';


export default class Fabricacion extends Component {

  constructor(props) {
    super(props);

    this.state = {
      data: [],
      dataInsumo: [],
      dataProducto: [],
      dataUsuario: [],
      dataCategoria: [],
      producto: {
        nombre: '',
        descripcion: '',
        imagen: null,
        categoria: []
    },
    fabricacion: {
      usuario: null,
      insumo: [],
      producto: null,
    },
    area: {
      nombre: '',
      fabricacion: null,
      tipo: '',
      idencargado: null,
      numerador: null,
    },
      items: [
        {
          id: 1,
          numerador: null,
          nombre: 'Diseño',
          tipo: '',
          idencargado: null,
        },
        {
          id: 2,
          numerador: null,
          nombre: 'Costura',
          tipo: '',
          idencargado: null,
        },
        {
          id: 3,
          numerador: null,
          nombre: 'Lavado',
          tipo: '',
          idencargado: null,
        },
        {
          id: 4,
          numerador: null,
          nombre: 'Control de calidad',
          tipo: '',
          idencargado: null,
        },
      ],
      data: [],
      expandedRows: null,
      modalInsertarFabricacion: false,
      colors: ['PHP', 'MYSQL', 'REACT', 'LARAVEL'],
    };
    this.navList = this.nav.bind(this);
    this.handleRLDDChange = this.handleRLDDChange.bind(this);
    this.amountBodyTemplate = this.amountBodyTemplate.bind(this);
    this.rowExpansionTemplate = this.rowExpansionTemplate.bind(this);
    this.searchBodyTemplate = this.searchBodyTemplate.bind(this);
    this.imageBodyTemplate = this.imageBodyTemplate.bind(this);
    this.priceBodyTemplate = this.priceBodyTemplate.bind(this);
    this.ratingBodyTemplate = this.ratingBodyTemplate.bind(this);
    this.statusBodyTemplate = this.statusBodyTemplate.bind(this);
    this.statusOrderBodyTemplate = this.statusOrderBodyTemplate.bind(this);
    this.onRowExpand = this.onRowExpand.bind(this);
    this.onRowCollapse = this.onRowCollapse.bind(this);
    this.expandAll = this.expandAll.bind(this);
    this.collapseAll = this.collapseAll.bind(this);
  }

  //PETICION GET
  peticionGet = () => {
    axios.get(baseUrl + "producto/", autorizacion).then(response => {
      const datos = [];
      response.data.forEach((i) => {
        const dato = { value: i.id, label: i.nombre }
        datos.push(dato);

      })
      this.setState({ dataProducto: datos, });
    }).catch(error => {
      console.log(error.message);
      this.setState({ loading: false });
      swal({ title: "ERROR AL CONSULTAR PRODUCTO", text: " ", icon: "error", buttons: false, timer: 1500 })
    })
    axios.get(baseUrl + "insumo", autorizacion).then(response => {
      const datos = [];
      response.data.forEach((i) => {
        const dato = { value: i.id, label: i.nombre }
        datos.push(dato);

      })
      this.setState({ dataInsumo: datos, });
    }).catch(error => {
      console.log(error.message);
      this.setState({ loading: false });
      swal({ title: "ERROR AL CONSULTAR INSUMO", text: " ", icon: "error", buttons: false, timer: 1500 })
    })

    axios.get(baseUrl + "fabricacion", autorizacion).then(response => {
      this.setState({ data: response.data, loading: false });
    }).catch(error => {
      console.log(error.message);
      this.setState({ loading: false });
      swal({ title: "ERROR AL CONSULTAR FABRICACION", text: " ", icon: "error", buttons: false, timer: 1500 })
    })
    axios.get(baseUrl + "usuario", autorizacion).then(response => {
      const datos = [];
      response.data.forEach((i) => {
        const dato = { value: i.id, label: i.nombre + ' ' + i.apellido }
        datos.push(dato);
        ;
      })
      this.setState({ dataUsuario: datos, })
    }).catch(error => {
      console.log(error.message);
      this.setState({ loading: false });
      swal({ title: "ERROR AL CONSULTAR USUARIO", text: " ", icon: "error", buttons: false, timer: 1500 })
    })
    axios.get(baseUrl + 'producto/categoria/', autorizacion).then(response => {
      const datos = [];

      response.data.forEach((categoria) => {
        const dato = { value: categoria.id, label: categoria.nombre }
        datos.push(dato);
      })

      this.setState({ dataCategoria: datos });
    }).catch(error => {
      console.log(error.message);
      swal({ title: "ERROR AL CONSULTAR CATEGORIAS", text: " ", icon: "error", buttons: false, timer: 1500 })
    })
  }


  //MODAL DE INSERTAR
  modalInsertarFabricacion = () => {
    this.setState({ modalInsertarFabricacion: !this.state.modalInsertarFabricacion });
  }

  componentDidMount() {
    this.peticionGet();
  }

  onRowExpand(event) {
    this.toast.show({ severity: 'info', summary: 'Product Expanded', detail: event.data.name, life: 3000 });
  }

  onRowCollapse(event) {
    this.toast.show({ severity: 'success', summary: 'Product Collapsed', detail: event.data.name, life: 3000 });
  }

  expandAll() {
    let expandedRows = {};
    this.state.data.forEach(p => expandedRows[`${p.id}`] = true);

    this.setState({
      expandedRows
    }, () => {
      this.toast.show({ severity: 'success', summary: 'All Rows Expanded', life: 3000 });
    });
  }

  collapseAll() {
    this.setState({
      expandedRows: null
    }, () => {
      this.toast.show({ severity: 'success', summary: 'All Rows Collapsed', life: 3000 });
    });
  }

  formatCurrency(value) {
    return null;
  }

  amountBodyTemplate(rowData) {
    return this.formatCurrency(rowData.amount);
  }

  statusOrderBodyTemplate(rowData) {
    return <span className={`order-badge order-${rowData.status.toLowerCase()}`}>{rowData.status}</span>;
  }

  searchBodyTemplate() {
    return <Button icon="pi pi-search" />;
  }

  imageBodyTemplate(rowData) {
    return <img src={`images/product/${rowData.image}`} onError={(e) => e.target.src = 'https://www.primefaces.org/wp-content/uploads/2020/05/placeholder.png'} alt={rowData.image} className="product-image" />;
  }

  priceBodyTemplate(rowData) {
    return this.formatCurrency(rowData.price);
  }

  ratingBodyTemplate(rowData) {
    return <Rating value={rowData.rating} readOnly cancel={false} />;
  }

  statusBodyTemplate(rowData) {
    return null;
  }

  allowExpansion(rowData) {
    return rowData.area.length > 0;
  };

  rowExpansionTemplate(data) {
    return (
      <div className="orders-subtable">
        <h5>Areas</h5>
        <DataTable value={data.area} responsiveLayout="scroll">
          <Column field="id" header="Id" sortable></Column>
          <Column field="nombre" header="Nombre" sortable></Column>
          <Column field="fechainicio" header="Fecha de Inicio" sortable></Column>
        </DataTable>
      </div>
    );
  }

  nav(item, index) {
    return (
      <ListGroupItem>
        <Row>
          <Col md={1}>
            <Label>#</Label>
            <p><FontAwesomeIcon icon={faGrip} /></p>
          </Col>
          <Col md={4}>
            <FormGroup>
              <Label htmlFor={index + 1}>Nombre de Área {index + 1}:</Label>
              <Input type='text' id={index + 1} name={index + 1} defaultValue={item.nombre} />
            </FormGroup>
          </Col>
          <Col md={3}>
            <FormGroup>
              <Label>Tipo Encargado:</Label>
              <Select />
            </FormGroup>
          </Col>
          <Col md={3}>
            <FormGroup>
              <Label>Encargado:</Label>
              <Select />
            </FormGroup>
          </Col>
          <Col md={1}>
            <Label>Eliminar</Label><br />
            <Button color='danger'><FontAwesomeIcon icon={faClose} /></Button>
          </Col>
        </Row>
      </ListGroupItem>
    );
  }


  handleRLDDChange(reorderedItems) {
    this.setState({ items: reorderedItems });
    console.log(reorderedItems);
  }

  render() {
    const header = (
      <div className="table-header-container">
        <Button icon="pi pi-plus" label="Expand All" onClick={this.expandAll} className="mr-2" />
        <Button icon="pi pi-minus" label="Collapse All" onClick={this.collapseAll} />
      </div>
    );
    const { data, dataProducto, dataInsumo, dataUsuario, dataCategoria } = this.state;
    const toggle = () => this.modalInsertarFabricacion();

    return (
      <div className="datatable-rowexpansion-demo">
        <div className="flex justify-content-between align-items-center">
          <h5 className="m-0 h5">Fabricación</h5>
          <button className='btn btn-primary' onClick={() => { this.modalInsertarFabricacion() }} ><FontAwesomeIcon icon={faPlus} style={{ "marginRight": "1rem" }} /><span className='menu-title'>Crear</span></button>
        </div><br />
        <Toast ref={(el) => this.toast = el} />

        <div className="card">
          <DataTable value={data} expandedRows={this.state.expandedRows} onRowToggle={(e) => this.setState({ expandedRows: e.data })}
            onRowExpand={this.onRowExpand} onRowCollapse={this.onRowCollapse} responsiveLayout="stack"
            rowExpansionTemplate={this.rowExpansionTemplate} dataKey="id" header={header}>
            <Column expander={this.allowExpansion} style={{ width: '3em' }} />
            <Column field="name" header="Producto" sortable />
            <Column header="Imagen" body={this.imageBodyTemplate} />
            <Column field="fechainicio" header="Fecha de Inicio" sortable />
          </DataTable>
        </div>
        {/* MODAL DE REGISTRAR */}
        <Modal isOpen={this.state.modalInsertarFabricacion} toggle={() => { toggle(); }} size="xl">
          <ModalHeader>
            <span>Agregar Fabricación</span>
            <button type="button" className="close" onClick={() => { this.modalInsertarFabricacion(); }}>
              <FontAwesomeIcon icon={faClose} />
            </button>

          </ModalHeader>

          <ModalBody>

            <FormGroup>

              <Accordion activeIndex={0}>
                <AccordionTab header="Datos del producto">
                  <Row>
                    <Col md={6}>
                      <Label htmlFor='nombre'>Nombre:</Label>
                      <Input type='text' name='nombre' id='nombre' />
                      <FormText>
                        Nombre del producto.
                      </FormText>
                      <FormFeedback>
                      </FormFeedback>
                      <Label htmlFor='categoria'>Categoria:</Label>
                      <br />
                      <Select isMulti name='categoria' options={dataCategoria} placeholder="Seleccione la categoria" />
                      <FormText>
                        Categoria del producto.
                      </FormText>

                      <br />
                      <button className='btn btn-primary' onClick={() => { this.setState({ categoria: null }); this.modalInsertarCategoria() }}>
                        Agregar Categoría
                      </button>
                    </Col>
                    <Col md={6}>
                      <Label htmlFor='nombre'>Encargado:</Label>
                      <Select options={dataUsuario} />
                      <FormText>
                        Encargado de la fabricación
                      </FormText>
                      <FormFeedback>
                      </FormFeedback>
                      <Label htmlFor='material'>Insumos para la fabricación:</Label>
                      <Select isMulti options={dataInsumo} />
                      <FormText>
                        Descripción del Insumo.
                      </FormText>
                      <FormFeedback>
                      </FormFeedback>

                    </Col>

                  </Row>
                </AccordionTab>
                <AccordionTab header="Áreas de la fabricación">
                  <Row>
                    <Col md={12}>
                      <Label htmlFor='area'>Áreas:</Label>
                      <FormText>
                        Áreas de la fabricación, puedes modificar el orden de la las áreas.
                      </FormText>
                      <br />
                      <Col md={6} className="input-group mb-3">
                        <input type="text" className="form-control" placeholder="Agregar área..." />
                        <div className="input-group-append">
                          <Button color="primary">Agregar</Button>
                        </div>
                      </Col>
                      <FormFeedback>
                      </FormFeedback>
                      <ListGroup flush>
                        <div className="card">
                          <RLDD
                            items={this.state.items}
                            itemRenderer={this.nav}
                            onChange={this.handleRLDDChange}
                          />
                        </div>
                      </ListGroup>
                    </Col>
                  </Row>
                </AccordionTab>
              </Accordion>

            </FormGroup>
          </ModalBody>

          <ModalFooter>
            <Button disabled={this.state.button} color='primary' onClick={() => this.peticionPostInsumo()}>
              Insertar
            </Button>
            <button className='btn btn-danger' onClick={() => { this.modalInsertarFabricacion(); }}>
              Cancelar
            </button>
          </ModalFooter>
        </Modal>
      </div>
    );
  }
}