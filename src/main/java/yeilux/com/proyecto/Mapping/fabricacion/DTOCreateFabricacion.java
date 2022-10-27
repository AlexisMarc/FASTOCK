package yeilux.com.proyecto.Mapping.fabricacion;

import java.util.List;

import javax.validation.constraints.NotNull;

public class DTOCreateFabricacion {
    // -----------------------ID-----------------------//
    private Integer id;
    // -----------------------FECHA_INICIO-----------------------//
    private String fechainicio;

    // -----------------------FECHA_FINAL-----------------------//
    private String fechafinal;
    // -----------------------Estado-----------------------//
    private Boolean estado;
    // ************************************************//
    // -------------Relacion con usuario----------------//
    // ************************************************//
    @NotNull(message = "El usuario no debe estar vacío")
    private Integer usuario;
    // ************************************************//
    // -------------Relacion con insumo----------------//
    // ************************************************//
    @NotNull(message = "Los insumos no debe estar vacíos")
    private List<Integer> insumo;

    // ************************************************//
    // -------------Relacion con area----------------//
    // ************************************************//
    private List<Integer> area;
    // ************************************************//
    // -------------Relacion con producto--------------//
    // ************************************************//
    @NotNull(message = "El producto no debe estar vacío")
    private Integer producto;

    // ************************************************//
    // -------------GETTERS AND SETTERS/CONSTRUCTORES----------------//
    // ************************************************//
    public DTOCreateFabricacion() {
    }

    public DTOCreateFabricacion(Integer id, String fechainicio, String fechafinal, Boolean estado,
            @NotNull(message = "El usuario no debe estar vacío") Integer usuario,
            @NotNull(message = "Los insumos no debe estar vacíos") List<Integer> insumo, List<Integer> area,
            @NotNull(message = "El producto no debe estar vacío") Integer producto) {
        this.id = id;
        this.fechainicio = fechainicio;
        this.fechafinal = fechafinal;
        this.estado = estado;
        this.usuario = usuario;
        this.insumo = insumo;
        this.area = area;
        this.producto = producto;
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

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Integer getUsuario() {
        return usuario;
    }

    public void setUsuario(Integer usuario) {
        this.usuario = usuario;
    }

    public List<Integer> getInsumo() {
        return insumo;
    }

    public void setInsumo(List<Integer> insumo) {
        this.insumo = insumo;
    }

    public List<Integer> getArea() {
        return area;
    }

    public void setArea(List<Integer> area) {
        this.area = area;
    }

    public Integer getProducto() {
        return producto;
    }

    public void setProducto(Integer producto) {
        this.producto = producto;
    }

    
    
}
