package fastock.fastock.Controller.fabricacion;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import fastock.fastock.Service.fabricacion.ImpProduccion;
import fastock.fastock.Mapping.fabricacion.DTOCreateProduccion;
import fastock.fastock.Mapping.fabricacion.DTOproduccion;

@RestController

@SessionAttributes("produccion")
@RequestMapping("/produccion")
public class ProduccionController {

    @Autowired
    private ImpProduccion iproduccion;

// ****************************************//
// --------------METODO GET----------------//
// ****************************************//

// --------------LISTAR TODOS--------------//
@GetMapping
	public ResponseEntity<List<DTOproduccion>> producciones(){
		return ResponseEntity.ok(iproduccion.listado());
	}


// ---------------LISTAR UNO---------------//


@GetMapping("/{id}")
	public ResponseEntity<DTOproduccion> produccion(@PathVariable Integer id){
		DTOproduccion produccionOptional = iproduccion.consulta(id);
		
		if(produccionOptional==null){
			return ResponseEntity.unprocessableEntity().build();
		}
		
		return ResponseEntity.ok(produccionOptional);
	}

// ****************************************//
// -------------METODO POST----------------//
// ****************************************//

// ---------------REGISTRAR----------------//

@PostMapping
	public ResponseEntity<DTOproduccion> guardarproduccion(@Valid @RequestBody DTOCreateProduccion produccion){
		DTOproduccion produccionGuardada = iproduccion.registrar(produccion);
		URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(produccionGuardada.getId()).toUri();
		return ResponseEntity.created(ubicacion).body(produccionGuardada);
	}


// ****************************************//
// --------------METODO PUT----------------//
// ****************************************//

// ----------------ESTADO------------------//

@PutMapping("/estado/{id}")
	public ResponseEntity<DTOproduccion> Estadoproduccion(@PathVariable Integer id){
		iproduccion.estado(id);
		return ResponseEntity.ok(iproduccion.consulta(id));
	}


}
