package yeilux.com.proyecto.Model.Class.insumo;

import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name="tipo")
public class tipo {
// -----------------------ID-----------------------//
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
// ************************************************//
// -------------Relacion con Insumo----------------//
// ************************************************//
    @JoinTable(
        name = "tipo_insumo",
        joinColumns = @JoinColumn(name = "id_tipo", nullable = false),
        inverseJoinColumns = @JoinColumn(name="id_insumo", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private List<insumo> insumo;
}
