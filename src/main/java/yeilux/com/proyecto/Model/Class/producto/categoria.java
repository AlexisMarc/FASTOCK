package yeilux.com.proyecto.Model.Class.producto;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

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
    @JoinTable(name = "categoria_producto", joinColumns = @JoinColumn(name = "id_categoria", nullable = false), inverseJoinColumns = @JoinColumn(name = "id_producto", nullable = false))
    @ManyToMany(cascade = CascadeType.ALL)
    private List<producto> producto;
    
    
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

    public List<producto> getProducto() {
        return producto;
    }

    public void setProducto(List<producto> producto) {
        this.producto = producto;
    }

    public categoria() {
        producto=new ArrayList<producto>();
    }

    public categoria(Integer id, @NotEmpty @Size(min = 2, max = 60) String nombre,
            @NotEmpty @Size(min = 2, max = 60) String descripcion,
            List<yeilux.com.proyecto.Model.Class.producto.producto> producto) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.producto = producto;
    }

    
    

    
}
