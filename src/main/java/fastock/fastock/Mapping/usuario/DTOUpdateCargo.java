package fastock.fastock.Mapping.usuario;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class DTOUpdateCargo {

    // -----------------------ID-----------------------//
    @NotNull(message = "El ID no debe estar vacío")
    private Integer id;
    // -----------------------NOMBRE-----------------------//
    @NotEmpty(message = "El nombre no debe estar vacío")
    @Size(min = 2, max = 60, message = "El nombre debe tener entre 2 y 60 caracteres")
    private String nombre;
    // -----------------------Estado-----------------------//
    @NotNull(message = "El estado no debe estar vacío")
    private Boolean estado;

    public DTOUpdateCargo(@NotNull(message = "El ID no debe estar vacío") Integer id,
            @NotEmpty(message = "El nombre no debe estar vacío") @Size(min = 2, max = 60, message = "El nombre debe tener entre 2 y 60 caracteres") String nombre,
            @NotNull(message = "El estado no debe estar vacío") Boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
    }

    public DTOUpdateCargo() {
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

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

}