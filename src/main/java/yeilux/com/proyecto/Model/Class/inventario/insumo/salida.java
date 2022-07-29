package yeilux.com.proyecto.Model.Class.inventario.insumo;

import jakarta.persistence.*;
import yeilux.com.proyecto.Model.Class.empleado.empleado;

@Entity
@Table(name="salida")
public class salida {
// -----------------------ID-----------------------//
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

// ************************************************//
// -------------Relacion con inventario------------//
// ************************************************//
    @ManyToOne(fetch = FetchType.LAZY)
    private inventario inventario;
// ************************************************//
// -------------Relacion con empleado--------------//
// ************************************************//
    @ManyToOne(fetch = FetchType.LAZY)
    private empleado empleado;
}
