package fastock.fastock.Controller.usuario;

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

import fastock.fastock.Service.usuario.ImpCargo;
import fastock.fastock.Service.usuario.ImpUsuario;
import fastock.fastock.Mapping.usuario.DTOCreateCargo;
import fastock.fastock.Mapping.usuario.DTOCreateUsuario;
import fastock.fastock.Mapping.usuario.DTOUpdateCargo;
import fastock.fastock.Mapping.usuario.DTOUpdateUsuario;
import fastock.fastock.Mapping.usuario.DTOcargo;
import fastock.fastock.Mapping.usuario.DTOusuario;

@RestController
@SessionAttributes("usuario")
@RequestMapping("/usuario")

public class UsuarioController {

    @Autowired
    private ImpUsuario iusuario;

	@Autowired 
	private ImpCargo icargo;

	// ****************************************//
// --------------METODO GET----------------//
// ****************************************//

// --------------LISTAR TODOS--------------//
@GetMapping
	public ResponseEntity<List<DTOusuario>> usuarioes(){
		return ResponseEntity.ok(iusuario.listado());
	}


// ---------------LISTAR UNO---------------//


@GetMapping("/{id}")
	public ResponseEntity<DTOusuario> usuario(@PathVariable Integer id){
		DTOusuario usuarioOptional = iusuario.consulta(id);
		
		if(usuarioOptional==null){
			return ResponseEntity.unprocessableEntity().build();
		}
		
		return ResponseEntity.ok(usuarioOptional);
	}

// ****************************************//
// -------------METODO POST----------------//
// ****************************************//

// ---------------REGISTRAR----------------//

@PostMapping
	public ResponseEntity<DTOusuario> guardarusuario(@Valid @RequestBody DTOCreateUsuario usuario){
		DTOusuario usuarioGuardada = iusuario.registrar(usuario);
		URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(usuarioGuardada.getId()).toUri();
		return ResponseEntity.created(ubicacion).body(usuarioGuardada);
	}


// ****************************************//
// --------------METODO PUT----------------//
// ****************************************//

// ----------------EDITAR------------------//

@PutMapping("/{id}")
	public ResponseEntity<DTOusuario> actualizarusuario(@PathVariable Integer id,@Valid @RequestBody DTOUpdateUsuario usuario){
		DTOusuario usuarioID = iusuario.consulta(id);
		if(usuarioID==null){
			return ResponseEntity.unprocessableEntity().build();
		}else{
			usuario.setId(usuarioID.getId());
			DTOusuario pro = iusuario.editar(usuario);

			URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(usuario.getId()).toUri();

			return ResponseEntity.created(ubicacion).body(pro);
		}
	}

// ----------------ESTADO------------------//

@PutMapping("/estado/{id}")
	public ResponseEntity<DTOusuario> Estadousuario(@PathVariable Integer id){
		iusuario.estado(id);
		return ResponseEntity.ok(iusuario.consulta(id));
	}

// ************************************************************************************************************//
// --------------------------------------------CARGO-------------------------------------------------------//
// ************************************************************************************************************//

// ****************************************//
// --------------METODO GET----------------//
// ****************************************//

// --------------LISTAR TODOS--------------//
@GetMapping("/cargo")
	public ResponseEntity<List<DTOcargo>> cargoes(){
		return ResponseEntity.ok(icargo.listado());
	}


// ---------------LISTAR UNO---------------//


@GetMapping("/cargo/{id}")
	public ResponseEntity<DTOcargo> cargo(@PathVariable Integer id){
		DTOcargo cargoOptional = icargo.consulta(id);
		
		if(cargoOptional==null){
			return ResponseEntity.unprocessableEntity().build();
		}
		
		return ResponseEntity.ok(cargoOptional);
	}

// ****************************************//
// -------------METODO POST----------------//
// ****************************************//

// ---------------REGISTRAR----------------//

@PostMapping("/cargo")
	public ResponseEntity<DTOcargo> guardarcargo(@Valid @RequestBody DTOCreateCargo cargo){
		DTOcargo cargoGuardada = icargo.registrar(cargo);
		URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(cargoGuardada.getId()).toUri();
		return ResponseEntity.created(ubicacion).body(cargoGuardada);
	}


// ****************************************//
// --------------METODO PUT----------------//
// ****************************************//

// ----------------EDITAR------------------//

@PutMapping("/cargo/{id}")
	public ResponseEntity<DTOcargo> actualizarcargo(@PathVariable Integer id,@Valid @RequestBody DTOUpdateCargo cargo){
		DTOcargo cargoID = icargo.consulta(id);
		if(cargoID==null){
			return ResponseEntity.unprocessableEntity().build();
		}else{
			cargo.setId(cargoID.getId());
			DTOcargo pro = icargo.editar(cargo);

			URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(cargo.getId()).toUri();

			return ResponseEntity.created(ubicacion).body(pro);
		}
	}

// ----------------ESTADO------------------//

@PutMapping("/cargo/estado/{id}")
	public ResponseEntity<DTOcargo> Estadocargo(@PathVariable Integer id){
		icargo.estado(id);
		return ResponseEntity.ok(icargo.consulta(id));
	}
}