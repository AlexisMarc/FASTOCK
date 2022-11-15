package fastock.fastock.Mapping.fabricacion;

import java.util.List;

public class DTOfabricacion {
    // -----------------------ID-----------------------//
    private Integer id;
    // -----------------------FECHA_INICIO-----------------------//
    private String fechainicio;

    // -----------------------FECHA_FINAL-----------------------//
    private String fechafinal;
    // -----------------------Estado-----------------------//
    private Boolean estado;
    // -----------------------Estado-----------------------//
    private Boolean suspendido;

    // ************************************************//
    // -------------Relacion con area------------------//
    // ************************************************//
    private List<DTOarea> area;
    // ************************************************//
    // -------------Relacion con usuario----------------//
    // ************************************************//
    private List<DTOAdmin> usuario;
    // ************************************************//
    // -------------Relacion con producto--------------//
    // ************************************************//
    private String producto;
    private Integer idProducto;
    private String imagen;

    // ************************************************//
    // -------------GETTERS AND SETTERS/CONSTRUCTORES----------------//
    // ************************************************//

    public DTOfabricacion() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(String fechainicio) {
        this.fechainicio = fechainicio;
    }

    public String getFechafinal() {
        return fechafinal;
    }

    public void setFechafinal(String fechafinal) {
        this.fechafinal = fechafinal;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setSuspendido(Boolean suspendido) {
        this.suspendido = suspendido;
    }

    public Boolean getSuspendido() {
        return suspendido;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public List<DTOarea> getArea() {
        return area;
    }

    public void setArea(List<DTOarea> area) {
        this.area = area;
    }

    public List<DTOAdmin> getUsuario() {
        return usuario;
    }

    public void setUsuario(List<DTOAdmin> usuario) {
        this.usuario = usuario;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public DTOfabricacion(Integer id, String fechainicio, String fechafinal, Boolean estado, Boolean suspendido,
            List<DTOarea> area, List<DTOAdmin> usuario, String producto, Integer idProducto, String imagen) {
        this.id = id;
        this.fechainicio = fechainicio;
        this.fechafinal = fechafinal;
        this.estado = estado;
        this.suspendido = suspendido;
        this.area = area;
        this.usuario = usuario;
        this.producto = producto;
        this.idProducto = idProducto;
        this.imagen = imagen;
    }

}
