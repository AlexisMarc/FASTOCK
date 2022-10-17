package yeilux.com.proyecto.Model.Class.empleado;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


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

@OneToMany(mappedBy = "cargo", cascade = CascadeType.ALL)
	private Set<empleado> empleado = new HashSet<>();


// ************************************************//
// ------------- CONSTRUCTORES/GETTERS AND SETTERS--------------//
// ************************************************//

public cargo() {
}


public cargo(Integer id, @NotEmpty @Size(min = 2, max = 60) String nombre,
        @NotEmpty @Size(min = 0, max = 200) String descripcion,
        Set<yeilux.com.proyecto.Model.Class.empleado.empleado> empleado) {
    this.id = id;
    Nombre = nombre;
    Descripcion = descripcion;
    this.empleado = empleado;
}


public Integer getId() {
    return id;
}


public void setId(Integer id) {
    this.id = id;
}


public String getNombre() {
    return Nombre;
}


public void setNombre(String nombre) {
    Nombre = nombre;
}


public String getDescripcion() {
    return Descripcion;
}


public void setDescripcion(String descripcion) {
    Descripcion = descripcion;
}


public Set<empleado> getEmpleado() {
    return empleado;
}


public void setEmpleado(Set<empleado> empleado) {
    this.empleado = empleado;
}




}
