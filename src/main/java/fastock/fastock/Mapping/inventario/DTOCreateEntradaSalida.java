package fastock.fastock.Mapping.inventario;

import javax.validation.constraints.NotNull;

import fastock.fastock.Utils.EnumEntradaSalida;

public class DTOCreateEntradaSalida {
    // -----------------------CANTIDAD_ENTRADA-----------------------//
    @NotNull(message = "La cantidad no debe estar vacía")
    private Integer cantidad;

    // ************************************************//
    // -------------Relacion con inventario------------//
    // ************************************************//
    @NotNull(message = "El Inventario no debe estar vacío")
    private Integer inventario;

    // ************************************************//
    // -------------Relacion con usuario--------------//
    // ************************************************//
    @NotNull(message = "El usuario no debe estar vacío")
    private Integer usuario;

    private EnumEntradaSalida tipo;

    // ************************************************//
    // -------------Contructores accesores--------------//
    // ************************************************//
    public DTOCreateEntradaSalida() {
    }

    public DTOCreateEntradaSalida(@NotNull(message = "La cantidad no debe estar vacía") Integer cantidad,
            @NotNull(message = "El Inventario no debe estar vacío") Integer inventario,
            @NotNull(message = "El usuario no debe estar vacío") Integer usuario,
            EnumEntradaSalida tipo) {
        this.cantidad = cantidad;
        this.inventario = inventario;
        this.usuario = usuario;
        this.tipo = tipo;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getInventario() {
        return inventario;
    }

    public void setInventario(Integer inventario) {
        this.inventario = inventario;
    }

    public Integer getUsuario() {
        return usuario;
    }

    public void setUsuario(Integer usuario) {
        this.usuario = usuario;
    }

    public EnumEntradaSalida getTipo() {
        return tipo;
    }

    public void setTipo(EnumEntradaSalida tipo) {
        this.tipo = tipo;
    }

}
