package fastock.fastock.Mapping.inventario;


public class DTOinventariopro {
    // -----------------------ID-----------------------//
    private Integer id;
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
    // -------------Relacion con producto----------------//
    // ************************************************//
    private String producto;

    private String img;

    private Integer idProducto;


    public DTOinventariopro(Integer id, Boolean estado, Integer salida, Integer entrada, String producto,
            String img, Integer idProducto) {
        this.id = id;
        this.estado = estado;
        this.salida = salida;
        this.entrada = entrada;
        this.producto = producto;
        this.img = img;
        this.idProducto = idProducto;
    }

    /*-----------------GETTERS AND SETTERS----------------*/
    public DTOinventariopro() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }
    
}
