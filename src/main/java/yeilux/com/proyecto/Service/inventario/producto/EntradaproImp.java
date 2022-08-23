package yeilux.com.proyecto.Service.inventario.producto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yeilux.com.proyecto.Model.Class.inventario.producto.entradapro;
import yeilux.com.proyecto.Model.Interface.inventario.producto.IEntradapro;

@Service
public class EntradaproImp implements IServiceEntradapro {

    @Autowired
    private IEntradapro entradaproi;

    @Override
    public List<entradapro> listar() {
        return (List<entradapro>) entradaproi.findAll();
    }

    @Override
    public void guardar(entradapro entradapro) {
        entradaproi.save(entradapro);
    }

    @Override
    public entradapro consulta(Integer id) {
        return entradaproi.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        entradaproi.deleteById(id);
    }

}
