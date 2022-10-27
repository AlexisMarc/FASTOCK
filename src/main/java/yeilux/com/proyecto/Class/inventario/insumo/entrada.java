package yeilux.com.proyecto.Class.inventario.insumo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import yeilux.com.proyecto.Class.usuario.usuario;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "entrada", uniqueConstraints = { @UniqueConstraint(columnNames = { "identificacion" }) })
public class entrada {
    // -----------------------ID-----------------------//
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    // -----------------------FECHA-ENTRADA-----------------------//
    @Column(length = 20, nullable = false)
    private String fecha;
    // -----------------------CANTIDAD-----------------------//
    @NotNull(message = "La cantidad no debe estar vacía")
    private Integer cantidad;
    // -----------------------ESTADO-----------------------//
    @Column(nullable = false)
    private Boolean estado;

    // ************************************************//
    // -------------Relacion con inventario------------//
    // ************************************************//
    @JsonBackReference(value = "inventario_entrada")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "inventario_id")
    @JsonProperty(access = Access.WRITE_ONLY)
    private inventario inventario;

    // ************************************************//
    // -------------Relacion con usuario--------------//
    // ************************************************//
    @JsonBackReference(value = "usuario_entrada")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usuario_id")
    @JsonProperty(access = Access.WRITE_ONLY)
    private usuario usuario;
    /*-----------GETTERS AND SETTERS-----------------*/

    public entrada() {
    }

    public entrada(Integer id, String fecha, @NotNull(message = "La cantidad no debe estar vacía") Integer cantidad,
            Boolean estado, inventario inventario,
            usuario usuario) {
        this.id = id;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.estado = estado;
        this.inventario = inventario;
        this.usuario = usuario;
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

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public inventario getInventario() {
        return inventario;
    }

    public void setInventario(inventario inventario) {
        this.inventario = inventario;
    }

    public usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(usuario usuario) {
        this.usuario = usuario;
    }

    
}
