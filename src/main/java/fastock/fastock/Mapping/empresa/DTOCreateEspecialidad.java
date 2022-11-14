package fastock.fastock.Mapping.empresa;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class DTOCreateEspecialidad {
    // --------------------NOMBRE-------------------//
    @NotEmpty(message = "La especialidad no debe estar vacía.")
    @Size(min = 2, max = 60, message = "La especialidad debe tener una longitud en 2 y 60 caracteres.")
    private String nombre;
    // ----------------------DESCRIPCION-----------------//
    @NotEmpty(message = "La descripción no debe estar vacía.")
    @Size(min = 2, max = 200, message = "La descripción debe tener una longitud entre 2 y 200 carcateres.")
    private String descripcion;

    // ************************************************//
    // -------------Constructores---------------//
    // ************************************************//
    public DTOCreateEspecialidad() {
    }

    public DTOCreateEspecialidad(
            @NotEmpty(message = "La especialidad no debe estar vacía.") @Size(min = 2, max = 60, message = "La especialidad debe tener una longitud en 2 y 60 caracteres.") String nombre,
            @NotEmpty(message = "La descripción no debe estar vacía.") @Size(min = 2, max = 200, message = "La descripción debe tener una longitud entre 2 y 200 carcateres.") String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}