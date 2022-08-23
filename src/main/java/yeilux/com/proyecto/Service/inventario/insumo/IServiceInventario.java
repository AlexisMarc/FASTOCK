package yeilux.com.proyecto.Service.inventario.insumo;

import java.util.List;

import yeilux.com.proyecto.Model.Class.inventario.insumo.inventario;

public interface IServiceInventario {
    public List<inventario>listar();
    public void guardar(inventario inventario);
    public inventario consulta(Integer id);
    public void eliminar(Integer id);
}
