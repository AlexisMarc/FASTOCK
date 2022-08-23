package yeilux.com.proyecto.Service.fabricacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yeilux.com.proyecto.Model.Class.fabricacion.area;
import yeilux.com.proyecto.Model.Interface.fabricacion.IArea;

@Service
public class AreaImp implements IServiceArea {
    @Autowired
    private IArea areai;

    @Override
    public List<area> listar() {
        
        return (List<area>) areai.findAll() ;
    }

    @Override
    public void guardar(area area) {
        areai.save(area);
    }

    @Override
    public area consultar(Integer id) {
        
        return areai.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        areai.deleteById(id);
    }

}
