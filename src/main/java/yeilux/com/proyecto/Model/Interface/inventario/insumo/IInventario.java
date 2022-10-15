package yeilux.com.proyecto.Model.Interface.inventario.insumo;

import org.springframework.data.jpa.repository.JpaRepository;

import yeilux.com.proyecto.Model.Class.inventario.insumo.inventario;
import org.springframework.stereotype.Repository;
@Repository
public interface IInventario extends JpaRepository<inventario, Integer>{
    
}
