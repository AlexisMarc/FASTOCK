package yeilux.com.proyecto.Mapping.inventario.insumo;

import java.util.HashSet;
import java.util.Set;

import yeilux.com.proyecto.Class.insumo.insumo;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class inventario {
    // -----------------------ID-----------------------//
    private Integer id;
    // -----------------------TIPO-UNIDAD-----------------------//
    @NotEmpty(message = "El tipo de unidad no debe estar vacío")
    @Size(min = 2, max = 30, message = "El tipo de unidad debe tener entre 2 y 30 carcateres")
    private String tipoUnidad;
    // -----------------------ESTADO-----------------------//
    private Boolean estado;

    // ************************************************//
    // -------------Relacion con salida----------------//
    // ************************************************//
    private Set<salida> salida = new HashSet<>();
    // ************************************************//
    // -------------Relacion con entrada----------------//
    // ************************************************//
    private Set<entrada> entrada = new HashSet<>();
    // ************************************************//
    // -------------Relacion con insumo----------------//
    // ************************************************//
    private insumo insumo;

    /*-----------------GETTERS AND SETTERS----------------*/
    public inventario() {
    }

}
