package fastock.fastock.Mapping.usuario;

import java.util.List;

public class DTOusuario {
    // -----------------------ID-----------------------//
    private Integer id;

    // -----------------------Tipo Idenficacion-----------------------//
    private String tipo;
    
    // -----------------------Idenficacion-----------------------//
    private Long identificacion;
    
    // -----------------------Nombre-----------------------//
    private String nombre;

    // -----------------------Apellido-----------------------//
    private String apellido;

    // -----------------------Genero-----------------------//
    private String genero;

    // -----------------------Fecha de nacimiento-----------------------//
    private String fecha;

    // -----------------------Direccion-----------------------//
    private String direccion;

    // -----------------------Telefono-----------------------//
    private Long telefono;

    // -----------------------Email-----------------------//
    private String email;

    // -----------------------Estado-----------------------//
    private Boolean estado;

    // -----------------------Inicio-----------------------//
    private Boolean inicio;

     // ----------------------Imagen-----------------------//
    private String imagen;

    // ************************************************//
    // -------------Relacion con cargo-----------------//
    // ************************************************//
    private List<DTOcargo> cargo;

    

    public DTOusuario(Integer id, String tipo, Long identificacion, String nombre, String apellido, String genero,
            String fecha, String direccion, Long telefono, String email, Boolean estado, Boolean inicio, String imagen,
            List<DTOcargo> cargo) {
        this.id = id;
        this.tipo = tipo;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.fecha = fecha;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.estado = estado;
        this.inicio = inicio;
        this.imagen = imagen;
        this.cargo = cargo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public List<DTOcargo> getCargo() {
        return cargo;
    }

    public void setCargo(List<DTOcargo> cargo) {
        this.cargo = cargo;
    }
    

    public DTOusuario() {
    }

    public Boolean getInicio() {
        return inicio;
    }

    public void setInicio(Boolean inicio) {
        this.inicio = inicio;
    }

    // ************************************************//
    // ------------- CONSTRUCTORES/GETTERS AND ListTERS--------------//
    // ************************************************///
    

    
}
