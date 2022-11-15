package fastock.fastock.Class.fabricacion;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import fastock.fastock.Class.empresa.empresa;
import fastock.fastock.Class.usuario.usuario;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "area")
public class area {
    // -----------------------ID-----------------------//
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    // -----------------------Nombre-----------------------//
    @NotEmpty(message = "El nombre no debe estar vacío")
    @Column(length = 60, nullable = false)
    @Size(min = 2, max = 60, message = "El nombre debe tener entre 2 y 30 caracteres")
    private String nombre;

    // -----------------------FECHA_INICIO-----------------------//
    @Column(length = 20, nullable = false)
    private String fechainicio;

    // -----------------------FECHA_FINAL-----------------------//
    @Column(length = 20, nullable = true)
    private String fechafinal;

    // ----------------------NUMERADOR---------------------//
    @NotNull(message = "El numerador no debe estar vacío")
    @Column(nullable = false)
    private Integer numerador;

    // -----------------------Estado-----------------------//
    @Column(nullable = false)
    private Boolean estado;

    // ************************************************//
    // -------------Relacion con fabricacion-----------//
    // ************************************************//
    @JsonBackReference(value = "fabricacion_area")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fabricacion_id")
    @JsonProperty(access = Access.WRITE_ONLY)
    private fabricacion fabricacion;
    // ************************************************//
    // -------------Relacion con produccion------------//
    // ************************************************//
    @JsonManagedReference(value = "area_produccion")
    @OneToMany(mappedBy = "area", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<produccion> produccion = new HashSet<>();
    // ************************************************//
    // -------------Relacion con usuario--------------//
    // ************************************************//
    @JsonIgnoreProperties(value = "area_usuario")
    @ManyToMany
    @JoinTable(name = "area_usuario", joinColumns = @JoinColumn(name = "id_area", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_usuario", referencedColumnName = "id"))
    private Set<usuario> usuario = new HashSet<>();
    // ************************************************//
    // -------------Relacion con empresa---------------//
    // ************************************************//
    @JsonIgnoreProperties(value = "area_empresa")
    @ManyToMany
    @JoinTable(name = "area_empresa", joinColumns = @JoinColumn(name = "id_area", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_empresa", referencedColumnName = "id"))
    private Set<empresa> empresa = new HashSet<>();

    public area() {
    }

    public area(Integer id,
            @NotEmpty(message = "El nombre no debe estar vacío") @Size(min = 2, max = 60, message = "El nombre debe tener entre 2 y 30 caracteres") String nombre,
            String fechainicio, String fechafinal,
            @NotNull(message = "El numerador no debe estar vacío") Integer numerador, Boolean estado,
            fabricacion fabricacion,
            Set<produccion> produccion,
            Set<usuario> usuario, Set<empresa> empresa) {
        this.id = id;
        this.nombre = nombre;
        this.fechainicio = fechainicio;
        this.fechafinal = fechafinal;
        this.numerador = numerador;
        this.estado = estado;
        this.fabricacion = fabricacion;
        this.produccion = produccion;
        this.usuario = usuario;
        this.empresa = empresa;
    }

    public Integer getNumerador() {
        return numerador;
    }

    public void setNumerador(Integer numerador) {
        this.numerador = numerador;
    }

    public Set<usuario> getUsuario() {
        return usuario;
    }

    public void setUsuario(Set<usuario> usuario) {
        this.usuario = usuario;
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

    public String getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(String fechainicio) {
        this.fechainicio = fechainicio;
    }

    public String getFechafinal() {
        return fechafinal;
    }

    public void setFechafinal(String fechafinal) {
        this.fechafinal = fechafinal;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public fabricacion getFabricacion() {
        return fabricacion;
    }

    public void setFabricacion(fabricacion fabricacion) {
        this.fabricacion = fabricacion;
    }

    public Set<produccion> getProduccion() {
        return produccion;
    }

    public void setProduccion(Set<produccion> produccion) {
        this.produccion = produccion;
    }

    public Set<usuario> getusuario() {
        return usuario;
    }

    public void setusuario(Set<usuario> usuario) {
        this.usuario = usuario;
    }

    public Set<empresa> getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Set<empresa> empresa) {
        this.empresa = empresa;
    }

}
