package yeilux.com.proyecto.Model.Interface.proveedor;

import org.springframework.data.jpa.repository.JpaRepository;

import yeilux.com.proyecto.Model.Class.proveedor.proveedor;
import org.springframework.stereotype.Repository;
@Repository
public interface IProveedor extends JpaRepository<proveedor, Integer>{
    
}
