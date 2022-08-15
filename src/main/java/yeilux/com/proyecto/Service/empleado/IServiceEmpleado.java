package yeilux.com.proyecto.Service.empleado;

import java.util.List;

import yeilux.com.proyecto.Model.Class.empleado.empleado;

public interface IServiceEmpleado {

    public List<empleado>listar();
    public void guardar(empleado empleado);

    public empleado consulta(Integer id);
    public void eliminar(Integer id);
    
}
