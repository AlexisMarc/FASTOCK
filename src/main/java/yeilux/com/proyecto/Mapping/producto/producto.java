package yeilux.com.proyecto.Mapping.producto;

import java.util.HashSet;
import java.util.Set;

import yeilux.com.proyecto.Class.fabricacion.fabricacion;
import yeilux.com.proyecto.Class.inventario.producto.inventariopro;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class producto {

    // -----------------------ID-----------------------//
    private Integer id;

    // -----------------------NOMBRE-----------------------//
    @NotEmpty(message = "El nombre no debe estar vacío")
    @Size(min = 2, max = 60, message = "El nombre debe tener entre 2 y 60 caracteres")
    private String nombre;

    // -----------------------DESCRIPCION-----------------------//
    private String descripcion;

    // -----------------------Estado-----------------------//
    private Boolean estado;

    // -----------------------VISIBLE-----------------------//
    private Boolean visible;

    // -----------------------IMAGEN-----------------------//
    private String imagen;

    // ************************************************//
    // -------------Relacion con Categoria-------------//
    // ************************************************//
    private Set<categoria> categoria = new HashSet<>();
    // ************************************************//
    // -------------Relacion con fabricacion-----------//

    // ************************************************//
    private Set<fabricacion> fabricacion = new HashSet<>();
    // ************************************************//
    // -------------Relacion con inventario------------//
    // ************************************************//
    private Set<inventariopro> inventario = new HashSet<>();

    // ************************************************//
    // -------------Contructores accesores--------------//
    // ************************************************//
    
    public producto() {
    }

}
