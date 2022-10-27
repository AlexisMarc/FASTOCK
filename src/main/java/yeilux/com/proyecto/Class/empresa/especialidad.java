package yeilux.com.proyecto.Class.empresa;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "especialidad")
public class especialidad {
    // -----------------------ID-----------------------//
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    // --------------------NOMBRE-------------------//
    @NotEmpty(message = "La especialidad no debe estar vacía.")
    @Column(length = 60, nullable = false)
    @Size(min = 2, max = 60, message = "La especialidad debe tener una longitud en 2 y 60 caracteres.")
    private String nombre;
    // ----------------------DESCRIPCION-----------------//
    @NotEmpty(message = "La descripción no debe estar vacía.")
    @Column(length = 200, nullable = false)
    @Size(min = 2, max = 200, message = "La descripción debe tener una longitud entre 2 y 200 carcateres.")
    private String descripcion;

    // --------------Estado---------------//
    @Column(nullable = true)
    private Boolean estado;
    // ************************************************//
    // -------------Relacion con empresa---------------//
    // ************************************************//
    @JsonManagedReference(value = "especialidad_empresa")
    @OneToMany(mappedBy = "especialidad", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<empresa> empresa = new HashSet<>();

    // ************************************************//
    // -------------Constructores---------------//
    // ************************************************//
    public especialidad() {
    }

    public especialidad(Integer id,
            @NotEmpty(message = "La especialidad no debe estar vacía.") @Size(min = 2, max = 60, message = "La especialidad debe tener una longitud en 2 y 60 caracteres.") String nombre,
            @NotEmpty(message = "La descripción no debe estar vacía.") @Size(min = 2, max = 200, message = "La descripción debe tener una longitud entre 2 y 200 carcateres.") String descripcion,
            Boolean estado, Set<yeilux.com.proyecto.Class.empresa.empresa> empresa) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
        this.empresa = empresa;
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

    public Set<empresa> getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Set<empresa> empresa) {
        this.empresa = empresa;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

}