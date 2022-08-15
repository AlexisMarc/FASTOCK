package yeilux.com.proyecto.Service.producto;

import java.util.List;

import yeilux.com.proyecto.Model.Class.producto.producto;


public interface IServiceProducto {

    public List<producto> listar();
    public void guardar(producto producto);
    public producto consulta(Integer id);
    public void eliminar(Integer id);
    


    
}
