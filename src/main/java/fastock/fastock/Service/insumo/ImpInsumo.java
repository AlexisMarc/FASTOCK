package fastock.fastock.Service.insumo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fastock.fastock.Class.insumo.insumo;
import fastock.fastock.Class.insumo.tipo;
import fastock.fastock.Mapping.insumo.DTOCreateInsumo;
import fastock.fastock.Mapping.insumo.DTOUpdateInsumo;
import fastock.fastock.Mapping.insumo.DTOinsumo;
import fastock.fastock.Service.proveedor.IProveedor;

@Service
public class ImpInsumo {

    @Autowired
    private IInsumo insumoi;

    @Autowired
    private ITipo tipoi;

    @Autowired
    private IProveedor proveedori;

    // LISTAR
    private List<insumo> listar() {
        return (List<insumo>) insumoi.findAll();
    }

    // GUARDAR
    private insumo guardar(insumo insumo) {
        insumo pro = insumoi.save(insumo);
        return pro;
    }

    // CONSULTAR
    private insumo consultar(Integer id) {
        return insumoi.findById(id).orElse(null);
    }

    // TIPOS
    private Set<tipo> tipos(List<Integer> tipo) {
        Set<tipo> lista = new HashSet<tipo>();

        Iterator<Integer> i = tipo.iterator();

        while (i.hasNext()) {
            Integer interar = i.next();
            lista.add(tipoi.findById(interar).get());
        }
        return lista;
    }

    // TIPOS A STRING
    private List<String> string(Set<tipo> tipos) {
        List<String> lista = new ArrayList<String>();
        Iterator<tipo> i = tipos.iterator();

        while (i.hasNext()) {
            tipo interar = i.next();
            lista.add(interar.getNombre());
        }
        return lista;
    }

    // DTOCREATE A ENTITY
    private insumo DTOCreate(DTOCreateInsumo DTO) {
        insumo insumo = new insumo();

        insumo.setNombre(DTO.getNombre());
        insumo.setMaterial(DTO.getMaterial());
        insumo.setTipo(tipos(DTO.getTipo()));
        insumo.setProveedor(proveedori.findById(DTO.getProveedor()).get());
        insumo.setImagen(DTO.getImagen());
        insumo.setEstado(true);
        return insumo;
    }

    // DTOUPDATE A ENTITY
    private insumo DTOUpdate(DTOUpdateInsumo DTO) {
        insumo insumo = new insumo();

        insumo.setId(DTO.getId());
        insumo.setNombre(DTO.getNombre());
        insumo.setMaterial(DTO.getMaterial());
        insumo.setTipo(tipos(DTO.getTipo()));
        insumo.setProveedor(proveedori.findById(DTO.getProveedor()).get());
        insumo.setImagen(DTO.getImagen());
        insumo.setEstado(DTO.getEstado());
        return insumo;
    }

    // ENTITY A DTOINSUMO
    private DTOinsumo DTOinsumo(insumo insumo) {
        DTOinsumo DTO = new DTOinsumo();

        DTO.setId(insumo.getId());
        DTO.setNombre(insumo.getNombre());
        DTO.setMaterial(insumo.getMaterial());
        DTO.setTipo(string(insumo.getTipo()));
        DTO.setImagen(insumo.getImagen());
        DTO.setIdProveedor(insumo.getProveedor().getId());
        DTO.setProveedor(insumo.getProveedor().getNombre());
        DTO.setEstado(insumo.getEstado());
        DTO.setInventario(insumo.getInventario().isEmpty());

        return DTO;
    }
    // ***************************************************************//
    // PUBLICOS
    // ***************************************************************//

    // LISTADO
    public List<DTOinsumo> listado() {
        List<DTOinsumo> DTO = new ArrayList<DTOinsumo>();
        List<insumo> insumos = listar();

        Iterator<insumo> i = insumos.iterator();

        while (i.hasNext()) {
            insumo interar = i.next();
            if (interar.getEstado()) {
                DTOinsumo DTOs = DTOinsumo(interar);
                DTO.add(DTOs);
            }

        }
        return DTO;
    }

    // LISTADO DE ELIMINADOS
    public List<DTOinsumo> eliminados() {
        List<DTOinsumo> DTO = new ArrayList<DTOinsumo>();
        List<insumo> insumos = listar();

        Iterator<insumo> i = insumos.iterator();

        while (i.hasNext()) {
            insumo interar = i.next();
            if (interar.getEstado() == false) {
                DTOinsumo DTOs = DTOinsumo(interar);
                DTO.add(DTOs);
            }

        }
        return DTO;
    }

    // LISTADO DE PROVEEDOR
    public List<DTOinsumo> proveedor(Integer id) {
        List<DTOinsumo> DTO = new ArrayList<DTOinsumo>();
        List<insumo> insumos = listar();

        Iterator<insumo> i = insumos.iterator();

        while (i.hasNext()) {
            insumo interar = i.next();
            if (interar.getEstado()) {
                if (interar.getProveedor().getId() == id) {
                    DTOinsumo DTOs = DTOinsumo(interar);
                    DTO.add(DTOs);
                }
            }

        }
        return DTO;
    }

    // CONSULTAR
    public DTOinsumo consulta(Integer id) {
        if (insumoi.existsById(id)) {
            return DTOinsumo(consultar(id));
        } else {
            return null;
        }
    }

    // EDITAR
    public DTOinsumo editar(DTOUpdateInsumo DTO) {
        insumo insumo = guardar(DTOUpdate(DTO));
        return DTOinsumo(insumo);
    }

    // REGISTAR
    public DTOinsumo registrar(DTOCreateInsumo DTO) {
        insumo insumo = guardar(DTOCreate(DTO));
        return DTOinsumo(insumo);
    }

    // ESTADO
    public void estado(Integer id) {
        insumo insumo = consultar(id);
        if (insumo.getEstado()) {
            insumo.setEstado(false);
        } else {
            insumo.setEstado(true);
        }
        guardar(insumo);
    }
}
