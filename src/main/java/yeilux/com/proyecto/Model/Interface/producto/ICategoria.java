package yeilux.com.proyecto.Model.Interface.producto;

import org.springframework.data.repository.CrudRepository;

import yeilux.com.proyecto.Model.Class.producto.categoria;


public interface ICategoria extends CrudRepository<categoria, Integer> {
    
}
