package yeilux.com.proyecto.Model.Class.fabricacion;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

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

    
}
