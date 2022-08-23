package yeilux.com.proyecto.Model.Class.proveedor;

import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import yeilux.com.proyecto.Model.Class.insumo.insumo;

@Entity
@Table(name="proveedor")
public class proveedor {
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
    // -----------------------DIRECCION-----------------------//
    @NotEmpty
    @Column(length = 60)
    @Size(min = 2, max = 60)
    private String direccion;
// ----------------------- TELEFONO-----------------------//
    private Integer telefono;
// -----------------------EMAIL-----------------------//
    @NotEmpty
    @Email 
    @Column(length = 60)
    @Size(min = 6, max = 200)
    private String email;
// -----------------------ESTADO-----------------------//
    @Column(nullable = true)
    private Boolean estado;
// ************************************************//
// -------------Relacion con insumo----------------//
// ************************************************//
    
@OneToMany(mappedBy = "proveedor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
private List<insumo> insumo;
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

    public List<insumo> getInsumo() {
        return insumo;
    }

    public void setInsumo(List<insumo> insumo) {
        this.insumo = insumo;
    }

    public proveedor() {
    }

    public proveedor(Integer id, @NotEmpty @Size(min = 2, max = 60) String nombre,
            @NotEmpty @Size(min = 2, max = 60) String contacto, @NotEmpty @Size(min = 2, max = 60) String direccion,
            Integer telefono, @NotEmpty @Email @Size(min = 6, max = 200) String email, Boolean estado,
            List<yeilux.com.proyecto.Model.Class.insumo.insumo> insumo) {
        this.id = id;
        this.nombre = nombre;
        this.contacto = contacto;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.estado = estado;
        this.insumo = insumo;
    }
}
