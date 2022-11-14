package fastock.fastock.Service.Empresa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fastock.fastock.Class.empresa.especialidad;
@Repository
public interface IEspecialidad extends JpaRepository<especialidad, Integer> {
    
}
