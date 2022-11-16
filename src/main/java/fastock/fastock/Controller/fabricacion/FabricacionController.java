package fastock.fastock.Controller.fabricacion;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

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

import fastock.fastock.Service.fabricacion.ImpArea;
import fastock.fastock.Service.fabricacion.ImpFabricacion;
import fastock.fastock.Mapping.fabricacion.DTOCreateArea;
import fastock.fastock.Mapping.fabricacion.DTOCreateFabricacion;
import fastock.fastock.Mapping.fabricacion.DTOUpdateArea;
import fastock.fastock.Mapping.fabricacion.DTOUpdateFabricacion;
import fastock.fastock.Mapping.fabricacion.DTOarea;
import fastock.fastock.Mapping.fabricacion.DTOfabricacion;

@RestController

@SessionAttributes("fabricacion")
@RequestMapping("/fabricacion")
public class FabricacionController {

	@Autowired
	private ImpFabricacion ifabricacion;

	@Autowired
	private ImpArea iarea;

	// ****************************************//
	// --------------METODO GET----------------//
	// ****************************************//

	// --------------LISTAR TODOS--------------//
	@GetMapping
	public ResponseEntity<List<DTOfabricacion>> fabricaciones() {
		return ResponseEntity.ok(ifabricacion.listado());
	}

	// ---------------LISTAR UNO---------------//

	@GetMapping("/{id}")
	public ResponseEntity<DTOfabricacion> fabricacion(@PathVariable Integer id) {
		DTOfabricacion fabricacionOptional = ifabricacion.consulta(id);

		if (fabricacionOptional == null) {
			return ResponseEntity.unprocessableEntity().build();
		}

		return ResponseEntity.ok(fabricacionOptional);
	}

	// ****************************************//
	// -------------METODO POST----------------//
	// ****************************************//

	// ---------------REGISTRAR----------------//

	@PostMapping
	public ResponseEntity<DTOfabricacion> guardarfabricacion(@Valid @RequestBody DTOCreateFabricacion fabricacion) {
		DTOfabricacion fabricacionGuardada = ifabricacion.registrar(fabricacion);
		URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(fabricacionGuardada.getId()).toUri();
		return ResponseEntity.created(ubicacion).body(fabricacionGuardada);
	}

	// ****************************************//
	// --------------METODO PUT----------------//
	// ****************************************//

	// ----------------EDITAR------------------//

	@PutMapping("/{id}")
	public ResponseEntity<DTOfabricacion> actualizarfabricacion(@PathVariable Integer id,
			@Valid @RequestBody DTOUpdateFabricacion fabricacion) {
		DTOfabricacion fabricacionID = ifabricacion.consulta(id);
		if (fabricacionID == null) {
			return ResponseEntity.unprocessableEntity().build();
		} else {
			fabricacion.setId(fabricacionID.getId());
			DTOfabricacion pro = ifabricacion.editar(fabricacion);

			URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(fabricacion.getId()).toUri();

			return ResponseEntity.created(ubicacion).body(pro);
		}
	}

	// ----------------ESTADO------------------//

	@PutMapping("/estado/{id}")
	public ResponseEntity<DTOfabricacion> Estadofabricacion(@PathVariable Integer id) {
		ifabricacion.estado(id);
		return ResponseEntity.ok(ifabricacion.consulta(id));
	}

	// ****************************************************************************************************************//
	// ------------------------------------------AREA--------------------------------------------------------//
	// ************************************************************************************************************//

	// ****************************************//
	// -------------METODO POST----------------//
	// ****************************************//

	// ---------------REGISTRAR----------------//

	@PostMapping("/area")
	public ResponseEntity<DTOarea> guardararea(@Valid @RequestBody DTOCreateArea area) {
		DTOarea areaGuardada = iarea.registrar(area);
		URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(areaGuardada.getId()).toUri();
		return ResponseEntity.created(ubicacion).body(areaGuardada);
	}

	// ****************************************//
	// --------------METODO PUT----------------//
	// ****************************************//

	// ----------------EDITAR------------------//

	@PutMapping("/area/{id}")
	public ResponseEntity<DTOarea> actualizararea(@PathVariable Integer id, @Valid @RequestBody DTOUpdateArea area) {
		DTOarea areaID = iarea.consulta(id);
		if (areaID == null) {
			return ResponseEntity.unprocessableEntity().build();
		} else {
			area.setId(areaID.getId());
			DTOarea pro = iarea.editar(area);

			URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(area.getId()).toUri();

			return ResponseEntity.created(ubicacion).body(pro);
		}
	}

	// ----------------ESTADO------------------//

	@PutMapping("/area/estado/{id}")
	public ResponseEntity<DTOarea> Estadoarea(@PathVariable Integer id) {
		iarea.estado(id);
		return ResponseEntity.ok(iarea.consulta(id));
	}

}
