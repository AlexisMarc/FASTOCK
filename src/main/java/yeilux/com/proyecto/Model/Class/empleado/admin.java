package yeilux.com.proyecto.Model.Class.empleado;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import yeilux.com.proyecto.Model.Class.fabricacion.fabricacion;

@Entity
@Table(name="admin",uniqueConstraints = {@UniqueConstraint(columnNames = {"identificacion"})})
public class admin {
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
    private Integer telefono;

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
// -------------Relacion con fabricacion-----------//
// ************************************************//
    @ManyToMany
	@JoinTable(
        name = "fabricacion_admin",
        joinColumns = @JoinColumn(name = "id_fabricacion", referencedColumnName = "id"), 
        inverseJoinColumns = @JoinColumn(name = "id_admin", referencedColumnName = "id"))
	private Set<fabricacion> fabricacion = new HashSet<>();


// ************************************************//
// ------------- CONSTRUCTORES/GETTERS AND SETTERS--------------//
// ************************************************//




}