package fastock.fastock.Service.producto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fastock.fastock.Class.producto.categoria;
import fastock.fastock.Class.producto.producto;
import fastock.fastock.Mapping.producto.DTOCreateProducto;
import fastock.fastock.Mapping.producto.DTOUpdateProducto;
import fastock.fastock.Mapping.producto.DTOproducto;

@Service
public class ImpProducto {

    @Autowired
    private IProducto productoi;

    @Autowired
    private ICategoria categoriai;

    // LISTAR
    private List<producto> listar() {
        return (List<producto>) productoi.findAll();
    }

    // GUARDAR
    private producto guardar(producto producto) {
        producto pro = productoi.save(producto);
        return pro;
    }

    // CONSULTAR
    private producto consultar(Integer id) {
        return productoi.findById(id).orElse(null);
    }

    // CATEGORIAS
    private Set<categoria> categorias(List<Integer> categoria) {
        Set<categoria> lista = new HashSet<categoria>();

        Iterator<Integer> i = categoria.iterator();

        while (i.hasNext()) {
            Integer interar = i.next();
            lista.add(categoriai.findById(interar).get());
        }
        return lista;
    }

    //CATEGORIAS A STRING
    private List<String> string(Set<categoria> categorias){
        List<String> lista = new ArrayList<String>();
        Iterator<categoria> i = categorias.iterator();
        
        while (i.hasNext()) {
            categoria interar = i.next();
            lista.add(interar.getNombre());
        }
        return lista;
    }
    
    // DTOCREATE A ENTITY
    private producto DTOCreate(DTOCreateProducto DTO) {
        producto producto = new producto();

        producto.setNombre(DTO.getNombre());
        producto.setDescripcion(DTO.getDescripcion());
        producto.setCategoria(categorias(DTO.getCategoria()));
        producto.setImagen(DTO.getImagen());
        producto.setEstado(true);
        producto.setVisible(false);

        return producto;
    }

    // DTOUPDATE A ENTITY
    private producto DTOUpdate(DTOUpdateProducto DTO) {
        producto producto = new producto();

        producto.setId(DTO.getId());
        producto.setNombre(DTO.getNombre());
        producto.setDescripcion(DTO.getDescripcion());
        producto.setCategoria(categorias(DTO.getCategoria()));
        producto.setImagen(DTO.getImagen());
        producto.setEstado(DTO.getEstado());
        producto.setVisible(DTO.getVisible());
        return producto;
    }

    // ENTITY A DTOPRODUCTO
    private DTOproducto DTOproducto(producto producto) {
        DTOproducto DTO = new DTOproducto();

        DTO.setId(producto.getId());
        DTO.setNombre(producto.getNombre());
        DTO.setDescripcion(producto.getDescripcion());
        DTO.setEstado(producto.getEstado());
        DTO.setImagen(producto.getImagen());
        DTO.setCategoria(string(producto.getCategoria()));
        DTO.setVisible(producto.getVisible());
        DTO.setInventario(producto.getInventario().isEmpty());

        return DTO;
    }

    // ***************************************************************//
    // PUBLICOS
    // ***************************************************************//

    // LISTADO
    public List<DTOproducto> listado() {
        List<DTOproducto> DTO = new ArrayList<DTOproducto>();
        List<producto> productoes = listar();

        Iterator<producto> i = productoes.iterator();

        while (i.hasNext()) {
            producto interar = i.next();
            if (interar.getEstado()) {
                DTOproducto DTOs = DTOproducto(interar);
                DTO.add(DTOs);
            }

        }
        return DTO;
    }

    // LISTADO DE ELIMINADOS
    public List<DTOproducto> eliminados() {
        List<DTOproducto> DTO = new ArrayList<DTOproducto>();
        List<producto> productoes = listar();

        Iterator<producto> i = productoes.iterator();

        while (i.hasNext()) {
            producto interar = i.next();
            if (interar.getEstado() == false) {
                DTOproducto DTOs = DTOproducto(interar);
                DTO.add(DTOs);
            }

        }
        return DTO;
    }

    // CONSULTAR
    public DTOproducto consulta(Integer id) {
        if (productoi.existsById(id)) {
            return DTOproducto(consultar(id));
        } else {
            return null;
        }

    }

    // EDITAR
    public DTOproducto editar(DTOUpdateProducto DTO) {
        producto producto = guardar(DTOUpdate(DTO));
        return DTOproducto(producto);
    }

    // REGISTAR
    public DTOproducto registrar(DTOCreateProducto DTO) {
        producto producto = guardar(DTOCreate(DTO));
        return DTOproducto(producto);
    }

    // ESTADO
    public void estado(Integer id) {
        producto producto = consultar(id);
        if (producto.getEstado()) {
            producto.setEstado(false);
        } else {
            producto.setEstado(true);
        }
        guardar(producto);
    }
}