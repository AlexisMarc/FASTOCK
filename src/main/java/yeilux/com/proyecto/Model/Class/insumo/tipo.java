package yeilux.com.proyecto.Model.Class.insumo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="tipo")
public class tipo {
// -----------------------ID-----------------------//
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
// --------------------NOMBRE-----------------------//
    @NotEmpty
    @Column(length = 60)
    @Size(min = 2, max = 60)
    private String nombre;
// ----------------DESCRIPCIÓN-----------------------//
    @NotEmpty
    @Column(length = 200)
    @Size(min = 0, max = 200)
    private String descripcion;
    //--------------Estado---------------//
    @Column(nullable=true)
    private Boolean estado;
// ************************************************//
// -------------Relacion con Insumo----------------//
// ************************************************//
@ManyToMany
@JoinTable(
    name = "insumo_tipo",
    joinColumns = @JoinColumn(name = "id_insumo", referencedColumnName = "id"), 
    inverseJoinColumns = @JoinColumn(name = "id_tipo", referencedColumnName = "id"))
private Set<insumo> insumo = new HashSet<>();
// ************************************************//
// -------------GETTERS AND SETTERS/CONSTRUCTORES----------------//
// ************************************************//

}

