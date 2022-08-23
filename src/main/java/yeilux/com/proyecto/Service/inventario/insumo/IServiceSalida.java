package yeilux.com.proyecto.Service.inventario.insumo;

import java.util.List;

import yeilux.com.proyecto.Model.Class.inventario.insumo.salida;

public interface IServiceSalida {
    public List<salida>listar();
    public void guardar(salida salida);
    public salida consulta(Integer id);
    public void eliminar(Integer id);
}
