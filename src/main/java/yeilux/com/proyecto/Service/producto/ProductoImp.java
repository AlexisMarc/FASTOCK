package yeilux.com.proyecto.Service.producto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yeilux.com.proyecto.Model.Class.producto.producto;
import yeilux.com.proyecto.Model.Interface.producto.IProducto;


@Service
public class ProductoImp implements IServiceProducto {
    
    @Autowired
    private IProducto productoi;

    @Override
    public List<producto> listar() {
        return (List<producto>) productoi.findAll();
    }

    @Override
    public void guardar(producto producto) {
        productoi.save(producto);
    }

    @Override
    public producto consulta(Integer id) {
        return productoi.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id){
        productoi.deleteById(id);
    }
}
