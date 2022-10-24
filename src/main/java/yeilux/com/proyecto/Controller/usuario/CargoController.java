package yeilux.com.proyecto.Controller.usuario;

import java.net.URI;
import java.util.Optional;

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

import javax.validation.Valid;

import yeilux.com.proyecto.Service.usuario.ICargo;
import yeilux.com.proyecto.Class.usuario.cargo;

@RestController
@SessionAttributes("cargo")
@RequestMapping("/cargo")
public class CargoController {


    @Autowired
    private ICargo icargo;

// ****************************************//
// --------------METODO GET----------------//
// ****************************************//

// --------------LISTAR TODOS--------------//

@GetMapping
	public ResponseEntity<Page<cargo>> cargos(Pageable pageable){
		return ResponseEntity.ok(icargo.findAll(pageable));
	}

// ---------------LISTAR UNO---------------//

@GetMapping("/{id}")
	public ResponseEntity<cargo> cargo(@PathVariable Integer id){
		Optional<cargo> cargoOptional = icargo.findById(id);
		
		if(!cargoOptional.isPresent()){
			return ResponseEntity.unprocessableEntity().build();
		}
		
		return ResponseEntity.ok(cargoOptional.get());
	}

// ****************************************//
// -------------METODO POST----------------//
// ****************************************//

// ---------------REGISTRAR----------------//

@PostMapping
	public ResponseEntity<cargo> guardarcargo(@Valid @RequestBody cargo cargo){
		cargo cargoGuardada = icargo.save(cargo);
		URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(cargoGuardada.getId()).toUri();
		return ResponseEntity.created(ubicacion).body(cargoGuardada);
	}

// ****************************************//
// --------------METODO PUT----------------//
// ****************************************//

// ----------------EDITAR------------------//

@PutMapping("/{id}")
	public ResponseEntity<cargo> actualizarcargo(@PathVariable Integer id,@Valid @RequestBody cargo cargo){
		Optional<cargo> cargoOptional = icargo.findById(id);
		
		if(!cargoOptional.isPresent()){
			return ResponseEntity.unprocessableEntity().build();
		}
		
		cargo.setId(cargoOptional.get().getId());
		icargo.save(cargo);
		
		return ResponseEntity.noContent().build();
	}

// ----------------ESTADO------------------//



}
