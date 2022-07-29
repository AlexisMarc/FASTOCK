package yeilux.com.proyecto.Model.Class.fabricacion;

import jakarta.persistence.*;

@Entity
@Table(name="produccion")
public class produccion {
// -----------------------ID-----------------------//
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

// ************************************************//
// -------------Relacion con area------------------//
// ************************************************//
    @ManyToOne(fetch = FetchType.LAZY)
    private area area;
}
