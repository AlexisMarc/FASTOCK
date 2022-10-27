package yeilux.com.proyecto.Mapping.inventario.insumo;

import yeilux.com.proyecto.Class.usuario.usuario;

import javax.validation.constraints.NotNull;

public class salida {
    // -----------------------ID-----------------------//
    private Integer id;
    // -----------------------FECHA-----------------------//
    private String fecha;
    // -----------------------CANTIDAD-----------------------//
    @NotNull(message = "La cantidad no debe estar vacía")
    private Integer cantidad;
    // -----------------------ESTADO-----------------------//
    private Boolean estado;

    // ************************************************//
    // -------------Relacion con inventario------------//
    // ************************************************//
    private inventario inventario;
    // ************************************************//
    // -------------Relacion con usuario--------------//
    // ************************************************//
    private usuario usuario;

    /*-----------------GETTERS AND SETTERS----------------*/
    public salida() {
    }

}
