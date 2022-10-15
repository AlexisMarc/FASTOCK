package yeilux.com.proyecto.Model.Class.proveedor;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import yeilux.com.proyecto.Model.Class.insumo.insumo;

@Entity
@Table(name="proveedor")
public class proveedor {
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
// -----------------------NOMBRE CONTACTO-----------------------//
    @NotEmpty
    @Column(length = 60)
    @Size(min = 2, max = 60)
    private String contacto;
    // -----------------------DIRECCION-----------------------//
    @NotEmpty
    @Column(length = 60)
    @Size(min = 2, max = 60)
    private String direccion;
// ----------------------- TELEFONO-----------------------//
    @NotNull
    private Long telefono;
// -----------------------EMAIL-----------------------//
    @NotEmpty
    @Email 
    @Column(length = 60)
    @Size(min = 6, max = 200)
    private String email;
// -----------------------ESTADO-----------------------//
    @NotNull
    private Boolean estado;
// ************************************************//
// -------------Relacion con insumo----------------//
// ************************************************//
    
@OneToMany(mappedBy = "proveedor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<insumo> insumo = new HashSet<>();
// ************************************************//
// -------------Constructores---------------//
// ************************************************//
    
}
