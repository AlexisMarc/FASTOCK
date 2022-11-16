package fastock.fastock.Controller.fabricacion;
import java.util.Collection;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import fastock.fastock.Service.fabricacion.IFabricacion;
import fastock.fastock.Class.fabricacion.fabricacion;
import fastock.fastock.Class.insumo.insumo;
import fastock.fastock.Class.producto.producto;
import fastock.fastock.Class.usuario.usuario;

@RestController

@SessionAttributes("fabricacion")
@RequestMapping("/fabricacion") 
public class FabricacionController {

    @Autowired
    private IFabricacion ifabricacion;

// ****************************************//
// --------------METODO GET----------------//
// ****************************************//

// --------------LISTAR TODOS--------------//
@PreAuthorize("hasRole('PRODUCTO_CREATE_UPDATE')")
@GetMapping
	public ResponseEntity<Collection<fabricacion>> listarfabricacions(){
		return new ResponseEntity<>(ifabricacion.findAll(),HttpStatus.OK);
	}

// ---------------LISTAR UNO---------------//

@GetMapping("/{id}")
	public ResponseEntity<fabricacion> obtenerfabricacionPorId(@PathVariable Integer id){
	fabricacion fabricacion = ifabricacion.findById(id).orElseThrow();
		
		if(fabricacion != null) {
			return new ResponseEntity<>(ifabricacion.findById(id).orElseThrow(),HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
	}

// ---------------LISTAR usuario---------------//

@GetMapping("/{id}/usuario")
	public ResponseEntity<Collection<usuario>> listarusuario(@PathVariable Integer id){
		fabricacion fabricacion = ifabricacion.findById(id).orElseThrow();
		
		if(fabricacion != null) {
			return new ResponseEntity<>(fabricacion.getUsuario(),HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
	}

// ---------------LISTAR PRODUCTOS---------------//

@GetMapping("/{id}/producto")
	public ResponseEntity<Collection<producto>> listarProducto(@PathVariable Integer id){
		fabricacion fabricacion = ifabricacion.findById(id).orElseThrow();
		
		if(fabricacion != null) {
			return new ResponseEntity<>(fabricacion.getProducto(),HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
	}

// ---------------LISTAR INSUMO---------------//

@GetMapping("/{id}/insumo")
	public ResponseEntity<Collection<insumo>> listarInsumo(@PathVariable Integer id){
		fabricacion fabricacion = ifabricacion.findById(id).orElseThrow();
		
		if(fabricacion != null) {
			return new ResponseEntity<>(fabricacion.getInsumo(),HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
	}
// ****************************************//
// -------------METODO POST----------------//
// ****************************************//

// ---------------REGISTRAR----------------//

@RolesAllowed("FABRICACION_CREATE_UPDATE")
@PostMapping
	public ResponseEntity<?> guardarfabricacion(@RequestBody fabricacion fabricacion){
		return new ResponseEntity<>(ifabricacion.save(fabricacion),HttpStatus.CREATED);
	}

// ****************************************//
// --------------METODO PUT----------------//
// ****************************************//

// ----------------EDITAR------------------//



// ----------------ESTADO------------------//



}
