package yeilux.com.proyecto.Controller.empleado;

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
import yeilux.com.proyecto.Model.Interface.empleado.IAdmin;

@RestController
@SessionAttributes("admin")
@RequestMapping("/admin")

public class AdminController {

    @Autowired
    private IAdmin iadmin;

// ****************************************//
// --------------METODO GET----------------//
// ****************************************//

// --------------LISTAR TODOS--------------//

@GetMapping
	public ResponseEntity<Collection<admin>> listarAdmins(){
		return new ResponseEntity<>(iadmin.findAll(),HttpStatus.OK);
	}
// ---------------LISTAR UNO---------------//

@GetMapping("/{id}")
	public ResponseEntity<admin> obtenerAdminPorId(@PathVariable Integer id){
		admin admin = iadmin.findById(id).orElseThrow();
		
		if(admin != null) {
			return new ResponseEntity<>(iadmin.findById(id).orElseThrow(),HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
	}

// ---------------LISTAR FABRICACIONES---------------//

@GetMapping("/{id}/fabricaciones")
	public ResponseEntity<Collection<fabricacion>> listarAdmin(@PathVariable Integer id){
		admin admin = iadmin.findById(id).orElseThrow();
		
		if(admin != null) {
			return new ResponseEntity<>(admin.getFabricacion(),HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
	}

// ****************************************//
// -------------METODO POST----------------//
// ****************************************//

// ---------------REGISTRAR----------------//

@PostMapping
	public ResponseEntity<?> guardarAdmin(@RequestBody admin admin){
		return new ResponseEntity<>(iadmin.save(admin),HttpStatus.CREATED);
	}

// ****************************************//
// --------------METODO PUT----------------//
// ****************************************//

// ----------------EDITAR------------------//


// ----------------ESTADO------------------//



}