package yeilux.com.proyecto.Controller.inventario.producto;

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

import javax.validation.Valid;

import yeilux.com.proyecto.Model.Class.inventario.producto.inventariopro;
import yeilux.com.proyecto.Model.Class.inventario.producto.salidapro;
import yeilux.com.proyecto.Model.Interface.inventario.producto.IInventariopro;
import yeilux.com.proyecto.Model.Interface.inventario.producto.ISalidapro;

@RestController
@SessionAttributes("salidapro")
@RequestMapping("/salidapro")

public class SalidaproController {

    @Autowired
    private ISalidapro isalidapro;

    @Autowired
    private IInventariopro iinventariopro;

    // ****************************************//
    // --------------METODO GET----------------//
    // ****************************************//

    // --------------LISTAR TODOS--------------//

    @GetMapping
    public ResponseEntity<Page<salidapro>> salida(Pageable pageable) {
        return ResponseEntity.ok(isalidapro.findAll(pageable));
    }

    // ---------------LISTAR UNO---------------//
    @GetMapping("/{id}")
    public ResponseEntity<salidapro> entrada(@PathVariable Integer id) {
        Optional<salidapro> salidaOptional = isalidapro.findById(id);

        if (!salidaOptional.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        return ResponseEntity.ok(salidaOptional.get());
    }

    // ****************************************//
    // -------------METODO POST----------------//
    // ****************************************//

    // ---------------REGISTRAR----------------//

    @PostMapping
    public ResponseEntity<salidapro> guardarentrada(@Valid @RequestBody salidapro salidapro) {
        Optional<inventariopro> inventarioproOptional = iinventariopro.findById(salidapro.getInventario().getId());

        if (!inventarioproOptional.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        salidapro.setInventario(inventarioproOptional.get());
        salidapro salidaproGuardado = isalidapro.save(salidapro);
        URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(salidaproGuardado.getId()).toUri();

        return ResponseEntity.created(ubicacion).body(salidaproGuardado);
    }

    // ****************************************//
    // --------------METODO PUT----------------//
    // ****************************************//

    // ----------------EDITAR------------------//

    @PutMapping("/{id}")
    public ResponseEntity<IInventariopro> actualizarentrada(@Valid @RequestBody salidapro salidapro,
            @PathVariable Integer id) {
        Optional<inventariopro> inventarioproOptional = iinventariopro.findById(salidapro.getInventario().getId());

        if (!inventarioproOptional.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        Optional<salidapro> salidaproOptional = isalidapro.findById(id);
        if (!salidaproOptional.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        salidapro.setInventario(inventarioproOptional.get());
        salidapro.setId(salidaproOptional.get().getId());
        isalidapro.save(salidapro);

        return ResponseEntity.noContent().build();
    }

    // ----------------ESTADO------------------//

}
