package fastock.fastock.Class.inventario.insumo;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import fastock.fastock.Class.insumo.insumo;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "inventario")
public class inventario {
    // -----------------------ID-----------------------//
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    // -----------------------TIPO-UNIDAD-----------------------//
    @NotEmpty(message = "El tipo de unidad no debe estar vacío")
    @Column(length = 30, nullable = false)
    @Size(min = 2, max = 30, message = "El tipo de unidad debe tener entre 2 y 30 carcateres")
    private String tipoUnidad;
    // -----------------------ESTADO-----------------------//
    @Column(nullable = false)
    private Boolean estado;

    // ************************************************//
    // -------------Relacion con salida----------------//
    // ************************************************//
    @JsonManagedReference(value = "inventario_salida")
    @OneToMany(mappedBy = "inventario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<salida> salida = new HashSet<>();
    // ************************************************//
    // -------------Relacion con entrada----------------//
    // ************************************************//
    @JsonManagedReference(value = "inventario_entrada")
    @OneToMany(mappedBy = "inventario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<entrada> entrada = new HashSet<>();
    // ************************************************//
    // -------------Relacion con insumo----------------//
    // ************************************************//
    @JsonBackReference(value = "insumo_inventario")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "insumo_id")
    @JsonProperty(access = Access.WRITE_ONLY)
    private insumo insumo;

    /*-----------------GETTERS AND SETTERS----------------*/
    public inventario() {
    }

    public inventario(Integer id,
            @NotEmpty(message = "El tipo de unidad no debe estar vacío") @Size(min = 2, max = 30, message = "El tipo de unidad debe tener entre 2 y 30 carcateres") String tipoUnidad,
            Boolean estado, Set<salida> salida,
            Set<entrada> entrada,
            insumo insumo) {
        this.id = id;
        this.tipoUnidad = tipoUnidad;
        this.estado = estado;
        this.salida = salida;
        this.entrada = entrada;
        this.insumo = insumo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoUnidad() {
        return tipoUnidad;
    }

    public void setTipoUnidad(String tipoUnidad) {
        this.tipoUnidad = tipoUnidad;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Set<salida> getSalida() {
        return salida;
    }

    public void setSalida(Set<salida> salida) {
        this.salida = salida;
    }

    public Set<entrada> getEntrada() {
        return entrada;
    }

    public void setEntrada(Set<entrada> entrada) {
        this.entrada = entrada;
    }

    public insumo getInsumo() {
        return insumo;
    }

    public void setInsumo(insumo insumo) {
        this.insumo = insumo;
    }

}
