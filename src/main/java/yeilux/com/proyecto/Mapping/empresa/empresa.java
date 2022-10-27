package yeilux.com.proyecto.Mapping.empresa;

import java.util.HashSet;
import java.util.Set;

import yeilux.com.proyecto.Class.fabricacion.area;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class empresa {
    // -----------------------ID-----------------------//
    private Integer id;
    // -----------------------NOMBRE-----------------------//
    @NotEmpty(message = "El nombre no debe estar vacío")
    @Size(min = 2, max = 60, message = "El nombre debe tener entre 2 y 60 carcateres")
    private String nombre;
    // -----------------------NOMBRE CONTACTO-----------------------//
    @NotEmpty(message = "El nombre del contacto no debe estar vacío")
    @Size(min = 2, max = 60, message = "El nombre de contacto debe tener entre 2 y 60 carcateres")
    private String contacto;
    // ----------------------- TELEFONO-----------------------//
    @NotNull(message = "El telefono no debe estar vacío")
    private Long telefono;
    // -----------------------DIRECCION-----------------------//
    @NotEmpty(message = "La dirección no debe estar vacía")
    @Size(min = 2, max = 100, message = "La dirección debe tener entre 2 y 100 carcateres")
    private String direccion;
    // -----------------------EMAIL-----------------------//
    @NotEmpty(message = "El email no debe estar vacío")
    @Email(message = "El email no es valido")
    @Size(min = 6, max = 200, message = "El email debe tener entre 2 y 200 carcateres")
    private String email;
    // -----------------------IMAGEN-----------------------//
    private String imagen;
    // -----------------------ESTADO-----------------------//
    private Boolean estado;
    // ************************************************//
    // -------------Relacion con especialidad----------//
    // ************************************************//
    private especialidad especialidad;
    // ************************************************//
    // -------------Relacion con area------------------//
    // ************************************************//
    private Set<area> area = new HashSet<>();

    // ************************************************//
    // -------------Constructores---------------//
    // ************************************************//
    public empresa() {
    }

    
}
