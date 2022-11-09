package yeilux.com.proyecto.Class.inventario.producto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import yeilux.com.proyecto.Class.usuario.usuario;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "entradapro")
public class entradapro {

    // -----------------------ID-----------------------//
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    // -----------------------FECHA_ENTRADA-----------------------//
    @Column(nullable = false)
    private String fecha;
    // -----------------------CANTIDAD_ENTRADA-----------------------//
    @NotNull(message = "La cantidad no debe estar vacía")
    @Column(nullable = false)
    private Integer cantidad;
    // -----------------------ESTADO-----------------------//
    @Column(nullable = false)
    private Boolean estado;

    // ************************************************//
    // -------------Relacion con inventario------------//
    // ************************************************//
    @JsonBackReference(value = "inventariopro_entrada")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "inventario_id")
    @JsonProperty(access = Access.WRITE_ONLY)
    private inventariopro inventario;

    // ************************************************//
    // -------------Relacion con usuario--------------//
    // ************************************************//
    @JsonBackReference(value = "usuario_entradapro")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usuario_id")
    @JsonProperty(access = Access.WRITE_ONLY)
    private usuario usuario;

    // ************************************************//
    // -------------Contructores accesores--------------//
    // ************************************************//

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

    public inventariopro getInventario() {
        return inventario;
    }

    public void setInventario(inventariopro inventario) {
        this.inventario = inventario;
    }

    public usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(usuario usuario) {
        this.usuario = usuario;
    }

    

    public entradapro(Integer id, String fecha, @NotNull(message = "La cantidad no debe estar vacía") Integer cantidad,
            Boolean estado, inventariopro inventario, yeilux.com.proyecto.Class.usuario.usuario usuario) {
        this.id = id;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.estado = estado;
        this.inventario = inventario;
        this.usuario = usuario;
    }

    public entradapro() {
    }

}
