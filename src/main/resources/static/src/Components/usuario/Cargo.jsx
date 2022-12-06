
import React, { Component } from 'react';
import axios from "axios";

import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faEdit, faTrashAlt } from '@fortawesome/free-solid-svg-icons';
import { Modal, ModalBody, ModalFooter, ModalHeader } from 'reactstrap';

const url =  "http://localhost:8083/api/cargo";



class Cargo extends Component {

  state = {
    data: [],
    modalInsertar: false,
    form: {
      id: '',
      nombre: '',
      descripcion: ''
    }
  }


  peticionGet = () => {
    axios.get(url).then(response => {
      this.setState({ data: response.data.content});
    }).catch(error => {
      console.log(error.message);
    })
  }

  peticionPost = async () =>{
    
    delete this.state.form.id;
    await axios.post(url,this.state.form).then(response => {
      this.modalInsertar();
      this.peticionGet();

    }).catch(error => {
      console.log(error.message);
    })
    
  }

  peticionPut = () => {
    axios.put(url + this.state.form.id, this.state.form).then(response => {
        this.modalInsertar();
        this.peticionGet();
    })
}

  seleccionarCargo = (cargo) => {
    this.setState({
        tipoModal: 'actualizar',
        form: {
            id: cargo.id,
            nombre: cargo.nombre,
            descripcion: cargo.descripcion,
            producto: cargo.producto,
            acciones: cargo.acciones
        }
    })
}

  modalInsertar = () => {
    this.setState({ modalInsertar: !this.state.modalInsertar });
  }

  handleChange = async e => {
    e.persist();
    await this.setState({
      form: {
        ...this.state.form,
        [e.target.name]: e.target.value
      }
    });
    console.log(this.state.form);
  }

  componentDidMount() {
    this.peticionGet();
  }

  render() {
    const{form} = this.state;
    return (
      <div className="Categoria" >
        <br />
        <button className='btn btn-primary' onClick={() => this.modalInsertar()}>Agregar Cargo</button>
        <br />
        <br />
        <table className='table'>
          <thead>
            <tr>
              <th>Id</th>
              <th>Nombre</th>
              <th>Descripción</th>
              <th>Acciones</th>
            </tr>
          </thead>
          <tbody>
            {this.state.data.map(cargo => {
              return (
                <tr>
                  <td>{cargo.id}</td>
                  <td>{cargo.nombre}</td>
                  <td>{cargo.descripcion}</td>
                  <td>
                  <button className='btn btn-primary' onClick={() => { this.seleccionarCargo(cargo); this.modalInsertar() }}><FontAwesomeIcon icon={faEdit} /></button> 
                    {" "}
                    <button className='btn btn-danger'><FontAwesomeIcon icon={faTrashAlt} /></button>
                  </td>
                </tr>
              )
            })}
          </tbody>
        </table>


        <Modal isOpen={this.state.modalInsertar}>
          <ModalHeader style={{ display: "block" }}>
            <span style={{ float: 'righ' }} >x</span>
          </ModalHeader>

          <ModalBody>
            <div className="form-group">
              <label htmlFor="id">ID</label>
              <input className="form-control" type="number" name="id" id="id" readOnly onChange={this.handleChange} value={this.state.data.length+1}/>
              <br />
              <label htmlFor="nombre">Nombre</label>
              <input className="form-control" type="text" name='nombre' id='nombre'  onChange={this.handleChange} value={form.nombre} />
              <div />
              <label htmlFor='descripcion'>Descripción</label>
              <input className='form-control' type='text' name='descripcion' id='descripcion'  onChange={this.handleChange} value={form.descripcion} />
            </div>
          </ModalBody>

          <ModalFooter>
            <button className='btn btn-primary' onClick={() => this.peticionPost()}>
              Insertar
            </button>

            <button className='btn btn-danger' onClick={() => this.modalInsertar()}>
              Cancelar
            </button>
          </ModalFooter>
        </Modal>
      </div>
    );
  }
}

export default Cargo;
