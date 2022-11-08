package yeilux.com.proyecto.Service.proveedor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yeilux.com.proyecto.Class.proveedor.proveedor;
import yeilux.com.proyecto.Mapping.proveedor.DTOCreateProveedor;
import yeilux.com.proyecto.Mapping.proveedor.DTOUpdateProveedor;
import yeilux.com.proyecto.Mapping.proveedor.DTOproveedor;

@Service
public class ImpProveedor {

    @Autowired
    private IProveedor proveedori;

    // LISTAR
    private List<proveedor> listar() {
        return (List<proveedor>) proveedori.findAll();
    }

    // GUARDAR
    private proveedor guardar(proveedor proveedor) {
        proveedor pro = proveedori.save(proveedor);
        return pro;
    }

    // CONSULTAR
    private proveedor consultar(Integer id) {
        return proveedori.findById(id).orElse(null);
    }

    // DTOCREATE A ENTITY
    private proveedor DTOCreate(DTOCreateProveedor DTO) {
        proveedor proveedor = new proveedor();

        proveedor.setNombre(DTO.getNombre());
        proveedor.setEmail(DTO.getEmail());
        proveedor.setEstado(true);
        proveedor.setTelefono(DTO.getTelefono());
        proveedor.setDireccion(DTO.getDireccion());
        proveedor.setContacto(DTO.getContacto());

        return proveedor;
    }

    // DTOUPDATE A ENTITY
    private proveedor DTOUpdate(DTOUpdateProveedor DTO) {
        proveedor proveedor = new proveedor();

        proveedor.setId(DTO.getId());
        proveedor.setNombre(DTO.getNombre());
        proveedor.setEmail(DTO.getEmail());
        proveedor.setEstado(DTO.getEstado());
        proveedor.setTelefono(DTO.getTelefono());
        proveedor.setDireccion(DTO.getDireccion());
        proveedor.setContacto(DTO.getContacto());

        return proveedor;
    }

    // ENTITY A DTOPROVEEDOR
    private DTOproveedor DTOproveedor(proveedor proveedor) {
        DTOproveedor DTO = new DTOproveedor();

        DTO.setId(proveedor.getId());
        DTO.setNombre(proveedor.getNombre());
        DTO.setEmail(proveedor.getEmail());
        DTO.setContacto(proveedor.getContacto());
        DTO.setTelefono(proveedor.getTelefono());
        DTO.setDireccion(proveedor.getDireccion());
        DTO.setEstado(proveedor.getEstado());

        return DTO;
    }

    // ***************************************************************//
    // PUBLICOS
    // ***************************************************************//

    // LISTADO
    public List<DTOproveedor> listado() {
        List<DTOproveedor> DTO = new ArrayList<DTOproveedor>();
        List<proveedor> proveedores = listar();

        Iterator<proveedor> i = proveedores.iterator();

        while (i.hasNext()) {
            proveedor interar = i.next();
            DTOproveedor DTOs = DTOproveedor(interar);

            DTO.add(DTOs);
        }
        return DTO;
    }

    // CONSULTAR
    public DTOproveedor consulta(Integer id) {
        if (proveedori.existsById(id)) {
            return DTOproveedor(consultar(id));
        } else {
            return null;
        }
        
    }

    // EDITAR
    public DTOproveedor editar(DTOUpdateProveedor DTO) {
        proveedor proveedor = guardar(DTOUpdate(DTO));
        return DTOproveedor(proveedor);
    }

    // REGISTAR
    public DTOproveedor registrar(DTOCreateProveedor DTO) {
        proveedor proveedor = guardar(DTOCreate(DTO));
        return DTOproveedor(proveedor);
    }

    // ESTADO
    public void estado(Integer id) {
        proveedor proveedor = consultar(id);
        if (proveedor.getEstado()) {
            proveedor.setEstado(false);
        } else {
            proveedor.setEstado(true);
        }
        guardar(proveedor);
    }
}
