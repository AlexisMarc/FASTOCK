package yeilux.com.proyecto.Service.empresa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yeilux.com.proyecto.Model.Class.empresa.especialidad;
import yeilux.com.proyecto.Model.Interface.Empresa.IEspecialidad;
@Service
public class EspecialidadImp implements IServiceEspecialidad {
    @Autowired
    private IEspecialidad especialidadi;

    @Override
    public List<especialidad> listar() {
        
        return (List<especialidad>) especialidadi.findAll() ;
    }

    @Override
    public void guardar(especialidad especialidad) {
        especialidadi.save(especialidad);
    }

    @Override
    public especialidad consultar(Integer id) {
        
        return especialidadi.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        especialidadi.deleteById(id);
    }

    
}
