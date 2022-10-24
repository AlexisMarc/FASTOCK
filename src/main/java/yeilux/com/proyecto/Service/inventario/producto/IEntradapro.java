package yeilux.com.proyecto.Service.inventario.producto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import yeilux.com.proyecto.Class.inventario.producto.entradapro;
@Repository
public interface IEntradapro extends JpaRepository<entradapro, Integer> {
    
}
