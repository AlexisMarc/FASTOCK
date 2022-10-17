package yeilux.com.proyecto.Model.Class.fabricacion;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="produccion")
public class produccion {
// -----------------------ID-----------------------//
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    // -----------------------DESCRIPCION-----------------------//
    @NotEmpty
    @Column (length = 200)
    @Size (min = 0, max = 200)
    private String Descripcion; 
    // -----------------------FECHA_ENTRADA-----------------------//
    private String fecha=obtenerFecha();

    public static String obtenerFecha() {
        String formato = "yyyy-MM-dd HH:mm:ss";
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern(formato);
        LocalDateTime ahora = LocalDateTime.now();
        return formateador.format(ahora);
    }
    // -----------------------TIPO-----------------------//
    @NotEmpty
    @Column (length = 60)
    @Size (min = 2, max = 60)
    private String tipo;


// ************************************************//
// -------------Relacion con area------------------//
// ************************************************//
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "area_id")
    @JsonProperty(access = Access.WRITE_ONLY)
    private area area;

    public produccion() {
    }

    public produccion(Integer id, @NotEmpty @Size(min = 0, max = 200) String descripcion, String fecha,
            @NotEmpty @Size(min = 2, max = 60) String tipo, yeilux.com.proyecto.Model.Class.fabricacion.area area) {
        this.id = id;
        Descripcion = descripcion;
        this.fecha = fecha;
        this.tipo = tipo;
        this.area = area;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public area getArea() {
        return area;
    }

    public void setArea(area area) {
        this.area = area;
    }

    
}
