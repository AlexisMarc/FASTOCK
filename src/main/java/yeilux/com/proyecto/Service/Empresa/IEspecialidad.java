package yeilux.com.proyecto.Service.Empresa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import yeilux.com.proyecto.Class.empresa.especialidad;
@Repository
public interface IEspecialidad extends JpaRepository<especialidad, Integer> {
    
}
