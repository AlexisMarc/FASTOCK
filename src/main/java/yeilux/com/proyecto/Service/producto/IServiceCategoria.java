package yeilux.com.proyecto.Service.producto;


import java.util.List;

import yeilux.com.proyecto.Model.Class.producto.categoria;

public interface IServiceCategoria  {
    public List<categoria> listar();
    public void guardar(categoria categoria);
    public categoria consulta(Integer id);
    public void eliminar(Integer id);
}
