package yeilux.com.proyecto.Model.Class.inventario.insumo;

import java.sql.Date;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import yeilux.com.proyecto.Model.Class.empleado.empleado;

@Entity
@Table(name="entrada")  
public class entrada {
// -----------------------ID-----------------------//
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
// -----------------------FECHA-ENTRADA-----------------------//
@NotNull
private Date fecha; 
// -----------------------CANTIDAD-----------------------//
@NotNull
private Integer cantidad; 
// -----------------------ESTADO-----------------------//
@NotNull
private Boolean estado;
// -----------------------ID-INVENTARIO-----------------------//
// ************************************************//
// -------------Relacion con inventario------------//
// ************************************************//
@ManyToOne(fetch = FetchType.LAZY, optional = false)
@JoinColumn(name = "inventario_id")
@JsonProperty(access = Access.WRITE_ONLY)
private inventario inventario;

// ************************************************//
// -------------Relacion con empleado--------------//
// ************************************************//
@ManyToOne(fetch = FetchType.LAZY, optional = false)
@JoinColumn(name = "empleado_id")
@JsonProperty(access = Access.WRITE_ONLY)
private empleado empleado;
/*-----------GETTERS AND SETTERS-----------------*/


}
