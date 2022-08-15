package yeilux.com.proyecto.Service.insumo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yeilux.com.proyecto.Model.Class.Interface.IInsumo;
import yeilux.com.proyecto.Model.Class.insumo.insumo;

@Service
public class InsumoImp implements IServiceInsumo{
    @Autowired
    private IInsumo insumoi;

    @Override
    public List<insumo> listar() {
        return (List<insumo>)insumoi.findAll();
    }

    @Override
    public void guardar(insumo insumo) {
        insumoi.save(insumo);
    }

    @Override
    public insumo consulta(Integer id) {
        return insumoi.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        insumoi.deleteById(id);
    }
}
