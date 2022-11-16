package fastock.fastock.Controller.empresa;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import fastock.fastock.Service.Empresa.ImpEmpresa;
import fastock.fastock.Service.Empresa.ImpEspecialidad;
import fastock.fastock.Mapping.empresa.DTOCreateEmpresa;
import fastock.fastock.Mapping.empresa.DTOCreateEspecialidad;
import fastock.fastock.Mapping.empresa.DTOUpdateEmpresa;
import fastock.fastock.Mapping.empresa.DTOUpdateEspecialidad;
import fastock.fastock.Mapping.empresa.DTOempresa;
import fastock.fastock.Mapping.empresa.DTOespecialidad;

@RestController

@SessionAttributes("empresa")
@RequestMapping("/empresa")
public class EmpresaController {
	@Autowired
	private ImpEmpresa iempresa;

	@Autowired
	private ImpEspecialidad iespecialidad;

	// ****************************************//
	// --------------METODO GET----------------//
	// ****************************************//

	// --------------LISTAR TODOS--------------//
	@GetMapping
	public ResponseEntity<List<DTOempresa>> empresaes() {
		return ResponseEntity.ok(iempresa.listado());
	}

	// ---------------LISTAR UNO---------------//

	@GetMapping("/{id}")
	public ResponseEntity<DTOempresa> empresa(@PathVariable Integer id) {
		DTOempresa empresaOptional = iempresa.consulta(id);

		if (empresaOptional == null) {
			return ResponseEntity.unprocessableEntity().build();
		}

		return ResponseEntity.ok(empresaOptional);
	}

	// ****************************************//
	// -------------METODO POST----------------//
	// ****************************************//

	// ---------------REGISTRAR----------------//

	@PostMapping
	public ResponseEntity<DTOempresa> guardarempresa(@Valid @RequestBody DTOCreateEmpresa empresa) {
		DTOempresa empresaGuardada = iempresa.registrar(empresa);
		URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(empresaGuardada.getId()).toUri();
		return ResponseEntity.created(ubicacion).body(empresaGuardada);
	}

	// ****************************************//
	// --------------METODO PUT----------------//
	// ****************************************//

	// ----------------EDITAR------------------//

	@PutMapping("/{id}")
	public ResponseEntity<DTOempresa> actualizarempresa(@PathVariable Integer id,
			@Valid @RequestBody DTOUpdateEmpresa empresa) {
		DTOempresa empresaID = iempresa.consulta(id);
		if (empresaID == null) {
			return ResponseEntity.unprocessableEntity().build();
		} else {
			empresa.setId(empresaID.getId());
			DTOempresa pro = iempresa.editar(empresa);

			URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(empresa.getId()).toUri();

			return ResponseEntity.created(ubicacion).body(pro);
		}
	}

	// ----------------ESTADO------------------//

	@PutMapping("/estado/{id}")
	public ResponseEntity<DTOempresa> Estadoempresa(@PathVariable Integer id) {
		iempresa.estado(id);
		return ResponseEntity.ok(iempresa.consulta(id));
	}

	// **************************************************************************************//
	// ----------------------------------------ESPECIALIDAD---------------------------------//
	// **************************************************************************************//

	// ****************************************//
	// --------------METODO GET----------------//
	// ****************************************//

	// --------------LISTAR TODOS--------------//
	@GetMapping("/especialidad")
	public ResponseEntity<List<DTOespecialidad>> especialidades() {
		return ResponseEntity.ok(iespecialidad.listado());
	}

	// ---------------LISTAR UNO---------------//

	@GetMapping("/especialidad/{id}")
	public ResponseEntity<DTOespecialidad> especialidad(@PathVariable Integer id) {
		DTOespecialidad especialidadOptional = iespecialidad.consulta(id);

		if (especialidadOptional == null) {
			return ResponseEntity.unprocessableEntity().build();
		}

		return ResponseEntity.ok(especialidadOptional);
	}

	// ****************************************//
	// -------------METODO POST----------------//
	// ****************************************//

	// ---------------REGISTRAR----------------//

	@PostMapping("/especialidad")
	public ResponseEntity<DTOespecialidad> guardarespecialidad(@Valid @RequestBody DTOCreateEspecialidad especialidad) {
		DTOespecialidad especialidadGuardada = iespecialidad.registrar(especialidad);
		URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(especialidadGuardada.getId()).toUri();
		return ResponseEntity.created(ubicacion).body(especialidadGuardada);
	}

	// ****************************************//
	// --------------METODO PUT----------------//
	// ****************************************//

	// ----------------EDITAR------------------//

	@PutMapping("/especialidad/{id}")
	public ResponseEntity<DTOespecialidad> actualizarespecialidad(@PathVariable Integer id,
			@Valid @RequestBody DTOUpdateEspecialidad especialidad) {
		DTOespecialidad especialidadID = iespecialidad.consulta(id);
		if (especialidadID == null) {
			return ResponseEntity.unprocessableEntity().build();
		} else {
			especialidad.setId(especialidadID.getId());
			DTOespecialidad pro = iespecialidad.editar(especialidad);

			URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(especialidad.getId()).toUri();

			return ResponseEntity.created(ubicacion).body(pro);
		}
	}

	// ----------------ESTADO------------------//

	@PutMapping("/especialidad/estado/{id}")
	public ResponseEntity<DTOespecialidad> Estadoespecialidad(@PathVariable Integer id) {
		iespecialidad.estado(id);
		return ResponseEntity.ok(iespecialidad.consulta(id));
	}

}
