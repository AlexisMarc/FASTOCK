package yeilux.com.proyecto.Service.fabricacion;

import java.util.List;

import yeilux.com.proyecto.Model.Class.fabricacion.area;

public interface IServiceArea {
    public List<area>listar();
    public void guardar (area area);
    public area consultar(Integer id);
    public void eliminar(Integer id);
}
