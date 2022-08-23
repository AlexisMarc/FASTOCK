package yeilux.com.proyecto.Service.fabricacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yeilux.com.proyecto.Model.Class.fabricacion.fabricacion;
import yeilux.com.proyecto.Model.Interface.fabricacion.IFabricacion;

@Service
public class FabricacionImp implements IServiceFabricacion {
    @Autowired
    private IFabricacion fabricacioni;

    @Override
    public List<fabricacion> listar() {
        
        return (List<fabricacion>) fabricacioni.findAll() ;
    }

    @Override
    public void guardar(fabricacion fabricacion) {
        fabricacioni.save(fabricacion);
    }

    @Override
    public fabricacion consultar(Integer id) {
        
        return fabricacioni.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        fabricacioni.deleteById(id);
    }

}
