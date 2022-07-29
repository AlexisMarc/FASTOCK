package yeilux.com.proyecto.Model.Class.inventario.producto;


import jakarta.persistence.*;
import yeilux.com.proyecto.Model.Class.empleado.empleado;

@Entity
@Table(name="entradapro")
public class entradapro {
    
// -----------------------ID-----------------------//
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

// ************************************************//
// -------------Relacion con inventario------------//
// ************************************************//
    @ManyToOne(fetch = FetchType.LAZY)
    private inventariopro inventario;

// ************************************************//
// -------------Relacion con empleado--------------//
// ************************************************//
    @ManyToOne(fetch = FetchType.LAZY)
    private empleado empleado;
}
