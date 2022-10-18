package yeilux.com.proyecto.Controller.inventario.producto;

import java.util.Collection;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import yeilux.com.proyecto.Model.Class.producto.producto;
import yeilux.com.proyecto.Model.Class.inventario.producto.inventariopro;
import yeilux.com.proyecto.Model.Interface.producto.IProducto;
import yeilux.com.proyecto.Model.Interface.inventario.producto.IInventariopro;

@RestController
@SessionAttributes("inventariopro")
@RequestMapping("/inventariopro")
public class InventarioproController {

    @Autowired
    private IInventariopro iInventariopro;
	@Autowired
    private IProducto iProducto;

// **************//
// --------------METODO GET----------------//
// **************//

// --------------LISTAR TODOS--------------//

@GetMapping
	public ResponseEntity<Collection<inventariopro>> listartipos(){
		return new ResponseEntity<>(iInventariopro.findAll(),HttpStatus.OK);
	}


// ---------------LISTAR UNO---------------//

@GetMapping("/{id}")
	public ResponseEntity<inventariopro> obtenertipoPorId(@PathVariable Integer id){
	inventariopro inventariopro = iInventariopro.findById(id).orElseThrow();
		
		if(inventariopro != null) {
			return new ResponseEntity<>(iInventariopro.findById(id).orElseThrow(),HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
	}

// **************//
// -------------METODO POST----------------//
// **************//

// ---------------REGISTRAR----------------//

@PostMapping
	public ResponseEntity<?> guardarTipo(@RequestBody inventariopro inventariopro){
		return new ResponseEntity<>(iInventariopro.save(inventariopro),HttpStatus.CREATED);
	}


// **************//
// --------------METODO PUT----------------//
// **************//

@PutMapping("/{id}")
    public ResponseEntity<inventariopro> actualizarinventario(@Valid @RequestBody inventariopro inventariopro,
            @PathVariable Integer id) {
        Optional<producto> productoOptional = iProducto.findById(inventariopro.getProducto().getId());

        if (!productoOptional.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        Optional<inventariopro> inventarioOptional = iInventariopro.findById(id);
        if (!inventarioOptional.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        inventariopro.setProducto(productoOptional.get());
        inventariopro.setId(inventarioOptional.get().getId());
        iInventariopro.save(inventariopro);

        return ResponseEntity.noContent().build();
    }

// ----------------EDITAR------------------//



// ----------------ESTADO------------------//



}
