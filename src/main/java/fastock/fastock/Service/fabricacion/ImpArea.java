package fastock.fastock.Service.fabricacion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fastock.fastock.Class.empresa.empresa;
import fastock.fastock.Class.fabricacion.area;
import fastock.fastock.Class.usuario.usuario;
import fastock.fastock.Mapping.fabricacion.DTOCreateArea;
import fastock.fastock.Mapping.fabricacion.DTOUpdateArea;
import fastock.fastock.Mapping.fabricacion.DTOarea;
import fastock.fastock.Service.Empresa.IEmpresa;
import fastock.fastock.Service.usuario.IUsuario;
import fastock.fastock.Utils.DataTime;
import fastock.fastock.Utils.EnumArea;

@Service
public class ImpArea {

    @Autowired
    private IArea areai;

    @Autowired
    private IFabricacion fabricacioni;

    @Autowired
    private IEmpresa empresai;

    @Autowired
    private IUsuario usuarioi;

    private DataTime fecha;

    // ***************************************************************//
    // PRIVADOS
    // ***************************************************************//

    // LISTAR
    private List<area> listar() {
        return (List<area>) areai.findAll();
    }

    // GUARDAR
    private area guardar(area area) {
        area pro = areai.save(area);
        return pro;
    }

    // CONSULTAR
    private area consultar(Integer id) {
        return areai.findById(id).orElse(null);
    }

    // DTOCREATE A ENTITY
    private area DTOCreate(DTOCreateArea DTO) {
        area area = new area();

        area.setNombre(DTO.getNombre());
        area.setEstado(true);
        area.setFechafinal(fecha.soloFecha());
        area.setFechafinal(null);
        area.setNumerador(DTO.getNumerador());
        area.setFabricacion(fabricacioni.findById(DTO.getFabricacion()).get());

        if (DTO.getTipo() == EnumArea.EMPLEADO) {
            Set<usuario> usuario = new HashSet<usuario>();
            usuario.add(usuarioi.findById(DTO.getIdencargado()).get());
            area.setUsuario(usuario);
        } else if (DTO.getTipo() == EnumArea.EMPRESA) {
            Set<empresa> empresa = new HashSet<empresa>();
            empresa.add(empresai.findById(DTO.getIdencargado()).get());
            area.setEmpresa(empresa);
        }

        return area;
    }

    // DTOUPDATE A ENTITY
    private area DTOUpdate(DTOUpdateArea DTO) {
        area area = areai.findById(DTO.getId()).get();

        area.setId(DTO.getId());
        area.setNombre(DTO.getNombre());
        area.setEstado(DTO.getEstado());

        if (DTO.getTipo() == EnumArea.EMPLEADO) {
            Set<usuario> usuario = new HashSet<usuario>();
            usuario.add(usuarioi.findById(DTO.getIdencargado()).get());
            area.setUsuario(usuario);
            area.setEmpresa(null);

        } else if (DTO.getTipo() == EnumArea.EMPRESA) {
            Set<empresa> empresa = new HashSet<empresa>();
            empresa.add(empresai.findById(DTO.getIdencargado()).get());
            area.setEmpresa(empresa);
            area.setUsuario(null);
        }

        return area;
    }

    // ENTITY A DTOarea
    private DTOarea DTOarea(area area) {
        DTOarea DTO = new DTOarea();

        DTO.setId(area.getId());
        DTO.setNombre(area.getNombre());
        DTO.setFechainicio(area.getFechainicio());
        DTO.setFechafinal(area.getFechafinal());
        DTO.setNumerador(area.getNumerador());
        DTO.setEstado(area.getEstado());

        if (area.getUsuario() != null) {
            Set<usuario> usuarios = area.getUsuario();

            Iterator<usuario> i = usuarios.iterator();

            while (i.hasNext()) {
                usuario usuario = i.next();
                DTO.setIdEncargado(usuario.getId());
                DTO.setEncargado(usuario.getNombre() + ' ' + usuario.getApellido());
                DTO.setTipoEncargado(EnumArea.EMPLEADO.name());
                DTO.setImagen(usuario.getImagen());
            }
        } else if (area.getEmpresa() != null) {
            Set<empresa> empresas = area.getEmpresa();

            Iterator<empresa> i = empresas.iterator();

            while (i.hasNext()) {
                empresa empresa = i.next();
                DTO.setIdEncargado(empresa.getId());
                DTO.setEncargado(empresa.getNombre());
                DTO.setTipoEncargado(EnumArea.EMPRESA.name());
                DTO.setImagen(empresa.getImagen());
            }
        }

        return DTO;
    }

    // ***************************************************************//
    // PUBLICOS
    // ***************************************************************//

    // LISTADO POR FABRICACION
    public List<DTOarea> listado(Integer id) {
        List<DTOarea> DTO = new ArrayList<DTOarea>();
        List<area> areas = listar();

        Iterator<area> i = areas.iterator();

        while (i.hasNext()) {
            area interar = i.next();
            if (interar.getFabricacion().getId() == id) {
                DTOarea DTOs = DTOarea(interar);
                DTO.add(DTOs);
            }

        }
        return DTO;
    }

    // EDITAR
    public DTOarea editar(DTOUpdateArea DTO) {
        area area = guardar(DTOUpdate(DTO));
        return DTOarea(area);
    }

    // REGISTAR
    public DTOarea registrar(DTOCreateArea DTO) {
        area area = guardar(DTOCreate(DTO));
        return DTOarea(area);
    }

    // CONSULTAR
    public DTOarea consulta(Integer id) {
        if (areai.existsById(id)) {
            return DTOarea(consultar(id));
        } else {
            return null;
        }
    }

    // ESTADO
    public void estado(Integer id) {
        area area = consultar(id);
        if (area.getEstado()) {
            area.setEstado(false);
        } else {
            area.setEstado(true);
        }
        guardar(area);
    }
}
