package yeilux.com.proyecto.Model.Class.empleado;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import yeilux.com.proyecto.Model.Class.fabricacion.area;
import yeilux.com.proyecto.Model.Class.inventario.insumo.entrada;
import yeilux.com.proyecto.Model.Class.inventario.insumo.salida;
import yeilux.com.proyecto.Model.Class.inventario.producto.entradapro;
import yeilux.com.proyecto.Model.Class.inventario.producto.salidapro;

@Entity
@Table(name="empleado",uniqueConstraints = {@UniqueConstraint(columnNames = {"identificacion"})})
public class empleado {
// -----------------------ID-----------------------//
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

// -----------------------Idenficacion-----------------------//
    @NotNull
    private Long identificacion;
// -----------------------Nombre-----------------------//
    @NotEmpty
    @Column (length = 60)
    @Size (min = 2, max = 60)
    private String nombre;

// -----------------------Apellido-----------------------//

    @NotEmpty
    @Column (length = 60)
    @Size (min = 2, max = 60)
    private String apellido;  

// -----------------------Genero-----------------------//
    @NotEmpty
    @Column (length = 10)
    @Size (min = 2, max = 10)
    private String genero; 

// -----------------------Fecha de nacimiento-----------------------// 
    @NotEmpty
    @Column (length = 12)
    private String fecha;   

// -----------------------Direccion-----------------------//

    @NotEmpty
    @Column (length = 60)
    @Size (min = 2, max = 60)
    private String direccion;  

// -----------------------Telefono-----------------------//
    @NotNull
    private Long telefono;

// -----------------------Email-----------------------//

    @NotEmpty
    @Email
    @Column (length = 200)
    @Size (min = 1, max = 200)
    private String email; 

// -----------------------Estado-----------------------//
@Column(nullable = false)
private Boolean estado=true;

// ************************************************//
// -------------Relacion con cargo-----------------//
// ************************************************//

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "cargo_id")
	@JsonProperty(access = Access.WRITE_ONLY)
	private cargo cargo;

// ************************************************//
// -------------Relacion con area------------------//
// ************************************************//
@ManyToMany
@JsonBackReference
@JoinTable(
    name = "area_empleado",
    joinColumns = @JoinColumn(name = "id_area", referencedColumnName = "id"), 
    inverseJoinColumns = @JoinColumn(name = "id_empleado", referencedColumnName = "id"))
private Set<area> area = new HashSet<>();

// ************************************************//
// -------------Relacion con entrada---------------//
// ************************************************//
@OneToMany(mappedBy = "empleado", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
private Set<entrada> entrada = new HashSet<>();
// ************************************************//
// -------------Relacion con entradapro------------//
// ************************************************//
@OneToMany(mappedBy = "empleado", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
private Set<entradapro> entradapro = new HashSet<>();
// ************************************************//
// -------------Relacion con salida---------------//
// ************************************************//
@OneToMany(mappedBy = "empleado", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
private Set<salida> salida = new HashSet<>();
// ************************************************//
// -------------Relacion con salidapro------------//
// ************************************************//
@OneToMany(mappedBy = "empleado", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
private Set<salidapro> salidapro = new HashSet<>();
 // ************************************************//
// ------------- CONSTRUCTORES/GETTERS AND SETTERS--------------//
// ************************************************//
    
}
