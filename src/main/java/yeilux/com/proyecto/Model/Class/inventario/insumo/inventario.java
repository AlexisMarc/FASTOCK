package yeilux.com.proyecto.Model.Class.inventario.insumo;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import yeilux.com.proyecto.Model.Class.insumo.insumo;

@Entity
@Table(name="inventario")
public class inventario {
// -----------------------ID-----------------------//
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
// -----------------------TIPO-UNIDAD-----------------------//
@NotEmpty
@Column(length = 60)
@Size(min = 2, max = 60)
private String tipoUnidad;
// -----------------------ESTADO-----------------------//
@Column(nullable=true)
private Boolean estado;
    
// ************************************************//
// -------------Relacion con salida----------------//
// ************************************************//
@OneToMany(mappedBy = "inventario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
private Set<salida> salida = new HashSet<>();
// ************************************************//
// -------------Relacion con entrada----------------//
// ************************************************//
@OneToMany(mappedBy = "inventario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
private Set<entrada> entrada = new HashSet<>();
// ************************************************//
// -------------Relacion con insumo----------------//
// ************************************************//
@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "insumo_id")
	@JsonProperty(access = Access.WRITE_ONLY)
	private insumo insumo;
/*-----------------GETTERS AND SETTERS----------------*/
public inventario() {
}
public inventario(Integer id, @NotEmpty @Size(min = 2, max = 60) String tipoUnidad, Boolean estado,
        Set<yeilux.com.proyecto.Model.Class.inventario.insumo.salida> salida,
        Set<yeilux.com.proyecto.Model.Class.inventario.insumo.entrada> entrada,
        yeilux.com.proyecto.Model.Class.insumo.insumo insumo) {
    this.id = id;
    this.tipoUnidad = tipoUnidad;
    this.estado = estado;
    this.salida = salida;
    this.entrada = entrada;
    this.insumo = insumo;
}
public Integer getId() {
    return id;
}
public void setId(Integer id) {
    this.id = id;
}
public String getTipoUnidad() {
    return tipoUnidad;
}
public void setTipoUnidad(String tipoUnidad) {
    this.tipoUnidad = tipoUnidad;
}
public Boolean getEstado() {
    return estado;
}
public void setEstado(Boolean estado) {
    this.estado = estado;
}
public Set<salida> getSalida() {
    return salida;
}
public void setSalida(Set<salida> salida) {
    this.salida = salida;
}
public Set<entrada> getEntrada() {
    return entrada;
}
public void setEntrada(Set<entrada> entrada) {
    this.entrada = entrada;
}
public insumo getInsumo() {
    return insumo;
}
public void setInsumo(insumo insumo) {
    this.insumo = insumo;
}


}
