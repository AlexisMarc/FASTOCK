package fastock.fastock.Mapping.fabricacion;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import fastock.fastock.Utils.EnumArea;

public class DTOUpdateArea {

    // -----------------------ID-----------------------//
    @NotNull(message = "El ID no debe estar vacío")
    private Integer id;

    // -----------------------Nombre-----------------------//
    @NotEmpty(message = "El nombre no debe estar vacío")
    @Size(min = 2, max = 60, message = "El nombre debe tener entre 2 y 30 caracteres")
    private String nombre;
    // ************************************************//
    // -------------usuario o Empresa--------------//
    // ************************************************//
    @NotEmpty(message = "El encargado no debe estar vacía")
    private EnumArea tipo;
    // ************************************************//
    // -------------Relacion con empresa y usuario---------------//
    // ************************************************//
    @NotNull(message = "El encargado no debe estar vacía")
    private Integer idencargado;

    // -----------------------Estado-----------------------//
    @NotNull(message = "El estado no debe estar vacío")
    private Boolean estado;

    // ************************************************//
    // -----------------CONSTRUCTORES------------------//
    // ************************************************//

    public DTOUpdateArea() {
    }

    public DTOUpdateArea(@NotNull(message = "El ID no debe estar vacío") Integer id,
            @NotEmpty(message = "El nombre no debe estar vacío") @Size(min = 2, max = 60, message = "El nombre debe tener entre 2 y 30 caracteres") String nombre,
            @NotEmpty(message = "El encargado no debe estar vacía") EnumArea tipo,
            @NotNull(message = "El encargado no debe estar vacía") Integer idencargado,
            @NotNull(message = "El estado no debe estar vacío") Boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.idencargado = idencargado;
        this.estado = estado;
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

    public EnumArea getTipo() {
        return tipo;
    }

    public void setTipo(EnumArea tipo) {
        this.tipo = tipo;
    }

    public Integer getIdencargado() {
        return idencargado;
    }

    public void setIdencargado(Integer idencargado) {
        this.idencargado = idencargado;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

}
