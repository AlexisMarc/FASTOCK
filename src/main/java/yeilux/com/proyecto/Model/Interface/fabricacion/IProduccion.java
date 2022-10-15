package yeilux.com.proyecto.Model.Interface.fabricacion;

import org.springframework.data.jpa.repository.JpaRepository;

import yeilux.com.proyecto.Model.Class.fabricacion.produccion;
import org.springframework.stereotype.Repository;
@Repository
public interface IProduccion extends JpaRepository<produccion, Integer>{
    
}
