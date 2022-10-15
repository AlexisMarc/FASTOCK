package yeilux.com.proyecto.Model.Class.inventario.insumo;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

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


}
