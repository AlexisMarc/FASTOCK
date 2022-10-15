package yeilux.com.proyecto.Model.Interface.empleado;

import org.springframework.data.jpa.repository.JpaRepository;

import yeilux.com.proyecto.Model.Class.empleado.empleado;
import org.springframework.stereotype.Repository;
@Repository
public interface IEmpleado extends JpaRepository<empleado, Integer>{

    
}
