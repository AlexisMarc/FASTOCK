package yeilux.com.proyecto.Class.producto;

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
    @Column(name = "id")
    private Integer id;

    // -----------------------NOMBRE-----------------------//
    @NotEmpty
    @Column(length = 60)
    @Size(min = 2, max = 60)
    private String nombre;

    // -----------------------Descri-----------------------//
    @NotEmpty
    @Column(length = 60)
    @Size(min = 2, max = 60)
    private String descripcion;

    // ************************************************//
    // -------------Relacion con producto--------------//
    // ************************************************//
    @ManyToMany
    @JsonIgnoreProperties(value = "producto_categoria")
@JoinTable(
    name = "producto_categoria",
    joinColumns = @JoinColumn(name = "id_producto", referencedColumnName = "id"), 
    inverseJoinColumns = @JoinColumn(name = "id_categoria", referencedColumnName = "id"))
private Set<producto> producto = new HashSet<>();
    
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

public String getDescripcion() {
    return descripcion;
}

public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
}

public Set<producto> getProducto() {
    return producto;
}

public void setProducto(Set<producto> producto) {
    this.producto = producto;
}

public categoria() {
}

public categoria(Integer id, @NotEmpty @Size(min = 2, max = 60) String nombre,
        @NotEmpty @Size(min = 2, max = 60) String descripcion,
        Set<producto> producto) {
    this.id = id;
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.producto = producto;
}

}
