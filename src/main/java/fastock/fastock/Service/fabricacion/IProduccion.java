package fastock.fastock.Service.fabricacion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fastock.fastock.Class.fabricacion.produccion;
@Repository
public interface IProduccion extends JpaRepository<produccion, Integer>{
    
}
