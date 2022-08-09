package yeilux.com.proyecto.Service.empleado;

import java.util.List;

import yeilux.com.proyecto.Model.Class.empleado.cargo;

public interface IServiceCargo {
    public List<cargo>listar();
    public void guardar(cargo cargo);

    public cargo consulta(Integer id);
    public void eliminar(Integer id);
    
}
