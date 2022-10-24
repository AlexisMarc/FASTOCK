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

import yeilux.com.proyecto.Service.producto.IProducto;
import yeilux.com.proyecto.Class.producto.producto;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@SessionAttributes("producto")
@RequestMapping("/producto")

public class ProductoController {
    @Autowired
    private IProducto iproducto;

// ****************************************//
// --------------METODO GET----------------//
// ****************************************//

// --------------LISTAR TODOS--------------//
@GetMapping
	public ResponseEntity<Collection<producto>> listarproductos(){
		return new ResponseEntity<>(iproducto.findAll(),HttpStatus.OK);
	}

// ---------------LISTAR UNO---------------//
@GetMapping("/{id}")
	public ResponseEntity<producto> obtenerproductoPorId(@PathVariable Integer id){
		producto producto = iproducto.findById(id).orElseThrow();
		
		if(producto != null) {
			return new ResponseEntity<>(iproducto.findById(id).orElseThrow(),HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
	}

// ****************************************//
// -------------METODO POST----------------//
// ****************************************//

// ---------------REGISTRAR----------------//
@PostMapping
	public ResponseEntity<?> guardarproducto(@RequestBody producto producto){
		return new ResponseEntity<>(iproducto.save(producto),HttpStatus.CREATED);
	}


// ****************************************//
// --------------METODO PUT----------------//
// ****************************************//

// ----------------EDITAR------------------//



// ----------------ESTADO------------------//



}
