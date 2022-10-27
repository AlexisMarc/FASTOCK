package yeilux.com.proyecto.Mapping.empresa;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class especialidad {
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
    // -------------Relacion con empresa---------------//
    // ************************************************//
    private Set<empresa> empresa = new HashSet<>();

    // ************************************************//
    // -------------Constructores---------------//
    // ************************************************//
    public especialidad() {
    }

}