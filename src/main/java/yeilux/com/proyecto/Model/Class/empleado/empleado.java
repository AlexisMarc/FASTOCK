package yeilux.com.proyecto.Model.Class.empleado;

import java.util.List;

import jakarta.persistence.*;
import yeilux.com.proyecto.Model.Class.fabricacion.area;
import yeilux.com.proyecto.Model.Class.inventario.insumo.entrada;
import yeilux.com.proyecto.Model.Class.inventario.insumo.salida;
import yeilux.com.proyecto.Model.Class.inventario.producto.entradapro;
import yeilux.com.proyecto.Model.Class.inventario.producto.salidapro;

@Entity
@Table(name="empleado")
public class empleado {
// -----------------------ID-----------------------//
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

// ************************************************//
// -------------Relacion con cargo-----------------//
// ************************************************//
    @ManyToOne(fetch = FetchType.LAZY)
    private cargo cargo;

// ************************************************//
// -------------Relacion con area------------------//
// ************************************************//
    @ManyToMany(mappedBy = "empleado")
    private List<area> area;

// ************************************************//
// -------------Relacion con entrada---------------//
// ************************************************//
    @OneToMany(mappedBy = "empleado", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<entrada> entrada;
// ************************************************//
// -------------Relacion con entradapro------------//
// ************************************************//
    @OneToMany(mappedBy = "empleado", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<entradapro> entradapro;
// ************************************************//
// -------------Relacion con salida---------------//
// ************************************************//
    @OneToMany(mappedBy = "empleado", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<salida> salida;
// ************************************************//
// -------------Relacion con salidapro------------//
// ************************************************//
    @OneToMany(mappedBy = "empleado", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<salidapro> salidapro;
}
