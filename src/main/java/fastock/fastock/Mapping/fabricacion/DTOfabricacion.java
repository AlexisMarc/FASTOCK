package fastock.fastock.Mapping.fabricacion;

import java.util.List;

import fastock.fastock.Mapping.insumo.DTOinsumo;
import fastock.fastock.Mapping.producto.DTOproducto;
import fastock.fastock.Mapping.usuario.DTOusuario;

public class DTOfabricacion {
    // -----------------------ID-----------------------//
    private Integer id;
    // -----------------------FECHA_INICIO-----------------------//
    private String fechainicio;

    // -----------------------FECHA_FINAL-----------------------//
    private String fechafinal;
    // -----------------------Estado-----------------------//
    private Boolean estado;

    // ************************************************//
    // -------------Relacion con area------------------//
    // ************************************************//
    private List<DTOarea> area;
    // ************************************************//
    // -------------Relacion con usuario----------------//
    // ************************************************//
    private List<DTOusuario> usuario;
    // ************************************************//
    // -------------Relacion con insumo----------------//
    // ************************************************//
    private List<DTOinsumo> insumo;
    // ************************************************//
    // -------------Relacion con producto--------------//
    // ************************************************//
    private List<DTOproducto> producto;

    // ************************************************//
    // -------------GETTERS AND SETTERS/CONSTRUCTORES----------------//
    // ************************************************//

    public DTOfabricacion() {
    }

    public DTOfabricacion(Integer id, String fechainicio, String fechafinal, Boolean estado, List<DTOarea> area,
            List<DTOusuario> usuario, List<DTOinsumo> insumo, List<DTOproducto> producto) {
        this.id = id;
        this.fechainicio = fechainicio;
        this.fechafinal = fechafinal;
        this.estado = estado;
        this.area = area;
        this.usuario = usuario;
        this.insumo = insumo;
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

    public List<DTOarea> getArea() {
        return area;
    }

    public void setArea(List<DTOarea> area) {
        this.area = area;
    }

    public List<DTOusuario> getUsuario() {
        return usuario;
    }

    public void setUsuario(List<DTOusuario> usuario) {
        this.usuario = usuario;
    }

    public List<DTOinsumo> getInsumo() {
        return insumo;
    }

    public void setInsumo(List<DTOinsumo> insumo) {
        this.insumo = insumo;
    }

    public List<DTOproducto> getProducto() {
        return producto;
    }

    public void setProducto(List<DTOproducto> producto) {
        this.producto = producto;
    }


}
