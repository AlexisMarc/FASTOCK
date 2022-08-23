package yeilux.com.proyecto.Model.Class.fabricacion;

import java.util.List;

import jakarta.persistence.*;
import yeilux.com.proyecto.Model.Class.empleado.empleado;
import yeilux.com.proyecto.Model.Class.empresa.empresa;

@Entity
@Table(name="area")
public class area {
// -----------------------ID-----------------------//
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

// ************************************************//
// -------------Relacion con fabricacion-----------//
// ************************************************//
    @ManyToOne(fetch = FetchType.LAZY)
    private fabricacion fabricacion;
// ************************************************//
// -------------Relacion con produccion------------//
// ************************************************//
    @OneToMany(mappedBy = "area", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<produccion> produccion;
// ************************************************//
// -------------Relacion con empleado--------------//
// ************************************************//
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "area_empleado",
        joinColumns = @JoinColumn(name = "id_area"),
        inverseJoinColumns = @JoinColumn(name="id_empleado")
    )
    private List<empleado> empleado;
// ************************************************//
// -------------Relacion con empresa---------------//
// ************************************************//
@ManyToMany(fetch = FetchType.LAZY)
@JoinTable(
    name = "area_empresa",
    joinColumns = @JoinColumn(name = "id_area"),
    inverseJoinColumns = @JoinColumn(name="id_empresa")
    )
    private List<empresa> empresa;
}
