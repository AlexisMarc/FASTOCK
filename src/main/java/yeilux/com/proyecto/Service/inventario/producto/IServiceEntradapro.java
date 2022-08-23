package yeilux.com.proyecto.Service.inventario.producto;

import java.util.List;

import yeilux.com.proyecto.Model.Class.inventario.producto.entradapro;

public interface IServiceEntradapro {

    public List<entradapro> listar();

    public void guardar(entradapro entradapro);

    public entradapro consulta(Integer id);

    public void eliminar(Integer id);

}
