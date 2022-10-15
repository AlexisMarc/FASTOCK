package yeilux.com.proyecto.Model.Interface.inventario.insumo;

import org.springframework.data.jpa.repository.JpaRepository;

import yeilux.com.proyecto.Model.Class.inventario.insumo.salida;
import org.springframework.stereotype.Repository;
@Repository
public interface ISalida extends JpaRepository<salida, Integer>{
    
}
