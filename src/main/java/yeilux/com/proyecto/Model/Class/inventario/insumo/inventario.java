package yeilux.com.proyecto.Model.Class.inventario.insumo;

import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
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
	private List<salida> salida;
// ************************************************//
// -------------Relacion con entrada----------------//
// ************************************************//
    @OneToMany(mappedBy = "inventario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<entrada> entrada;
// ************************************************//
// -------------Relacion con insumo----------------//
// ************************************************//
@ManyToOne(fetch = FetchType.LAZY)
private insumo insumo;
/*-----------------GETTERS AND SETTERS----------------*/

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

public List<salida> getSalida() {
    return salida;
}

public void setSalida(List<salida> salida) {
    this.salida = salida;
}

public List<entrada> getEntrada() {
    return entrada;
}

public void setEntrada(List<entrada> entrada) {
    this.entrada = entrada;
}

public insumo getInsumo() {
    return insumo;
}

public void setInsumo(insumo insumo) {
    this.insumo = insumo;
}
/*-----------CONSTRUCTORS--------------------*/
public inventario() {
}

public inventario(Integer id, @NotEmpty @Size(min = 2, max = 60) String tipoUnidad, Boolean estado,
        List<yeilux.com.proyecto.Model.Class.inventario.insumo.salida> salida,
        List<yeilux.com.proyecto.Model.Class.inventario.insumo.entrada> entrada,
        yeilux.com.proyecto.Model.Class.insumo.insumo insumo) {
    this.id = id;
    this.tipoUnidad = tipoUnidad;
    this.estado = estado;
    this.salida = salida;
    this.entrada = entrada;
    this.insumo = insumo;
}

}
