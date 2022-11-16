package fastock.fastock.Service.usuario;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import fastock.fastock.Class.usuario.cargo;
import fastock.fastock.Class.usuario.usuario;
import fastock.fastock.Mapping.usuario.DTOCreateUsuario;
import fastock.fastock.Mapping.usuario.DTOUpdateUsuario;
import fastock.fastock.Mapping.usuario.DTOcargo;
import fastock.fastock.Mapping.usuario.DTOusuario;

@Service
public class ImpUsuario {

    @Autowired
    private IUsuario usuarioi;

    @Autowired
    private ICargo cargoi;

    PasswordEncoder password = new BCryptPasswordEncoder();

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

    // LISTA DE INTEGER A LISTA DE CARGOS
    private Set<cargo> cargos(List<Integer> cargos) {
        Set<cargo> cargo = new HashSet<cargo>();

        Iterator<Integer> i = cargos.iterator();
        while (i.hasNext()) {
            cargo.add(cargoi.findById(i.next()).get());
        }

    return cargo;

    }

    // LISTA DE INTEGER A LISTA DE CARGOS
    private List<DTOcargo> cargosDTO(Set<cargo> cargos) {
        List<DTOcargo> cargo = new ArrayList<DTOcargo>();

        Iterator<cargo> i = cargos.iterator();
        while (i.hasNext()) {
            cargo.add(DTOcargo(i.next()));
        }

    return cargo;

    }

    // ENTITYCARGO A DTOCARGO
    private DTOcargo DTOcargo(cargo cargo) {
        DTOcargo DTO = new DTOcargo();

        DTO.setId(cargo.getId());
        DTO.setNombre(cargo.getCargo());
        DTO.setEstado(cargo.getEstado());

        return DTO;
    }

    // DTOCREATE A ENTITY
    private usuario DTOCreate(DTOCreateUsuario DTO) {
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
        usuario.setVerificacion(false);
        usuario.setImagen(DTO.getImagen());
        usuario.setPassword(password.encode(String.valueOf(DTO.getIdentificacion())));
        usuario.setCargo(cargos(DTO.getCargo()));

        return usuario;
    }

    // DTOUPDATE A ENTITY
    private usuario DTOUpdate(DTOUpdateUsuario DTO) {
        usuario usuario = consultar(DTO.getId());

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
        usuario.setImagen(DTO.getImagen());usuario.setCargo(cargos(DTO.getCargo()));
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

        DTO.setCargo(cargosDTO(usuario.getCargo()));
        return DTO;
    }

    // ***************************************************************//
    // PUBLICOS
    // ***************************************************************//

    // LISTADO
    public List<DTOusuario> listado() {
        List<DTOusuario> DTO = new ArrayList<DTOusuario>();
        List<usuario> usuarioes = listar();

        Iterator<usuario> i = usuarioes.iterator();

        while (i.hasNext()) {
            usuario interar = i.next();
            if (interar.getEstado()) {
                DTOusuario DTOs = DTOusuario(interar);
                DTO.add(DTOs);
            }

        }
        return DTO;
    }

    // LISTADO DE ELIMINADOS
    public List<DTOusuario> eliminados() {
        List<DTOusuario> DTO = new ArrayList<DTOusuario>();
        List<usuario> usuarioes = listar();

        Iterator<usuario> i = usuarioes.iterator();

        while (i.hasNext()) {
            usuario interar = i.next();
            if (interar.getEstado() == false) {
                DTOusuario DTOs = DTOusuario(interar);
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
    public DTOusuario editar(DTOUpdateUsuario DTO) {
        usuario usuario = guardar(DTOUpdate(DTO));
        return DTOusuario(usuario);
    }

    // REGISTAR
    public DTOusuario registrar(DTOCreateUsuario DTO) {
        usuario usuario = guardar(DTOCreate(DTO));
        return DTOusuario(usuario);
    }

    // ESTADO
    public void estado(Integer id) {
        usuario usuario = consultar(id);
        if (usuario.getEstado()) {
            usuario.setEstado(false);
        } else {
            usuario.setEstado(true);
        }
        guardar(usuario);
    }
}
