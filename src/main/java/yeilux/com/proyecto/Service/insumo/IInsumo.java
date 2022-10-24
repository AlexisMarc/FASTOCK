package yeilux.com.proyecto.Service.insumo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import yeilux.com.proyecto.Class.insumo.insumo;
@Repository
public interface IInsumo extends JpaRepository<insumo, Integer>{
    
}
