package fastock.fastock.Service.usuario;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fastock.fastock.Class.usuario.cargo;
import fastock.fastock.Mapping.usuario.DTOCreateCargo;
import fastock.fastock.Mapping.usuario.DTOUpdateCargo;
import fastock.fastock.Mapping.usuario.DTOcargo;

@Service
public class ImpCargo {

    @Autowired
    private ICargo cargoi;

    // LISTAR
    private List<cargo> listar() {
        return (List<cargo>) cargoi.findAll();
    }

    // GUARDAR
    private cargo guardar(cargo cargo) {
        cargo pro = cargoi.save(cargo);
        return pro;
    }

    // CONSULTAR
    private cargo consultar(Integer id) {
        return cargoi.findById(id).orElse(null);
    }

    // DTOCREATE A ENTITY
    private cargo DTOCreate(DTOCreateCargo DTO) {
        cargo cargo = new cargo();

        cargo.setCargo(DTO.getNombre());
        cargo.setEstado(true);

        return cargo;
    }

    // DTOUPDATE A ENTITY
    private cargo DTOUpdate(DTOUpdateCargo DTO) {
        cargo cargo = new cargo();

        cargo.setId(DTO.getId());
        cargo.setCargo(DTO.getNombre());
        cargo.setEstado(DTO.getEstado());

        return cargo;
    }

    // ENTITY A DTOCARGO
    private DTOcargo DTOcargo(cargo cargo) {
        DTOcargo DTO = new DTOcargo();

        DTO.setId(cargo.getId());
        DTO.setNombre(cargo.getCargo());
        DTO.setEstado(cargo.getEstado());

        return DTO;
    }
    // ***************************************************************//
    // PUBLICOS
    // ***************************************************************//

    // LISTADO
    public List<DTOcargo> listado() {
        List<DTOcargo> DTO = new ArrayList<DTOcargo>();
        List<cargo> cargos = listar();

        Iterator<cargo> i = cargos.iterator();

        while (i.hasNext()) {
            cargo interar = i.next();
            if (interar.getEstado()) {
                DTOcargo DTOs = DTOcargo(interar);
                DTO.add(DTOs);
            }

        }
        return DTO;
    }

    // LISTADO DE ELIMINADOS
    public List<DTOcargo> eliminados() {
        List<DTOcargo> DTO = new ArrayList<DTOcargo>();
        List<cargo> cargoes = listar();

        Iterator<cargo> i = cargoes.iterator();

        while (i.hasNext()) {
            cargo interar = i.next();
            if (interar.getEstado() == false) {
                DTOcargo DTOs = DTOcargo(interar);
                DTO.add(DTOs);
            }
        }
        return DTO;
    }

    // CONSULTAR
    public DTOcargo consulta(Integer id) {
        if (cargoi.existsById(id)) {
            return DTOcargo(consultar(id));
        } else {
            return null;
        }
    }

    // EDITAR
    public DTOcargo editar(DTOUpdateCargo DTO) {
        cargo cargo = guardar(DTOUpdate(DTO));
        return DTOcargo(cargo);
    }

    // REGISTAR
    public DTOcargo registrar(DTOCreateCargo DTO) {
        cargo cargo = guardar(DTOCreate(DTO));
        return DTOcargo(cargo);
    }

    // ESTADO
    public void estado(Integer id) {
        cargo cargo = consultar(id);
        if (cargo.getEstado()) {
            cargo.setEstado(false);
        } else {
            cargo.setEstado(true);
        }
        guardar(cargo);
    }
}
