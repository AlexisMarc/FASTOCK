package fastock.fastock.Mapping.insumo;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class DTOUpdateInsumo {
    // -----------------------ID-----------------------//
    @NotNull(message = "El ID no debe estar vacío")
    private Integer id;
    // ----------------NOMBRE-------------//
    @NotEmpty(message = "El nombre no debe estar vacío")
    @Size(min = 2, max = 60, message = "El nombre debe tener entre 2 y 60 caracteres")
    private String nombre;
	// -----------------------ESTADO-----------------------//
    @NotNull(message = "El estado no debe estar vacío")
    private Boolean estado;
    // --------------Material insumo---------------//
    @NotEmpty(message = "El nombre del material no debe estar vacío")
    @Size(min = 2, max = 30, message = "El nombre del material debe tener entre 2 y 30 carcateres")
    private String material;
    // ************************************************//
    // -------------Relacion con tipo------------------//
    // ************************************************//
    @NotNull(message = "Los tipos no debe estar vacío")
    private List<Integer> tipo;
    // ************************************************//
    // -------------Relacion con proveedor-------------//
    // ************************************************//
    private Integer proveedor;
    // -----------------------IMAGEN-----------------------//
    private String imagen;
    public DTOUpdateInsumo(@NotNull(message = "El ID no debe estar vacío") Integer id,
            @NotEmpty(message = "El nombre no debe estar vacío") @Size(min = 2, max = 60, message = "El nombre debe tener entre 2 y 60 caracteres") String nombre,
            @NotNull(message = "El estado no debe estar vacío") Boolean estado,
            @NotEmpty(message = "El nombre del material no debe estar vacío") @Size(min = 2, max = 30, message = "El nombre del material debe tener entre 2 y 30 carcateres") String material,
            @NotNull(message = "Los tipos no debe estar vacío") List<Integer> tipo, Integer proveedor, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
        this.material = material;
        this.tipo = tipo;
        this.proveedor = proveedor;
        this.imagen = imagen;
    }
    public DTOUpdateInsumo() {
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
    public String getMaterial() {
        return material;
    }
    public void setMaterial(String material) {
        this.material = material;
    }
    public List<Integer> getTipo() {
        return tipo;
    }
    public void setTipo(List<Integer> tipo) {
        this.tipo = tipo;
    }
    public Integer getProveedor() {
        return proveedor;
    }
    public void setProveedor(Integer proveedor) {
        this.proveedor = proveedor;
    }
    public String getImagen() {
        return imagen;
    }
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    


}