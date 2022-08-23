package yeilux.com.proyecto.Service.inventario.producto;

import java.util.List;

import yeilux.com.proyecto.Model.Class.inventario.producto.inventariopro;

public interface IServiceInventariopro {

    public List<inventariopro> listar();

    public void guardar(inventariopro inventariopro);

    public inventariopro consulta(Integer id);

    public void eliminar(Integer id);

}
