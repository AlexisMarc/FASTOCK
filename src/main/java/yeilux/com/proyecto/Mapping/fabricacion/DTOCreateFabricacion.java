package yeilux.com.proyecto.Mapping.fabricacion;

import java.util.List;

import javax.validation.constraints.NotNull;

public class DTOCreateFabricacion {
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
    // -------------Relacion con producto--------------//
    // ************************************************//
    @NotNull(message = "El producto no debe estar vacío")
    private Integer producto;

    // ************************************************//
    // -------------GETTERS AND SETTERS/CONSTRUCTORES----------------//
    // ************************************************//
    public DTOCreateFabricacion() {
    }

    public DTOCreateFabricacion(@NotNull(message = "El usuario no debe estar vacío") Integer usuario,
            @NotNull(message = "Los insumos no debe estar vacíos") List<Integer> insumo,
            @NotNull(message = "El producto no debe estar vacío") Integer producto) {
        this.usuario = usuario;
        this.insumo = insumo;
        this.producto = producto;
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

    public Integer getProducto() {
        return producto;
    }

    public void setProducto(Integer producto) {
        this.producto = producto;
    }

}
