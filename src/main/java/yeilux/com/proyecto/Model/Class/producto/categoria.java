package yeilux.com.proyecto.Model.Class.producto;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="categoria")
public class categoria {
// -----------------------ID-----------------------//
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

// ************************************************//
// -------------Relacion con producto--------------//
// ************************************************//
    @JoinTable(
        name = "categoria_producto",
        joinColumns = @JoinColumn(name = "id_categoria", nullable = false),
        inverseJoinColumns = @JoinColumn(name="id_producto", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private List<producto> producto;
}
