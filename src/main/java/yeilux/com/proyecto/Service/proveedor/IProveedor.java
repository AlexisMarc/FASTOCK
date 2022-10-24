package yeilux.com.proyecto.Service.proveedor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import yeilux.com.proyecto.Class.proveedor.proveedor;
@Repository
public interface IProveedor extends JpaRepository<proveedor, Integer>{
    
}
