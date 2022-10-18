package yeilux.com.proyecto.Controller.fabricacion;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import yeilux.com.proyecto.Model.Class.empleado.admin;
import yeilux.com.proyecto.Model.Class.fabricacion.fabricacion;
import yeilux.com.proyecto.Model.Class.insumo.insumo;
import yeilux.com.proyecto.Model.Class.producto.producto;
import yeilux.com.proyecto.Model.Interface.empleado.IAdmin;
import yeilux.com.proyecto.Model.Interface.fabricacion.IFabricacion;

@RestController
@SessionAttributes("fabricacion")
@RequestMapping("/fabricacion") 
public class FabricacionController {

    @Autowired
    private IFabricacion ifabricacion;

    @Autowired
    private IAdmin iadmin;

// ****************************************//
// --------------METODO GET----------------//
// ****************************************//

// --------------LISTAR TODOS--------------//

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

// ---------------LISTAR ADMIN---------------//

@GetMapping("/{id}/admin")
	public ResponseEntity<Collection<admin>> listarAdmin(@PathVariable Integer id){
		fabricacion fabricacion = ifabricacion.findById(id).orElseThrow();
		
		if(fabricacion != null) {
			return new ResponseEntity<>(fabricacion.getAdmin(),HttpStatus.OK);
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
