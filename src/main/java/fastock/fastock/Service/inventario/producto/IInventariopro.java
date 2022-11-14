package fastock.fastock.Service.inventario.producto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fastock.fastock.Class.inventario.producto.inventariopro;
@Repository
public interface IInventariopro extends JpaRepository<inventariopro, Integer> {
    
}
