package yeilux.com.proyecto.Model.Class.inventario.producto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import javax.persistence.*;
import yeilux.com.proyecto.Model.Class.empleado.empleado;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "entradapro")
public class entradapro {

    // -----------------------ID-----------------------//
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    // -----------------------FECHA_ENTRADA-----------------------//
    private String fecha = obtenerFecha();

    public static String obtenerFecha() {
        String formato = "yyyy-MM-dd HH:mm:ss";
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern(formato);
        LocalDateTime ahora = LocalDateTime.now();
        return formateador.format(ahora);
    }

    // -----------------------CANTIDAD_ENTRADA-----------------------//
    @NotNull
    private Integer cantidad;

    // -----------------------ESTADO-----------------------//
    @NotNull
    private Boolean estado;

    // ************************************************//
    // -------------Relacion con inventario------------//
    // ************************************************//
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "inventario_id")
    @JsonProperty(access = Access.WRITE_ONLY)
    private inventariopro inventario;

    // ************************************************//
    // -------------Relacion con empleado--------------//
    // ************************************************//
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "empleado_id")
    @JsonProperty(access = Access.WRITE_ONLY)
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

    public empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(empleado empleado) {
        this.empleado = empleado;
    }

    public entradapro(Integer id, String fecha, @NotNull Integer cantidad, @NotNull Boolean estado,
            inventariopro inventario, yeilux.com.proyecto.Model.Class.empleado.empleado empleado) {
        this.id = id;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.estado = estado;
        this.inventario = inventario;
        this.empleado = empleado;
    }

    public entradapro() {
    }

}
