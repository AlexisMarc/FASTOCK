package yeilux.com.proyecto.Model.Class.producto;

// import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import yeilux.com.proyecto.Model.Class.fabricacion.fabricacion;
import yeilux.com.proyecto.Model.Class.inventario.producto.inventariopro;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

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
    private Boolean estado=false;

    // -----------------------Imagen-----------------------//
    private String imagen;


    // ************************************************//
    // -------------Relacion con Categoria-------------//
    // ************************************************//
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "producto_categoria", 
    joinColumns = @JoinColumn(name = "id_producto"), 
    inverseJoinColumns = @JoinColumn(name = "id_categoria"))
    @NotNull
    private List<categoria> categoria;
    // ************************************************//
    // -------------Relacion con fabricacion-----------//
    // ************************************************//
    @ManyToMany(mappedBy = "producto", fetch = FetchType.LAZY)
    private List<fabricacion> fabricacion;
    // ************************************************//
    // -------------Relacion con inventario------------//
    // ************************************************//
    @OneToOne(mappedBy = "producto", fetch = FetchType.LAZY)
    private inventariopro inventario;


    
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

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public List<categoria> getCategoria() {
        return categoria;
    }

    public void setCategoria(List<categoria> categoria) {
        this.categoria = categoria;
    }

    public List<fabricacion> getFabricacion() {
        return fabricacion;
    }

    public void setFabricacion(List<fabricacion> fabricacion) {
        this.fabricacion = fabricacion;
    }

    public inventariopro getInventario() {
        return inventario;
    }

    public void setInventario(inventariopro inventario) {
        this.inventario = inventario;
    }

    
    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public producto() {
    }

    public producto(Integer id, @NotEmpty @Size(min = 2, max = 60) String nombre,
            @NotEmpty @Size(min = 2, max = 200) String descripcion, Boolean estado, String imagen,
            @NotNull List<yeilux.com.proyecto.Model.Class.producto.categoria> categoria,
            List<yeilux.com.proyecto.Model.Class.fabricacion.fabricacion> fabricacion, inventariopro inventario) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
        this.imagen = imagen;
        this.categoria = categoria;
        this.fabricacion = fabricacion;
        this.inventario = inventario;
    }


    

   

    

}
