package fastock.fastock.Class.producto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "categoria")
public class categoria {
    // -----------------------ID-----------------------//
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    // -----------------------NOMBRE-----------------------//
    @NotEmpty(message = "La categoría no debe estar vacía")
    @Column(length = 30, nullable = false)
    @Size(min = 2, max = 30, message = "La categoría debe tener una longitud en 2 y 60 caracteres.")
    private String nombre;

    // -----------------------Estado-----------------------//
    @Column(nullable = false)
    private Boolean estado;

    // ************************************************//
    // -------------Relacion con producto--------------//
    // ************************************************//
    @ManyToMany
    @JsonIgnoreProperties(value = "producto_categoria")
    @JoinTable(name = "producto_categoria", 
    inverseJoinColumns = @JoinColumn(name = "id_producto", referencedColumnName = "id"), 
    joinColumns = @JoinColumn(name = "id_categoria", referencedColumnName = "id"))
    private Set<producto> producto = new HashSet<>();

    // ************************************************//
    // -------------Contructores accesores--------------//
    // ************************************************//

    public categoria() {
    }

    public categoria(Integer id,
            @NotEmpty(message = "La categoría no debe estar vacía") @Size(min = 2, max = 30, message = "La categoría debe tener una longitud en 2 y 60 caracteres.") 
            String nombre, Boolean estado,
            Set<producto> producto) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
        this.producto = producto;
    }

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

    public Set<producto> getProducto() {
        return producto;
    }

    public void setProducto(Set<producto> producto) {
        this.producto = producto;
    }

   
}
