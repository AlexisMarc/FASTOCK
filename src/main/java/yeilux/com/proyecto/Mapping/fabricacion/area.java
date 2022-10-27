package yeilux.com.proyecto.Mapping.fabricacion;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import yeilux.com.proyecto.Class.empresa.empresa;
import yeilux.com.proyecto.Class.usuario.usuario;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class area {
    // -----------------------ID-----------------------//
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // -----------------------Nombre-----------------------//
    @NotEmpty(message = "El nombre no debe estar vacío")
    @Size(min = 2, max = 60, message = "El nombre debe tener entre 2 y 30 caracteres")
    private String nombre;

    // -----------------------FECHA_INICIO-----------------------//
    private String fechainicio;

    // -----------------------FECHA_FINAL-----------------------//
    private String fechafinal;
    // -----------------------Estado-----------------------//
    private Boolean estado;

    // ************************************************//
    // -------------Relacion con fabricacion-----------//
    // ************************************************//
    private fabricacion fabricacion;
    // ************************************************//
    // -------------Relacion con produccion------------//
    // ************************************************//
    private Set<produccion> produccion = new HashSet<>();
    // ************************************************//
    // -------------Relacion con usuario--------------//
    // ************************************************//
    private Set<usuario> usuario = new HashSet<>();
    // ************************************************//
    // -------------Relacion con empresa---------------//
    // ************************************************//
    private Set<empresa> empresa = new HashSet<>();

    public area() {
    }

}
