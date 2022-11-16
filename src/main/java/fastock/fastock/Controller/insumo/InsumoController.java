package fastock.fastock.Controller.insumo;
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

import fastock.fastock.Service.insumo.ImpInsumo;
import fastock.fastock.Service.insumo.ImpTipo;
import fastock.fastock.Service.inventario.ImpInventario;
import fastock.fastock.Mapping.insumo.DTOCreateInsumo;
import fastock.fastock.Mapping.insumo.DTOCreateTipo;
import fastock.fastock.Mapping.insumo.DTOUpdateInsumo;
import fastock.fastock.Mapping.insumo.DTOUpdateTipo;
import fastock.fastock.Mapping.insumo.DTOinsumo;
import fastock.fastock.Mapping.insumo.DTOtipo;
import fastock.fastock.Mapping.inventario.DTOCreateInventario;
import fastock.fastock.Mapping.inventario.DTOinventario;


@RestController

@SessionAttributes("insumo")
@RequestMapping("/insumo")

public class InsumoController {

    @Autowired
    private ImpInsumo iinsumo;

	@Autowired
	private ImpTipo itipo;

	@Autowired
	private ImpInventario iinventario;

	// ****************************************//
	// --------------METODO GET----------------//
	// ****************************************//

	// --------------LISTAR TODOS--------------//
	@GetMapping
	public ResponseEntity<List<DTOinsumo>> insumoes() {
		return ResponseEntity.ok(iinsumo.listado());
	}

	// ---------------LISTAR UNO---------------//

	@GetMapping("/{id}")
	public ResponseEntity<DTOinsumo> insumo(@PathVariable Integer id) {
		DTOinsumo insumoOptional = iinsumo.consulta(id);

		if (insumoOptional == null) {
			return ResponseEntity.unprocessableEntity().build();
		}

		return ResponseEntity.ok(insumoOptional);
	}

	// ****************************************//
	// -------------METODO POST----------------//
	// ****************************************//

	// ---------------REGISTRAR----------------//

	@PostMapping
	public ResponseEntity<DTOinsumo> guardarinsumo(@Valid @RequestBody DTOCreateInsumo insumo) {
		DTOinsumo insumoGuardada = iinsumo.registrar(insumo);
		URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(insumoGuardada.getId()).toUri();
		return ResponseEntity.created(ubicacion).body(insumoGuardada);
	}

	// ****************************************//
	// --------------METODO PUT----------------//
	// ****************************************//

	// ----------------EDITAR------------------//

	@PutMapping("/{id}")
	public ResponseEntity<DTOinsumo> actualizarinsumo(@PathVariable Integer id,
			@Valid @RequestBody DTOUpdateInsumo insumo) {
		DTOinsumo insumoID = iinsumo.consulta(id);
		if (insumoID == null) {
			return ResponseEntity.unprocessableEntity().build();
		} else {
			insumo.setId(insumoID.getId());
			DTOinsumo pro = iinsumo.editar(insumo);

			URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(insumo.getId()).toUri();

			return ResponseEntity.created(ubicacion).body(pro);
		}
	}

	// ----------------ESTADO------------------//

	@PutMapping("/estado/{id}")
	public ResponseEntity<DTOinsumo> Estadoinsumo(@PathVariable Integer id) {
		iinsumo.estado(id);
		return ResponseEntity.ok(iinsumo.consulta(id));
	}

	// ****************************************************************************************************************//
	// ------------------------------------------TIPO-------------------------------------------------------//
	// ****************************************************************************************************************//

// ****************************************//
// --------------METODO GET----------------//
// ****************************************//

// --------------LISTAR TODOS--------------//
@GetMapping
	public ResponseEntity<List<DTOtipo>> tipoes(){
		return ResponseEntity.ok(itipo.listado());
	}


// ---------------LISTAR UNO---------------//


@GetMapping("/tipo/{id}")
	public ResponseEntity<DTOtipo> tipo(@PathVariable Integer id){
		DTOtipo tipoOptional = itipo.consulta(id);
		
		if(tipoOptional==null){
			return ResponseEntity.unprocessableEntity().build();
		}
		
		return ResponseEntity.ok(tipoOptional);
	}

// ****************************************//
// -------------METODO POST----------------//
// ****************************************//

// ---------------REGISTRAR----------------//

@PostMapping
	public ResponseEntity<DTOtipo> guardartipo(@Valid @RequestBody DTOCreateTipo tipo){
		DTOtipo tipoGuardada = itipo.registrar(tipo);
		URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(tipoGuardada.getId()).toUri();
		return ResponseEntity.created(ubicacion).body(tipoGuardada);
	}


// ****************************************//
// --------------METODO PUT----------------//
// ****************************************//

// ----------------EDITAR------------------//

@PutMapping("/tipo/{id}")
	public ResponseEntity<DTOtipo> actualizartipo(@PathVariable Integer id,@Valid @RequestBody DTOUpdateTipo tipo){
		DTOtipo tipoID = itipo.consulta(id);
		if(tipoID==null){
			return ResponseEntity.unprocessableEntity().build();
		}else{
			tipo.setId(tipoID.getId());
			DTOtipo pro = itipo.editar(tipo);

			URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(tipo.getId()).toUri();

			return ResponseEntity.created(ubicacion).body(pro);
		}
	}

// ----------------ESTADO------------------//

@PutMapping("/tipo/estado/{id}")
	public ResponseEntity<DTOtipo> Estadotipo(@PathVariable Integer id){
		itipo.estado(id);
		return ResponseEntity.ok(itipo.consulta(id));
	}

// ****************************************************************************************************************//
// ------------------------------------------INVENTARIO--------------------------------------------------------//
// ************************************************************************************************************//

// ****************************************//
// --------------METODO GET----------------//
// ****************************************//

// --------------LISTAR TODOS--------------//
@GetMapping
	public ResponseEntity<List<DTOinventario>> inventarioes(){
		return ResponseEntity.ok(iinventario.listado());
	}


// ---------------LISTAR UNO---------------//


@GetMapping("/inventario/{id}")
	public ResponseEntity<DTOinventario> inventario(@PathVariable Integer id){
		DTOinventario inventarioOptional = iinventario.consulta(id);
		
		if(inventarioOptional==null){
			return ResponseEntity.unprocessableEntity().build();
		}
		
		return ResponseEntity.ok(inventarioOptional);
	}

// ****************************************//
// -------------METODO POST----------------//
// ****************************************//

// ---------------REGISTRAR----------------//

@PostMapping
	public ResponseEntity<DTOinventario> guardarinventario(@Valid @RequestBody DTOCreateInventario inventario){
		DTOinventario inventarioGuardada = iinventario.registrar(inventario);
		URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(inventarioGuardada.getId()).toUri();
		return ResponseEntity.created(ubicacion).body(inventarioGuardada);
	}


// ****************************************//
// --------------METODO PUT----------------//
// ****************************************//


// ----------------ESTADO------------------//

@PutMapping("/inventario/estado/{id}")
	public ResponseEntity<DTOinventario> Estadoinventario(@PathVariable Integer id){
		iinventario.estado(id);
		return ResponseEntity.ok(iinventario.consulta(id));
	}

}

