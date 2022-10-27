package yeilux.com.proyecto.Mapping.proveedor;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import yeilux.com.proyecto.Class.insumo.insumo;

public class proveedor {
    // -----------------------ID-----------------------//
    private Integer id;
    // -----------------------NOMBRE-----------------------//
    @NotEmpty(message = "El nombre no debe estar vacío")
    @Size(min = 2, max = 60, message = "El nombre debe tener entre 2 y 60 caracteres")
    private String nombre;
    // -----------------------NOMBRE CONTACTO-----------------------//
    @NotEmpty(message = "El nombre del contacto no debe estar vacío")
    @Size(min = 2, max = 60, message = "El nombre del contacto debe tener entre 2 y 60 caracteres")
    private String contacto;
    // -----------------------DIRECCION-----------------------//
    @NotEmpty(message = "La dirección no debe estar vacío")
    @Size(min = 2, max = 60, message = "La dirección debe tener entre 2 y 60 caracteres")
    private String direccion;
    // ----------------------- TELEFONO-----------------------//
    @NotNull(message = "El teléfono no debe estar vacío")
    private Long telefono;
    // -----------------------EMAIL-----------------------//
    @NotEmpty(message = "El email no debe estar vacío")
    @Email(message = "El email no es valido")
    @Size(min = 6, max = 200, message = "El email debe tener entre 6 y 200 caracteres")
    private String email;
    // -----------------------ESTADO-----------------------//
    private Boolean estado;
    // ************************************************//
    // -------------Relacion con insumo----------------//
    // ************************************************//
    private Set<insumo> insumo = new HashSet<>();
    // ************************************************//
    // -------------Constructores---------------//
    // ************************************************//

    public proveedor() {
    }

}
