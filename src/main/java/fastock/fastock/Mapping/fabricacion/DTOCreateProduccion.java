package fastock.fastock.Mapping.fabricacion;

import fastock.fastock.Utils.EnumProduccion;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class DTOCreateProduccion {

    // -----------------------DESCRIPCION-----------------------//
    @NotEmpty(message = "La descripción no debe estar vacía")
    @Size(min = 0, max = 300, message = "La descripción debe tener una longitud entre 2 y 200 carcateres.")
    private String descripcion;
    // -----------------------TIPO-----------------------//
    @NotNull(message = "El tipo de producción no debe estar vacío")
    private EnumProduccion tipo;
    // ************************************************//
    // -------------Relacion con area------------------//
    // ************************************************//
    @NotNull(message = "El producto no debe estar vacío")
    private Integer area;

    // ************************************************//
    // -------------Relacion con usuario------------------//
    // ************************************************//
    @NotNull(message = "El usuario no debe estar vacío")
    private Integer usuario;

    public DTOCreateProduccion() {
    }

    public DTOCreateProduccion(
            @NotEmpty(message = "La descripción no debe estar vacía") @Size(min = 0, max = 300, message = "La descripción debe tener una longitud entre 2 y 200 carcateres.") String descripcion,
            @NotNull(message = "El tipo de producción no debe estar vacío") EnumProduccion tipo,
            @NotNull(message = "El producto no debe estar vacío") Integer area,
            @NotNull(message = "El usuario no debe estar vacío") Integer usuario) {
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.area = area;
        this.usuario = usuario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public EnumProduccion getTipo() {
        return tipo;
    }

    public void setTipo(EnumProduccion tipo) {
        this.tipo = tipo;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Integer getUsuario() {
        return usuario;
    }

    public void setUsuario(Integer usuario) {
        this.usuario = usuario;
    }

}
