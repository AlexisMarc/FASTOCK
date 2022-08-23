package yeilux.com.proyecto.Service.inventario.producto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yeilux.com.proyecto.Model.Class.inventario.producto.inventariopro;
import yeilux.com.proyecto.Model.Interface.inventario.producto.IInventariopro;

@Service
public class InventarioproImp implements IServiceInventariopro {

    @Autowired
    private IInventariopro inventarioproi;

    @Override
    public List<inventariopro> listar() {
        return (List<inventariopro>) inventarioproi.findAll();
    }

    @Override
    public void guardar(inventariopro inventariopro) {
        inventarioproi.save(inventariopro);
    }

    @Override
    public inventariopro consulta(Integer id) {
        return inventarioproi.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        inventarioproi.deleteById(id);
    }

}
