package yeilux.com.proyecto.Model.Class.inventario.insumo;

import java.sql.Date;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import yeilux.com.proyecto.Model.Class.empleado.empleado;

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
    @ManyToOne(fetch = FetchType.LAZY)
    private inventario inventario;
// ************************************************//
// -------------Relacion con empleado--------------//
// ************************************************//
    @ManyToOne(fetch = FetchType.LAZY)
    private empleado empleado;
/*-----------------GETTERS AND SETTERS----------------*/
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

public empleado getEmpleado() {
    return empleado;
}

public void setEmpleado(empleado empleado) {
    this.empleado = empleado;
}

/*-----------------CONSTRUCTORES----------------*/
public salida() {
}

public salida(Integer id, @NotNull Date fecha, @NotNull Integer cantidad, @NotNull Boolean estado,
        yeilux.com.proyecto.Model.Class.inventario.insumo.inventario inventario,
        yeilux.com.proyecto.Model.Class.empleado.empleado empleado) {
    this.id = id;
    this.fecha = fecha;
    this.cantidad = cantidad;
    this.estado = estado;
    this.inventario = inventario;
    this.empleado = empleado;
}


}
