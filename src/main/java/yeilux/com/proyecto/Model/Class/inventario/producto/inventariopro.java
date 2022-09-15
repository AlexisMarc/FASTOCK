package yeilux.com.proyecto.Model.Class.inventario.producto;

import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import yeilux.com.proyecto.Model.Class.producto.producto;

@Entity
@Table(name = "inventariopro")
public class inventariopro {

    // -----------------------ID-----------------------//
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    // -----------------------ESTADO-----------------------//
    @Column(nullable = true)
    private Boolean estado;

    // ************************************************//
    // -------------Relacion con salida----------------//
    // ************************************************//
    @OneToMany(mappedBy = "inventario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<salidapro> salida;
    // ************************************************//
    // -------------Relacion con entrada---------------//
    // ************************************************//
    @OneToMany(mappedBy = "inventario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<entradapro> entrada;
    // ************************************************//
    // -------------Relacion con producto--------------//
    // ************************************************//
    @OneToOne(fetch = FetchType.LAZY)
    private producto producto;

    
    

    // ************************************************//
    // -------------Contructores accesores--------------//
    // ************************************************//

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public List<salidapro> getSalida() {
        return salida;
    }

    public void setSalida(List<salidapro> salida) {
        this.salida = salida;
    }

    public List<entradapro> getEntrada() {
        return entrada;
    }

    public void setEntrada(List<entradapro> entrada) {
        this.entrada = entrada;
    }

    public producto getProducto() {
        return producto;
    }

    public void setProducto(producto producto) {
        this.producto = producto;
    }

    public inventariopro() {
    }

    public inventariopro(Integer id, @NotNull Boolean estado, List<salidapro> salida, List<entradapro> entrada,
            yeilux.com.proyecto.Model.Class.producto.producto producto) {
        this.id = id;
        this.estado = estado;
        this.salida = salida;
        this.entrada = entrada;
        this.producto = producto;
    }

}
