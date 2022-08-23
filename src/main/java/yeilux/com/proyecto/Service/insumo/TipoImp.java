package yeilux.com.proyecto.Service.insumo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yeilux.com.proyecto.Model.Class.insumo.tipo;
import yeilux.com.proyecto.Model.Interface.insumo.ITipo;

@Service
public class TipoImp implements IServiceTipo{

    @Autowired
    private ITipo tipoi;
    
    private List<tipo>insumoTipo=new ArrayList<tipo>();

    @Override
    public List<tipo> listar() {
        return (List<tipo>)tipoi.findAll();
    }

    @Override
    public void guardar(tipo tipo) {
        tipoi.save(tipo);
        insumoTipo.add(tipo);
    }

    @Override
    public tipo consulta(Integer id) {
        return tipoi.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        tipoi.deleteById(id);
    }

    @Override
    public void eliminarTipos() {
        insumoTipo=new ArrayList<tipo>();
    }

    @Override
    public List<tipo> insumoTipo() {

        return insumoTipo;
    }

    @Override
    public void eliminarTipo(tipo tipo) {
        insumoTipo.remove(tipo);
    }

    @Override
    public void agregarTipo(tipo tipo) {
        insumoTipo.add(tipo);
    }
}
