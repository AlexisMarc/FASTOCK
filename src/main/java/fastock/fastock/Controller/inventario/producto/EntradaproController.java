package fastock.fastock.Controller.inventario.producto;

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

import javax.validation.Valid;

import fastock.fastock.Service.inventario.producto.IEntradapro;
import fastock.fastock.Service.inventario.producto.IInventariopro;
import fastock.fastock.Class.inventario.producto.entradapro;
import fastock.fastock.Class.inventario.producto.inventariopro;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@SessionAttributes("entradapro")
@RequestMapping("entradapro")

public class EntradaproController {

    @Autowired
    private IEntradapro ientradapro;

    @Autowired
    private IInventariopro iinventariopro;

    // ****************************************//
    // --------------METODO GET----------------//
    // ****************************************//

    // --------------LISTAR TODOS--------------//

    @GetMapping
    public ResponseEntity<Page<entradapro>> entrada(Pageable pageable) {
        return ResponseEntity.ok(ientradapro.findAll(pageable));
    }

    // ---------------LISTAR UNO---------------//
    @GetMapping("/{id}")
    public ResponseEntity<entradapro> entrada(@PathVariable Integer id) {
        Optional<entradapro> entradaOptional = ientradapro.findById(id);

        if (!entradaOptional.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        return ResponseEntity.ok(entradaOptional.get());
    }

    // ****************************************//
    // -------------METODO POST----------------//
    // ****************************************//

    // ---------------REGISTRAR----------------//

@PostMapping
public ResponseEntity<entradapro> guardarentrada(@Valid @RequestBody entradapro entradapro){
    Optional<inventariopro> inventarioproOptional = iinventariopro.findById(entradapro.getInventario().getId());
    
    if(!inventarioproOptional.isPresent()){
        return ResponseEntity.unprocessableEntity().build();
    }
    
    entradapro.setInventario(inventarioproOptional.get());
    entradapro entradaproGuardado = ientradapro.save(entradapro);
    URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(entradaproGuardado.getId()).toUri();
    
    return ResponseEntity.created(ubicacion).body(entradaproGuardado);
}

    // ****************************************//
    // --------------METODO PUT----------------//
    // ****************************************//

    // ----------------EDITAR------------------//

    @PutMapping("/{id}")
    public ResponseEntity<IInventariopro> actualizarentrada(@Valid @RequestBody entradapro entradapro,
            @PathVariable Integer id) {
        Optional<inventariopro> inventarioproOptional = iinventariopro.findById(entradapro.getInventario().getId());

        if (!inventarioproOptional.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        Optional<entradapro> entradaproOptional = ientradapro.findById(id);
        if (!entradaproOptional.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        entradapro.setInventario(inventarioproOptional.get());
        entradapro.setId(entradaproOptional.get().getId());
        ientradapro.save(entradapro);

        return ResponseEntity.noContent().build();
    }

    // ----------------ESTADO------------------//

}
