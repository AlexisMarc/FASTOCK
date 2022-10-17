package yeilux.com.proyecto.Controller.empleado;

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
import yeilux.com.proyecto.Model.Class.empleado.cargo;
import yeilux.com.proyecto.Model.Class.empleado.empleado;
import yeilux.com.proyecto.Model.Interface.empleado.ICargo;
import yeilux.com.proyecto.Model.Interface.empleado.IEmpleado;

@RestController
@SessionAttributes("empleado")
@RequestMapping("/empleado")

public class EmpleadoController {

    @Autowired
    private IEmpleado iempleado;

    @Autowired
    private ICargo icargo;

// ****************************************//
// --------------METODO GET----------------//
// ****************************************//

// --------------LISTAR TODOS--------------//

@GetMapping
	public ResponseEntity<Page<empleado>> empleados(Pageable pageable){
		return ResponseEntity.ok(iempleado.findAll(pageable));
	}

// ---------------LISTAR UNO---------------//
@GetMapping("/{id}")
	public ResponseEntity<empleado> empleado(@PathVariable Integer id){
		Optional<empleado> empleadoOptional = iempleado.findById(id);
		
		if(!empleadoOptional.isPresent()){
			return ResponseEntity.unprocessableEntity().build();
		}
		
		return ResponseEntity.ok(empleadoOptional.get());
	}


// ****************************************//
// -------------METODO POST----------------//
// ****************************************//

// ---------------REGISTRAR----------------//

@PostMapping
	public ResponseEntity<empleado> guardarempleado(@Valid @RequestBody empleado empleado){
		Optional<cargo> cargoOptional = icargo.findById(empleado.getCargo().getId());
		
		if(!cargoOptional.isPresent()){
			return ResponseEntity.unprocessableEntity().build();
		}
		
		empleado.setCargo(cargoOptional.get());
		empleado empleadoGuardado = iempleado.save(empleado);
		URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(empleadoGuardado.getId()).toUri();
		
		return ResponseEntity.created(ubicacion).body(empleadoGuardado);
	}


// ****************************************//
// --------------METODO PUT----------------//
// ****************************************//

// ----------------EDITAR------------------//

@PutMapping("/{id}")
	public ResponseEntity<empleado> actualizarempleado(@Valid @RequestBody empleado empleado,@PathVariable Integer id){
		Optional<cargo> cargoOptional = icargo.findById(empleado.getCargo().getId());
		
		if(!cargoOptional.isPresent()){
			return ResponseEntity.unprocessableEntity().build();
		}
		
		Optional<empleado> empleadoOptional = iempleado.findById(id);
		if(!empleadoOptional.isPresent()){
			return ResponseEntity.unprocessableEntity().build();
		}
		
		empleado.setCargo(cargoOptional.get());
		empleado.setId(empleadoOptional.get().getId());
		iempleado.save(empleado);
		
		return ResponseEntity.noContent().build();
	}

// ----------------ESTADO------------------//



}