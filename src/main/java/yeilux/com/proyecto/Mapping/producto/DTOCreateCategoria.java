package yeilux.com.proyecto.Mapping.producto;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class categoria {
    // -----------------------ID-----------------------//
    private Integer id;

    // -----------------------NOMBRE-----------------------//
    @NotEmpty(message = "La categoría no debe estar vacía")
    @Size(min = 2, max = 30, message = "La categoría debe tener una longitud en 2 y 60 caracteres.")
    private String nombre;

    // -----------------------FILTRO-----------------------//
    @NotEmpty(message = "El filtro no debe estar vacío")
    @Size(min = 2, max = 20)
    private String filtro;

    // ************************************************//
    // -------------Relacion con producto--------------//
    // ************************************************//
    private Set<producto> producto = new HashSet<>();

    // ************************************************//
    // -------------Contructores accesores--------------//
    // ************************************************//

    public categoria() {
    }

    

}
