package fastock.fastock.Mapping.insumo;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class DTOCreateTipo {
    // --------------------NOMBRE-----------------------//
    @NotEmpty(message = "El tipo debe tener una longitud en 2 y 30 caracteres.")
    @Size(min = 2, max = 30)
    private String nombre;
    // ************************************************//
    // -------------GETTERS AND SETTERS/CONSTRUCTORES----------------//
    // ************************************************//
    public DTOCreateTipo() {
    }

    public DTOCreateTipo(
            @NotEmpty(message = "El tipo debe tener una longitud en 2 y 30 caracteres.") @Size(min = 2, max = 30) String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
