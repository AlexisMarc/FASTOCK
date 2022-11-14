package fastock.fastock.Service.fabricacion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fastock.fastock.Class.fabricacion.fabricacion;
@Repository
public interface IFabricacion extends JpaRepository<fabricacion, Integer>{
    
}
