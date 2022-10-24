package yeilux.com.proyecto.Controller.fabricacion;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import yeilux.com.proyecto.Service.fabricacion.IArea;
import yeilux.com.proyecto.Service.fabricacion.IProduccion;
import yeilux.com.proyecto.Class.fabricacion.area;
import yeilux.com.proyecto.Class.fabricacion.produccion;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@SessionAttributes("produccion")
@RequestMapping("/produccion")
public class ProduccionController {
    @Autowired
    private IProduccion iproduccion;

    @Autowired
    private IArea iarea;
    // ****************************************//
// --------------METODO GET----------------//
// ****************************************//

// --------------LISTAR TODOS--------------//

@GetMapping
public ResponseEntity<Page<produccion>> produccions(Pageable pageable){
    return ResponseEntity.ok(iproduccion.findAll(pageable));
}

// ---------------LISTAR UNO---------------//
@GetMapping("/{id}")
public ResponseEntity<produccion> produccion(@PathVariable Integer id){
    Optional<produccion> produccionOptional = iproduccion.findById(id);
    
    if(!produccionOptional.isPresent()){
        return ResponseEntity.unprocessableEntity().build();
    }
    
    return ResponseEntity.ok(produccionOptional.get());
}


// ****************************************//
// -------------METODO POST----------------//
// ****************************************//

// ---------------REGISTRAR----------------//

@PostMapping
public ResponseEntity<produccion> guardarproduccion(@Valid @RequestBody produccion produccion){
    Optional<area> areaOptional = iarea.findById(produccion.getArea().getId());
    
    if(!areaOptional.isPresent()){
        return ResponseEntity.unprocessableEntity().build();
    }
    
    produccion.setArea(areaOptional.get());
    produccion produccionGuardado = iproduccion.save(produccion);
    URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(produccionGuardado.getId()).toUri();
    
    return ResponseEntity.created(ubicacion).body(produccionGuardado);
}


// ****************************************//
// --------------METODO PUT----------------//
// ****************************************//

// ----------------EDITAR------------------//

@PutMapping("/{id}")
public ResponseEntity<produccion> actualizarproduccion(@Valid @RequestBody produccion produccion,@PathVariable Integer id){
    Optional<area> areaOptional = iarea.findById(produccion.getArea().getId());
    
    if(!areaOptional.isPresent()){
        return ResponseEntity.unprocessableEntity().build();
    }
    
    Optional<produccion> produccionOptional = iproduccion.findById(id);
    if(!produccionOptional.isPresent()){
        return ResponseEntity.unprocessableEntity().build();
    }
    
    produccion.setArea(areaOptional.get());
    produccion.setId(produccionOptional.get().getId());
    iproduccion.save(produccion);
    
    return ResponseEntity.noContent().build();
}

// ----------------ESTADO------------------//


}
