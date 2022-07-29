package yeilux.com.proyecto.Model.Class.empleado;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="cargo")
public class cargo {
// -----------------------ID-----------------------//
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

// ************************************************//
// -------------Relacion con empleado--------------//
// ************************************************//
@OneToMany(mappedBy = "cargo", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
private List<empleado> empleado;
}
