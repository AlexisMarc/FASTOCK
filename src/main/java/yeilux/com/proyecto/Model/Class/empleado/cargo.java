package yeilux.com.proyecto.Model.Class.empleado;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="cargo")
public class cargo {
// -----------------------ID-----------------------//
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

// -----------------------NOMBRE-----------------------//
    @NotEmpty
    @Column (length = 60)
    @Size (min = 2, max = 60)
    private String Nombre;

// -----------------------DESCRIPCION-----------------------//
    @NotEmpty
    @Column (length = 200)
    @Size (min = 0, max = 200)
    private String Descripcion; 

// ************************************************//
// -------------Relacion con empleado--------------//
// ************************************************//
@OneToMany(mappedBy = "cargo", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<empleado> empleado = new HashSet<>();

// ************************************************//
// ------------- CONSTRUCTORES/GETTERS AND SETTERS--------------//
// ************************************************//


}
