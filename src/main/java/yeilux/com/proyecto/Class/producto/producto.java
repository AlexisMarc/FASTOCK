package yeilux.com.proyecto.Class.producto;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import yeilux.com.proyecto.Class.fabricacion.fabricacion;
import yeilux.com.proyecto.Class.inventario.producto.inventariopro;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "producto")
public class producto {

    // -----------------------ID-----------------------//
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    // -----------------------NOMBRE-----------------------//
    @NotEmpty(message = "El nombre no debe estar vacío")
    @Column(length = 60, nullable = false)
    @Size(min = 2, max = 60, message = "El nombre debe tener entre 2 y 60 caracteres")
    private String nombre;

    // -----------------------DESCRIPCION-----------------------//
    @Column(length = 200, nullable = true)
    private String descripcion;

    // -----------------------Estado-----------------------//
    @Column(nullable = false)
    private Boolean estado;

    // -----------------------VISIBLE-----------------------//
    @Column(nullable = false)
    private Boolean visible;

    // -----------------------IMAGEN-----------------------//
    @Column(length = 200)
    private String imagen;

    // ************************************************//
    // -------------Relacion con Categoria-------------//
    // ************************************************//
    @ManyToMany
    @JsonIgnoreProperties(value = "producto_categoria")
    @JoinTable(name = "producto_categoria", joinColumns = @JoinColumn(name = "id_producto", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_categoria", referencedColumnName = "id"))
    private Set<categoria> categoria = new HashSet<>();
    // ************************************************//
    // -------------Relacion con fabricacion-----------//

    // ************************************************//
    @JsonBackReference(value = "fabricacion_producto")
    @ManyToMany
    @JoinTable(name = "fabricacion_producto", joinColumns = @JoinColumn(name = "id_fabricacion", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_producto", referencedColumnName = "id"))
    private Set<fabricacion> fabricacion = new HashSet<>();
    // ************************************************//
    // -------------Relacion con inventario------------//
    // ************************************************//
    @JsonManagedReference(value = "producto_inventario")
    @OneToMany(mappedBy = "producto", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<inventariopro> inventario = new HashSet<>();

    // ************************************************//
    // -------------Contructores accesores--------------//
    // ************************************************//

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Set<categoria> getCategoria() {
        return categoria;
    }

    public void setCategoria(Set<categoria> categoria) {
        this.categoria = categoria;
    }

    public Set<fabricacion> getFabricacion() {
        return fabricacion;
    }

    public void setFabricacion(Set<fabricacion> fabricacion) {
        this.fabricacion = fabricacion;
    }

    public Set<inventariopro> getInventario() {
        return inventario;
    }

    public void setInventario(Set<inventariopro> inventario) {
        this.inventario = inventario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public producto(Integer id,
            @NotEmpty(message = "El nombre no debe estar vacío") @Size(min = 2, max = 60, message = "El nombre debe tener entre 2 y 60 caracteres") String nombre,
            String descripcion, Boolean estado, Boolean visible, String imagen,
            Set<categoria> categoria,
            Set<fabricacion> fabricacion, Set<inventariopro> inventario) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
        this.visible = visible;
        this.imagen = imagen;
        this.categoria = categoria;
        this.fabricacion = fabricacion;
        this.inventario = inventario;
    }

    public producto() {
    }

}
