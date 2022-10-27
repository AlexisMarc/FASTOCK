package yeilux.com.proyecto.Mapping.fabricacion;

import yeilux.com.proyecto.Utils.EnumProduccion;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class produccion {

    // -----------------------ID-----------------------//
    private Integer id;
    // -----------------------DESCRIPCION-----------------------//
    @NotEmpty(message = "La descripción no debe estar vacía")
    @Size(min = 0, max = 300, message = "La descripción debe tener una longitud entre 2 y 200 carcateres.")
    private String descripcion;
    // -----------------------FECHA-----------------------//
    private String fecha;
    // -----------------------TIPO-----------------------//
    private EnumProduccion tipo;

    // --------------Estado---------------//
    private Boolean estado;
    // ************************************************//
    // -------------Relacion con area------------------//
    // ************************************************//
    private area area;

    public produccion() {
    }

}
