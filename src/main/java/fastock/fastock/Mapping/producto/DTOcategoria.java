package fastock.fastock.Mapping.producto;

public class DTOcategoria {
    // -----------------------ID-----------------------//
    private Integer id;

    // -----------------------NOMBRE-----------------------//
    private String nombre;

    // -----------------------ESTADO-----------------------//
    private Boolean estado;

    // ************************************************//
    // -------------Relacion con producto--------------//
    // ************************************************//
    // ************************************************//
    // -------------Contructores accesores--------------//
    // ************************************************//

    public DTOcategoria() {
    }

    public DTOcategoria(Integer id, String nombre, Boolean estado) {
        this.id = id;
        this.nombre = nombre;
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
    
    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }



}
