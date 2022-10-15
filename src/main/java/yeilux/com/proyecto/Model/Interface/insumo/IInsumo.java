package yeilux.com.proyecto.Model.Interface.insumo;

import org.springframework.data.jpa.repository.JpaRepository;

import yeilux.com.proyecto.Model.Class.insumo.insumo;
import org.springframework.stereotype.Repository;
@Repository
public interface IInsumo extends JpaRepository<insumo, Integer>{
    
}
