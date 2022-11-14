package fastock.fastock.Mapping.insumo;

import java.util.List;

import fastock.fastock.Mapping.fabricacion.DTOfabricacion;

public class DTOinsumo {
	// -----------------------ID-----------------------//
	private Integer id;
	// ----------------NOMBRE-------------//
	private String nombre;
	// --------------Material insumo---------------//
	private String material;
	// -----------------------IMAGEN-----------------------//
	private String imagen;
	// --------------Estado---------------//
	private Boolean estado;
	// ************************************************//
	// -------------Relacion con tipo------------------//
	// ************************************************//
	private List<DTOtipo> tipo ;
	// ************************************************//
	// -------------Relacion con proveedor-------------//
	// ************************************************//
	private String proveedor;
	// ************************************************//
	// -------------Relacion con fabricacion-----------//
	// ************************************************//
	private List<DTOfabricacion> fabricacion ;
	// ************************************************//
	// -------------Relacion con inventario------------//
	// ************************************************//
	private Boolean inventario;

	// ---------GETTERS AND SETTERS---------------------//

	public DTOinsumo() {
	}

	public DTOinsumo(Integer id, String nombre, String material, String imagen, Boolean estado, List<DTOtipo> tipo,
			String proveedor, List<DTOfabricacion> fabricacion, Boolean inventario) {
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

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public List<DTOtipo> getTipo() {
		return tipo;
	}

	public void setTipo(List<DTOtipo> tipo) {
		this.tipo = tipo;
	}

	public String getProveedor() {
		return proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	public List<DTOfabricacion> getFabricacion() {
		return fabricacion;
	}

	public void setFabricacion(List<DTOfabricacion> fabricacion) {
		this.fabricacion = fabricacion;
	}

	public Boolean getInventario() {
		return inventario;
	}

	public void setInventario(Boolean inventario) {
		this.inventario = inventario;
	}


	
}