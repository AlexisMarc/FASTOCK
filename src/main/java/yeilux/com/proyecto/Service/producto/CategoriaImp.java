package yeilux.com.proyecto.Service.producto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import yeilux.com.proyecto.Model.Class.producto.categoria;
import yeilux.com.proyecto.Model.Interface.producto.ICategoria;

@Service
public class CategoriaImp implements IServiceCategoria {

    @Autowired
    private ICategoria categoriai;

    @Override
    public List<categoria> listar() {
        return (List<categoria>) categoriai.findAll();
    }

    @Override
    public void guardar(categoria categoria) {
        categoriai.save(categoria);
    }

    @Override
    public categoria consulta(Integer id) {
        return categoriai.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id){
        categoriai.deleteById(id);
    }


}
