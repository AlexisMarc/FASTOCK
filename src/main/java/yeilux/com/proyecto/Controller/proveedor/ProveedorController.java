package yeilux.com.proyecto.Controller.proveedor;

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

import yeilux.com.proyecto.Model.Class.proveedor.proveedor;
import yeilux.com.proyecto.Model.Interface.proveedor.IProveedor;

@RestController
@SessionAttributes("proveedor")
@RequestMapping("/proveedor") 
public class ProveedorController {

    @Autowired
    private IProveedor iproveedor;

// ****************************************//
// --------------METODO GET----------------//
// ****************************************//

// --------------LISTAR TODOS--------------//
@GetMapping
	public ResponseEntity<Page<proveedor>> proveedores(Pageable pageable){
		return ResponseEntity.ok(iproveedor.findAll(pageable));
	}


// ---------------LISTAR UNO---------------//


@GetMapping("/{id}")
	public ResponseEntity<proveedor> proveedor(@PathVariable Integer id){
		Optional<proveedor> proveedorOptional = iproveedor.findById(id);
		
		if(!proveedorOptional.isPresent()){
			return ResponseEntity.unprocessableEntity().build();
		}
		
		return ResponseEntity.ok(proveedorOptional.get());
	}

// ****************************************//
// -------------METODO POST----------------//
// ****************************************//

// ---------------REGISTRAR----------------//

@PostMapping
	public ResponseEntity<proveedor> guardarproveedor(@Valid @RequestBody proveedor proveedor){
		proveedor proveedorGuardada = iproveedor.save(proveedor);
		URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(proveedorGuardada.getId()).toUri();
		return ResponseEntity.created(ubicacion).body(proveedorGuardada);
	}


// ****************************************//
// --------------METODO PUT----------------//
// ****************************************//

// ----------------EDITAR------------------//

@PutMapping("/{id}")
	public ResponseEntity<proveedor> actualizarproveedor(@PathVariable Integer id,@Valid @RequestBody proveedor proveedor){
		Optional<proveedor> proveedorOptional = iproveedor.findById(id);
		
		if(!proveedorOptional.isPresent()){
			return ResponseEntity.unprocessableEntity().build();
		}
		
		proveedor.setId(proveedorOptional.get().getId());
		iproveedor.save(proveedor);
		
		return ResponseEntity.noContent().build();
	}

// ----------------ESTADO------------------//



}
