package fastock.fastock.Service.inventario.insumo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fastock.fastock.Class.inventario.insumo.inventario;
@Repository
public interface IInventario extends JpaRepository<inventario, Integer>{
    
}
