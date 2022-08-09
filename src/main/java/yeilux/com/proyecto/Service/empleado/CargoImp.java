package yeilux.com.proyecto.Service.empleado;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yeilux.com.proyecto.Model.Class.empleado.cargo;
import yeilux.com.proyecto.Model.Interface.empleado.ICargo;

@Service
public class CargoImp implements IServiceCargo{

    @Autowired
    private ICargo cargoi;

    @Override
    public List<cargo> listar() {
        return (List<cargo>)cargoi.findAll();
    }

    @Override
    public void guardar(cargo cargo) {
        cargoi.save(cargo);
    }

    @Override
    public cargo consulta(Integer id) {
        return cargoi.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        cargoi.deleteById(id);
    }
    
}
