package yeilux.com.proyecto.Model.Class.fabricacion;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import jakarta.persistence.*;
import yeilux.com.proyecto.Model.Class.empleado.admin;
import yeilux.com.proyecto.Model.Class.insumo.insumo;
import yeilux.com.proyecto.Model.Class.producto.producto;

@Entity
@Table(name="fabricacion")
public class fabricacion {
    // -----------------------ID-----------------------//
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    // -----------------------FECHA_INICIO-----------------------//
    private String fechainicio=obtenerFecha();

    public static String obtenerFecha() {
        String formato = "yyyy-MM-dd";
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern(formato);
        LocalDateTime ahora = LocalDateTime.now();
        return formateador.format(ahora);
    }
    // -----------------------FECHA_FINAL-----------------------//
    private String fechafinal;
    // -----------------------Estado-----------------------//
    private Boolean estado=true;


// ************************************************//
// -------------Relacion con area------------------//
// ************************************************//
    @OneToMany(mappedBy = "fabricacion", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        private List<area> area;
    
// ************************************************//
// -------------Relacion con admin----------------//
// ************************************************//
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "fabricacion_admin",
        joinColumns = @JoinColumn(name = "id_fabricacion"),
        inverseJoinColumns = @JoinColumn(name="id_admin")
    )
    private List<admin> admin;
// ************************************************//
// -------------Relacion con insumo----------------//
// ************************************************//
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "fabricacion_insumo",
        joinColumns = @JoinColumn(name = "id_fabricacion"),
        inverseJoinColumns = @JoinColumn(name="id_insumo")
    )
    private List<insumo> insumo;
// ************************************************//
// -------------Relacion con producto--------------//
// ************************************************//
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "fabricacion_producto",
        joinColumns = @JoinColumn(name = "id_fabricacion"),
        inverseJoinColumns = @JoinColumn(name="id_producto")
    )
    private List<producto> producto;

    public fabricacion() {
    }

    public fabricacion(Integer id, String fechainicio, String fechafinal, Boolean estado,
            List<yeilux.com.proyecto.Model.Class.fabricacion.area> area,
            List<yeilux.com.proyecto.Model.Class.empleado.admin> admin,
            List<yeilux.com.proyecto.Model.Class.insumo.insumo> insumo,
            List<yeilux.com.proyecto.Model.Class.producto.producto> producto) {
        this.id = id;
        this.fechainicio = fechainicio;
        this.fechafinal = fechafinal;
        this.estado = estado;
        this.area = area;
        this.admin = admin;
        this.insumo = insumo;
        this.producto = producto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(String fechainicio) {
        this.fechainicio = fechainicio;
    }

    public String getFechafinal() {
        return fechafinal;
    }

    public void setFechafinal(String fechafinal) {
        this.fechafinal = fechafinal;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public List<area> getArea() {
        return area;
    }

    public void setArea(List<area> area) {
        this.area = area;
    }

    public List<admin> getAdmin() {
        return admin;
    }

    public void setAdmin(List<admin> admin) {
        this.admin = admin;
    }

    public List<insumo> getInsumo() {
        return insumo;
    }

    public void setInsumo(List<insumo> insumo) {
        this.insumo = insumo;
    }

    public List<producto> getProducto() {
        return producto;
    }

    public void setProducto(List<producto> producto) {
        this.producto = producto;
    }

    
    
}
