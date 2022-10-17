package yeilux.com.proyecto.Model.Class.empresa;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="especialidad")
public class especialidad {
// -----------------------ID-----------------------//
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
// --------------------NOMBRE-------------------//
    @NotEmpty
    @Column(length = 60)
    @Size(min = 2, max = 60)
    private String nombre;
// ----------------------DESCRIPCION-----------------//
    @NotEmpty
    @Column(length = 200)
    @Size(min = 0, max = 200)
    private String descripcion;
// ************************************************//
// -------------Relacion con empresa---------------//
// ************************************************//
@OneToMany(mappedBy = "especialidad", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<empresa> empresa = new HashSet<>();



// ************************************************//
// -------------Constructores---------------//
// ************************************************//
public especialidad() {
}


public especialidad(Integer id, @NotEmpty @Size(min = 2, max = 60) String nombre,
        @NotEmpty @Size(min = 0, max = 200) String descripcion,
        Set<yeilux.com.proyecto.Model.Class.empresa.empresa> empresa) {
    this.id = id;
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.empresa = empresa;
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


public Set<empresa> getEmpresa() {
    return empresa;
}


public void setEmpresa(Set<empresa> empresa) {
    this.empresa = empresa;
}






}