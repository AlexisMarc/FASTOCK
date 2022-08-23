package yeilux.com.proyecto.Service.empresa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yeilux.com.proyecto.Model.Class.empresa.empresa;
import yeilux.com.proyecto.Model.Interface.Empresa.IEmpesa;
@Service
public class EmpresaImp implements IServiceEmpresa {
    @Autowired
    private IEmpesa empresai;

    @Override
    public List<empresa> listar() {
        
        return (List<empresa>) empresai.findAll() ;
    }

    @Override
    public void guardar(empresa empresa) {
        empresai.save(empresa);
    }

    @Override
    public empresa consultar(Integer id) {
        
        return empresai.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        empresai.deleteById(id);
    }
}
