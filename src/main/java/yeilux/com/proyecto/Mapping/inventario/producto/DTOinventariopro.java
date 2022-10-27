package yeilux.com.proyecto.Mapping.inventario.producto;

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
    // -------------Relacion con entrada---------------//
    // ************************************************//
    private Integer entrada;
    // ************************************************//
    // -------------Relacion con producto--------------//
    // ************************************************//
    private String producto;

    // ************************************************//
    // -------------Contructores accesores--------------//
    // ************************************************//

    public DTOinventariopro() {
    }

    public DTOinventariopro(Integer id, Boolean estado, Integer salida, Integer entrada, String producto) {
        this.id = id;
        this.estado = estado;
        this.salida = salida;
        this.entrada = entrada;
        this.producto = producto;
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

  

}
