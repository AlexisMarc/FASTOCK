package fastock.fastock.Mapping.usuario;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class DTOCreateUsuario {
    // -----------------------Idenficacion-----------------------//
    @NotNull(message = "La identificación no debe estar vacío")
    private Long identificacion;
    // -----------------------Nombre-----------------------//
    @NotEmpty(message = "El nombre no debe estar vacío")
    @Size(min = 2, max = 60, message = "El nombre debe tener entre 2 y 60 carcateres")
    private String nombre;

    // -----------------------Apellido-----------------------//

    @NotEmpty(message = "El apellido no debe estar vacío")
    @Size(min = 2, max = 60, message = "El nombre debe tener entre 2 y 60 carcateres")
    private String apellido;

    // -----------------------Genero-----------------------//
    @NotEmpty(message = "El género no debe estar vacío")
    @Size(min = 2, message = "El género no debe tener mínimo 2 caracteres")
    private String genero;

    // -----------------------Fecha de nacimiento-----------------------//
    @NotEmpty(message = "La fecha de nacimiento no debe estar vacío")
    private String fecha;

    // -----------------------Direccion-----------------------//

    @NotEmpty(message = "La dirección no debe estar vacío")
    @Size(min = 2, max = 100, message = "La dirección debe tener entre 2 y 100 carcateres")
    private String direccion;

    // -----------------------Telefono-----------------------//
    @NotNull(message = "El número teléfono no debe estar vacío")
    private Long telefono;

    // -----------------------Email-----------------------//

    @NotEmpty(message = "EL Email no debe estar vacío")
    @Email(message = "EL Email no valido")
    @Size(min = 4, max = 200, message = "La dirección debe tener entre 4 y 200 carcateres")
    private String email;

    // ************************************************//
    // -------------Relacion con cargo-----------------//
    // ************************************************//
    @NotNull(message = "El cargo no debe estar vacío")
    private List<Integer> cargo;

    public DTOCreateUsuario(@NotNull(message = "La identificación no debe estar vacío") Long identificacion,
            @NotEmpty(message = "El nombre no debe estar vacío") @Size(min = 2, max = 60, message = "El nombre debe tener entre 2 y 60 carcateres") String nombre,
            @NotEmpty(message = "El apellido no debe estar vacío") @Size(min = 2, max = 60, message = "El nombre debe tener entre 2 y 60 carcateres") String apellido,
            @NotEmpty(message = "El género no debe estar vacío") @Size(min = 2, message = "El género no debe tener mínimo 2 caracteres") String genero,
            @NotEmpty(message = "La fecha de nacimiento no debe estar vacío") String fecha,
            @NotEmpty(message = "La dirección no debe estar vacío") @Size(min = 2, max = 100, message = "La dirección debe tener entre 2 y 100 carcateres") String direccion,
            @NotNull(message = "El número teléfono no debe estar vacío") Long telefono,
            @NotEmpty(message = "EL Email no debe estar vacío") @Email(message = "EL Email no valido") @Size(min = 4, max = 200, message = "La dirección debe tener entre 4 y 200 carcateres") String email,
            @NotNull(message = "El cargo no debe estar vacío") List<Integer> cargo) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.fecha = fecha;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.cargo = cargo;
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

    public List<Integer> getCargo() {
        return cargo;
    }

    public void setCargo(List<Integer> cargo) {
        this.cargo = cargo;
    }

    public DTOCreateUsuario() {
    }


    
    // ************************************************//
    // ------------- CONSTRUCTORES/GETTERS AND SETTERS--------------//
    // ************************************************//
    

    
}
