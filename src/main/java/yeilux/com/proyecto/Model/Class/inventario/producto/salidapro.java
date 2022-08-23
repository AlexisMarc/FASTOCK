package yeilux.com.proyecto.Model.Class.inventario.producto;

import java.sql.Date;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import yeilux.com.proyecto.Model.Class.empleado.empleado;

@Entity
@Table(name = "salidapro")
public class salidapro {
    // -----------------------ID-----------------------//
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    // -----------------------FECHA_SALIDA-----------------------//
    @NotEmpty
    private Date fecha;

    // -----------------------CANTIDAD_SALIDA-----------------------//
    @NotEmpty
    private Integer cantidad;

    // -----------------------ESTADO-----------------------//
    @Column(nullable = true)
    private Boolean estado;

    // ************************************************//
    // -------------Relacion con inventario------------//
    // ************************************************//
    @ManyToOne(fetch = FetchType.LAZY)
    private inventariopro inventario;
    // ************************************************//
    // -------------Relacion con empleado--------------//
    // ************************************************//
    @ManyToOne(fetch = FetchType.LAZY)
    private empleado empleado;

    // ************************************************//
    // -------------Contructores accesores--------------//
    // ************************************************//

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

    public inventariopro getInventario() {
        return inventario;
    }

    public void setInventario(inventariopro inventario) {
        this.inventario = inventario;
    }

    public empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(empleado empleado) {
        this.empleado = empleado;
    }

    public salidapro() {
    }

    public salidapro(Integer id, @NotEmpty Date fecha, @NotEmpty Integer cantidad, Boolean estado,
            inventariopro inventario, yeilux.com.proyecto.Model.Class.empleado.empleado empleado) {
        this.id = id;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.estado = estado;
        this.inventario = inventario;
        this.empleado = empleado;
    }

}
