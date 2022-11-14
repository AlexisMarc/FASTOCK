package fastock.fastock.Service.proveedor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fastock.fastock.Class.proveedor.proveedor;
@Repository
public interface IProveedor extends JpaRepository<proveedor, Integer>{
    
}
