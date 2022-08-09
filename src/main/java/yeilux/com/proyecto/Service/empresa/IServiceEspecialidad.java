package yeilux.com.proyecto.Service.empresa;

import java.util.List;

import yeilux.com.proyecto.Model.Class.empresa.especialidad;

public interface IServiceEspecialidad {

    public List<especialidad>listar();
    public void guardar (especialidad especialidad);
    public especialidad consultar(Integer id);
    public void eliminar(Integer id);
}
