package fastock.fastock.Service.fabricacion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fastock.fastock.Class.fabricacion.fabricacion;
import fastock.fastock.Class.insumo.insumo;
import fastock.fastock.Class.producto.producto;
import fastock.fastock.Class.usuario.usuario;
import fastock.fastock.Mapping.fabricacion.DTOAdmin;
import fastock.fastock.Mapping.fabricacion.DTOCreateFabricacion;
import fastock.fastock.Mapping.fabricacion.DTOUpdateFabricacion;
import fastock.fastock.Mapping.fabricacion.DTOfabricacion;
import fastock.fastock.Service.insumo.IInsumo;
import fastock.fastock.Service.producto.IProducto;
import fastock.fastock.Service.usuario.IUsuario;
import fastock.fastock.Utils.DataTime;

@Service
public class ImpFabricacion {

    @Autowired
    private IFabricacion fabricacioni;

    @Autowired
    private IUsuario usuarioi;

    @Autowired
    private IInsumo insumoi;

    @Autowired
    private ImpArea areaimp;

    @Autowired
    private IProducto productoi;

    private DataTime fecha;

    // LISTAR
    private List<fabricacion> listar() {
        return (List<fabricacion>) fabricacioni.findAll();
    }

    // GUARDAR
    private fabricacion guardar(fabricacion fabricacion) {
        fabricacion pro = fabricacioni.save(fabricacion);
        return pro;
    }

    // CONSULTAR
    private fabricacion consultar(Integer id) {
        return fabricacioni.findById(id).orElse(null);
    }

    // LISTA DE INSUMOS
    private Set<insumo> insumos(List<Integer> insumos) {

        Set<insumo> lista = new HashSet<>();
        Iterator<Integer> i = insumos.iterator();

        while (i.hasNext()) {
            lista.add(insumoi.findById(i.next()).get());
        }
        return lista;

    }

    // DTOCREATE A ENTITY
    private fabricacion DTOCreate(DTOCreateFabricacion DTO) {
        fabricacion fabricacion = new fabricacion();

        fabricacion.setFechainicio(fecha.soloFecha());
        fabricacion.setFechafinal(null);
        fabricacion.setEstado(true);
        fabricacion.setSuspendido(false);

        Set<usuario> usuario = new HashSet<>();
        usuario.add(usuarioi.findById(DTO.getUsuario()).get());
        fabricacion.setUsuario(usuario);

        fabricacion.setInsumo(insumos(DTO.getInsumo()));

        Set<producto> producto = new HashSet<>();
        producto.add(productoi.findById(DTO.getProducto()).get());
        fabricacion.setProducto(producto);

        return fabricacion;
    }

    // DTOUPDATE A ENTITY
    private fabricacion DTOUpdate(DTOUpdateFabricacion DTO) {
        fabricacion fabricacion = fabricacioni.findById(DTO.getId()).get();

        fabricacion.setEstado(DTO.getEstado());
        fabricacion.setSuspendido(DTO.getSuspendido());

        Set<usuario> usuario = new HashSet<>();
        usuario.add(usuarioi.findById(DTO.getUsuario()).get());
        fabricacion.setUsuario(usuario);

        fabricacion.setInsumo(insumos(DTO.getInsumo()));

        return fabricacion;

    }

    // LISTA USUARIO A LISTA DTOADMIN
    public List<DTOAdmin> admin(Set<usuario> usuario) {
        List<DTOAdmin> lista = new ArrayList<>();

        Iterator<usuario> i = usuario.iterator();

        while (i.hasNext()) {
            lista.add(DTOAdmin(i.next()));
        }

        return null;
    }

    // USUARIO A DTOADMIN
    public DTOAdmin DTOAdmin(usuario usuario) {
        DTOAdmin DTO = new DTOAdmin();

        DTO.setId(usuario.getId());
        DTO.setNombre(usuario.getNombre() + ' ' + usuario.getApellido());

        return DTO;

    }

    // ENTITY A DTOFABRICACION
    private DTOfabricacion DTOfabricacion(fabricacion fabricacion) {
        DTOfabricacion DTO = new DTOfabricacion();

        DTO.setId(fabricacion.getId());
        DTO.setFechainicio(fabricacion.getFechafinal());
        DTO.setFechafinal(fabricacion.getFechafinal());
        DTO.setEstado(fabricacion.getEstado());
        DTO.setSuspendido(fabricacion.getSuspendido());
        DTO.setArea(areaimp.listado(fabricacion.getId()));
        DTO.setUsuario(admin(fabricacion.getUsuario()));

        Iterator<producto> i = fabricacion.getProducto().iterator();

        while (i.hasNext()) {
            DTO.setProducto(i.next().getNombre());
            DTO.setIdProducto(i.next().getId());
            DTO.setImagen(i.next().getImagen());
        }

        return DTO;
    }

    // ***************************************************************//
    // PUBLICOS
    // ***************************************************************//

    // LISTADO
    public List<DTOfabricacion> listado() {
        List<DTOfabricacion> DTO = new ArrayList<DTOfabricacion>();
        List<fabricacion> fabricaciones = listar();

        Iterator<fabricacion> i = fabricaciones.iterator();

        while (i.hasNext()) {
            fabricacion interar = i.next();
            if (interar.getEstado()) {
                DTOfabricacion DTOs = DTOfabricacion(interar);

                DTO.add(DTOs);
            }
        }
        return DTO;
    }

    // LISTADO DE SUSPENDIDOS
    public List<DTOfabricacion> suspendidos() {
        List<DTOfabricacion> DTO = new ArrayList<DTOfabricacion>();
        List<fabricacion> fabricaciones = listar();

        Iterator<fabricacion> i = fabricaciones.iterator();

        while (i.hasNext()) {
            fabricacion interar = i.next();
            if (interar.getSuspendido()) {
                DTOfabricacion DTOs = DTOfabricacion(interar);

                DTO.add(DTOs);
            }
        }
        return DTO;
    }

    // REGISTAR
    public DTOfabricacion registrar(DTOCreateFabricacion DTO) {
        fabricacion fabricacion = guardar(DTOCreate(DTO));
        return DTOfabricacion(fabricacion);
    }

    // EDITAR
    public DTOfabricacion editar(DTOUpdateFabricacion DTO) {
        fabricacion fabricacion = guardar(DTOUpdate(DTO));
        return DTOfabricacion(fabricacion);
    }

    // ESTADO
    public void estado(Integer id) {
        fabricacion fabricacion = consultar(id);
        if (fabricacion.getEstado()) {
            fabricacion.setEstado(false);
        } else {
            fabricacion.setEstado(true);
        }
        guardar(fabricacion);
    }
}
