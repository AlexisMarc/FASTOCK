package yeilux.com.proyecto.Model.Class.inventario.producto;

import java.util.List;

import jakarta.persistence.*;
import yeilux.com.proyecto.Model.Class.producto.producto;

@Entity
@Table(name="inventariopro")
public class inventariopro {

// -----------------------ID-----------------------//
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
// ************************************************//
// -------------Relacion con salida----------------//
// ************************************************//
    @OneToMany(mappedBy = "inventario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<salidapro> salida;
// ************************************************//
// -------------Relacion con entrada---------------//
// ************************************************//
    @OneToMany(mappedBy = "inventario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<entradapro> entrada;
// ************************************************//
// -------------Relacion con producto--------------//
// ************************************************//
    @ManyToOne(fetch = FetchType.LAZY)
    private producto producto;
}
