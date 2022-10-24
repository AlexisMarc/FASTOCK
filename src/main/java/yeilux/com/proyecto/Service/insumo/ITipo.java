package yeilux.com.proyecto.Service.insumo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import yeilux.com.proyecto.Class.insumo.tipo;
@Repository
public interface ITipo extends JpaRepository<tipo, Integer>{
    
}
