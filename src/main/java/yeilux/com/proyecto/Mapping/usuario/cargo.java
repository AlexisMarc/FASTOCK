package yeilux.com.proyecto.Mapping.usuario;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class cargo {
    // -----------------------ID-----------------------//
    private Integer id;

    // -----------------------NOMBRE-----------------------//
    @NotEmpty(message = "El nombre no debe estar vacío")
    @Size(min = 2, max = 60, message = "El nombre debe tener entre 2 y 60 caracteres")
    private String nombre;

    // ************************************************//
    // -------------Relacion con usuario--------------//
    // ************************************************//
    private Set<usuario> usuario = new HashSet<>();

    // ************************************************//
    // ------------- CONSTRUCTORES/GETTERS AND SETTERS--------------//
    // ************************************************//

    public cargo() {
    }

}
