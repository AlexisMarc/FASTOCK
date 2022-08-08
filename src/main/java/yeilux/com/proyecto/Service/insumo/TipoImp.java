package yeilux.com.proyecto.Service.insumo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yeilux.com.proyecto.Model.Class.Interface.insumo.ITipo;
import yeilux.com.proyecto.Model.Class.insumo.tipo;

@Service
public class TipoImp implements IServiceTipo{

    @Autowired
    private ITipo tipoi;

    @Override
    public List<tipo> listar() {
        return (List<tipo>)tipoi.findAll();
    }

    @Override
    public void guardar(tipo tipo) {
        tipoi.save(tipo);
    }

    @Override
    public tipo consulta(Integer id) {
        return tipoi.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        tipoi.deleteById(id);
    }
}
