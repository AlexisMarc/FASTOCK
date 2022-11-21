package fastock.fastock.Mapping.producto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class DTOCreateCategoria {

    // -----------------------NOMBRE-----------------------//
    @NotEmpty(message = "La categoría no debe estar vacía")
    @Size(min = 2, max = 30, message = "La categoría debe tener una longitud en 2 y 60 caracteres.")
    private String nombre;

    // ************************************************//
    // -------------Contructores accesores--------------//
    // ************************************************//

    public DTOCreateCategoria() {
    }

    public DTOCreateCategoria(
            @NotEmpty(message = "La categoría no debe estar vacía") @Size(min = 2, max = 30, message = "La categoría debe tener una longitud en 2 y 60 caracteres.") String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
