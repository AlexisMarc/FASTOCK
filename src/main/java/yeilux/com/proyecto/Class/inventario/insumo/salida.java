package yeilux.com.proyecto.Class.inventario.insumo;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import yeilux.com.proyecto.Class.usuario.usuario;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="salida")
public class salida {
// -----------------------ID-----------------------//
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
// -----------------------FECHA-----------------------//
@NotNull
private Date fecha;
// -----------------------CANTIDAD-----------------------//
@NotNull
private Integer cantidad; 
// -----------------------ESTADO-----------------------//
@NotNull
private Boolean estado;
// -----------------------ID-INVENTARIO-----------------------//
// ************************************************//
// -------------Relacion con inventario------------//
// ************************************************//
@JsonBackReference(value = "inventario_salida")
@ManyToOne(fetch = FetchType.LAZY, optional = false)
@JoinColumn(name = "inventario_id")
@JsonProperty(access = Access.WRITE_ONLY)
private inventario inventario;
// ************************************************//
// -------------Relacion con usuario--------------//
// ************************************************//
@JsonBackReference(value = "usuario_salida")
@ManyToOne(fetch = FetchType.LAZY, optional = false)
@JoinColumn(name = "usuario_id")
@JsonProperty(access = Access.WRITE_ONLY)
private usuario usuario;
/*-----------------GETTERS AND SETTERS----------------*/
public salida() {
}
public salida(Integer id, @NotNull Date fecha, @NotNull Integer cantidad, @NotNull Boolean estado,
        inventario inventario,
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
public Date getFecha() {
    return fecha;
}
public void setFecha(Date fecha) {
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
public usuario getusuario() {
    return usuario;
}
public void setusuario(usuario usuario) {
    this.usuario = usuario;
}


}
