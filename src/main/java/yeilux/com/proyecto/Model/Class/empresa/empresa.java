package yeilux.com.proyecto.Model.Class.empresa;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import yeilux.com.proyecto.Model.Class.fabricacion.area;

@Entity
@Table(name = "empresa")
public class empresa {
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
    // -----------------------NOMBRE CONTACTO-----------------------//
    @NotEmpty
    @Column(length = 60)
    @Size(min = 2, max = 60)
    private String contacto;
    // ----------------------- TELEFONO-----------------------//
    @NotNull
    private Long telefono;
    // -----------------------DIRECCION-----------------------//
    @NotEmpty
    @Column(length = 60)
    @Size(min = 2, max = 60)
    private String direccion;
    // -----------------------EMAIL-----------------------//
    @NotEmpty
    @Email
    @Column(length = 60)
    @Size(min = 6, max = 200)
    private String email;
    // -----------------------ESTADO-----------------------//
    @Column(nullable = false)
    private Boolean estado = true;
    // ************************************************//
    // -------------Relacion con especialidad----------//
    // ************************************************//
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "especialidad_id")
    @JsonProperty(access = Access.WRITE_ONLY)
    private especialidad especialidad;
    // ************************************************//
    // -------------Relacion con area------------------//
    // ************************************************//
    @ManyToMany
    @JoinTable(name = "area_empresa", joinColumns = @JoinColumn(name = "id_area", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_empresa", referencedColumnName = "id"))
    private Set<area> area = new HashSet<>();

    // ************************************************//
    // -------------Constructores---------------//
    // ************************************************//

}
