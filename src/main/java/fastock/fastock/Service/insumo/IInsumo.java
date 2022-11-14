package fastock.fastock.Service.insumo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fastock.fastock.Class.insumo.insumo;
@Repository
public interface IInsumo extends JpaRepository<insumo, Integer>{
    
}
