package fastock.fastock.Class.proveedor;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import fastock.fastock.Class.insumo.insumo;

@Entity
@Table(name = "proveedor")
public class proveedor {
    // -----------------------ID-----------------------//
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    // -----------------------NOMBRE-----------------------//
    @NotEmpty(message = "El nombre no debe estar vacío")
    @Column(length = 60, nullable = false)
    @Size(min = 2, max = 60, message = "El nombre debe tener entre 2 y 60 caracteres")
    private String nombre;
    // -----------------------NOMBRE CONTACTO-----------------------//
    @NotEmpty(message = "El nombre del contacto no debe estar vacío")
    @Column(length = 60, nullable = false)
    @Size(min = 2, max = 60, message = "El nombre del contacto debe tener entre 2 y 60 caracteres")
    private String contacto;
    // -----------------------DIRECCION-----------------------//
    @NotEmpty(message = "La dirección no debe estar vacío")
    @Column(length = 60, nullable = false)
    @Size(min = 2, max = 60, message = "La dirección debe tener entre 2 y 60 caracteres")
    private String direccion;
    // ----------------------- TELEFONO-----------------------//
    @NotNull(message = "El teléfono no debe estar vacío")
    private Long telefono;
    // -----------------------EMAIL-----------------------//
    @NotEmpty(message = "El email no debe estar vacío")
    @Email(message = "El email no es valido")
    @Column(length = 200, nullable = false)
    @Size(min = 6, max = 200, message = "El email debe tener entre 6 y 200 caracteres")
    private String email;
    // -----------------------ESTADO-----------------------//
    @Column(nullable = false)
    private Boolean estado;
    // ************************************************//
    // -------------Relacion con insumo----------------//
    // ************************************************//
    @JsonManagedReference(value = "insumo_proveedor")
    @OneToMany(mappedBy = "proveedor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<insumo> insumo = new HashSet<>();
    // ************************************************//
    // -------------Constructores---------------//
    // ************************************************//

    public proveedor() {
    }

    public proveedor(Integer id,
            @NotEmpty(message = "El nombre no debe estar vacío") @Size(min = 2, max = 60, message = "El nombre debe tener entre 2 y 60 caracteres") String nombre,
            @NotEmpty(message = "El nombre del contacto no debe estar vacío") @Size(min = 2, max = 60, message = "El nombre del contacto debe tener entre 2 y 60 caracteres") String contacto,
            @NotEmpty(message = "La dirección no debe estar vacío") @Size(min = 2, max = 60, message = "La dirección debe tener entre 2 y 60 caracteres") String direccion,
            @NotNull(message = "El teléfono no debe estar vacío") Long telefono,
            @NotEmpty(message = "El email no debe estar vacío") @Email(message = "El email no es valido") @Size(min = 6, max = 200, message = "El email debe tener entre 6 y 200 caracteres") String email,
            Boolean estado, Set<insumo> insumo) {
        this.id = id;
        this.nombre = nombre;
        this.contacto = contacto;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.estado = estado;
        this.insumo = insumo;
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

    public Set<insumo> getInsumo() {
        return insumo;
    }

    public void setInsumo(Set<insumo> insumo) {
        this.insumo = insumo;
    }

}
