package fastock.fastock.Mapping.fabricacion;

public class DTOarea {
    // -----------------------ID-----------------------//
    private Integer id;

    // -----------------------Nombre-----------------------//
    private String nombre;

    // -----------------------FECHA_INICIO-----------------------//
    private String fechainicio;

    // -----------------------FECHA_FINAL-----------------------//
    private String fechafinal;
    // ----------------------NUMERADOR---------------------//
    private Integer numerador;
    // -----------------------Estado-----------------------//
    private Boolean estado;

    // ************************************************//
    // --------------------Encargado-------------------//
    // ************************************************//
    private Integer idEncargado;
    private String encargado;
    private String tipoEncargado;
    private String imagen;
    // ************************************************//
    // -------------GETTERS AND SETTERS/CONSTRUCTORES----------------//
    // ************************************************//

    public DTOarea() {
    }

    public DTOarea(Integer id, String nombre, String fechainicio, String fechafinal, Integer numerador, Boolean estado,
            Integer idEncargado, String encargado, String tipoEncargado, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.fechainicio = fechainicio;
        this.fechafinal = fechafinal;
        this.numerador = numerador;
        this.estado = estado;
        this.idEncargado = idEncargado;
        this.encargado = encargado;
        this.tipoEncargado = tipoEncargado;
        this.imagen = imagen;
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

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Integer getIdEncargado() {
        return idEncargado;
    }

    public void setIdEncargado(Integer idEncargado) {
        this.idEncargado = idEncargado;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    public String getTipoEncargado() {
        return tipoEncargado;
    }

    public void setTipoEncargado(String tipoEncargado) {
        this.tipoEncargado = tipoEncargado;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Integer getNumerador() {
        return numerador;
    }

    public void setNumerador(Integer numerador) {
        this.numerador = numerador;
    }

}
