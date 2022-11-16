package fastock.fastock.Service.fabricacion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fastock.fastock.Class.fabricacion.produccion;
import fastock.fastock.Mapping.fabricacion.DTOCreateProduccion;
import fastock.fastock.Mapping.fabricacion.DTOproduccion;
import fastock.fastock.Service.usuario.IUsuario;

@Service
public class ImpProduccion {

    @Autowired
    private IProduccion produccioni;

    @Autowired
    private IArea areai;

    @Autowired
    private IUsuario usuarioi;

    // LISTAR
    private List<produccion> listar() {
        return (List<produccion>) produccioni.findAll();
    }

    // GUARDAR
    private produccion guardar(produccion produccion) {
        produccion pro = produccioni.save(produccion);
        return pro;
    }

    // CONSULTAR
    private produccion consultar(Integer id) {
        return produccioni.findById(id).orElse(null);
    }

    // DTOCREATE A ENTITY
    private produccion DTOCreate(DTOCreateProduccion DTO) {
        produccion produccion = new produccion();

        produccion.setDescripcion(DTO.getDescripcion());
        produccion.setEstado(true);
        produccion.setVisto(false);
        produccion.setConfirmacion(null);
        produccion.setArea(areai.findById(DTO.getArea()).get());
        produccion.setUsuario(usuarioi.findById(DTO.getUsuario()).get());
        produccion.setTipo(DTO.getTipo());

        return produccion;
    }

    // ENTITY A DTOproduccion
    private DTOproduccion DTOproduccion(produccion produccion) {
        DTOproduccion DTO = new DTOproduccion();

        DTO.setId(produccion.getId());
        DTO.setDescripcion(DTO.getDescripcion());
        DTO.setFecha(produccion.getFecha());
        DTO.setTipo(produccion.getTipo().name());
        DTO.setArea(produccion.getArea().getNombre());
        DTO.setIdArea(produccion.getArea().getId());
        DTO.setIdUsuario(produccion.getUsuario().getId());
        DTO.setUsuario(produccion.getUsuario().getNombre());
        DTO.setImagen(produccion.getUsuario().getImagen());
        DTO.setEstado(produccion.getEstado());
        DTO.setVisto(produccion.getVisto());
        DTO.setConfirmacion(produccion.getConfirmacion());

        return DTO;
    }

    // ***************************************************************//
    // PUBLICOS
    // ***************************************************************//

    // LISTADO
    public List<DTOproduccion> listado() {
        List<DTOproduccion> DTO = new ArrayList<DTOproduccion>();
        List<produccion> producciones = listar();

        Iterator<produccion> i = producciones.iterator();

        while (i.hasNext()) {
            produccion interar = i.next();
            if (interar.getEstado()) {
                DTOproduccion DTOs = DTOproduccion(interar);

                DTO.add(DTOs);
            }
        }
        return DTO;
    }

    // LISTADO DE ELIMINADOS
    public List<DTOproduccion> eliminados() {
        List<DTOproduccion> DTO = new ArrayList<DTOproduccion>();
        List<produccion> producciones = listar();

        Iterator<produccion> i = producciones.iterator();

        while (i.hasNext()) {
            produccion interar = i.next();
            if (interar.getEstado() == false) {
                DTOproduccion DTOs = DTOproduccion(interar);

                DTO.add(DTOs);
            }
        }
        return DTO;
    }

    // CONSULTAR
    public DTOproduccion consulta(Integer id) {
        if (produccioni.existsById(id)) {
            return DTOproduccion(consultar(id));
        } else {
            return null;
        }
    }

    // REGISTAR
    public DTOproduccion registrar(DTOCreateProduccion DTO) {
        produccion produccion = guardar(DTOCreate(DTO));
        return DTOproduccion(produccion);
    }

    // ESTADO
    public void estado(Integer id) {
        produccion produccion = consultar(id);
        if (produccion.getEstado()) {
            produccion.setEstado(false);
        } else {
            produccion.setEstado(true);
        }
        guardar(produccion);
    }
}