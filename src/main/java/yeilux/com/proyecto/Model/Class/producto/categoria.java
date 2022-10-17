package yeilux.com.proyecto.Model.Class.producto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

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
@JoinTable(
    name = "producto_categoria",
    joinColumns = @JoinColumn(name = "id_producto", referencedColumnName = "id"), 
    inverseJoinColumns = @JoinColumn(name = "id_categoria", referencedColumnName = "id"))
private Set<producto> producto = new HashSet<>();
    
    
      // ************************************************//
    // -------------Contructores accesores--------------//
    // ************************************************//


}
