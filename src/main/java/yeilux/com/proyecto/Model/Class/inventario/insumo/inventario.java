package yeilux.com.proyecto.Model.Class.inventario.insumo;

import java.util.List;

import jakarta.persistence.*;
import yeilux.com.proyecto.Model.Class.insumo.insumo;

@Entity
@Table(name="inventario")
public class inventario {
// -----------------------ID-----------------------//
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
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
}
