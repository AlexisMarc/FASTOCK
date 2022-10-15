package yeilux.com.proyecto.Model.Interface.inventario.insumo;

import org.springframework.data.jpa.repository.JpaRepository;

import yeilux.com.proyecto.Model.Class.inventario.insumo.entrada;
import org.springframework.stereotype.Repository;
@Repository
public interface IEntrada extends JpaRepository<entrada, Integer>{
    
}
