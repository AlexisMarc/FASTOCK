package yeilux.com.proyecto.Service.fabricacion;

import java.util.List;

import yeilux.com.proyecto.Model.Class.fabricacion.produccion;

public interface IServiceProduccion {
    public List<produccion>listar();
    public void guardar (produccion produccion);
    public produccion consultar(Integer id);
    public void eliminar(Integer id);
}
