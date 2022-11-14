package fastock.fastock.Mapping.producto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class DTOCreateCategoria {

    // -----------------------NOMBRE-----------------------//
    @NotEmpty(message = "La categoría no debe estar vacía")
    @Size(min = 2, max = 30, message = "La categoría debe tener una longitud en 2 y 60 caracteres.")
    private String nombre;

    // -----------------------FILTRO-----------------------//
    @NotEmpty(message = "El filtro no debe estar vacío")
    @Size(min = 2, max = 20)
    private String filtro;

    // ************************************************//
    // -------------Contructores accesores--------------//
    // ************************************************//

    public DTOCreateCategoria() {
    }

    public DTOCreateCategoria(
            @NotEmpty(message = "La categoría no debe estar vacía") @Size(min = 2, max = 30, message = "La categoría debe tener una longitud en 2 y 60 caracteres.") String nombre,
            @NotEmpty(message = "El filtro no debe estar vacío") @Size(min = 2, max = 20) String filtro) {
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
