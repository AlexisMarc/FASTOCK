package fastock.fastock.Mapping.insumo;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class DTOUpdateTipo {
    // -----------------------ID-----------------------//
    @NotNull(message = "El ID no debe estar vacío")
    private Integer id;
    // --------------------NOMBRE-----------------------//
    @NotEmpty(message = "El tipo debe tener una longitud en 2 y 30 caracteres.")
    @Size(min = 2, max = 30)
    private String nombre;
    // -----------------------ESTADO-----------------------//
    @NotNull(message = "El estado no debe estar vacío")
    private Boolean estado;
    // -----------------------FILTRO-----------------------//
    @NotEmpty(message = "No puede ser vacío.")
    @Size(min = 2, max = 20)
    private String filtro;

    public DTOUpdateTipo(@NotNull(message = "El ID no debe estar vacío") Integer id,
            @NotEmpty(message = "El tipo debe tener una longitud en 2 y 30 caracteres.") @Size(min = 2, max = 30) String nombre,
            @NotNull(message = "El estado no debe estar vacío") Boolean estado,
            @NotEmpty(message = "No puede ser vacío.") @Size(min = 2, max = 20) String filtro) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
        this.filtro = filtro;
    }

    public DTOUpdateTipo() {
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

    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }

}
