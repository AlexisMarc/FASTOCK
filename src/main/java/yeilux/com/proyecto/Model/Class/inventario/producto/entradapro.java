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
    private String fecha=obtenerFecha();

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

}
