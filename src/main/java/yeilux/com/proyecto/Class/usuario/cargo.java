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
    @NotEmpty(message = "El nombre no debe estar vacío")
    @Column(length = 60, nullable = false)
    @Size(min = 2, max = 60, message = "El nombre debe tener entre 2 y 60 caracteres")
    private String nombre;

    // ************************************************//
    // -------------Relacion con usuario--------------//
    // ************************************************//
    @ManyToMany
    @JsonIgnoreProperties(value = "usuario_cargo")
    @JoinTable(name = "usuario_cargo", joinColumns = @JoinColumn(name = "id_usuario", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_cargo", referencedColumnName = "id"))
    private Set<usuario> usuario = new HashSet<>();

    // ************************************************//
    // ------------- CONSTRUCTORES/GETTERS AND SETTERS--------------//
    // ************************************************//

    public cargo() {
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

    public Set<usuario> getusuario() {
        return usuario;
    }

    public void setusuario(Set<usuario> usuario) {
        this.usuario = usuario;
    }

    public cargo(Integer id,
            @NotEmpty(message = "El nombre no debe estar vacío") @Size(min = 2, max = 60, message = "El nombre debe tener entre 2 y 60 caracteres") String nombre,
            Set<usuario> usuario) {
        this.id = id;
        this.nombre = nombre;
        this.usuario = usuario;
    }

}
