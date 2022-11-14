package fastock.fastock.Mapping.empresa;

public class DTOempresa {
    // -----------------------ID-----------------------//
    private Integer id;
    // -----------------------NOMBRE-----------------------//
    private String nombre;
    // -----------------------NOMBRE CONTACTO-----------------------//
    private String contacto;
    // ----------------------- TELEFONO-----------------------//
    private Long telefono;
    // -----------------------DIRECCION-----------------------//
    private String direccion;
    // -----------------------EMAIL-----------------------//
    private String email;
    // -----------------------IMAGEN-----------------------//
    private String imagen;
    // -----------------------ESTADO-----------------------//
    private Boolean estado;
    // ************************************************//
    // -------------Relacion con especialidad----------//
    // ************************************************//
    private String especialidad;

    // ************************************************//
    // -------------Constructores---------------//
    // ************************************************//
    public DTOempresa() {
    }

    public DTOempresa(Integer id, String nombre, String contacto, Long telefono, String direccion, String email,
            String imagen, Boolean estado, String especialidad) {
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

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

   
    
}
