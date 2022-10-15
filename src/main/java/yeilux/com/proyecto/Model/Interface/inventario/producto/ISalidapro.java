package yeilux.com.proyecto.Model.Interface.inventario.producto;

import org.springframework.data.jpa.repository.JpaRepository;

import yeilux.com.proyecto.Model.Class.inventario.producto.salidapro;
import org.springframework.stereotype.Repository;
@Repository
public interface ISalidapro extends JpaRepository<salidapro, Integer> {
    
}
