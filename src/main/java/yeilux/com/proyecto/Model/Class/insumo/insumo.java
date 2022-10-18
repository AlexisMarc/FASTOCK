package yeilux.com.proyecto.Model.Class.insumo;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
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
@Column(nullable = false)
    private Boolean estado=true;
// ************************************************//
// -------------Relacion con tipo------------------//
// ************************************************//
@ManyToMany
@JsonBackReference
@JoinTable(
    name = "insumo_tipo",
    joinColumns = @JoinColumn(name = "id_insumo", referencedColumnName = "id"), 
    inverseJoinColumns = @JoinColumn(name = "id_tipo", referencedColumnName = "id"))
private Set<tipo> tipo = new HashSet<>();
// ************************************************//
// -------------Relacion con proveedor-------------//
// ************************************************//
@ManyToOne(fetch = FetchType.LAZY, optional = false)
@JoinColumn(name = "proveedor_id")
@JsonProperty(access = Access.WRITE_ONLY)
private proveedor proveedor;
// ************************************************//
// -------------Relacion con fabricacion-----------//
// ************************************************//
@ManyToMany
@JoinTable(
    name = "fabricacion_insumo",
    joinColumns = @JoinColumn(name = "id_fabricacion", referencedColumnName = "id"), 
    inverseJoinColumns = @JoinColumn(name = "id_insumo", referencedColumnName = "id"))
private Set<fabricacion> fabricacion = new HashSet<>();
// ************************************************//
// -------------Relacion con inventario------------//
// ************************************************//
@OneToMany(mappedBy = "insumo", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<inventario> inventario = new HashSet<>();





//---------GETTERS AND SETTERS---------------------//

public insumo() {
}
public insumo(Integer id, @NotEmpty @Size(min = 2, max = 60) String nombre,
		@NotEmpty @Size(min = 2, max = 200) String descripcion, @NotEmpty @Size(min = 2, max = 200) String material,
		Boolean estado, Set<yeilux.com.proyecto.Model.Class.insumo.tipo> tipo,
		yeilux.com.proyecto.Model.Class.proveedor.proveedor proveedor,
		Set<yeilux.com.proyecto.Model.Class.fabricacion.fabricacion> fabricacion,
		Set<yeilux.com.proyecto.Model.Class.inventario.insumo.inventario> inventario) {
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
public Set<tipo> getTipo() {
	return tipo;
}
public void setTipo(Set<tipo> tipo) {
	this.tipo = tipo;
}
public proveedor getProveedor() {
	return proveedor;
}
public void setProveedor(proveedor proveedor) {
	this.proveedor = proveedor;
}
public Set<fabricacion> getFabricacion() {
	return fabricacion;
}
public void setFabricacion(Set<fabricacion> fabricacion) {
	this.fabricacion = fabricacion;
}
public Set<inventario> getInventario() {
	return inventario;
}
public void setInventario(Set<inventario> inventario) {
	this.inventario = inventario;

}
    





}