package fastock.fastock.Controller.insumo;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import fastock.fastock.Service.insumo.ITipo;
import fastock.fastock.Class.insumo.tipo;
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@SessionAttributes("tipo")
@RequestMapping("/tipo")
public class TipoController {

    @Autowired
    private ITipo itipo;

// ****************************************//
// --------------METODO GET----------------//
// ****************************************//

// --------------LISTAR TODOS--------------//

@GetMapping
	public ResponseEntity<Collection<tipo>> listartipos(){
		return new ResponseEntity<>(itipo.findAll(),HttpStatus.OK);
	}

// ---------------LISTAR UNO---------------//

@GetMapping("/{id}")
	public ResponseEntity<tipo> obtenertipoPorId(@PathVariable Integer id){
	tipo tipo = itipo.findById(id).orElseThrow();
		
		if(tipo != null) {
			return new ResponseEntity<>(itipo.findById(id).orElseThrow(),HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
	}


// ****************************************//
// -------------METODO POST----------------//
// ****************************************//

// ---------------REGISTRAR----------------//

@PostMapping
	public ResponseEntity<?> guardarTipo(@RequestBody tipo tipo){
		return new ResponseEntity<>(itipo.save(tipo),HttpStatus.CREATED);
	}

// ****************************************//
// --------------METODO PUT----------------//
// ****************************************//

// ----------------EDITAR------------------//



// ----------------ESTADO------------------//



}
