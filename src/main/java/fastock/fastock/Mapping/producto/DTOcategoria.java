package fastock.fastock.Mapping.producto;

public class DTOcategoria {
    // -----------------------ID-----------------------//
    private Integer id;

    // -----------------------NOMBRE-----------------------//
    private String nombre;

    // -----------------------FILTRO-----------------------//
    private String filtro;

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

    public DTOcategoria(Integer id, String nombre, String filtro, Boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.filtro = filtro;
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

    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }



}
