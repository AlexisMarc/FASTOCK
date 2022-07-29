package yeilux.com.proyecto.Model.Class.producto;

import java.util.List;

import jakarta.persistence.*;
import yeilux.com.proyecto.Model.Class.fabricacion.fabricacion;
import yeilux.com.proyecto.Model.Class.inventario.producto.inventariopro;

@Entity
@Table(name="producto")
public class producto {
// -----------------------ID-----------------------//
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
// ************************************************//
// -------------Relacion con Categoria-------------//
// ************************************************//
    @ManyToMany(mappedBy = "producto")
    private List<categoria> categoria;
// ************************************************//
// -------------Relacion con fabricacion-----------//
// ************************************************//
    @ManyToMany(mappedBy = "producto")
    private List<fabricacion> fabricacion;
// ************************************************//
// -------------Relacion con inventario------------//
// ************************************************//
    @OneToMany(mappedBy = "producto", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<inventariopro> inventario;
}
