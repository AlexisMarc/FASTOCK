package yeilux.com.proyecto.Mapping.fabricacion;

import yeilux.com.proyecto.Utils.EnumProduccion;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class DTOCreateProduccion {

    // -----------------------ID-----------------------//
    private Integer id;
    // -----------------------DESCRIPCION-----------------------//
    @NotEmpty(message = "La descripción no debe estar vacía")
    @Size(min = 0, max = 300, message = "La descripción debe tener una longitud entre 2 y 200 carcateres.")
    private String descripcion;
    // -----------------------FECHA-----------------------//
    private String fecha;
    // -----------------------TIPO-----------------------//
    @NotNull(message = "El tipo de producción no debe estar vacío")
    private EnumProduccion tipo;

    // --------------Estado---------------//
    private Boolean estado;
    // ************************************************//
    // -------------Relacion con area------------------//
    // ************************************************//
    @NotNull(message = "El producto no debe estar vacío")
    private Integer area;

    public DTOCreateProduccion() {
    }

    

    public DTOCreateProduccion(Integer id,
            @NotEmpty(message = "La descripción no debe estar vacía") @Size(min = 0, max = 300, message = "La descripción debe tener una longitud entre 2 y 200 carcateres.") String descripcion,
            String fecha, @NotNull(message = "El tipo de producción no debe estar vacío") EnumProduccion tipo,
            Boolean estado, @NotNull(message = "El producto no debe estar vacío") Integer area) {
        this.id = id;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.tipo = tipo;
        this.estado = estado;
        this.area = area;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public EnumProduccion getTipo() {
        return tipo;
    }

    public void setTipo(EnumProduccion tipo) {
        this.tipo = tipo;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }
    

}
