package yeilux.com.proyecto.Model.Class.producto;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import yeilux.com.proyecto.Model.Class.fabricacion.fabricacion;
import yeilux.com.proyecto.Model.Class.inventario.producto.inventariopro;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "producto")
public class producto {

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

    // -----------------------Descri Producto-----------------------//
    @NotEmpty
    @Column(length = 200)
    @Size(min = 2, max = 200)
    private String descripcion;

    // -----------------------Estado-----------------------//
    @Column(nullable = false)
    private Boolean estado=true;

    // -----------------------Imagen-----------------------//
    private String imagen;


    // ************************************************//
    // -------------Relacion con Categoria-------------//
    // ************************************************//
    @ManyToMany
@JsonBackReference
@JoinTable(
    name = "producto_categoria",
    joinColumns = @JoinColumn(name = "id_producto", referencedColumnName = "id"), 
    inverseJoinColumns = @JoinColumn(name = "id_categoria", referencedColumnName = "id"))
private Set<categoria> categoria = new HashSet<>();
    // ************************************************//
    // -------------Relacion con fabricacion-----------//
    // ************************************************//
    @ManyToMany
@JoinTable(
    name = "fabricacion_producto",
    joinColumns = @JoinColumn(name = "id_fabricacion", referencedColumnName = "id"), 
    inverseJoinColumns = @JoinColumn(name = "id_producto", referencedColumnName = "id"))
private Set<fabricacion> fabricacion = new HashSet<>();
    // ************************************************//
    // -------------Relacion con inventario------------//
    // ************************************************//
    @OneToMany(mappedBy = "producto", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<inventariopro> inventario = new HashSet<>();


    
    // ************************************************//
    // -------------Contructores accesores--------------//
    // ************************************************//

    

}
