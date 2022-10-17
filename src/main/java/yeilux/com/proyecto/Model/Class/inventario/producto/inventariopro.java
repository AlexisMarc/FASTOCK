package yeilux.com.proyecto.Model.Class.inventario.producto;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import javax.persistence.*;
import yeilux.com.proyecto.Model.Class.producto.producto;

@Entity
@Table(name = "inventariopro")
public class inventariopro {

    // -----------------------ID-----------------------//
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    // -----------------------ESTADO-----------------------//
    @Column(nullable = true)
    private Boolean estado;

    // ************************************************//
    // -------------Relacion con salida----------------//
    // ************************************************//
    @OneToMany(mappedBy = "inventario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
private Set<salidapro> salida = new HashSet<>();
    // ************************************************//
    // -------------Relacion con entrada---------------//
    // ************************************************//
    @OneToMany(mappedBy = "inventario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
private Set<entradapro> entrada = new HashSet<>();
    // ************************************************//
    // -------------Relacion con producto--------------//
    // ************************************************//
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "producto_id")
	@JsonProperty(access = Access.WRITE_ONLY)
	private producto producto;

    
    

    // ************************************************//
    // -------------Contructores accesores--------------//
    // ************************************************//


}
