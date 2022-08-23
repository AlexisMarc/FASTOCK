package yeilux.com.proyecto.Service.proveedor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yeilux.com.proyecto.Model.Class.proveedor.proveedor;
import yeilux.com.proyecto.Model.Interface.proveedor.IProveedor;

@Service
public class ProveedorImp implements IServiceProveedor{
    @Autowired
    private IProveedor proveedori;
    @Override
    public List<proveedor> listar() {
        
        return (List<proveedor>) proveedori.findAll() ;
    }
    @Override
    public void guardar(proveedor proveedor) {
        proveedori.save(proveedor);
    }

    @Override
    public proveedor consultar(Integer id) {
        
        return proveedori.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        proveedori.deleteById(id);
    }
}
