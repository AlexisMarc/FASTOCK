package yeilux.com.proyecto.Model.Interface.inventario.producto;

import org.springframework.data.jpa.repository.JpaRepository;

import yeilux.com.proyecto.Model.Class.inventario.producto.inventariopro;
import org.springframework.stereotype.Repository;
@Repository
public interface IInventariopro extends JpaRepository<inventariopro, Integer> {
    
}
