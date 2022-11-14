package fastock.fastock.Mapping.fabricacion;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class DTOCreateArea {
    // -----------------------Nombre-----------------------//
    @NotEmpty(message = "El nombre no debe estar vacío")
    @Size(min = 2, max = 60, message = "El nombre debe tener entre 2 y 30 caracteres")
    private String nombre;
    // ************************************************//
    // -------------Relacion con fabricacion-----------//
    // ************************************************//
    @NotNull(message = "La fabricación no debe estar vacía")
    private Integer fabricacion;
    // ************************************************//
    // -------------usuario o Empresa--------------//
    // ************************************************//
    @NotEmpty(message = "El encargado no debe estar vacía")
    private String encargado;
    // ************************************************//
    // -------------Relacion con empresa y usuario---------------//
    // ************************************************//
    @NotNull(message = "El encargado no debe estar vacía")
    private Integer idencargado;

    // ************************************************//
    // -------------GETTERS AND SETTERS/CONSTRUCTORES----------------//
    // ************************************************//
    public DTOCreateArea() {
    }

    public DTOCreateArea(
            @NotEmpty(message = "El nombre no debe estar vacío") @Size(min = 2, max = 60, message = "El nombre debe tener entre 2 y 30 caracteres") String nombre,
            @NotNull(message = "La fabricación no debe estar vacía") Integer fabricacion,
            @NotEmpty(message = "El encargado no debe estar vacía") String encargado,
            @NotNull(message = "El encargado no debe estar vacía") Integer idencargado) {
        this.nombre = nombre;
        this.fabricacion = fabricacion;
        this.encargado = encargado;
        this.idencargado = idencargado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getFabricacion() {
        return fabricacion;
    }

    public void setFabricacion(Integer fabricacion) {
        this.fabricacion = fabricacion;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    public Integer getIdencargado() {
        return idencargado;
    }

    public void setIdencargado(Integer idencargado) {
        this.idencargado = idencargado;
    }

}
