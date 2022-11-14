package fastock.fastock.Service.producto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fastock.fastock.Class.producto.producto;
@Repository
public interface IProducto extends JpaRepository<producto,Integer>{
    
}
