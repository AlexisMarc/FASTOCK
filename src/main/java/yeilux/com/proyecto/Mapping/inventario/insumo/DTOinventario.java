package yeilux.com.proyecto.Mapping.inventario.insumo;


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

    /*-----------------GETTERS AND SETTERS----------------*/
    public DTOinventario() {
    }

    public DTOinventario(Integer id, String tipoUnidad, Boolean estado, Integer salida, Integer entrada,
            String insumo) {
        this.id = id;
        this.tipoUnidad = tipoUnidad;
        this.estado = estado;
        this.salida = salida;
        this.entrada = entrada;
        this.insumo = insumo;
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

   
    
}
