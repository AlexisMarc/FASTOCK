package yeilux.com.proyecto.Model.Class.proveedor;

import java.util.List;

import jakarta.persistence.*;
import yeilux.com.proyecto.Model.Class.insumo.insumo;

@Entity
@Table(name="proveedor")
public class proveedor {
// -----------------------ID-----------------------//
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

// ************************************************//
// -------------Relacion con insumo----------------//
// ************************************************//
    
    @OneToMany(mappedBy = "proveedor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<insumo> insumo;
}
