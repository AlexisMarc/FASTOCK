package yeilux.com.proyecto.Class.empresa;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import yeilux.com.proyecto.Class.fabricacion.area;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "empresa")
public class empresa {
    // -----------------------ID-----------------------//
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    // -----------------------NOMBRE-----------------------//
    @NotEmpty(message = "El nombre no debe estar vacío")
    @Column(length = 60, nullable = false)
    @Size(min = 2, max = 60, message = "El nombre debe tener entre 2 y 60 carcateres")
    private String nombre;
    // -----------------------NOMBRE CONTACTO-----------------------//
    @NotEmpty(message = "El nombre del contacto no debe estar vacío")
    @Column(length = 60, nullable = false)
    @Size(min = 2, max = 60, message = "El nombre de contacto debe tener entre 2 y 60 carcateres")
    private String contacto;
    // ----------------------- TELEFONO-----------------------//
    @NotNull(message = "El telefono no debe estar vacío")
    private Long telefono;
    // -----------------------DIRECCION-----------------------//
    @NotEmpty(message = "La dirección no debe estar vacía")
    @Column(length = 100, nullable = false)
    @Size(min = 2, max = 100, message = "La dirección debe tener entre 2 y 100 carcateres")
    private String direccion;
    // -----------------------EMAIL-----------------------//
    @NotEmpty(message = "El email no debe estar vacío")
    @Email(message = "El email no es valido")
    @Column(length = 60, nullable = false)
    @Size(min = 6, max = 200, message = "El email debe tener entre 2 y 200 carcateres")
    private String email;
    // -----------------------IMAGEN-----------------------//
    @Column(length = 200)
    private String imagen;
    // -----------------------ESTADO-----------------------//
    @Column(nullable = false)
    private Boolean estado;
    // ************************************************//
    // -------------Relacion con especialidad----------//
    // ************************************************//
    @JsonBackReference(value = "especialidad_empresa")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "especialidad_id")
    @JsonProperty(access = Access.WRITE_ONLY)
    private especialidad especialidad;
    // ************************************************//
    // -------------Relacion con area------------------//
    // ************************************************//
    @JsonIgnoreProperties(value = "area_empresa")
    @ManyToMany
    @JoinTable(name = "area_empresa", joinColumns = @JoinColumn(name = "id_area", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_empresa", referencedColumnName = "id"))
    private Set<area> area = new HashSet<>();

    // ************************************************//
    // -------------Constructores---------------//
    // ************************************************//
    public empresa() {
    }

    public empresa(Integer id,
            @NotEmpty(message = "El nombre no debe estar vacío") @Size(min = 2, max = 60, message = "El nombre debe tener entre 2 y 60 carcateres") String nombre,
            @NotEmpty(message = "El nombre del contacto no debe estar vacío") @Size(min = 2, max = 60, message = "El nombre de contacto debe tener entre 2 y 60 carcateres") String contacto,
            @NotNull(message = "El telefono no debe estar vacío") Long telefono,
            @NotEmpty(message = "La dirección no debe estar vacía") @Size(min = 2, max = 100, message = "La dirección debe tener entre 2 y 100 carcateres") String direccion,
            @NotEmpty(message = "El email no debe estar vacío") @Email(message = "El email no es valido") @Size(min = 6, max = 200, message = "El email debe tener entre 2 y 200 carcateres") String email,
            String imagen, Boolean estado, yeilux.com.proyecto.Class.empresa.especialidad especialidad,
            Set<yeilux.com.proyecto.Class.fabricacion.area> area) {
        this.id = id;
        this.nombre = nombre;
        this.contacto = contacto;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
        this.imagen = imagen;
        this.estado = estado;
        this.especialidad = especialidad;
        this.area = area;
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

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public Set<area> getArea() {
        return area;
    }

    public void setArea(Set<area> area) {
        this.area = area;
    }

}
