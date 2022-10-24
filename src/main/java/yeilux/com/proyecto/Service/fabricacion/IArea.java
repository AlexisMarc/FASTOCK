package yeilux.com.proyecto.Service.fabricacion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import yeilux.com.proyecto.Class.fabricacion.area;
@Repository
public interface IArea extends JpaRepository<area, Integer> {
    
}
