package yeilux.com.proyecto.Model.Class.empresa;

import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import yeilux.com.proyecto.Model.Class.fabricacion.area;

@Entity
@Table(name="empresa")
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
    @NotNull
    private Boolean estado;
// ************************************************//
// -------------Relacion con especialidad----------//
// ************************************************//
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private especialidad especialidad;
// ************************************************//
// -------------Relacion con area------------------//
// ************************************************//
    @ManyToMany(mappedBy = "empresa", fetch = FetchType.LAZY)
    private List<area> area;
// ************************************************//
// -------------Constructores---------------//
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
    public List<area> getArea() {
        return area;
    }
    public void setArea(List<area> area) {
        this.area = area;
    }
    public empresa() {
    }
    public empresa(Integer id, @NotEmpty @Size(min = 2, max = 60) String nombre,
            @NotEmpty @Size(min = 2, max = 60) String contacto,@NotNull Long telefono,
            @NotEmpty @Size(min = 2, max = 60) String direccion,
            @NotEmpty @Email @Size(min = 6, max = 200) String email, @NotNull Boolean estado,
            @NotNull yeilux.com.proyecto.Model.Class.empresa.especialidad especialidad,
            List<yeilux.com.proyecto.Model.Class.fabricacion.area> area) {
        this.id = id;
        this.nombre = nombre;
        this.contacto = contacto;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
        this.estado = estado;
        this.especialidad = especialidad;
        this.area = area;
    }
}
