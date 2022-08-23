package yeilux.com.proyecto.Service.insumo;

import java.util.List;

import yeilux.com.proyecto.Model.Class.insumo.insumo;

public interface IServiceInsumo {

    public List<insumo>listar();
    public void guardar(insumo insumo);
    public insumo consulta(Integer id);
    public void eliminar(Integer id);
}

