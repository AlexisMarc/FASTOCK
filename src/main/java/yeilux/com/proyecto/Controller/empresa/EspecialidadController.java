package yeilux.com.proyecto.Controller.empresa;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import yeilux.com.proyecto.Model.Class.empresa.especialidad;
import yeilux.com.proyecto.Model.Interface.Empresa.IEspecialidad;

@RestController
@SessionAttributes("especialidad")
@RequestMapping("/especialidad") 
public class EspecialidadController {

    @Autowired
    private IEspecialidad iespecialidad;

// ****************************************//
// --------------METODO GET----------------//
// ****************************************//

// --------------LISTAR TODOS--------------//

@GetMapping
	public ResponseEntity<Page<especialidad>> especialidades(Pageable pageable){
		return ResponseEntity.ok(iespecialidad.findAll(pageable));
	}

// ---------------LISTAR UNO---------------//

@GetMapping("/{id}")
	public ResponseEntity<especialidad> especialidad(@PathVariable Integer id){
		Optional<especialidad> especialidadOptional = iespecialidad.findById(id);
		
		if(!especialidadOptional.isPresent()){
			return ResponseEntity.unprocessableEntity().build();
		}
		
		return ResponseEntity.ok(especialidadOptional.get());
	}

// ****************************************//
// -------------METODO POST----------------//
// ****************************************//

// ---------------REGISTRAR----------------//

@PostMapping
	public ResponseEntity<especialidad> guardarespecialidad(@Valid @RequestBody especialidad especialidad){
		especialidad especialidadGuardada = iespecialidad.save(especialidad);
		URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(especialidadGuardada.getId()).toUri();
		return ResponseEntity.created(ubicacion).body(especialidadGuardada);
	}

// ****************************************//
// --------------METODO PUT----------------//
// ****************************************//

// ----------------EDITAR------------------//


@PutMapping("/{id}")
	public ResponseEntity<especialidad> actualizarespecialidad(@PathVariable Integer id,@Valid @RequestBody especialidad especialidad){
		Optional<especialidad> especialidadOptional = iespecialidad.findById(id);
		
		if(!especialidadOptional.isPresent()){
			return ResponseEntity.unprocessableEntity().build();
		}
		
		especialidad.setId(especialidadOptional.get().getId());
		iespecialidad.save(especialidad);
		
		return ResponseEntity.noContent().build();
	}

// ----------------ESTADO------------------//



}
