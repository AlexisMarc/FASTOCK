package fastock.fastock.Service.insumo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fastock.fastock.Class.insumo.tipo;
@Repository
public interface ITipo extends JpaRepository<tipo, Integer>{
    
}
