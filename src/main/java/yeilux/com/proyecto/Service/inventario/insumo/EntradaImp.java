package yeilux.com.proyecto.Service.inventario.insumo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yeilux.com.proyecto.Model.Class.inventario.insumo.entrada;
import yeilux.com.proyecto.Model.Interface.inventario.insumo.IEntrada;

@Service
public class EntradaImp implements IServiceEntrada{
    @Autowired
    private IEntrada entradai;

    @Override
    public List<entrada> listar() {
        return (List<entrada>)entradai.findAll();
    }

    @Override
    public void guardar(entrada entrada) {
        entradai.save(entrada);
        
    }

    @Override
    public entrada consulta(Integer id) {
        return entradai.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        entradai.deleteById(id);
        
    }
}
