package fastock.fastock.Class.insumo;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import fastock.fastock.Class.fabricacion.fabricacion;
import fastock.fastock.Class.inventario.insumo.inventario;
import fastock.fastock.Class.proveedor.proveedor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "insumo")
public class insumo {
	// -----------------------ID-----------------------//
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;
	// ----------------NOMBRE-------------//
	@NotEmpty(message = "El nombre no debe estar vacío")
	@Column(length = 60, nullable = false)
	@Size(min = 2, max = 60, message = "El nombre debe tener entre 2 y 60 caracteres")
	private String nombre;
	// --------------Material insumo---------------//
	@NotEmpty(message = "El nombre del material no debe estar vacío")
	@Column(length = 30, nullable = false)
	@Size(min = 2, max = 30, message = "El nombre del material debe tener entre 2 y 30 carcateres")
	private String material;
	// -----------------------IMAGEN-----------------------//
	@Column(length = 200)
	private String imagen;
	// --------------Estado---------------//
	@Column(nullable = false)
	private Boolean estado;
	// ************************************************//
	// -------------Relacion con tipo------------------//
	// ************************************************//
	@ManyToMany
	@JsonIgnoreProperties(value = "insumo_tipo")
	@JoinTable(name = "insumo_tipo", 
	joinColumns = @JoinColumn(name = "id_insumo", referencedColumnName = "id"), 
	inverseJoinColumns = @JoinColumn(name = "id_tipo", referencedColumnName = "id"))
	private Set<tipo> tipo = new HashSet<>();
	// ************************************************//
	// -------------Relacion con proveedor-------------//
	// ************************************************//
	@JsonBackReference(value = "insumo_proveedor")
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "proveedor_id")
	@JsonProperty(access = Access.WRITE_ONLY)
	private proveedor proveedor;
	// ************************************************//
	// -------------Relacion con fabricacion-----------//
	// ************************************************//
	@ManyToMany
	@JsonIgnoreProperties(value = "fabricacion_insumo")
	@JoinTable(name = "fabricacion_insumo", joinColumns = @JoinColumn(name = "id_fabricacion", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_insumo", referencedColumnName = "id"))
	private Set<fabricacion> fabricacion = new HashSet<>();
	// ************************************************//
	// -------------Relacion con inventario------------//
	// ************************************************//
	@JsonManagedReference(value = "insumo_inventario")
	@OneToMany(mappedBy = "insumo", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<inventario> inventario = new HashSet<>();

	// ---------GETTERS AND SETTERS---------------------//

	public insumo() {
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

	

	public insumo(Integer id,
			@NotEmpty(message = "El nombre no debe estar vacío") @Size(min = 2, max = 60, message = "El nombre debe tener entre 2 y 60 caracteres") String nombre,
			@NotEmpty(message = "El nombre del material no debe estar vacío") @Size(min = 2, max = 30, message = "El nombre del material debe tener entre 2 y 30 carcateres") String material,
			String imagen, Boolean estado, Set<tipo> tipo,
			proveedor proveedor,
			Set<fabricacion> fabricacion,
			Set<inventario> inventario) {
		this.id = id;
		this.nombre = nombre;
		this.material = material;
		this.imagen = imagen;
		this.estado = estado;
		this.tipo = tipo;
		this.proveedor = proveedor;
		this.fabricacion = fabricacion;
		this.inventario = inventario;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

}