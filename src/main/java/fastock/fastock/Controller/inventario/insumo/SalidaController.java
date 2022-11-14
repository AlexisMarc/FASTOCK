package fastock.fastock.Controller.inventario.insumo;


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

import fastock.fastock.Service.inventario.insumo.IInventario;
import fastock.fastock.Service.inventario.insumo.ISalida;
import fastock.fastock.Class.inventario.insumo.inventario;
import fastock.fastock.Class.inventario.insumo.salida;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@SessionAttributes("salida")
@RequestMapping("/salida")
public class SalidaController {
    @Autowired
    private ISalida isalida;

    @Autowired
    private IInventario iinventario;
    // ****************************************//
// --------------METODO GET----------------//
// ****************************************//

// --------------LISTAR TODOS--------------//

@GetMapping
public ResponseEntity<Page<salida>> salidas(Pageable pageable){
    return ResponseEntity.ok(isalida.findAll(pageable));
}

// ---------------LISTAR UNO---------------//
@GetMapping("/{id}")
public ResponseEntity<salida> salida(@PathVariable Integer id){
    Optional<salida> salidaOptional = isalida.findById(id);
    
    if(!salidaOptional.isPresent()){
        return ResponseEntity.unprocessableEntity().build();
    }
    
    return ResponseEntity.ok(salidaOptional.get());
}


// ****************************************//
// -------------METODO POST----------------//
// ****************************************//

// ---------------REGISTRAR----------------//

@PostMapping
public ResponseEntity<salida> guardarsalida(@Valid @RequestBody salida salida){
    Optional<inventario> inventarioOptional = iinventario.findById(salida.getInventario().getId());
    
    if(!inventarioOptional.isPresent()){
        return ResponseEntity.unprocessableEntity().build();
    }
    
    salida.setInventario(inventarioOptional.get());
    salida salidaGuardado = isalida.save(salida);
    URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(salidaGuardado.getId()).toUri();
    
    return ResponseEntity.created(ubicacion).body(salidaGuardado);
}


// ****************************************//
// --------------METODO PUT----------------//
// ****************************************//

// ----------------EDITAR------------------//

@PutMapping("/{id}")
public ResponseEntity<salida> actualizarsalida(@Valid @RequestBody salida salida,@PathVariable Integer id){
    Optional<inventario> inventarioOptional = iinventario.findById(salida.getInventario().getId());
    
    if(!inventarioOptional.isPresent()){
        return ResponseEntity.unprocessableEntity().build();
    }
    
    Optional<salida> salidaOptional = isalida.findById(id);
    if(!salidaOptional.isPresent()){
        return ResponseEntity.unprocessableEntity().build();
    }
    
    salida.setInventario(inventarioOptional.get());
    salida.setId(salidaOptional.get().getId());
    isalida.save(salida);
    
    return ResponseEntity.noContent().build();
}

// ----------------ESTADO------------------//


}
