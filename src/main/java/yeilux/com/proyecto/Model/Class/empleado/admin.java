package yeilux.com.proyecto.Model.Class.empleado;

import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import yeilux.com.proyecto.Model.Class.fabricacion.fabricacion;

@Entity
@Table(name="admin")
public class admin {
// -----------------------ID-----------------------//
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    // -----------------------Idenficacion-----------------------//
    private Integer identificacion;
// -----------------------Nombre-----------------------//
    @NotEmpty
    @Column (length = 60)
    @Size (min = 2, max = 60)
    private String nombre;

// -----------------------Apellido-----------------------//

    @NotEmpty
    @Column (length = 60)
    @Size (min = 2, max = 60)
    private String apellido;  

// -----------------------Genero-----------------------//
    @NotEmpty
    @Column (length = 10)
    @Size (min = 2, max = 10)
    private String genero; 

// -----------------------Fecha de nacimiento-----------------------// 
    @NotEmpty
    @Column (length = 12)
    private String fecha;   

// -----------------------Direccion-----------------------//

    @NotEmpty
    @Column (length = 60)
    @Size (min = 2, max = 60)
    private String direccion;  

// -----------------------Telefono-----------------------//
    
    private Integer telefono;

// -----------------------Email-----------------------//

    @NotEmpty
    @Email
    @Column (length = 200)
    @Size (min = 1, max = 200)
    private String email; 

// -----------------------Estado-----------------------//
    @Column(nullable = true)
    private Boolean estado;

// ************************************************//
// -------------Relacion con fabricacion-----------//
// ************************************************//
    @ManyToMany(mappedBy = "admin", fetch = FetchType.LAZY)
    private List<fabricacion> fabricacion;

// ************************************************//
// ------------- CONSTRUCTORES/GETTERS AND SETTERS--------------//
// ************************************************//
public void setId(Integer id) {
    this.id = id;
}
public Integer getidentificacion() {
    return identificacion;
}
public void setidentificacion(Integer identificacion) {
    this.identificacion = identificacion;
}
public String getNombre() {
    return nombre;
}
public void setNombre(String nombre) {
    this.nombre = nombre;
}
public String getApellido() {
    return apellido;
}
public void setApellido(String apellido) {
    this.apellido = apellido;
}
public String getGenero() {
    return genero;
}
public void setGenero(String genero) {
    this.genero = genero;
}
public String getFecha() {
    return fecha;
}
public void setFecha(String fecha) {
    this.fecha = fecha;
}
public String getDireccion() {
    return direccion;
}
public void setDireccion(String direccion) {
    this.direccion = direccion;
}
public Integer getTelefono() {
    return telefono;
}
public void setTelefono(Integer telefono) {
    this.telefono = telefono;
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
public Integer getId() {
    return id;
}
public Integer getIdentificacion() {
    return identificacion;
}
public void setIdentificacion(Integer identificacion) {
    this.identificacion = identificacion;
}
public List<fabricacion> getFabricacion() {
    return fabricacion;
}
public void setFabricacion(List<fabricacion> fabricacion) {
    this.fabricacion = fabricacion;
}
public admin(Integer id, Integer identificacion, @NotEmpty @Size(min = 2, max = 60) String nombre,
        @NotEmpty @Size(min = 2, max = 60) String apellido, @NotEmpty @Size(min = 2, max = 10) String genero,
        @NotEmpty String fecha, @NotEmpty @Size(min = 2, max = 60) String direccion, Integer telefono,
        @NotEmpty @Email @Size(min = 1, max = 200) String email, Boolean estado,
        List<yeilux.com.proyecto.Model.Class.fabricacion.fabricacion> fabricacion) {
    this.id = id;
    this.identificacion = identificacion;
    this.nombre = nombre;
    this.apellido = apellido;
    this.genero = genero;
    this.fecha = fecha;
    this.direccion = direccion;
    this.telefono = telefono;
    this.email = email;
    this.estado = estado;
    this.fabricacion = fabricacion;
}
public admin() {
}



}