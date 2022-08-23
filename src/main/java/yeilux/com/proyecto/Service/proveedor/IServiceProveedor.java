package yeilux.com.proyecto.Service.proveedor;

import java.util.List;

import yeilux.com.proyecto.Model.Class.proveedor.proveedor;

public interface IServiceProveedor {
    public List<proveedor>listar();
    public void guardar (proveedor proveedor);
    public proveedor consultar(Integer id);
    public void eliminar(Integer id);
}
