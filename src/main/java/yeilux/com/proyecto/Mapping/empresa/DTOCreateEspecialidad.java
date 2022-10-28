package yeilux.com.proyecto.Mapping.empresa;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class DTOCreateEspecialidad {
    // -----------------------ID-----------------------//
    private Integer id;
    // --------------------NOMBRE-------------------//
    @NotEmpty(message = "La especialidad no debe estar vacía.")
    @Size(min = 2, max = 60, message = "La especialidad debe tener una longitud en 2 y 60 caracteres.")
    private String nombre;
    // ----------------------DESCRIPCION-----------------//
    @NotEmpty(message = "La descripción no debe estar vacía.")
    @Size(min = 2, max = 200, message = "La descripción debe tener una longitud entre 2 y 200 carcateres.")
    private String descripcion;

    // --------------Estado---------------//
    private Boolean estado;
    // ************************************************//
    // -------------Constructores---------------//
    // ************************************************//
    public DTOCreateEspecialidad() {
    }
    public DTOCreateEspecialidad(Integer id,
            @NotEmpty(message = "La especialidad no debe estar vacía.") @Size(min = 2, max = 60, message = "La especialidad debe tener una longitud en 2 y 60 caracteres.") String nombre,
            @NotEmpty(message = "La descripción no debe estar vacía.") @Size(min = 2, max = 200, message = "La descripción debe tener una longitud entre 2 y 200 carcateres.") String descripcion,
            Boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
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
    public Boolean getEstado() {
        return estado;
    }
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

}