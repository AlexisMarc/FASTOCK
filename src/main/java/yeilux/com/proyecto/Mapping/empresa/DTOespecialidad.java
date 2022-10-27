package yeilux.com.proyecto.Mapping.empresa;

public class DTOespecialidad {
    // -----------------------ID-----------------------//
    private Integer id;
    // --------------------NOMBRE-------------------//
    private String nombre;
    // ----------------------DESCRIPCION-----------------//
    private String descripcion;

    // --------------Estado---------------//
    private Boolean estado;
    // ************************************************//
    // -------------Relacion con empresa---------------//
    // ************************************************//

    // ************************************************//
    // -------------Constructores---------------//
    // ************************************************//
    public DTOespecialidad() {
    }

    public DTOespecialidad(Integer id, String nombre, String descripcion, Boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

  
    

}