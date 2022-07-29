package yeilux.com.proyecto.Model.Class.fabricacion;

import java.util.List;

import jakarta.persistence.*;
import yeilux.com.proyecto.Model.Class.empleado.admin;
import yeilux.com.proyecto.Model.Class.insumo.insumo;
import yeilux.com.proyecto.Model.Class.producto.producto;

@Entity
@Table(name="fabricacion")
public class fabricacion {
    // -----------------------ID-----------------------//
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

// ************************************************//
// -------------Relacion con area------------------//
// ************************************************//
    @OneToMany(mappedBy = "fabricacion", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        private List<area> area;
    
// ************************************************//
// -------------Relacion con admin----------------//
// ************************************************//
    @JoinTable(
        name = "fabricacion_admin",
        joinColumns = @JoinColumn(name = "id_fabricacion", nullable = false),
        inverseJoinColumns = @JoinColumn(name="id_admin", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private List<admin> admin;
// ************************************************//
// -------------Relacion con insumo----------------//
// ************************************************//
    @JoinTable(
        name = "fabricacion_insumo",
        joinColumns = @JoinColumn(name = "id_fabricacion", nullable = false),
        inverseJoinColumns = @JoinColumn(name="id_insumo", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private List<insumo> insumo;
// ************************************************//
// -------------Relacion con producto--------------//
// ************************************************//
    @JoinTable(
        name = "fabricacion_producto",
        joinColumns = @JoinColumn(name = "id_fabricacion", nullable = false),
        inverseJoinColumns = @JoinColumn(name="id_producto", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private List<producto> producto;
}
