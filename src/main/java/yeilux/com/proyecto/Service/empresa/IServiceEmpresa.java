package yeilux.com.proyecto.Service.empresa;

import java.util.List;

import yeilux.com.proyecto.Model.Class.empresa.empresa;

public interface IServiceEmpresa {
    public List<empresa>listar();
    public void guardar (empresa empresa);
    public empresa consultar(Integer id);
    public void eliminar(Integer id);
}
