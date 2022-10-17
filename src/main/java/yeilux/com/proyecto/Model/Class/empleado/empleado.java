package yeilux.com.proyecto.Model.Class.empleado;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import yeilux.com.proyecto.Model.Class.fabricacion.area;
import yeilux.com.proyecto.Model.Class.inventario.insumo.entrada;
import yeilux.com.proyecto.Model.Class.inventario.insumo.salida;
import yeilux.com.proyecto.Model.Class.inventario.producto.entradapro;
import yeilux.com.proyecto.Model.Class.inventario.producto.salidapro;

@Entity
@Table(name="empleado",uniqueConstraints = {@UniqueConstraint(columnNames = {"identificacion"})})
public class empleado {
// -----------------------ID-----------------------//
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

// -----------------------Idenficacion-----------------------//
    @NotNull
    private Long identificacion;
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
    @NotNull
    private Long telefono;

// -----------------------Email-----------------------//

    @NotEmpty
    @Email
    @Column (length = 200)
    @Size (min = 1, max = 200)
    private String email; 

// -----------------------Estado-----------------------//
@Column(nullable = false)
private Boolean estado=true;

// ************************************************//
// -------------Relacion con cargo-----------------//
// ************************************************//

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "cargo_id")
	@JsonProperty(access = Access.WRITE_ONLY)
	private cargo cargo;

// ************************************************//
// -------------Relacion con area------------------//
// ************************************************//

@ManyToMany
@JsonBackReference
@JoinTable(
    name = "area_empleado",
    joinColumns = @JoinColumn(name = "id_area", referencedColumnName = "id"), 
    inverseJoinColumns = @JoinColumn(name = "id_empleado", referencedColumnName = "id"))
private Set<area> area = new HashSet<>();

// ************************************************//
// -------------Relacion con entrada---------------//
// ************************************************//

@OneToMany(mappedBy = "empleado", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
private Set<entrada> entrada = new HashSet<>();
// ************************************************//
// -------------Relacion con entradapro------------//
// ************************************************//

@OneToMany(mappedBy = "empleado", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
private Set<entradapro> entradapro = new HashSet<>();
// ************************************************//
// -------------Relacion con salida---------------//
// ************************************************//

@OneToMany(mappedBy = "empleado", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
private Set<salida> salida = new HashSet<>();
// ************************************************//
// -------------Relacion con salidapro------------//
// ************************************************//

@OneToMany(mappedBy = "empleado", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
private Set<salidapro> salidapro = new HashSet<>();
 // ************************************************//
// ------------- CONSTRUCTORES/GETTERS AND SETTERS--------------//
// ************************************************//
public empleado() {
}
public empleado(Integer id, @NotNull Long identificacion, @NotEmpty @Size(min = 2, max = 60) String nombre,
        @NotEmpty @Size(min = 2, max = 60) String apellido, @NotEmpty @Size(min = 2, max = 10) String genero,
        @NotEmpty String fecha, @NotEmpty @Size(min = 2, max = 60) String direccion, @NotNull Long telefono,
        @NotEmpty @Email @Size(min = 1, max = 200) String email, Boolean estado,
        yeilux.com.proyecto.Model.Class.empleado.cargo cargo,
        Set<yeilux.com.proyecto.Model.Class.fabricacion.area> area,
        Set<yeilux.com.proyecto.Model.Class.inventario.insumo.entrada> entrada,
        Set<yeilux.com.proyecto.Model.Class.inventario.producto.entradapro> entradapro,
        Set<yeilux.com.proyecto.Model.Class.inventario.insumo.salida> salida,
        Set<yeilux.com.proyecto.Model.Class.inventario.producto.salidapro> salidapro) {
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
    this.cargo = cargo;
    this.area = area;
    this.entrada = entrada;
    this.entradapro = entradapro;
    this.salida = salida;
    this.salidapro = salidapro;
}
public Integer getId() {
    return id;
}
public void setId(Integer id) {
    this.id = id;
}
public Long getIdentificacion() {
    return identificacion;
}
public void setIdentificacion(Long identificacion) {
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
public Long getTelefono() {
    return telefono;
}
public void setTelefono(Long telefono) {
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
public cargo getCargo() {
    return cargo;
}
public void setCargo(cargo cargo) {
    this.cargo = cargo;
}
public Set<area> getArea() {
    return area;
}
public void setArea(Set<area> area) {
    this.area = area;
}
public Set<entrada> getEntrada() {
    return entrada;
}
public void setEntrada(Set<entrada> entrada) {
    this.entrada = entrada;
}
public Set<entradapro> getEntradapro() {
    return entradapro;
}
public void setEntradapro(Set<entradapro> entradapro) {
    this.entradapro = entradapro;
}
public Set<salida> getSalida() {
    return salida;
}
public void setSalida(Set<salida> salida) {
    this.salida = salida;
}
public Set<salidapro> getSalidapro() {
    return salidapro;
}
public void setSalidapro(Set<salidapro> salidapro) {
    this.salidapro = salidapro;
}
    



}
