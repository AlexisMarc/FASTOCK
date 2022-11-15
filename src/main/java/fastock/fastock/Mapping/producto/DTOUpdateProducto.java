package fastock.fastock.Mapping.producto;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class DTOUpdateProducto {

    // -----------------------ID-----------------------//
    @NotNull(message = "El ID no debe estar vacío")
    private Integer id;
    // -----------------------NOMBRE-----------------------//
    @NotEmpty(message = "El nombre no debe estar vacío")
    @Size(min = 2, max = 60, message = "El nombre debe tener entre 2 y 60 caracteres")
    private String nombre;
    // -----------------------DESCRIPCION-----------------------//
    private String descripcion;
    // -----------------------ESTADO-----------------------//
    @NotNull(message = "El estado no debe estar vacío")
    private Boolean estado;
    // -----------------------VISIBLE -----------------------//
    @NotNull(message = "El visible no debe estar vacío")
    private Boolean visible;
    // -----------------------IMAGEN-----------------------//
    private String imagen;

    // ----------------------CATEGORIA---------------------//
    private List<Integer> categoria;

    // ************************************************//
    // -------------Constructores---------------//
    // ************************************************//

    public DTOUpdateProducto() {
    }

    public DTOUpdateProducto(@NotNull(message = "El ID no debe estar vacío") Integer id,
            @NotEmpty(message = "El nombre no debe estar vacío") @Size(min = 2, max = 60, message = "El nombre debe tener entre 2 y 60 caracteres") String nombre,
            String descripcion, @NotNull(message = "El estado no debe estar vacío") Boolean estado,
            @NotNull(message = "El visible no debe estar vacío") Boolean visible, String imagen,
            List<Integer> categoria) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
        this.visible = visible;
        this.imagen = imagen;
        this.categoria = categoria;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public List<Integer> getCategoria() {
        return categoria;
    }

    public void setCategoria(List<Integer> categoria) {
        this.categoria = categoria;
    }

}