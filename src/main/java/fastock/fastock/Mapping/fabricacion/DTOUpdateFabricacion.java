package fastock.fastock.Mapping.fabricacion;

import java.util.List;

import javax.validation.constraints.NotNull;

public class DTOUpdateFabricacion {
    // -----------------------ID-----------------------//
    @NotNull(message = "El ID no debe estar vacío")
    private Integer id;

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

    // -----------------------ESTADO-----------------------//
    @NotNull(message = "El estado no debe estar vacío")
    private Boolean estado;
    // -----------------------SUSPENDIDO-----------------------//
    @NotNull(message = "El suspendido no debe estar vacío")
    private Boolean suspendido;

    // ************************************************//
    // -------------GETTERS AND SETTERS/CONSTRUCTORES----------------//
    // ************************************************//

    

    public DTOUpdateFabricacion() {
    }

    public DTOUpdateFabricacion(@NotNull(message = "El ID no debe estar vacío") Integer id,
            @NotNull(message = "El usuario no debe estar vacío") Integer usuario,
            @NotNull(message = "Los insumos no debe estar vacíos") List<Integer> insumo,
            @NotNull(message = "El estado no debe estar vacío") Boolean estado,
            @NotNull(message = "El suspendido no debe estar vacío") Boolean suspendido) {
        this.id = id;
        this.usuario = usuario;
        this.insumo = insumo;
        this.estado = estado;
        this.suspendido = suspendido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Boolean getSuspendido() {
        return suspendido;
    }

    public void setSuspendido(Boolean suspendido) {
        this.suspendido = suspendido;
    }

}
