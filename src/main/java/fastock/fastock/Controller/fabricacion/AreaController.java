package fastock.fastock.Controller.fabricacion;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import fastock.fastock.Service.fabricacion.IArea;
import fastock.fastock.Class.fabricacion.area;
import fastock.fastock.Class.fabricacion.produccion;

@RestController

@SessionAttributes("area")
@RequestMapping("/area")
public class AreaController {
    
    @Autowired
    private IArea iarea;

    // ****************************************//
    // --------------METODO GET----------------//
    // ****************************************//

    // --------------LISTAR TODOS--------------//

    @GetMapping
    public ResponseEntity<Collection<area>> listarareas() {
        return new ResponseEntity<>(iarea.findAll(), HttpStatus.OK);
    }
    // ---------------LISTAR UNO---------------//

    @GetMapping("/{id}")
    public ResponseEntity<area> obtenerareaPorId(@PathVariable Integer id) {
        area area = iarea.findById(id).orElseThrow();

        if (area != null) {
            return new ResponseEntity<>(iarea.findById(id).orElseThrow(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // ---------------LISTAR producciones---------------//

    @GetMapping("/{id}/producciones")
    public ResponseEntity<Collection<produccion>> listararea(@PathVariable Integer id) {
        area area = iarea.findById(id).orElseThrow();

        if (area != null) {
            return new ResponseEntity<>(area.getProduccion(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // ****************************************//
    // -------------METODO POST----------------//
    // ****************************************//

    // ---------------REGISTRAR----------------//

    @PostMapping
    public ResponseEntity<?> guardararea(@RequestBody area area) {
        return new ResponseEntity<>(iarea.save(area), HttpStatus.CREATED);
    }

    // ****************************************//
    // --------------METODO PUT----------------//
    // ****************************************//

    // ----------------EDITAR------------------//

    // ----------------ESTADO------------------//

}
