package fastock.fastock.Class.usuario;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "cargo")
public class cargo {
    // -----------------------ID-----------------------//
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    // -----------------------cargo-----------------------//
    @NotEmpty(message = "El cargo no debe estar vacío")
    @Column(length = 60, nullable = false)
    @Size(min = 2, max = 60, message = "El cargo debe tener entre 2 y 60 caracteres")
    private String cargo;

    // -----------------------Estado-----------------------//
    @Column(nullable = false)
    private Boolean estado;

    // ************************************************//
    // -------------Relacion con usuario--------------//
    // ************************************************//
    @ManyToMany
    @JsonBackReference(value = "usuario_cargo")
    @JoinTable(name = "usuario_cargo", 
    joinColumns = @JoinColumn(name = "id_usuario", referencedColumnName = "id"), 
    inverseJoinColumns = @JoinColumn(name = "id_cargo", referencedColumnName = "id"))
    private Set<usuario> usuario = new HashSet<>();

    // ************************************************//
    // -------------Relacion con privilegios--------------//
    // ************************************************//

    @ManyToMany(fetch = FetchType.EAGER)
    @JsonManagedReference(value = "privilegio_cargo")
    @JoinTable(
        name = "privilegio_cargo", 
        joinColumns = @JoinColumn(name = "id_cargo", referencedColumnName = "id"), 
        inverseJoinColumns = @JoinColumn(name = "id_privilegio", referencedColumnName = "id"))
    private Set<privilegios> privilegio = new HashSet<>();

    // ************************************************//
    // ------------- CONSTRUCTORES/GETTERS AND SETTERS--------------//
    // ************************************************//

    public cargo() {
    }

    
    public cargo(Integer id,
            @NotEmpty(message = "El cargo no debe estar vacío") @Size(min = 2, max = 60, message = "El cargo debe tener entre 2 y 60 caracteres") String cargo,
            Boolean estado, Set<fastock.fastock.Class.usuario.usuario> usuario, Set<privilegios> privilegio) {
        this.id = id;
        this.cargo = cargo;
        this.estado = estado;
        this.usuario = usuario;
        this.privilegio = privilegio;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Set<usuario> getUsuario() {
        return usuario;
    }

    public void setUsuario(Set<usuario> usuario) {
        this.usuario = usuario;
    }

    public Set<privilegios> getPrivilegio() {
        return privilegio;
    }

    public void setPrivilegio(Set<privilegios> privilegio) {
        this.privilegio = privilegio;
    }


    public Boolean getEstado() {
        return estado;
    }


    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    
}
