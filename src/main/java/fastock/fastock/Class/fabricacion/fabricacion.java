package fastock.fastock.Class.fabricacion;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import fastock.fastock.Class.insumo.insumo;
import fastock.fastock.Class.producto.producto;
import fastock.fastock.Class.usuario.usuario;

import javax.persistence.*;

@Entity
@Table(name = "fabricacion")
public class fabricacion {
    // -----------------------ID-----------------------//
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    // -----------------------FECHA_INICIO-----------------------//
    @Column(length = 20, nullable = false)
    private String fechainicio;

    // -----------------------FECHA_FINAL-----------------------//
    @Column(length = 20, nullable = true)
    private String fechafinal;
    // -----------------------Estado-----------------------//
    @Column(nullable = false)
    private Boolean estado;

    // ************************************************//
    // -------------Relacion con area------------------//
    // ************************************************//
    @JsonManagedReference(value = "fabricacion_area")
    @OneToMany(mappedBy = "fabricacion", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<area> area = new HashSet<>();

    // ************************************************//
    // -------------Relacion con usuario----------------//
    // ************************************************//

    @ManyToMany
    @JsonIgnoreProperties(value = "fabricacion_usuario")
    @JoinTable(name = "fabricacion_usuario", joinColumns = @JoinColumn(name = "id_fabricacion", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_usuario", referencedColumnName = "id"))
    private Set<usuario> usuario = new HashSet<>();
    // ************************************************//
    // -------------Relacion con insumo----------------//
    // ************************************************//
    @ManyToMany
    @JsonIgnoreProperties(value = "fabricacion_insumo")
    @JoinTable(name = "fabricacion_insumo", joinColumns = @JoinColumn(name = "id_fabricacion", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_insumo", referencedColumnName = "id"))
    private Set<insumo> insumo = new HashSet<>();
    // ************************************************//
    // -------------Relacion con producto--------------//
    // ************************************************//
    @ManyToMany
    @JsonIgnoreProperties(value = "fabricacion_producto")
    @JoinTable(name = "fabricacion_producto", joinColumns = @JoinColumn(name = "id_fabricacion", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_producto", referencedColumnName = "id"))
    private Set<producto> producto = new HashSet<>();

    public fabricacion() {
    }

    public fabricacion(Integer id, String fechainicio, String fechafinal, Boolean estado,
            Set<area> area, Set<usuario> usuario,
            Set<insumo> insumo,
            Set<producto> producto) {
        this.id = id;
        this.fechainicio = fechainicio;
        this.fechafinal = fechafinal;
        this.estado = estado;
        this.area = area;
        this.usuario = usuario;
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

    public Set<area> getArea() {
        return area;
    }

    public void setArea(Set<area> area) {
        this.area = area;
    }

    public Set<usuario> getUsuario() {
        return usuario;
    }

    public void setUsuario(Set<usuario> usuario) {
        this.usuario = usuario;
    }

    public Set<insumo> getInsumo() {
        return insumo;
    }

    public void setInsumo(Set<insumo> insumo) {
        this.insumo = insumo;
    }

    public Set<producto> getProducto() {
        return producto;
    }

    public void setProducto(Set<producto> producto) {
        this.producto = producto;
    }

}
