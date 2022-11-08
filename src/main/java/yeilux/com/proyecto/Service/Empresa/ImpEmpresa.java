package yeilux.com.proyecto.Service.Empresa;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yeilux.com.proyecto.Class.empresa.empresa;
import yeilux.com.proyecto.Mapping.empresa.DTOCreateEmpresa;
import yeilux.com.proyecto.Mapping.empresa.DTOUpdateEmpresa;
import yeilux.com.proyecto.Mapping.empresa.DTOempresa;


@Service

public class ImpEmpresa {
    
    @Autowired
    private IEmpresa empresai;

    // LISTAR
    private List<empresa> listar() {
        return (List<empresa>) empresai.findAll();
    }

    // GUARDAR
    private empresa guardar(empresa empresa) {
        empresa pro = empresai.save(empresa);
        return pro;
    }

    // CONSULTAR
    private empresa consultar(Integer id) {
        return empresai.findById(id).orElse(null);
    }

    // DTOCREATE A ENTITY
    private empresa DTOCreate(DTOCreateEmpresa DTO) {
        empresa empresa = new empresa();

        empresa.setNombre(DTO.getNombre());
        empresa.setEmail(DTO.getEmail());
        empresa.setEstado(true);
        empresa.setTelefono(DTO.getTelefono());
        empresa.setDireccion(DTO.getDireccion());
        empresa.setContacto(DTO.getContacto());
        empresa.setImagen(DTO.getImagen());
        empresa.setEspecialidad(null);

        return empresa;
    }

    // DTOUPDATE A ENTITY
    private empresa DTOUpdate(DTOUpdateEmpresa DTO) {
        empresa empresa = new empresa();

        empresa.setId(DTO.getId());
        empresa.setNombre(DTO.getNombre());
        empresa.setContacto(null);
        empresa.setDireccion(null);
        empresa.setTelefono(null);
        empresa.setEmail(null);
        empresa.setEstado(null);

        return empresa;
    }

    // ENTITY A DTOempresa
    private DTOempresa DTOempresa(empresa empresa) {
        DTOempresa DTO = new DTOempresa();

        DTO.setId(empresa.getId());
        DTO.setNombre(empresa.getNombre());
        DTO.setEmail(empresa.getEmail());
        DTO.setContacto(empresa.getContacto());
        DTO.setTelefono(empresa.getTelefono());
        DTO.setDireccion(empresa.getDireccion());
        DTO.setEstado(empresa.getEstado());

        return DTO;
    }

    // ***************************************************************//
    // PUBLICOS
    // ***************************************************************//

    // LISTADO
    public List<DTOempresa> listado() {
        List<DTOempresa> DTO = new ArrayList<DTOempresa>();
        List<empresa> empresaes = listar();

        Iterator<empresa> i = empresaes.iterator();

        while (i.hasNext()) {
            empresa interar = i.next();
            DTOempresa DTOs = DTOempresa(interar);

            DTO.add(DTOs);
        }
        return DTO;
    }

    // CONSULTAR
    public DTOempresa consulta(Integer id) {
        if (empresai.existsById(id)) {
            return DTOempresa(consultar(id));
        } else {
            return null;
        }
        
    }

    // EDITAR
    public DTOempresa editar(DTOUpdateEmpresa DTO) {
        empresa empresa = guardar(DTOUpdate(DTO));
        return DTOempresa(empresa);
    }

    // REGISTAR
    public DTOempresa registrar(DTOCreateEmpresa DTO) {
        empresa empresa = guardar(DTOCreate(DTO));
        return DTOempresa(empresa);
    }

    // ESTADO
    public void estado(Integer id) {
        empresa empresa = consultar(id);
        if (empresa.getEstado()) {
            empresa.setEstado(false);
        } else {
            empresa.setEstado(true);
        }
        guardar(empresa);
    }
}
