package fastock.fastock.Service.producto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fastock.fastock.Class.producto.categoria;
import fastock.fastock.Mapping.producto.DTOCreateCategoria;
import fastock.fastock.Mapping.producto.DTOUpdateCategoria;
import fastock.fastock.Mapping.producto.DTOcategoria;

@Service
public class ImpCategoria {

    @Autowired 
    private ICategoria categoriai;

    // LISTAR
    private List<categoria> listar() {
        return (List<categoria>) categoriai.findAll();
    }

    // GUARDAR
    private categoria guardar(categoria categoria) {
        categoria pro = categoriai.save(categoria);
        return pro;
    }

    // CONSULTAR
    private categoria consultar(Integer id) {
        return categoriai.findById(id).orElse(null);
    }

    // DTOCREATE A ENTITY
    private categoria DTOCreate(DTOCreateCategoria DTO) {
        categoria categoria = new categoria();

        categoria.setNombre(DTO.getNombre());
        categoria.setEstado(true);

        return categoria;
    }

    // DTOUPDATE A ENTITY
    private categoria DTOUpdate(DTOUpdateCategoria DTO) {
        categoria categoria = new categoria();

        categoria.setId(DTO.getId());
        categoria.setNombre(DTO.getNombre());
        categoria.setEstado(DTO.getEstado());

        return categoria;
    }

    // ENTITY A DTOCATEGORIA
    private DTOcategoria DTOcategoria(categoria categoria) {
        DTOcategoria DTO = new DTOcategoria();

        DTO.setId(categoria.getId());
        DTO.setNombre(categoria.getNombre());
        DTO.setEstado(categoria.getEstado());

        return DTO;
    }
    
    // ***************************************************************//
    // PUBLICOS
    // ***************************************************************//

    // LISTADO
    public List<DTOcategoria> listado() {
        List<DTOcategoria> DTO = new ArrayList<DTOcategoria>();
        List<categoria> categoriaes = listar();

        Iterator<categoria> i = categoriaes.iterator();

        while (i.hasNext()) {
            categoria interar = i.next();
            if (interar.getEstado()) {
                DTOcategoria DTOs = DTOcategoria(interar);
                DTO.add(DTOs);
            }

        }
        return DTO;
    }

    // LISTADO DE ELIMINADOS
    public List<DTOcategoria> eliminados() {
        List<DTOcategoria> DTO = new ArrayList<DTOcategoria>();
        List<categoria> categoriaes = listar();

        Iterator<categoria> i = categoriaes.iterator();

        while (i.hasNext()) {
            categoria interar = i.next();
            if (interar.getEstado()==false) {
                DTOcategoria DTOs = DTOcategoria(interar);
                DTO.add(DTOs);
            }

        }
        return DTO;
    }

    // CONSULTAR
    public DTOcategoria consulta(Integer id) {
        if (categoriai.existsById(id)) {
            return DTOcategoria(consultar(id));
        } else {
            return null;
        }
    }

    // EDITAR
    public DTOcategoria editar(DTOUpdateCategoria DTO) {
        categoria categoria = guardar(DTOUpdate(DTO));
        return DTOcategoria(categoria);
    }

    // REGISTAR
    public DTOcategoria registrar(DTOCreateCategoria DTO) {
        categoria categoria = guardar(DTOCreate(DTO));
        return DTOcategoria(categoria);
    }

    // ESTADO
    public void estado(Integer id) {
        categoria categoria = consultar(id);
        if (categoria.getEstado()) {
            categoria.setEstado(false);
        } else {
            categoria.setEstado(true);
        }
        guardar(categoria);
    }
    
}
