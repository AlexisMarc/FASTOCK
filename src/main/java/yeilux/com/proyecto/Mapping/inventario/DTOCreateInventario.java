package yeilux.com.proyecto.Mapping.inventario;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class DTOCreateInventario {
    // -----------------------TIPO-UNIDAD-----------------------//
    @NotEmpty(message = "El tipo de unidad no debe estar vacío")
    @Size(min = 2, max = 30, message = "El tipo de unidad debe tener entre 2 y 30 carcateres")
    private String tipoUnidad;
    // ************************************************//
    // -------------Relacion con insumo----------------//
    // ************************************************//
    @NotNull(message = "El insumo no debe estar vacío")
    private Integer insumo;

    /*-----------------GETTERS AND SETTERS----------------*/
    public DTOCreateInventario() {
    }

    public String getTipoUnidad() {
        return tipoUnidad;
    }

    public void setTipoUnidad(String tipoUnidad) {
        this.tipoUnidad = tipoUnidad;
    }

    public Integer getInsumo() {
        return insumo;
    }

    public void setInsumo(Integer insumo) {
        this.insumo = insumo;
    }

    public DTOCreateInventario(
            @NotEmpty(message = "El tipo de unidad no debe estar vacío") @Size(min = 2, max = 30, message = "El tipo de unidad debe tener entre 2 y 30 carcateres") String tipoUnidad,
            @NotNull(message = "El insumo no debe estar vacío") Integer insumo) {
        this.tipoUnidad = tipoUnidad;
        this.insumo = insumo;
    }

    
}
