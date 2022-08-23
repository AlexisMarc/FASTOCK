package yeilux.com.proyecto.Service.inventario.producto;

import java.util.List;

import yeilux.com.proyecto.Model.Class.inventario.producto.salidapro;

public interface IServiceSalidapro {

    public List<salidapro> listar();
    public void guardar(salidapro salidapro);
    public salidapro consulta(Integer id);
    public void eliminar(Integer id);

}
