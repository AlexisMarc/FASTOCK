package yeilux.com.proyecto.Mapping.insumo;

import java.util.HashSet;
import java.util.Set;

import yeilux.com.proyecto.Class.fabricacion.fabricacion;
import yeilux.com.proyecto.Class.inventario.insumo.inventario;
import yeilux.com.proyecto.Class.proveedor.proveedor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class insumo {
	// -----------------------ID-----------------------//
	private Integer id;
	// ----------------NOMBRE-------------//
	@NotEmpty(message = "El nombre no debe estar vacío")
	@Size(min = 2, max = 60, message = "El nombre debe tener entre 2 y 60 caracteres")
	private String nombre;
	// --------------Material insumo---------------//
	@NotEmpty(message = "El nombre del material no debe estar vacío")
	@Size(min = 2, max = 30, message = "El nombre del material debe tener entre 2 y 30 carcateres")
	private String material;
	// -----------------------IMAGEN-----------------------//
	private String imagen;
	// --------------Estado---------------//
	private Boolean estado;
	// ************************************************//
	// -------------Relacion con tipo------------------//
	// ************************************************//
	private Set<tipo> tipo = new HashSet<>();
	// ************************************************//
	// -------------Relacion con proveedor-------------//
	// ************************************************//
	private proveedor proveedor;
	// ************************************************//
	// -------------Relacion con fabricacion-----------//
	// ************************************************//
	private Set<fabricacion> fabricacion = new HashSet<>();
	// ************************************************//
	// -------------Relacion con inventario------------//
	// ************************************************//
	private Set<inventario> inventario = new HashSet<>();

	// ---------GETTERS AND SETTERS---------------------//

	public insumo() {
	}

	
}