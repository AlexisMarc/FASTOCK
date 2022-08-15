package yeilux.com.proyecto.Model.Class.insumo;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

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
// ************************************************//
// -------------GETTERS AND SETTERS/CONSTRUCTORES----------------//
// ************************************************//
public Integer getId() {
    return id;
}
public void setId(Integer id) {
    this.id = id;
}
public String getNombre() {
    return nombre;
}
public void setNombre(String nombre) {
    this.nombre = nombre;
}
public String getDescripcion() {
    return descripcion;
}
public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
}
public List<insumo> getInsumo() {
    return insumo;
}
public void setInsumo(List<insumo> insumo) {
    this.insumo = insumo;
}
// -------------CONSTRUCTORES----------------//
public tipo(){
    insumo=new ArrayList<insumo>();
}
public tipo(Integer id, @NotEmpty @Size(min = 2, max = 60) String nombre,
        @NotEmpty @Size(min = 0, max = 200) String descripcion,
        List<yeilux.com.proyecto.Model.Class.insumo.insumo> insumo) {
    this.id = id;
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.insumo = insumo;
}

}

