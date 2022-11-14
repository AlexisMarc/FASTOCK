package fastock.fastock.Service.producto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fastock.fastock.Class.producto.categoria;
@Repository
public interface ICategoria extends JpaRepository<categoria, Integer> {
    
}
