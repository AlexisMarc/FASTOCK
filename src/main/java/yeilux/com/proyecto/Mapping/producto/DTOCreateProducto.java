package yeilux.com.proyecto.Mapping.producto;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class DTOCreateProducto {
    // -----------------------NOMBRE-----------------------//
    @NotEmpty(message = "El nombre no debe estar vacío")
    @Size(min = 2, max = 60, message = "El nombre debe tener entre 2 y 60 caracteres")
    private String nombre;

    // -----------------------DESCRIPCION-----------------------//
    private String descripcion;

    // -----------------------IMAGEN-----------------------//
    private String imagen;

    // ************************************************//
    // -------------Relacion con Categoria-------------//
    // ************************************************//
    @NotNull(message = "Las categorías no debe estar vacías")
    private List<Integer> categoria;
    // ************************************************//
    // -------------Contructores accesores--------------//
    // ************************************************//

    public DTOCreateProducto() {
    }

    public DTOCreateProducto(
            @NotEmpty(message = "El nombre no debe estar vacío") @Size(min = 2, max = 60, message = "El nombre debe tener entre 2 y 60 caracteres") String nombre,
            String descripcion, String imagen,
            @NotNull(message = "Las categorías no debe estar vacías") List<Integer> categoria) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.categoria = categoria;
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
