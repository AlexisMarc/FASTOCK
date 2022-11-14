package fastock.fastock.Mapping.insumo;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class DTOCreateTipo {
    // --------------------NOMBRE-----------------------//
    @NotEmpty(message = "El tipo debe tener una longitud en 2 y 30 caracteres.")
    @Size(min = 2, max = 30)
    private String nombre;
    // -----------------------FILTRO-----------------------//
    @NotEmpty(message = "No puede ser vacío.")
    @Size(min = 2, max = 20)
    private String filtro;

    // ************************************************//
    // -------------GETTERS AND SETTERS/CONSTRUCTORES----------------//
    // ************************************************//
    public DTOCreateTipo() {
    }

    public DTOCreateTipo(
            @NotEmpty(message = "El tipo debe tener una longitud en 2 y 30 caracteres.") @Size(min = 2, max = 30) String nombre,
            @NotEmpty(message = "No puede ser vacío.") @Size(min = 2, max = 20) String filtro) {
        this.nombre = nombre;
        this.filtro = filtro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }

}
