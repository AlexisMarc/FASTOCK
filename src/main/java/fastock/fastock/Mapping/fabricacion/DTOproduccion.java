package fastock.fastock.Mapping.fabricacion;

public class DTOproduccion {

    // -----------------------ID-----------------------//
    private Integer id;
    // -----------------------DESCRIPCION-----------------------//
    private String descripcion;
    // -----------------------FECHA-----------------------//
    private String fecha;
    // -----------------------TIPO-----------------------//
    private String tipo;

    // --------------Estado---------------//
    private Boolean estado;
    // ************************************************//
    // -------------Relacion con area------------------//
    // ************************************************//
    private String area;

    private Integer idarea;

    // ************************************************//
    // -------------GETTERS AND SETTERS/CONSTRUCTORES----------------//
    // ************************************************//

    public DTOproduccion() {
    }

    public DTOproduccion(Integer id, String descripcion, String fecha, String tipo, Boolean estado, String area,
            Integer idarea) {
        this.id = id;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.tipo = tipo;
        this.estado = estado;
        this.area = area;
        this.idarea = idarea;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Integer getIdarea() {
        return idarea;
    }

    public void setIdarea(Integer idarea) {
        this.idarea = idarea;
    }

    
}
