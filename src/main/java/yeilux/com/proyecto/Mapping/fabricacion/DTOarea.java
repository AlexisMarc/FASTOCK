package yeilux.com.proyecto.Mapping.fabricacion;

import yeilux.com.proyecto.Mapping.empresa.DTOempresa;
import yeilux.com.proyecto.Mapping.usuario.DTOusuario;

import java.util.List;

public class DTOarea {
    // -----------------------ID-----------------------//
    private Integer id;

    // -----------------------Nombre-----------------------//
    private String nombre;

    // -----------------------FECHA_INICIO-----------------------//
    private String fechainicio;

    // -----------------------FECHA_FINAL-----------------------//
    private String fechafinal;
    // -----------------------Estado-----------------------//
    private Boolean estado;

    // ************************************************//
    // -------------Relacion con fabricacion-----------//
    // ************************************************//
    private Integer fabricacion;
    // ************************************************//
    // -------------Relacion con produccion------------//
    // ************************************************//
    private List<DTOproduccion> produccion;
    // ************************************************//
    // -------------Relacion con usuario--------------//
    // ************************************************//
    private List<DTOusuario> usuario;
    // ************************************************//
    // -------------Relacion con empresa---------------//
    // ************************************************//
    private List<DTOempresa> empresa;

    // ************************************************//
    // -------------GETTERS AND SETTERS/CONSTRUCTORES----------------//
    // ************************************************//

    public DTOarea() {
    }

    public DTOarea(Integer id, String nombre, String fechainicio, String fechafinal, Boolean estado,
            Integer fabricacion, List<DTOproduccion> produccion, List<DTOusuario> usuario, List<DTOempresa> empresa) {
        this.id = id;
        this.nombre = nombre;
        this.fechainicio = fechainicio;
        this.fechafinal = fechafinal;
        this.estado = estado;
        this.fabricacion = fabricacion;
        this.produccion = produccion;
        this.usuario = usuario;
        this.empresa = empresa;
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

    public Integer getFabricacion() {
        return fabricacion;
    }

    public void setFabricacion(Integer fabricacion) {
        this.fabricacion = fabricacion;
    }

    public List<DTOproduccion> getProduccion() {
        return produccion;
    }

    public void setProduccion(List<DTOproduccion> produccion) {
        this.produccion = produccion;
    }

    public List<DTOusuario> getUsuario() {
        return usuario;
    }

    public void setUsuario(List<DTOusuario> usuario) {
        this.usuario = usuario;
    }

    public List<DTOempresa> getEmpresa() {
        return empresa;
    }

    public void setEmpresa(List<DTOempresa> empresa) {
        this.empresa = empresa;
    }

    

   

}
