package yeilux.com.proyecto.Controller.producto;

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

import yeilux.com.proyecto.Service.producto.ICategoria;
import yeilux.com.proyecto.Class.producto.categoria;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@SessionAttributes("categoria")
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private ICategoria icategoria;
    
// ****************************************//
// --------------METODO GET----------------//
// ****************************************//

// --------------LISTAR TODOS--------------//

@GetMapping
	public ResponseEntity<Collection<categoria>> listarcategorias(){
		return new ResponseEntity<>(icategoria.findAll(),HttpStatus.OK);
	}

// ---------------LISTAR UNO---------------//

@GetMapping("/{id}")
	public ResponseEntity<categoria> obtenerCategoriaPorId(@PathVariable Integer id){
	categoria categoria = icategoria.findById(id).orElseThrow();
		
		if(categoria != null) {
			return new ResponseEntity<>(icategoria.findById(id).orElseThrow(),HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
	}

// ****************************************//
// -------------METODO POST----------------//
// ****************************************//

// ---------------REGISTRAR----------------//

@PostMapping
	public ResponseEntity<?> guardarCategoria(@RequestBody categoria categoria){
		return new ResponseEntity<>(icategoria.save(categoria),HttpStatus.CREATED);
	}

// ****************************************//
// --------------METODO PUT----------------//
// ****************************************//

// ----------------EDITAR------------------//



// ----------------ESTADO------------------//




}
