package yeilux.com.proyecto.Class.insumo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tipo")
public class tipo {
// -----------------------ID-----------------------//
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
// --------------------NOMBRE-----------------------//
    @NotEmpty
    @Column(length = 60)
    @Size(min = 2, max = 60)
    private String nombre;
// ----------------DESCRIPCIÓN-----------------------//
    @NotEmpty
    @Column(length = 200)
    @Size(min = 0, max = 200)
    private String descripcion;
    //--------------Estado---------------//
    @Column(nullable=true)
    private Boolean estado;
// ************************************************//
// -------------Relacion con Insumo----------------//
// ************************************************//
@JsonIgnoreProperties(value = "insumo_tipo")
@ManyToMany
@JoinTable(
    name = "insumo_tipo",
    joinColumns = @JoinColumn(name = "id_insumo", referencedColumnName = "id"), 
    inverseJoinColumns = @JoinColumn(name = "id_tipo", referencedColumnName = "id"))
private Set<insumo> insumo = new HashSet<>();
// ************************************************//
// -------------GETTERS AND SETTERS/CONSTRUCTORES----------------//
// ************************************************//

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
public Boolean getEstado() {
    return estado;
}
public void setEstado(Boolean estado) {
    this.estado = estado;
}
public Set<insumo> getInsumo() {
    return insumo;
}
public void setInsumo(Set<insumo> insumo) {
    this.insumo = insumo;
}
public tipo() {
}
public tipo(Integer id, @NotEmpty @Size(min = 2, max = 60) String nombre,
        @NotEmpty @Size(min = 0, max = 200) String descripcion, Boolean estado,
        Set<insumo> insumo) {
    this.id = id;
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.estado = estado;
    this.insumo = insumo;
}

}

