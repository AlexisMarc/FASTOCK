package fastock.fastock.Service.insumo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fastock.fastock.Class.insumo.tipo;
import fastock.fastock.Mapping.insumo.DTOCreateTipo;
import fastock.fastock.Mapping.insumo.DTOUpdateTipo;
import fastock.fastock.Mapping.insumo.DTOtipo;

@Service
public class ImpTipo {
    @Autowired
    private ITipo tipoi;

    // LISTAR
    private List<tipo> listar() {
        return (List<tipo>) tipoi.findAll();
    }

    // GUARDAR
    private tipo guardar(tipo tipo) {
        tipo pro = tipoi.save(tipo);
        return pro;
    }

    // CONSULTAR
    private tipo consultar(Integer id) {
        return tipoi.findById(id).orElse(null);
    }

    // DTOCREATE A ENTITY
    private tipo DTOCreate(DTOCreateTipo DTO) {
        tipo tipo = new tipo();

        tipo.setNombre(DTO.getNombre());
        tipo.setEstado(true);

        return tipo;
    }

    // DTOUPDATE A ENTITY
    private tipo DTOUpdate(DTOUpdateTipo DTO) {
        tipo tipo = new tipo();

        tipo.setId(DTO.getId());
        tipo.setNombre(DTO.getNombre());
        tipo.setEstado(DTO.getEstado());

        return tipo;
    }

    // ENTITY A DTOTIPO
    private DTOtipo DTOtipo(tipo tipo) {
        DTOtipo DTO = new DTOtipo();

        DTO.setId(tipo.getId());
        DTO.setNombre(tipo.getNombre());

        DTO.setEstado(tipo.getEstado());

        return DTO;
    }
    // ***************************************************************//
    // PUBLICOS
    // ***************************************************************//

    // LISTADO
    public List<DTOtipo> listado() {
        List<DTOtipo> DTO = new ArrayList<DTOtipo>();
        List<tipo> tipos = listar();

        Iterator<tipo> i = tipos.iterator();

        while (i.hasNext()) {
            tipo interar = i.next();
            if (interar.getEstado()) {
                DTOtipo DTOs = DTOtipo(interar);
                DTO.add(DTOs);
            }

        }
        return DTO;
    }

    // LISTADO DE ELIMINADOS
    public List<DTOtipo> eliminados() {
        List<DTOtipo> DTO = new ArrayList<DTOtipo>();
        List<tipo> tipoes = listar();

        Iterator<tipo> i = tipoes.iterator();

        while (i.hasNext()) {
            tipo interar = i.next();
            if (interar.getEstado() == false) {
                DTOtipo DTOs = DTOtipo(interar);
                DTO.add(DTOs);
            }
        }
        return DTO;
    }

    // CONSULTAR
    public DTOtipo consulta(Integer id) {
        if (tipoi.existsById(id)) {
            return DTOtipo(consultar(id));
        } else {
            return null;
        }
    }

    // EDITAR
    public DTOtipo editar(DTOUpdateTipo DTO) {
        tipo tipo = guardar(DTOUpdate(DTO));
        return DTOtipo(tipo);
    }

    // REGISTAR
    public DTOtipo registrar(DTOCreateTipo DTO) {
        tipo tipo = guardar(DTOCreate(DTO));
        return DTOtipo(tipo);
    }

    // ESTADO
    public void estado(Integer id) {
        tipo tipo = consultar(id);
        if (tipo.getEstado()) {
            tipo.setEstado(false);
        } else {
            tipo.setEstado(true);
        }
        guardar(tipo);
    }
}