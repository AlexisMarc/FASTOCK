package yeilux.com.proyecto.Service.fabricacion;

import java.util.List;

import yeilux.com.proyecto.Model.Class.fabricacion.fabricacion;

public interface IServiceFabricacion {
    public List<fabricacion>listar();
    public void guardar (fabricacion fabricacion);
    public fabricacion consultar(Integer id);
    public void eliminar(Integer id);
}
