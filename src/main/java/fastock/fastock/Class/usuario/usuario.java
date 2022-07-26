package fastock.fastock.Class.usuario;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import fastock.fastock.Class.fabricacion.area;
import fastock.fastock.Class.fabricacion.fabricacion;
import fastock.fastock.Class.inventario.insumo.entrada;
import fastock.fastock.Class.inventario.insumo.salida;
import fastock.fastock.Class.inventario.producto.entradapro;
import fastock.fastock.Class.inventario.producto.salidapro;
import fastock.fastock.Utils.EnumGenero;
import fastock.fastock.Utils.EnumTipoIdentificacion;
import fastock.fastock.Class.fabricacion.produccion;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "usuario", uniqueConstraints = { @UniqueConstraint(columnNames = { "identificacion" }) })
public class usuario {
    // -----------------------ID-----------------------//
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    // -----------------------Idenficacion-----------------------//
    @NotNull(message = "La identificación no debe estar vacío")
    @Column(nullable = false)
    private Long identificacion;
    // -----------------------Nombre-----------------------//
    @NotEmpty(message = "El nombre no debe estar vacío")
    @Column(length = 60, nullable = false)
    @Size(min = 2, max = 60, message = "El nombre debe tener entre 2 y 60 carcateres")
    private String nombre;

    // -----------------------Tipo de Identificacion-----------------------//
    @NotEmpty(message = "El tipo de Identificación no debe estar vacío")
    @Column(length = 60, nullable = false)
    @Enumerated(EnumType.STRING)
    @Size(min = 2, max = 30, message = "El tipo de Identificación debe tener entre 2 y 30 carcateres")
    private EnumTipoIdentificacion tipo;

    // -----------------------Apellido-----------------------//

    @NotEmpty(message = "El apellido no debe estar vacío")
    @Column(length = 60, nullable = false)
    @Size(min = 2, max = 60, message = "El nombre debe tener entre 2 y 60 carcateres")
    private String apellido;

    // -----------------------Genero-----------------------//
    @NotEmpty(message = "El género no debe estar vacío")
    @Column(length = 10, nullable = false)
    @Size(min = 2, message = "El género no debe tener mínimo 2 caracteres")
    @Enumerated(EnumType.STRING)
    private EnumGenero genero;

    // -----------------------Fecha de nacimiento-----------------------//
    @NotEmpty(message = "La fecha de nacimiento no debe estar vacío")
    @Column(length = 12, nullable = false)
    private String fecha;

    // -----------------------Direccion-----------------------//

    @NotEmpty(message = "La dirección no debe estar vacío")
    @Column(length = 100, nullable = false)
    @Size(min = 2, max = 100, message = "La dirección debe tener entre 2 y 100 carcateres")
    private String direccion;

    // -----------------------Telefono-----------------------//
    @NotNull(message = "El número teléfono no debe estar vacío")
    @Column(nullable = false)
    private Long telefono;

    // -----------------------Email-----------------------//
    @NaturalId
    @NotEmpty(message = "EL Email no debe estar vacío")
    @Email(message = "EL Email no valido")
    @Column(length = 200, nullable = false, unique = true)
    @Size(min = 4, max = 200, message = "La dirección debe tener entre 4 y 200 carcateres")
    private String userName;

    // -----------------------Password-----------------------//
    @NotNull
    private String password;

    // -----------------------IMAGEN-----------------------//
    @Column(length = 200)
    private String imagen;

    // -----------------------Estado-----------------------//
    @Column(nullable = false)
    private Boolean estado;

    // -----------------------Inicio-----------------------//
    @Column(nullable = false)
    private Boolean inicio;

    // -----------------------Inicio-----------------------//
    @Column(nullable = false)
    private Boolean verificacion;

    // ************************************************//
    // -------------Relacion con fabricacion-----------//
    // ************************************************//
    @ManyToMany
    @JsonIgnoreProperties(value = "fabricacion_usuario")
    @JoinTable(name = "fabricacion_usuario", joinColumns = @JoinColumn(name = "id_fabricacion", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_usuario", referencedColumnName = "id"))
    private Set<fabricacion> fabricacion = new HashSet<>();

    // ************************************************//
    // -------------Relacion con cargo-----------------//
    // ************************************************//
    @ManyToMany(fetch = FetchType.EAGER)
    @JsonManagedReference(value = "usuario_cargo")
    @JoinTable(name = "usuario_cargo", joinColumns = @JoinColumn(name = "id_usuario", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_cargo", referencedColumnName = "id"))
    private Set<cargo> cargo = new HashSet<>();

    // ************************************************//
    // -------------Relacion con area------------------//
    // ************************************************//

    @ManyToMany
    @JsonIgnoreProperties(value = "area_usuario")
    @JoinTable(name = "area_usuario", joinColumns = @JoinColumn(name = "id_area", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_usuario", referencedColumnName = "id"))
    private Set<area> area = new HashSet<>();

    // ************************************************//
    // -------------Relacion con entrada---------------//
    // ************************************************//
    @JsonManagedReference(value = "usuario_entrada")
    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<entrada> entrada = new HashSet<>();
    // ************************************************//
    // -------------Relacion con entradapro------------//
    // ************************************************//
    @JsonManagedReference(value = "usuario_entradapro")
    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<entradapro> entradapro = new HashSet<>();
    // ************************************************//
    // -------------Relacion con salida---------------//
    // ************************************************//
    @JsonManagedReference(value = "usuario_salida")
    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<salida> salida = new HashSet<>();
    // ************************************************//
    // -------------Relacion con salidapro------------//
    // ************************************************//
    @JsonManagedReference(value = "usuario_salidapro")
    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<salidapro> salidapro = new HashSet<>();

    // ************************************************//
    // -------------Relacion con produccion------------//
    // ************************************************//
    @JsonManagedReference(value = "usuario_produccion")
    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<produccion> produccion = new HashSet<>();

    // ************************************************//
    // ------------- CONSTRUCTORES/GETTERS AND SETTERS--------------//
    // ************************************************//
    public usuario() {
    }

    public usuario(Integer id, @NotNull(message = "La identificación no debe estar vacío") Long identificacion,
            @NotEmpty(message = "El nombre no debe estar vacío") @Size(min = 2, max = 60, message = "El nombre debe tener entre 2 y 60 carcateres") String nombre,
            @NotEmpty(message = "El tipo de Identificación no debe estar vacío") @Size(min = 2, max = 30, message = "El tipo de Identificación debe tener entre 2 y 30 carcateres") EnumTipoIdentificacion tipo,
            @NotEmpty(message = "El apellido no debe estar vacío") @Size(min = 2, max = 60, message = "El nombre debe tener entre 2 y 60 carcateres") String apellido,
            @NotEmpty(message = "El género no debe estar vacío") @Size(min = 2, message = "El género no debe tener mínimo 2 caracteres") EnumGenero genero,
            @NotEmpty(message = "La fecha de nacimiento no debe estar vacío") String fecha,
            @NotEmpty(message = "La dirección no debe estar vacío") @Size(min = 2, max = 100, message = "La dirección debe tener entre 2 y 100 carcateres") String direccion,
            @NotNull(message = "El número teléfono no debe estar vacío") Long telefono,
            @NotEmpty(message = "EL Email no debe estar vacío") @Email(message = "EL Email no valido") @Size(min = 4, max = 200, message = "La dirección debe tener entre 4 y 200 carcateres") String userName,
            @NotNull String password, String imagen, Boolean estado, Boolean inicio, Boolean verificacion,
            Set<fabricacion> fabricacion,
            Set<cargo> cargo, Set<area> area,
            Set<entrada> entrada,
            Set<entradapro> entradapro,
            Set<salida> salida,
            Set<salidapro> salidapro,
            Set<produccion> produccion) {
        this.id = id;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.tipo = tipo;
        this.apellido = apellido;
        this.genero = genero;
        this.fecha = fecha;
        this.direccion = direccion;
        this.telefono = telefono;
        this.userName = userName;
        this.password = password;
        this.imagen = imagen;
        this.estado = estado;
        this.inicio = inicio;
        this.verificacion = verificacion;
        this.fabricacion = fabricacion;
        this.cargo = cargo;
        this.area = area;
        this.entrada = entrada;
        this.entradapro = entradapro;
        this.salida = salida;
        this.salidapro = salidapro;
        this.produccion = produccion;
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

    public EnumGenero getGenero() {
        return genero;
    }

    public void setGenero(EnumGenero genero) {
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Set<fabricacion> getFabricacion() {
        return fabricacion;
    }

    public void setFabricacion(Set<fabricacion> fabricacion) {
        this.fabricacion = fabricacion;
    }

    public Set<cargo> getCargo() {
        return cargo;
    }

    public void setCargo(Set<cargo> cargo) {
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

    public Set<produccion> getProduccion() {
        return produccion;
    }

    public void setProduccion(Set<produccion> produccion) {
        this.produccion = produccion;
    }

    public EnumTipoIdentificacion getTipo() {
        return tipo;
    }

    public void setTipo(EnumTipoIdentificacion tipo) {
        this.tipo = tipo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Boolean getInicio() {
        return inicio;
    }

    public void setInicio(Boolean inicio) {
        this.inicio = inicio;
    }

    public Boolean getVerificacion() {
        return verificacion;
    }

    public void setVerificacion(Boolean verificacion) {
        this.verificacion = verificacion;
    }

    

}
