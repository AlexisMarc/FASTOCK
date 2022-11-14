package fastock.fastock.Mapping.inventario;

import javax.validation.constraints.NotNull;

public class DTOCreateInventariopro {
    // ************************************************//
    // -------------Relacion con producto--------------//
    // ************************************************//
    @NotNull(message = "El producto no debe estar vacío")
    private Integer producto;

    // ************************************************//
    // -------------Contructores accesores--------------//
    // ************************************************//

    public DTOCreateInventariopro() {
    }

    public DTOCreateInventariopro(@NotNull(message = "El producto no debe estar vacío") Integer producto) {
        this.producto = producto;
    }

    public Integer getProducto() {
        return producto;
    }

    public void setProducto(Integer producto) {
        this.producto = producto;
    }

    
}
