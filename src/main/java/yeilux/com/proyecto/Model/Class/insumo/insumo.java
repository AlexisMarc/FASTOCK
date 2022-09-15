package yeilux.com.proyecto.Model.Class.insumo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import yeilux.com.proyecto.Model.Class.fabricacion.fabricacion;
import yeilux.com.proyecto.Model.Class.inventario.insumo.inventario;
import yeilux.com.proyecto.Model.Class.proveedor.proveedor;

@Entity
@Table(name="insumo")
public class insumo {
// -----------------------ID-----------------------//
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

//----------------NOMBRE-------------//
@NotEmpty
@Column(length = 60)
@Size(min = 2, max = 60)
private String nombre;
//--------------Descripcion---------------//
@NotEmpty
@Column(length = 200)
@Size(min = 2, max = 200)
private String descripcion;
//--------------Imagen---------------//
//--------------Material insumo---------------//
@NotEmpty
@Column(length = 200)
@Size(min = 2, max = 200)
private String material;
//--------------Estado---------------//
private Boolean estado=false;
// ************************************************//
// -------------Relacion con tipo------------------//
// ************************************************//
    @NotNull
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "insumo_tipo",
        joinColumns = @JoinColumn(name = "id_insumo"),
        inverseJoinColumns = @JoinColumn(name="id_tipo")
    )
    private List<tipo> tipo;
// ************************************************//
// -------------Relacion con proveedor-------------//
// ************************************************//
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private proveedor proveedor;
// ************************************************//
// -------------Relacion con fabricacion-----------//
// ************************************************//
    @ManyToMany(mappedBy = "insumo", fetch = FetchType.LAZY)
    private List<fabricacion> fabricacion;
// ************************************************//
// -------------Relacion con inventario------------//
// ************************************************//
    @OneToMany(mappedBy = "insumo", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<inventario> inventario;
//---------GETTERS AND SETTERS---------------------//
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
    public String getMaterial() {
        return material;
    }
    public void setMaterial(String material) {
        this.material = material;
    }
    public Boolean getEstado() {
        return estado;
    }
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    public List<tipo> getTipo() {
        return tipo;
    }
    public void setTipo(List<tipo> tipo) {
        this.tipo = tipo;
    }
    public proveedor getProveedor() {
        return proveedor;
    }
    public void setProveedor(proveedor proveedor) {
        this.proveedor = proveedor;
    }
    public List<fabricacion> getFabricacion() {
        return fabricacion;
    }
    public void setFabricacion(List<fabricacion> fabricacion) {
        this.fabricacion = fabricacion;
    }
    public List<inventario> getInventario() {
        return inventario;
    }
    public void setInventario(List<inventario> inventario) {
        this.inventario = inventario;
    }
//--------------CONSTRUCOTRES----------------------//
public insumo() {
    tipo=new ArrayList<tipo>();
}
    public insumo(Integer id, @NotEmpty @Size(min = 2, max = 60) String nombre,
            @NotEmpty @Size(min = 2, max = 200) String descripcion,
            @NotEmpty @Size(min = 2, max = 200) String material, Boolean estado,
            @NotNull List<yeilux.com.proyecto.Model.Class.insumo.tipo> tipo,
            @NotNull yeilux.com.proyecto.Model.Class.proveedor.proveedor proveedor,
            List<yeilux.com.proyecto.Model.Class.fabricacion.fabricacion> fabricacion,
            List<yeilux.com.proyecto.Model.Class.inventario.insumo.inventario> inventario) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.material = material;
        this.estado = estado;
        this.tipo = tipo;
        this.proveedor = proveedor;
        this.fabricacion = fabricacion;
        this.inventario = inventario;
    }
}