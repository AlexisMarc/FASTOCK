package fastock.fastock.Service.Empresa;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fastock.fastock.Class.empresa.especialidad;
import fastock.fastock.Mapping.empresa.DTOCreateEspecialidad;
import fastock.fastock.Mapping.empresa.DTOUpdateEspecialidad;
import fastock.fastock.Mapping.empresa.DTOespecialidad;


@Service
public class ImpEspecialidad {
    
    @Autowired
    private IEspecialidad especialidadi;

    // LISTAR
    private List<especialidad> listar() {
        return (List<especialidad>) especialidadi.findAll();
    }

    // GUARDAR
    private especialidad guardar(especialidad especialidad) {
        especialidad pro = especialidadi.save(especialidad);
        return pro;
    }

    // CONSULTAR
    private especialidad consultar(Integer id) {
        return especialidadi.findById(id).orElse(null);
    }

    // DTOCREATE A ENTITY
    private especialidad DTOCreate(DTOCreateEspecialidad DTO) {
        especialidad especialidad = new especialidad();

        especialidad.setNombre(DTO.getNombre());
        especialidad.setDescripcion(DTO.getDescripcion());
        especialidad.setEstado(true);

        return especialidad;
    }

    // DTOUPDATE A ENTITY
    private especialidad DTOUpdate(DTOUpdateEspecialidad DTO) {
        especialidad especialidad = new especialidad();

        especialidad.setId(DTO.getId());
        especialidad.setNombre(DTO.getNombre());
        especialidad.setDescripcion(DTO.getDescripcion());
        especialidad.setEstado(DTO.getEstado());

        return especialidad;
    }

    // ENTITY A DTOespecialidad
    private DTOespecialidad DTOespecialidad(especialidad especialidad) {
        DTOespecialidad DTO = new DTOespecialidad();

        DTO.setId(especialidad.getId());
        DTO.setNombre(especialidad.getNombre());
        DTO.setDescripcion(especialidad.getDescripcion());
        DTO.setEstado(especialidad.getEstado());

        return DTO;
    }

    // ***************************************************************//
    // PUBLICOS
    // ***************************************************************//

    // LISTADO
    public List<DTOespecialidad> listado() {
        List<DTOespecialidad> DTO = new ArrayList<DTOespecialidad>();
        List<especialidad> especialidades = listar();

        Iterator<especialidad> i = especialidades.iterator();

        while (i.hasNext()) {
            especialidad interar = i.next();
            DTOespecialidad DTOs = DTOespecialidad(interar);

            DTO.add(DTOs);
        }
        return DTO;
    }

    // CONSULTAR
    public DTOespecialidad consulta(Integer id) {
        if (especialidadi.existsById(id)) {
            return DTOespecialidad(consultar(id));
        } else {
            return null;
        }
        
    }

    // EDITAR
    public DTOespecialidad editar(DTOUpdateEspecialidad DTO) {
        especialidad especialidad = guardar(DTOUpdate(DTO));
        return DTOespecialidad(especialidad);
    }

    // REGISTAR
    public DTOespecialidad registrar(DTOCreateEspecialidad DTO) {
        especialidad especialidad = guardar(DTOCreate(DTO));
        return DTOespecialidad(especialidad);
    }

    // ESTADO
    public void estado(Integer id) {
        especialidad especialidad = consultar(id);
        if (especialidad.getEstado()) {
            especialidad.setEstado(false);
        } else {
            especialidad.setEstado(true);
        }
        guardar(especialidad);
    }

}
