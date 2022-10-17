package yeilux.com.proyecto.Controller.inventario.insumo;
import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

import yeilux.com.proyecto.Model.Class.inventario.insumo.entrada;
import yeilux.com.proyecto.Model.Class.inventario.insumo.inventario;
import yeilux.com.proyecto.Model.Interface.inventario.insumo.IEntrada;
import yeilux.com.proyecto.Model.Interface.inventario.insumo.IInventario;

import javax.validation.Valid;

@RestController
@SessionAttributes("entrada")
@RequestMapping("/entrada")
public class EntradaController {
    @Autowired
    private IEntrada ientrada;

    @Autowired
    private IInventario iinventario;
    // ****************************************//
// --------------METODO GET----------------//
// ****************************************//

// --------------LISTAR TODOS--------------//

@GetMapping
public ResponseEntity<Page<entrada>> entradas(Pageable pageable){
    return ResponseEntity.ok(ientrada.findAll(pageable));
}

// ---------------LISTAR UNO---------------//
@GetMapping("/{id}")
public ResponseEntity<entrada> entrada(@PathVariable Integer id){
    Optional<entrada> entradaOptional = ientrada.findById(id);
    
    if(!entradaOptional.isPresent()){
        return ResponseEntity.unprocessableEntity().build();
    }
    
    return ResponseEntity.ok(entradaOptional.get());
}


// ****************************************//
// -------------METODO POST----------------//
// ****************************************//

// ---------------REGISTRAR----------------//

@PostMapping
public ResponseEntity<entrada> guardarentrada(@Valid @RequestBody entrada entrada){
    Optional<inventario> inventarioOptional = iinventario.findById(entrada.getInventario().getId());
    
    if(!inventarioOptional.isPresent()){
        return ResponseEntity.unprocessableEntity().build();
    }
    
    entrada.setInventario(inventarioOptional.get());
    entrada entradaGuardado = ientrada.save(entrada);
    URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(entradaGuardado.getId()).toUri();
    
    return ResponseEntity.created(ubicacion).body(entradaGuardado);
}


// ****************************************//
// --------------METODO PUT----------------//
// ****************************************//

// ----------------EDITAR------------------//

@PutMapping("/{id}")
public ResponseEntity<entrada> actualizarentrada(@Valid @RequestBody entrada entrada,@PathVariable Integer id){
    Optional<inventario> inventarioOptional = iinventario.findById(entrada.getInventario().getId());
    
    if(!inventarioOptional.isPresent()){
        return ResponseEntity.unprocessableEntity().build();
    }
    
    Optional<entrada> entradaOptional = ientrada.findById(id);
    if(!entradaOptional.isPresent()){
        return ResponseEntity.unprocessableEntity().build();
    }
    
    entrada.setInventario(inventarioOptional.get());
    entrada.setId(entradaOptional.get().getId());
    ientrada.save(entrada);
    
    return ResponseEntity.noContent().build();
}

// ----------------ESTADO------------------//


}
