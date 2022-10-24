package yeilux.com.proyecto.Service.producto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import yeilux.com.proyecto.Class.producto.categoria;
@Repository
public interface ICategoria extends JpaRepository<categoria, Integer> {
    
}
