package fastock.fastock.Service.usuario;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fastock.fastock.Class.usuario.usuario;
import fastock.fastock.Mapping.usuario.DTOCreateUsuario;
import fastock.fastock.Mapping.usuario.DTOUpdateUsuario;
import fastock.fastock.Mapping.usuario.DTOusuario;

// import fastock.fastock.Class.usuario.usuario;

@Service
public class ImpUsuario {
    
    @Autowired
    private IUsuario usuarioi;

      // LISTAR
    private List<usuario> listar() {
        return (List<usuario>) usuarioi.findAll();
    }

    // GUARDAR
    private usuario guardar(usuario usuario) {
        usuario pro = usuarioi.save(usuario);
        return pro;
    }

    // CONSULTAR
    private usuario consultar(Integer id) {
        return usuarioi.findById(id).orElse(null);
    }

    // DTOCREATE A ENTITY
    private usuario DTOCreate(DTOCreateUsuario  DTO) {
        usuario usuario = new usuario();

        usuario.setTipo(DTO.getTipo());
        usuario.setIdentificacion(DTO.getIdentificacion());
        usuario.setNombre(DTO.getNombre());
        usuario.setApellido(DTO.getApellido());
        usuario.setGenero(DTO.getGenero());
        usuario.setFecha(DTO.getFecha());
        usuario.setDireccion(DTO.getDireccion());
        usuario.setTelefono(DTO.getTelefono());
        usuario.setUserName(DTO.getEmail());
        usuario.setEstado(true);
        usuario.setInicio(false);
        usuario.setImagen(DTO.getImagen());

        return usuario;
    }

    // DTOUPDATE A ENTITY
    private usuario DTOUpdate(DTOUpdateUsuario DTO) {
        usuario usuario= new usuario();

        usuario.setId(DTO.getId());
        usuario.setTipo(DTO.getTipo());
        usuario.setIdentificacion(DTO.getIdentificacion());
        usuario.setNombre(DTO.getNombre());
        usuario.setApellido(DTO.getApellido());
        usuario.setGenero(DTO.getGenero());
        usuario.setFecha(DTO.getFecha());
        usuario.setDireccion(DTO.getDireccion());
        usuario.setTelefono(DTO.getTelefono());
        usuario.setUserName(DTO.getEmail());
        usuario.setEstado(DTO.getEstado());
        usuario.setInicio(DTO.getInicio());
        usuario.setImagen(DTO.getImagen());
        return usuario;
    }

    // ENTITY A DTOusuario 
    private DTOusuario DTOusuario(usuario usuario) {
        DTOusuario DTO = new DTOusuario();

        DTO.setId(usuario.getId());
        DTO.setTipo(usuario.getTipo().name());
        DTO.setIdentificacion(usuario.getIdentificacion());
        DTO.setNombre(usuario.getNombre());
        DTO.setApellido(usuario.getApellido());
        DTO.setGenero(usuario.getGenero().name());
        DTO.setFecha(usuario.getFecha());
        DTO.setDireccion(usuario.getDireccion());
        DTO.setTelefono(usuario.getTelefono());
        DTO.setEmail(usuario.getUserName());
        DTO.setEstado(usuario.getEstado());
        DTO.setInicio(usuario.getInicio());
        DTO.setImagen(usuario.getImagen());

        return DTO;
    }

     // ***************************************************************//
    // PUBLICOS
    // ***************************************************************//

    // LISTADO
    public List<DTOusuario > listado() {
        List<DTOusuario > DTO = new ArrayList<DTOusuario >();
        List<usuario > usuarioes = listar();

        Iterator<usuario > i = usuarioes.iterator();

        while (i.hasNext()) {
            usuario  interar = i.next();
            if (interar.getEstado()) {
                DTOusuario  DTOs = DTOusuario (interar);
                DTO.add(DTOs);
            }

        }
        return DTO;
    }

    // LISTADO DE ELIMINADOS
    public List<DTOusuario > eliminados(){
        List<DTOusuario > DTO = new ArrayList<DTOusuario >();
        List<usuario > usuarioes = listar();

        Iterator<usuario > i = usuarioes.iterator();

        while (i.hasNext()) {
            usuario  interar = i.next();
            if (interar.getEstado()==false) {
                DTOusuario  DTOs = DTOusuario (interar);
                DTO.add(DTOs);
            }
        }
        return DTO;
    }

    // CONSULTAR
    public DTOusuario consulta(Integer id) {
        if (usuarioi.existsById(id)) {
            return DTOusuario(consultar(id));
        } else {
            return null;
        }
    }

    // EDITAR
    public DTOusuario  editar(DTOUpdateUsuario  DTO) {
        usuario  usuario  = guardar(DTOUpdate(DTO));
        return DTOusuario (usuario );
    }

    // REGISTAR
    public DTOusuario  registrar(DTOCreateUsuario  DTO) {
        usuario  usuario  = guardar(DTOCreate(DTO));
        return DTOusuario (usuario );
    }

    // ESTADO
    public void estado(Integer id) {
        usuario  usuario  = consultar(id);
        if (usuario .getEstado()) {
            usuario .setEstado(false);
        } else {
            usuario .setEstado(true);
        }
        guardar(usuario );
    }
}
