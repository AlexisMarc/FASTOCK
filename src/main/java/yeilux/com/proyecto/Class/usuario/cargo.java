package yeilux.com.proyecto.Class.usuario;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "cargo")
public class cargo {
    // -----------------------ID-----------------------//
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    // -----------------------NOMBRE-----------------------//
    @NotEmpty
    @Column(length = 60)
    @Size(min = 2, max = 60)
    private String nombre;

    // -----------------------DESCRIPCION-----------------------//
    @NotEmpty
    @Column(length = 200)
    @Size(min = 0, max = 200)
    private String descripcion;

    // ************************************************//
    // -------------Relacion con usuario--------------//
    // ************************************************//
    @ManyToMany
	@JsonIgnoreProperties(value = "usuario_cargo")
	@JoinTable(
        name = "usuario_cargo",
        joinColumns = @JoinColumn(name = "id_usuario", referencedColumnName = "id"), 
        inverseJoinColumns = @JoinColumn(name = "id_cargo", referencedColumnName = "id"))
	private Set<usuario> usuario = new HashSet<>();

    // ************************************************//
    // ------------- CONSTRUCTORES/GETTERS AND SETTERS--------------//
    // ************************************************//

    public cargo() {
    }

    public cargo(Integer id, @NotEmpty @Size(min = 2, max = 60) String nombre,
            @NotEmpty @Size(min = 0, max = 200) String descripcion,
            Set<usuario> usuario) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.usuario = usuario;
    }

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

    public Set<usuario> getusuario() {
        return usuario;
    }

    public void setusuario(Set<usuario> usuario) {
        this.usuario = usuario;
    }

}
