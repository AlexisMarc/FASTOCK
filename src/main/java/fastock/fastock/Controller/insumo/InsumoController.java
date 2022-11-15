package fastock.fastock.Controller.insumo;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

import fastock.fastock.Service.insumo.IInsumo;
import fastock.fastock.Class.insumo.insumo;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@SessionAttributes("insumo")
@RequestMapping("/insumo")

public class InsumoController {

    @Autowired
    private IInsumo iinsumo;
    // @Autowired
    // private Ifabricacion ifabricacion;

// ****************************************//
// --------------METODO GET----------------//
// ****************************************//

// --------------LISTAR TODOS--------------//

@GetMapping
	public ResponseEntity<Page<insumo>> insumos(Pageable pageable){
		return ResponseEntity.ok(iinsumo.findAll(pageable));
	}

// ---------------LISTAR UNO---------------//
@GetMapping("/{id}")
	public ResponseEntity<insumo> insumo(@PathVariable Integer id){
		Optional<insumo> insumoOptional = iinsumo.findById(id);
		
		if(!insumoOptional.isPresent()){
			return ResponseEntity.unprocessableEntity().build();
		}
		
		return ResponseEntity.ok(insumoOptional.get());
	}


// ****************************************//
// -------------METODO POST----------------//
// ****************************************//

// ---------------REGISTRAR----------------//

@PostMapping
public ResponseEntity<?> guardarinsumo(@RequestBody insumo insumo){
    return new ResponseEntity<>(iinsumo.save(insumo),HttpStatus.CREATED);
}


// ****************************************//
// --------------METODO PUT----------------//
// ****************************************//

// ----------------EDITAR------------------//



// ----------------ESTADO------------------//





}
