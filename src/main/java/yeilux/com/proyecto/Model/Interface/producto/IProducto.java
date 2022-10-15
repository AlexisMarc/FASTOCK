package yeilux.com.proyecto.Model.Interface.producto;

import org.springframework.data.jpa.repository.JpaRepository;

import yeilux.com.proyecto.Model.Class.producto.producto;
import org.springframework.stereotype.Repository;
@Repository
public interface IProducto extends JpaRepository<producto,Integer>{
    
}
