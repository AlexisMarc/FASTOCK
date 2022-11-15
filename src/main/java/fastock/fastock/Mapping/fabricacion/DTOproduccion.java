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

    // --------------confirmacion---------------//
    private Boolean confirmacion;

    // --------------visto---------------//
    private Boolean visto;
    // ************************************************//
    // -------------Relacion con area------------------//
    // ************************************************//
    private String area;
    private Integer idArea;

    // ************************************************//
    // -------------Relacion con usuario------------------//
    // ************************************************//
    private Integer idUsuario;
    private String Usuario;
    private String imagen;

    // ************************************************//
    // -------------GETTERS AND SETTERS/CONSTRUCTORES----------------//
    // ************************************************//

    public DTOproduccion() {
    }

    public DTOproduccion(Integer id, String descripcion, String fecha, String tipo, Boolean estado,
            Boolean confirmacion, Boolean visto, String area, Integer idArea, Integer idUsuario, String usuario,
            String imagen) {
        this.id = id;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.tipo = tipo;
        this.estado = estado;
        this.confirmacion = confirmacion;
        this.visto = visto;
        this.area = area;
        this.idArea = idArea;
        this.idUsuario = idUsuario;
        Usuario = usuario;
        this.imagen = imagen;
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

    public Integer getIdArea() {
        return idArea;
    }

    public void setIdArea(Integer idArea) {
        this.idArea = idArea;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Boolean getConfirmacion() {
        return confirmacion;
    }

    public void setConfirmacion(Boolean confirmacion) {
        this.confirmacion = confirmacion;
    }

    public Boolean getVisto() {
        return visto;
    }

    public void setVisto(Boolean visto) {
        this.visto = visto;
    }

}
