package yeilux.com.proyecto.Controller.inventario.insumo;

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

import yeilux.com.proyecto.Service.insumo.IInsumo;
import yeilux.com.proyecto.Service.inventario.insumo.IInventario;
import yeilux.com.proyecto.Class.insumo.insumo;
import yeilux.com.proyecto.Class.inventario.insumo.inventario;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@SessionAttributes("inventario")
@RequestMapping("/inventario")
public class InventarioController {

    @Autowired
    private IInventario iinventario;

    @Autowired
    private IInsumo iinsumo;

    // ****************************************//
    // --------------METODO GET----------------//
    // ****************************************//

    // --------------LISTAR TODOS--------------//

    @GetMapping
    public ResponseEntity<Page<inventario>> inventarios(Pageable pageable) {
        return ResponseEntity.ok(iinventario.findAll(pageable));
    }

    // ---------------LISTAR UNO---------------//
    @GetMapping("/{id}")
    public ResponseEntity<inventario> inventario(@PathVariable Integer id) {
        Optional<inventario> inventarioOptional = iinventario.findById(id);

        if (!inventarioOptional.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        return ResponseEntity.ok(inventarioOptional.get());
    }

    // ****************************************//
    // -------------METODO POST----------------//
    // ****************************************//

    // ---------------REGISTRAR----------------//

    // ---------------REGISTRAR----------------//

    @PostMapping
    public ResponseEntity<inventario> guardarinventario(@Valid @RequestBody inventario inventario) {
        Optional<insumo> insumoOptional = iinsumo.findById(inventario.getInsumo().getId());

        if (!insumoOptional.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        inventario.setInsumo(insumoOptional.get());
        inventario inventarioGuardado = iinventario.save(inventario);
        URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(inventarioGuardado.getId()).toUri();

        return ResponseEntity.created(ubicacion).body(inventarioGuardado);
    }

    // ****************************************//
    // --------------METODO PUT----------------//
    // ****************************************//

    // ----------------EDITAR------------------//

    @PutMapping("/{id}")
    public ResponseEntity<inventario> actualizarinventario(@Valid @RequestBody inventario inventario,
            @PathVariable Integer id) {
        Optional<insumo> insumoOptional = iinsumo.findById(inventario.getInsumo().getId());

        if (!insumoOptional.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        Optional<inventario> inventarioOptional = iinventario.findById(id);
        if (!inventarioOptional.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        inventario.setInsumo(insumoOptional.get());
        inventario.setId(inventarioOptional.get().getId());
        iinventario.save(inventario);

        return ResponseEntity.noContent().build();
    }

    // ----------------ESTADO------------------//

}
