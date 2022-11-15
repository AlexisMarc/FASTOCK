package fastock.fastock.Mapping.inventario;


public class DTOinventario {
    // -----------------------ID-----------------------//
    private Integer id;
    // -----------------------TIPO-UNIDAD-----------------------//
      private String tipoUnidad;
    // -----------------------ESTADO-----------------------//
    private Boolean estado;

    // ************************************************//
    // -------------Relacion con salida----------------//
    // ************************************************//
    private Integer salida;
    // ************************************************//
    // -------------Relacion con entrada----------------//
    // ************************************************//
    private Integer entrada;
    // ************************************************//
    // -------------Relacion con insumo----------------//
    // ************************************************//
    private String insumo;

    private String img;

    private Integer idInsumo;


    public DTOinventario(Integer id, String tipoUnidad, Boolean estado, Integer salida, Integer entrada, String insumo,
            String img, Integer idInsumo) {
        this.id = id;
        this.tipoUnidad = tipoUnidad;
        this.estado = estado;
        this.salida = salida;
        this.entrada = entrada;
        this.insumo = insumo;
        this.img = img;
        this.idInsumo = idInsumo;
    }

    /*-----------------GETTERS AND SETTERS----------------*/
    public DTOinventario() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoUnidad() {
        return tipoUnidad;
    }

    public void setTipoUnidad(String tipoUnidad) {
        this.tipoUnidad = tipoUnidad;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Integer getSalida() {
        return salida;
    }

    public void setSalida(Integer salida) {
        this.salida = salida;
    }

    public Integer getEntrada() {
        return entrada;
    }

    public void setEntrada(Integer entrada) {
        this.entrada = entrada;
    }

    public String getInsumo() {
        return insumo;
    }

    public void setInsumo(String insumo) {
        this.insumo = insumo;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(Integer idInsumo) {
        this.idInsumo = idInsumo;
    }
    
}
