package fastock.fastock.Class.fabricacion;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import fastock.fastock.Utils.EnumProduccion;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "produccion")
public class produccion {

    // -----------------------ID-----------------------//
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    // -----------------------DESCRIPCION-----------------------//
    @NotEmpty(message = "La descripción no debe estar vacía")
    @Column(length = 300, nullable = false)
    @Size(min = 0, max = 300, message = "La descripción debe tener una longitud entre 2 y 200 carcateres.")
    private String descripcion;
    // -----------------------FECHA-----------------------//
    @Column(length = 20, nullable = false)
    private String fecha;
    // -----------------------TIPO-----------------------//
    @NotEmpty(message = "El tipo no debe estar vacío")
    @Column(length = 10, nullable = false)
    @Enumerated(EnumType.STRING)
    private EnumProduccion tipo;

    // --------------Estado---------------//
    @Column(nullable = false)
    private Boolean estado;
    // ************************************************//
    // -------------Relacion con area------------------//
    // ************************************************//
    @JsonBackReference(value = "area_produccion")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "area_id")
    @JsonProperty(access = Access.WRITE_ONLY)
    private area area;

    public produccion() {
    }

    public produccion(Integer id,
            @NotEmpty(message = "La descripción no debe estar vacía") @Size(min = 0, max = 300, message = "La descripción debe tener una longitud entre 2 y 200 carcateres.") String descripcion,
            String fecha, @NotEmpty(message = "El tipo no debe estar vacío") EnumProduccion tipo, Boolean estado,
            area area) {
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

    public area getArea() {
        return area;
    }

    public void setArea(area area) {
        this.area = area;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
