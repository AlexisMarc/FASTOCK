package fastock.fastock.Service.fabricacion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fastock.fastock.Class.fabricacion.area;
@Repository
public interface IArea extends JpaRepository<area, Integer> {
    
}
