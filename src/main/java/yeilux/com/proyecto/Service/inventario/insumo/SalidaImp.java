package yeilux.com.proyecto.Service.inventario.insumo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yeilux.com.proyecto.Model.Class.inventario.insumo.salida;
import yeilux.com.proyecto.Model.Interface.inventario.insumo.ISalida;

@Service
public class SalidaImp implements IServiceSalida{
    @Autowired
    private ISalida salidai;

    @Override
    public List<salida> listar() {
        return (List<salida>)salidai.findAll();
    }

    @Override
    public void guardar(salida salida) {
        salidai.save(salida);
        
    }

    @Override
    public salida consulta(Integer id) {
        return salidai.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        salidai.deleteById(id);
        
    }
    
}
