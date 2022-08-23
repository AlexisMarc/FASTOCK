package yeilux.com.proyecto.Service.fabricacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yeilux.com.proyecto.Model.Class.fabricacion.produccion;
import yeilux.com.proyecto.Model.Interface.fabricacion.IProduccion;
@Service
public class ProduccionImp implements IServiceProduccion {
    @Autowired
    private IProduccion produccioni;

    @Override
    public List<produccion> listar() {
        
        return (List<produccion>) produccioni.findAll() ;
    }

    @Override
    public void guardar(produccion produccion) {
        produccioni.save(produccion);
    }

    @Override
    public produccion consultar(Integer id) {
        
        return produccioni.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        produccioni.deleteById(id);
    }

}
