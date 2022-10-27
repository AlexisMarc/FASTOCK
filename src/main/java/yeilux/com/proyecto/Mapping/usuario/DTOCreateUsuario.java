package yeilux.com.proyecto.Mapping.usuario;

import java.util.HashSet;
import java.util.Set;

import yeilux.com.proyecto.Class.fabricacion.area;
import yeilux.com.proyecto.Class.fabricacion.fabricacion;
import yeilux.com.proyecto.Class.inventario.insumo.entrada;
import yeilux.com.proyecto.Class.inventario.insumo.salida;
import yeilux.com.proyecto.Class.inventario.producto.entradapro;
import yeilux.com.proyecto.Class.inventario.producto.salidapro;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class usuario {
    // -----------------------ID-----------------------//
    private Integer id;

    // -----------------------Idenficacion-----------------------//
    @NotNull
    private Long identificacion;
    // -----------------------Nombre-----------------------//
    @NotEmpty(message = "El nombre no debe estar vacío")
    @Size(min = 2, max = 60, message = "El nombre debe tener entre 2 y 60 carcateres")
    private String nombre;

    // -----------------------Apellido-----------------------//

    @NotEmpty(message = "El apellido no debe estar vacío")
    @Size(min = 2, max = 60, message = "El nombre debe tener entre 2 y 60 carcateres")
    private String apellido;

    // -----------------------Genero-----------------------//
    @NotEmpty(message = "El género no debe estar vacío")
    @Size(min = 2, message = "El género no debe tener mínimo 2 caracteres")
    private String genero;

    // -----------------------Fecha de nacimiento-----------------------//
    @NotEmpty(message = "La fecha de nacimiento no debe estar vacío")
    private String fecha;

    // -----------------------Direccion-----------------------//

    @NotEmpty(message = "La dirección no debe estar vacío")
    @Size(min = 2, max = 100, message = "La dirección debe tener entre 2 y 100 carcateres")
    private String direccion;

    // -----------------------Telefono-----------------------//
    @NotNull(message = "El número teléfono no debe estar vacío")
    private Long telefono;

    // -----------------------Email-----------------------//

    @NotEmpty(message = "EL Email no debe estar vacío")
    @Email(message = "EL Email no valido")
    @Size(min = 4, max = 200, message = "La dirección debe tener entre 4 y 200 carcateres")
    private String email;

    // -----------------------Estado-----------------------//
    private Boolean estado = true;

    // ************************************************//
    // -------------Relacion con fabricacion-----------//
    // ************************************************//
    private Set<fabricacion> fabricacion = new HashSet<>();

    // ************************************************//
    // -------------Relacion con cargo-----------------//
    // ************************************************//
    private Set<cargo> cargo = new HashSet<>();

    // ************************************************//
    // -------------Relacion con area------------------//
    // ************************************************//

    private Set<area> area = new HashSet<>();

    // ************************************************//
    // -------------Relacion con entrada---------------//
    // ************************************************//
    private Set<entrada> entrada = new HashSet<>();
    // ************************************************//
    // -------------Relacion con entradapro------------//
    // ************************************************//
    private Set<entradapro> entradapro = new HashSet<>();
    // ************************************************//
    // -------------Relacion con salida---------------//
    // ************************************************//
    private Set<salida> salida = new HashSet<>();
    // ************************************************//
    // -------------Relacion con salidapro------------//
    // ************************************************//
    private Set<salidapro> salidapro = new HashSet<>();

    // ************************************************//
    // ------------- CONSTRUCTORES/GETTERS AND SETTERS--------------//
    // ************************************************//
    public usuario() {
    }
}
