package yeilux.com.proyecto.Service.inventario.insumo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import yeilux.com.proyecto.Model.Class.inventario.insumo.inventario;
import yeilux.com.proyecto.Model.Interface.inventario.insumo.IInventario;

public class InventarioImp implements IServiceInventario {

    @Autowired
    public IInventario inventarioi;

    @Override
    public List<inventario> listar() {
        return (List<inventario>)inventarioi.findAll();
    }

    @Override
    public void guardar(inventario inventario) {
        inventarioi.save(inventario);
    }

    @Override
    public inventario consulta(Integer id) {

        return inventarioi.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        inventarioi.deleteById(id);
        
    }
    
}
