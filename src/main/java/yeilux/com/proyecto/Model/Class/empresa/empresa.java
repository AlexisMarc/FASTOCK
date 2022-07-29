package yeilux.com.proyecto.Model.Class.empresa;

import java.util.List;

import jakarta.persistence.*;
import yeilux.com.proyecto.Model.Class.fabricacion.area;

@Entity
@Table(name="empresa")
public class empresa {
// -----------------------ID-----------------------//
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

// ************************************************//
// -------------Relacion con especialidad----------//
// ************************************************//
    @ManyToOne(fetch = FetchType.LAZY)
    private especialidad especialidad;
// ************************************************//
// -------------Relacion con area------------------//
// ************************************************//
    @ManyToMany(mappedBy = "empresa")
    private List<area> area;
}
