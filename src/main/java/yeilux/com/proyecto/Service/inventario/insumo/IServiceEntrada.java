package yeilux.com.proyecto.Service.inventario.insumo;

import java.util.List;

import yeilux.com.proyecto.Model.Class.inventario.insumo.entrada;

public interface IServiceEntrada {
    public List<entrada>listar();
    public void guardar(entrada entrada);
    public entrada consulta(Integer id);
    public void eliminar(Integer id); 
}
