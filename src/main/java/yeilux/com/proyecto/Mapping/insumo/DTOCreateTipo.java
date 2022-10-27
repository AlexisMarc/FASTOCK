package yeilux.com.proyecto.Mapping.insumo;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class DTOCreateTipo {
    // -----------------------ID-----------------------//
    private Integer id;
    // --------------------NOMBRE-----------------------//
    @NotEmpty(message = "El tipo debe tener una longitud en 2 y 30 caracteres.")
    @Size(min = 2, max = 30)
    private String nombre;
    // -----------------------FILTRO-----------------------//
    @NotEmpty(message = "No puede ser vacío.")
    @Size(min = 2, max = 20)
    private String filtro;
    // --------------Estado---------------//
    private Boolean estado;
    // ************************************************//
    // -------------Relacion con Insumo----------------//
    // ************************************************//
    private Set<insumo> insumo = new HashSet<>();
    // ************************************************//
    // -------------GETTERS AND SETTERS/CONSTRUCTORES----------------//
    // ************************************************//

}
