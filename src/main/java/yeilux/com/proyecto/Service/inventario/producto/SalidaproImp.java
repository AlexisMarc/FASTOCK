package yeilux.com.proyecto.Service.inventario.producto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yeilux.com.proyecto.Model.Class.inventario.producto.salidapro;
import yeilux.com.proyecto.Model.Interface.inventario.producto.ISalidapro;

@Service
public class SalidaproImp implements IServiceSalidapro {

    @Autowired
    private ISalidapro salidaproi;

    @Override
    public List<salidapro> listar() {
        return (List<salidapro>) salidaproi.findAll();
    }

    @Override
    public void guardar(salidapro salidapro) {
        salidaproi.save(salidapro);
    }

    @Override
    public salidapro consulta(Integer id) {
        return salidaproi.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id){
       salidaproi.deleteById(id);
    }
    
}
