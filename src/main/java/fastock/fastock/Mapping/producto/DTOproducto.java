package fastock.fastock.Mapping.producto;

import java.util.List;

public class DTOproducto {

    // -----------------------ID-----------------------//
    private Integer id;

    // -----------------------NOMBRE-----------------------//
    private String nombre;

    // -----------------------DESCRIPCION-----------------------//
    private String descripcion;

    // -----------------------Estado-----------------------//
    private Boolean estado;

    // -----------------------VISIBLE-----------------------//
    private Boolean visible;

    // -----------------------IMAGEN-----------------------//
    private String imagen;

    // ************************************************//
    // -------------Relacion con Categoria-------------//
    // ************************************************//
    private List<DTOcategoria> categoria;
    // ************************************************//
    // -------------Relacion con inventario------------//
    // ************************************************//
    private Boolean inventario;

    // ************************************************//
    // -------------Contructores accesores--------------//
    // ************************************************//
    
    public DTOproducto() {
    }

    public DTOproducto(Integer id, String nombre, String descripcion, Boolean estado, Boolean visible, String imagen,
            List<DTOcategoria> categoria, Boolean inventario) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
        this.visible = visible;
        this.imagen = imagen;
        this.categoria = categoria;
        this.inventario = inventario;
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

    public List<DTOcategoria> getCategoria() {
        return categoria;
    }

    public void setCategoria(List<DTOcategoria> categoria) {
        this.categoria = categoria;
    }

    public Boolean getInventario() {
        return inventario;
    }

    public void setInventario(Boolean inventario) {
        this.inventario = inventario;
    }

    

   

}
