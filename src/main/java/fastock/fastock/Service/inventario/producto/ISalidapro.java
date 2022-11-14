package fastock.fastock.Service.inventario.producto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fastock.fastock.Class.inventario.producto.salidapro;
@Repository
public interface ISalidapro extends JpaRepository<salidapro, Integer> {
    
}
