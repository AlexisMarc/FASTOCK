package yeilux.com.proyecto.Class.inventario.producto;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import yeilux.com.proyecto.Class.producto.producto;

import javax.persistence.*;

@Entity
@Table(name = "inventariopro")
public class inventariopro {

    // -----------------------ID-----------------------//
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    // -----------------------ESTADO-----------------------//
    @Column(nullable = false)
    private Boolean estado;

    // ************************************************//
    // -------------Relacion con salida----------------//
    // ************************************************//
    @JsonManagedReference(value = "inventariopro_salida")
    @OneToMany(mappedBy = "inventario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<salidapro> salida = new HashSet<>();
    // ************************************************//
    // -------------Relacion con entrada---------------//
    // ************************************************//
    @JsonManagedReference(value = "inventariopro_entrada")
    @OneToMany(mappedBy = "inventario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<entradapro> entrada = new HashSet<>();
    // ************************************************//
    // -------------Relacion con producto--------------//
    // ************************************************//
    @JsonBackReference(value = "producto_inventario")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "producto_id")
    @JsonProperty(access = Access.WRITE_ONLY)
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

    public Set<salidapro> getSalida() {
        return salida;
    }

    public void setSalida(Set<salidapro> salida) {
        this.salida = salida;
    }

    public Set<entradapro> getEntrada() {
        return entrada;
    }

    public void setEntrada(Set<entradapro> entrada) {
        this.entrada = entrada;
    }

    public producto getProducto() {
        return producto;
    }

    public void setProducto(producto producto) {
        this.producto = producto;
    }

    public inventariopro(Integer id, Boolean estado, Set<salidapro> salida, Set<entradapro> entrada,
            producto producto) {
        this.id = id;
        this.estado = estado;
        this.salida = salida;
        this.entrada = entrada;
        this.producto = producto;
    }

    public inventariopro() {
    }

}
