package yeilux.com.proyecto.Class.insumo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tipo")
public class tipo {
    // -----------------------ID-----------------------//
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    // --------------------NOMBRE-----------------------//
    @NotEmpty(message = "El tipo debe tener una longitud en 2 y 30 caracteres.")
    @Column(length = 30, nullable = false)
    @Size(min = 2, max = 30)
    private String nombre;
    // -----------------------FILTRO-----------------------//
    @NotEmpty(message = "No puede ser vacío.")
    @Column(length = 20, nullable = false)
    @Size(min = 2, max = 20)
    private String filtro;
    // --------------Estado---------------//
    @Column(nullable = true)
    private Boolean estado;
    // ************************************************//
    // -------------Relacion con Insumo----------------//
    // ************************************************//
    @JsonIgnoreProperties(value = "insumo_tipo")
    @ManyToMany
    @JoinTable(name = "insumo_tipo", joinColumns = @JoinColumn(name = "id_insumo", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_tipo", referencedColumnName = "id"))
    private Set<insumo> insumo = new HashSet<>();
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

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Set<insumo> getInsumo() {
        return insumo;
    }

    public void setInsumo(Set<insumo> insumo) {
        this.insumo = insumo;
    }

    public tipo() {
    }

    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }

    public tipo(Integer id,
            @NotEmpty(message = "El tipo debe tener una longitud en 2 y 30 caracteres.") @Size(min = 2, max = 30) String nombre,
            @NotEmpty(message = "No puede ser vacío.") @Size(min = 2, max = 20) String filtro, Boolean estado,
            Set<insumo> insumo) {
        this.id = id;
        this.nombre = nombre;
        this.filtro = filtro;
        this.estado = estado;
        this.insumo = insumo;
    }

}
