package yeilux.com.proyecto.Model.Interface.Empresa;

import org.springframework.data.jpa.repository.JpaRepository;

import yeilux.com.proyecto.Model.Class.empresa.especialidad;
import org.springframework.stereotype.Repository;
@Repository
public interface IEspecialidad extends JpaRepository<especialidad, Integer> {
    
}
