package yeilux.com.proyecto.Model.Class.fabricacion;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import yeilux.com.proyecto.Model.Class.empleado.empleado;

public class listFabricacion {
    // -----------------------NOMBRE-----------------------//
    @NotEmpty
    @Size(min = 2, max = 60)
    private String nombre;

    // -----------------------Descri Producto-----------------------//
    @NotEmpty
    @Size(min = 2, max = 200)
    private String descripcion;

    //-----------------------Empleado------------------//
    @NotNull
    private empleado diseno;
    @NotNull
    private empleado corte;
    @NotNull
    private empleado confeccion;
    @NotNull
    private empleado tintura;
    @NotNull
    private empleado empaquetado;
    @NotNull
    private empleado control;

}
