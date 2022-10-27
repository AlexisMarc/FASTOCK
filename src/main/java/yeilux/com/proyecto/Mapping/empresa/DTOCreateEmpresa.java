package yeilux.com.proyecto.Mapping.empresa;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class DTOCreateEmpresa {
    // -----------------------ID-----------------------//
    private Integer id;
    // -----------------------NOMBRE-----------------------//
    @NotEmpty(message = "El nombre no debe estar vacío")
    @Size(min = 2, max = 60, message = "El nombre debe tener entre 2 y 60 carcateres")
    private String nombre;
    // -----------------------NOMBRE CONTACTO-----------------------//
    @NotEmpty(message = "El nombre del contacto no debe estar vacío")
    @Size(min = 2, max = 60, message = "El nombre de contacto debe tener entre 2 y 60 carcateres")
    private String contacto;
    // ----------------------- TELEFONO-----------------------//
    @NotNull(message = "El telefono no debe estar vacío")
    private Long telefono;
    // -----------------------DIRECCION-----------------------//
    @NotEmpty(message = "La dirección no debe estar vacía")
    @Size(min = 2, max = 100, message = "La dirección debe tener entre 2 y 100 carcateres")
    private String direccion;
    // -----------------------EMAIL-----------------------//
    @NotEmpty(message = "El email no debe estar vacío")
    @Email(message = "El email no es valido")
    @Size(min = 6, max = 200, message = "El email debe tener entre 2 y 200 carcateres")
    private String email;
    // -----------------------IMAGEN-----------------------//
    private String imagen;
    // -----------------------ESTADO-----------------------//
    private Boolean estado;
    // ************************************************//
    // -------------Relacion con especialidad----------//
    // ************************************************//
    @NotNull(message = "La especialidad no debe estar vacía")
    private Integer especialidad;

    // ************************************************//
    // -------------Constructores---------------//
    // ************************************************//

    public DTOCreateEmpresa() {
    }

    

    public DTOCreateEmpresa(Integer id,
            @NotEmpty(message = "El nombre no debe estar vacío") @Size(min = 2, max = 60, message = "El nombre debe tener entre 2 y 60 carcateres") String nombre,
            @NotEmpty(message = "El nombre del contacto no debe estar vacío") @Size(min = 2, max = 60, message = "El nombre de contacto debe tener entre 2 y 60 carcateres") String contacto,
            @NotNull(message = "El telefono no debe estar vacío") Long telefono,
            @NotEmpty(message = "La dirección no debe estar vacía") @Size(min = 2, max = 100, message = "La dirección debe tener entre 2 y 100 carcateres") String direccion,
            @NotEmpty(message = "El email no debe estar vacío") @Email(message = "El email no es valido") @Size(min = 6, max = 200, message = "El email debe tener entre 2 y 200 carcateres") String email,
            String imagen, Boolean estado,
            @NotNull(message = "La especialidad no debe estar vacía") Integer especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.contacto = contacto;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
        this.imagen = imagen;
        this.estado = estado;
        this.especialidad = especialidad;
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

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Integer getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Integer especialidad) {
        this.especialidad = especialidad;
    }

}