package yeilux.com.proyecto.Service.empleado;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yeilux.com.proyecto.Model.Class.empleado.empleado;
import yeilux.com.proyecto.Model.Interface.empleado.IEmpleado;

@Service
public class EmpleadoImp implements IServiceEmpleado{

    @Autowired
    private IEmpleado empleadoi;

    @Override
    public List<empleado> listar() {
        return (List<empleado>)empleadoi.findAll();
    }

    @Override
    public void guardar(empleado empleado) {
        empleadoi.save(empleado);
    }

    @Override
    public empleado consulta(Integer id) {
        return empleadoi.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        empleadoi.deleteById(id);
    }

    
    
}
