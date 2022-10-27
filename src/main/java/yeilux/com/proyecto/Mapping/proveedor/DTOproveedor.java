package yeilux.com.proyecto.Mapping.proveedor;

public class DTOproveedor {
    // -----------------------ID-----------------------//
    private Integer id;
    // -----------------------NOMBRE-----------------------//
    private String nombre;
    // -----------------------NOMBRE CONTACTO-----------------------//
    private String contacto;
    // -----------------------DIRECCION-----------------------//
    private String direccion;
    // ----------------------- TELEFONO-----------------------//
    private Long telefono;
    // -----------------------EMAIL-----------------------//
    private String email;
    // -----------------------ESTADO-----------------------//
    private Boolean estado;
    // ************************************************//
    // -------------Constructores---------------//
    // ************************************************//

    public DTOproveedor() {
    }

    public DTOproveedor(Integer id, String nombre, String contacto, String direccion, Long telefono, String email,
            Boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.contacto = contacto;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.estado = estado;
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

   
}
