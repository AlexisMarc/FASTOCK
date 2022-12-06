import axios from 'axios';
import React, { Component } from 'react';
import { Modal, ModalBody, ModalFooter, ModalHeader } from 'reactstrap';

import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faEdit } from '@fortawesome/free-solid-svg-icons';


const url = "http://localhost:8083/api/produccion";

class Produccion extends Component {

state = {
    data: [],
    modalInsertar: false,
    form : {
        id: '',
        descripcion: '',
        fecha: '',
        tipo: '',
        area_id: ''
    }
}

modalInsertar = ()=>{
    this.setState({modalInsertar : !this.state.modalInsertar})
}

peticionPut = () => {
    axios.put(url + this.state.form.id, this.state.form).then(response => {
        this.modalInsertar();
        this.peticionGet();
    })
}

peticionPost = async () => {

  delete this.state.form.id;
  await axios.post(url, this.state.form).then(response => {
      this.modalInsertar();
      this.peticionGet();

  }).catch(error => {
      console.log(error.message);
  })

}

  seleccionarProduccion = (produccion) => {
    this.setState({
        tipoModal: 'actualizar',
        form: {
            id: produccion.id,
            descripcion: produccion.descripcion,
            fecha: produccion.fecha,
            tipo:produccion.tipo,
            area_id:produccion.area_id
        }
    })
}

handleChange = async e =>{
    e.persist();
    await this.setState({
        form:{
        ...this.state.form,
        [e.target.name]: e.target.value
        }
    })
    console.log(this.state.form)
    }

peticionGet = () => (
    axios.get(url).then(response => {
        this.setState({ data: response.data.content});
})
    
)
    
componentDidMount() {
    this.peticionGet();
}

render() {
    const { form } = this.state;
return (
<div className="Produccion" >
    <br />
    <button className='btn btn-primary' onClick={() => { this.setState({ form: null, tipoModal: 'insertar' }); this.modalInsertar() }}>Agregar Produccion</button>
    <br />
    <br />
    <table className='table'>
        <thead>
            <tr>
                <th>Id</th>
                <th>Descripcion</th>
                <th>Fecha</th>
                <th>Tipo</th>
                <th>Area_id</th>
            </tr>
        </thead>
            <tbody>
                {this.state.data.map(produccion => {
                return (
                <tr>
                    <td>{produccion.id}</td>
                    <td>{produccion.descripcion}</td>
                    <td>{produccion.fecha}</td>
                    <td>{produccion.tipo}</td>
                    <td>{produccion.area_id}</td>
                    <td>
                    <button className='btn btn-primary' onClick={() => { this.seleccionarProduccion(produccion); this.modalInsertar() }}><FontAwesomeIcon icon={faEdit} /></button>
                        {" "}
                        <button className='btn btn-danger'>Eliminar</button>
                    </td>
                </tr>
                )
})}
</tbody>
<Modal isOpen={this.state.modalInsertar}>
    <ModalHeader style={{display: 'block'}}>
            <span style={{float: 'right'}} onClick={()=>this.modalInsertar()}>x</span>
    </ModalHeader>
    <ModalBody>
                <div className="form-group">
                    <label htmlFor="id">Id</label>
                    <input className="form-control" type="text" name="id" id="id" readOnly onChange={this.handleChange} value={form ? form.id : this.state.data.length + 1}/>
                    <br />
                    <label htmlFor="nombre">Descripcion</label>
                    <input className="form-control" type="text" name="descripcion" id="descripcion" onChange={this.handleChange} value={form ? form.descripcion:''}/>
                    <br />
                    <label htmlFor="nombre">Fecha</label>
                    <input className="form-control" type="text" name="fecha" id="fecha" onChange={this.handleChange} value={form ? form.fecha:''}/>
                    <br />
                    <label htmlFor="nombre">Tipo</label>
                    <input className="form-control" type="text" name="tipo" id="tipo" onChange={this.handleChange} value={form ? form.tipo:''}/>
                    <br />
                    <label htmlFor="capital_bursatil">Area_id</label>
                    <input className="form-control" type="number" name="area_id" id="area_id" onChange={this.handleChange} value={form ? form.area_id:''}/>
                    <br />
            </div>
                </ModalBody>

                <ModalFooter>
                {this.state.tipoModal ==='insertar'?
                    <button className="btn btn-primary" onClick={()=>this.peticionPost()}>
                    Insertar
                </button>: <button className="btn btn-primary" onClick={()=>this.peticionPut()}>
                    Actualizar
                </button>
}
                    <button className="btn btn-danger" onClick={()=>this.modalInsertar()}>Cancelar</button>
                </ModalFooter>
            </Modal>

            <Modal isOpen={this.state.modalEliminar}>
            <ModalBody>
                ¿Estás seguro que deseas eliminar el tipo?
            </ModalBody>
            <ModalFooter>
                        {this.state.tipoModal === 'insertar' ?
                            <button className='btn btn-primary' onClick={() => this.peticionPost()}>
                                Insertar
                            </button> : <button className='btn btn-primary' onClick={() => this.peticionPut()}>
                                Actualizar
                            </button>
                        }
                        <button className='btn btn-danger' onClick={() => this.modalInsertar()}>
                            Cancelar
                        </button>
                    </ModalFooter>
            </Modal>

        </table>
    </div>
    );
}
}

export default Produccion;