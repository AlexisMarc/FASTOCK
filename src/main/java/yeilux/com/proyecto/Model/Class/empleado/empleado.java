package yeilux.com.proyecto.Model.Class.empleado;

import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import yeilux.com.proyecto.Model.Class.fabricacion.area;
import yeilux.com.proyecto.Model.Class.inventario.insumo.entrada;
import yeilux.com.proyecto.Model.Class.inventario.insumo.salida;
import yeilux.com.proyecto.Model.Class.inventario.producto.entradapro;
import yeilux.com.proyecto.Model.Class.inventario.producto.salidapro;

@Entity
@Table(name="empleado")
public class empleado {
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
// -------------Relacion con cargo-----------------//
// ************************************************//
    @ManyToOne(fetch = FetchType.LAZY)
    private cargo cargo;

// ************************************************//
// -------------Relacion con area------------------//
// ************************************************//
    @ManyToMany(mappedBy = "empleado", fetch = FetchType.LAZY)
    private List<area> area;

// ************************************************//
// -------------Relacion con entrada---------------//
// ************************************************//
    @OneToMany(mappedBy = "empleado", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<entrada> entrada;
// ************************************************//
// -------------Relacion con entradapro------------//
// ************************************************//
    @OneToMany(mappedBy = "empleado", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<entradapro> entradapro;
// ************************************************//
// -------------Relacion con salida---------------//
// ************************************************//
    @OneToMany(mappedBy = "empleado", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<salida> salida;
// ************************************************//
// -------------Relacion con salidapro------------//
// ************************************************//
    @OneToMany(mappedBy = "empleado", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<salidapro> salidapro;
    public Integer getId() {
        return id;
    }

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
    public cargo getCargo() {
        return cargo;
    }
    public void setCargo(cargo cargo) {
        this.cargo = cargo;
    }
    public List<area> getArea() {
        return area;
    }
    public void setArea(List<area> area) {
        this.area = area;
    }
    public List<entrada> getEntrada() {
        return entrada;
    }
    public void setEntrada(List<entrada> entrada) {
        this.entrada = entrada;
    }
    public List<entradapro> getEntradapro() {
        return entradapro;
    }
    public void setEntradapro(List<entradapro> entradapro) {
        this.entradapro = entradapro;
    }
    public List<salida> getSalida() {
        return salida;
    }
    public void setSalida(List<salida> salida) {
        this.salida = salida;
    }
    public List<salidapro> getSalidapro() {
        return salidapro;
    }
    public void setSalidapro(List<salidapro> salidapro) {
        this.salidapro = salidapro;
    }

    public empleado() {
    }

    public empleado(Integer id, Integer identificacion,
            @NotEmpty @Size(min = 2, max = 60) String nombre, @NotEmpty @Size(min = 2, max = 60) String apellido,
            @NotEmpty @Size(min = 2, max = 10) String genero, @NotEmpty String fecha,
            @NotEmpty @Size(min = 2, max = 60) String direccion,  Integer telefono,
            @NotEmpty @Email @Size(min = 1, max = 200) String email, Boolean estado,
            yeilux.com.proyecto.Model.Class.empleado.cargo cargo,
            List<yeilux.com.proyecto.Model.Class.fabricacion.area> area,
            List<yeilux.com.proyecto.Model.Class.inventario.insumo.entrada> entrada,
            List<yeilux.com.proyecto.Model.Class.inventario.producto.entradapro> entradapro,
            List<yeilux.com.proyecto.Model.Class.inventario.insumo.salida> salida,
            List<yeilux.com.proyecto.Model.Class.inventario.producto.salidapro> salidapro) {
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





}
