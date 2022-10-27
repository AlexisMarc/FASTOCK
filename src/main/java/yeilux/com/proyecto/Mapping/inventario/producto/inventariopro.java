package yeilux.com.proyecto.Mapping.inventario.producto;

import java.util.HashSet;
import java.util.Set;

import yeilux.com.proyecto.Class.producto.producto;

public class inventariopro {

    // -----------------------ID-----------------------//
    private Integer id;

    // -----------------------ESTADO-----------------------//
    private Boolean estado;

    // ************************************************//
    // -------------Relacion con salida----------------//
    // ************************************************//
    private Set<salidapro> salida = new HashSet<>();
    // ************************************************//
    // -------------Relacion con entrada---------------//
    // ************************************************//
    private Set<entradapro> entrada = new HashSet<>();
    // ************************************************//
    // -------------Relacion con producto--------------//
    // ************************************************//
    private producto producto;

    // ************************************************//
    // -------------Contructores accesores--------------//
    // ************************************************//

    public inventariopro() {
    }

}
