package yeilux.com.proyecto.Model.Interface.inventario.producto;

import org.springframework.data.jpa.repository.JpaRepository;

import yeilux.com.proyecto.Model.Class.inventario.producto.entradapro;
import org.springframework.stereotype.Repository;
@Repository
public interface IEntradapro extends JpaRepository<entradapro, Integer> {
    
}
