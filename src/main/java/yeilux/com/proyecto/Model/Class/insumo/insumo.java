package yeilux.com.proyecto.Model.Class.insumo;

import java.util.List;

import jakarta.persistence.*;
import yeilux.com.proyecto.Model.Class.fabricacion.fabricacion;
import yeilux.com.proyecto.Model.Class.inventario.insumo.inventario;
import yeilux.com.proyecto.Model.Class.proveedor.proveedor;

@Entity
@Table(name="insumo")
public class insumo {
// -----------------------ID-----------------------//
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
// ************************************************//
// -------------Relacion con tipo------------------//
// ************************************************//
    @ManyToMany(mappedBy = "insumo")
    private List<tipo> tipo;
// ************************************************//
// -------------Relacion con proveedor-------------//
// ************************************************//
    @ManyToOne(fetch = FetchType.LAZY)
    private proveedor proveedor;
// ************************************************//
// -------------Relacion con fabricacion-----------//
// ************************************************//
    @ManyToMany(mappedBy = "insumo")
    private List<fabricacion> fabricacion;
// ************************************************//
// -------------Relacion con inventario------------//
// ************************************************//
    @OneToMany(mappedBy = "insumo", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<inventario> inventario;
}
