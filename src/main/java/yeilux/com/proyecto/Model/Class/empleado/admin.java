package yeilux.com.proyecto.Model.Class.empleado;

import java.util.List;

import jakarta.persistence.*;
import yeilux.com.proyecto.Model.Class.fabricacion.fabricacion;

@Entity
@Table(name="admin")
public class admin {
// -----------------------ID-----------------------//
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
// ************************************************//
// -------------Relacion con fabricacion-----------//
// ************************************************//
    @ManyToMany(mappedBy = "admin")
    private List<fabricacion> fabricacion;
}
