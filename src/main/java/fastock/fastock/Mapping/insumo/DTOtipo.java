package fastock.fastock.Mapping.insumo;

public class DTOtipo {
    // -----------------------ID-----------------------//
    private Integer id;
    // --------------------NOMBRE-----------------------//
    private String nombre;
    // --------------Estado---------------//
    private Boolean estado;
    

    // ************************************************//
    // -------------Relacion con Insumo----------------//
    // ************************************************//
    // ************************************************//
    // -------------GETTERS AND SETTERS/CONSTRUCTORES----------------//
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
    public Boolean getEstado() {
        return estado;
    }
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    public DTOtipo(Integer id, String nombre, Boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
    }
    public DTOtipo() {
    }

    
}
