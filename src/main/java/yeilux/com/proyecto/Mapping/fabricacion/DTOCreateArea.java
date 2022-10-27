package yeilux.com.proyecto.Mapping.fabricacion;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class DTOCreateArea {
    // -----------------------ID-----------------------//
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // -----------------------Nombre-----------------------//
    @NotEmpty(message = "El nombre no debe estar vacío")
    @Size(min = 2, max = 60, message = "El nombre debe tener entre 2 y 30 caracteres")
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
    @NotNull(message = "La fabricación no debe estar vacía")
    private Integer fabricacion;
    // ************************************************//
    // -------------Relacion con usuario--------------//
    // ************************************************//
    @NotNull(message = "La lista de usuarios no debe estar vacía")
    private List<Integer> usuario;
    // ************************************************//
    // -------------Relacion con empresa---------------//
    // ************************************************//
    @NotNull(message = "La lista de empresas no debe estar vacía")
    private List<Integer> empresa;
    

    // ************************************************//
    // -------------GETTERS AND SETTERS/CONSTRUCTORES----------------//
    // ************************************************//
    public DTOCreateArea() {
    }


    public DTOCreateArea(Integer id,
            @NotEmpty(message = "El nombre no debe estar vacío") @Size(min = 2, max = 60, message = "El nombre debe tener entre 2 y 30 caracteres") String nombre,
            String fechainicio, String fechafinal, Boolean estado,
            @NotNull(message = "La fabricación no debe estar vacía") Integer fabricacion,
            @NotNull(message = "La lista de usuarios no debe estar vacía") List<Integer> usuario,
            @NotNull(message = "La lista de empresas no debe estar vacía") List<Integer> empresa) {
        this.id = id;
        this.nombre = nombre;
        this.fechainicio = fechainicio;
        this.fechafinal = fechafinal;
        this.estado = estado;
        this.fabricacion = fabricacion;
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


    public List<Integer> getUsuario() {
        return usuario;
    }


    public void setUsuario(List<Integer> usuario) {
        this.usuario = usuario;
    }


    public List<Integer> getEmpresa() {
        return empresa;
    }


    public void setEmpresa(List<Integer> empresa) {
        this.empresa = empresa;
    }
    
}
