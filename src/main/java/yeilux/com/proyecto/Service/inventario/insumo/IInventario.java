package yeilux.com.proyecto.Service.inventario.insumo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import yeilux.com.proyecto.Class.inventario.insumo.inventario;
@Repository
public interface IInventario extends JpaRepository<inventario, Integer>{
    
}
