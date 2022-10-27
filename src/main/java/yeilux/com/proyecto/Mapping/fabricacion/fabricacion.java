package yeilux.com.proyecto.Mapping.fabricacion;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import yeilux.com.proyecto.Class.insumo.insumo;
import yeilux.com.proyecto.Class.producto.producto;
import yeilux.com.proyecto.Class.usuario.usuario;


public class fabricacion {
    // -----------------------ID-----------------------//
    private Integer id;
    // -----------------------FECHA_INICIO-----------------------//
    private String fechainicio;

    // -----------------------FECHA_FINAL-----------------------//
    private String fechafinal;
    // -----------------------Estado-----------------------//
    private Boolean estado;

    // ************************************************//
    // -------------Relacion con area------------------//
    // ************************************************//
    private Set<area> area = new HashSet<>();
    // ************************************************//
    // -------------Relacion con usuario----------------//
    // ************************************************//
    private Set<usuario> usuario = new HashSet<>();
    // ************************************************//
    // -------------Relacion con insumo----------------//
    // ************************************************//
    private Set<insumo> insumo = new HashSet<>();
    // ************************************************//
    // -------------Relacion con producto--------------//
    // ************************************************//
    private Set<producto> producto = new HashSet<>();

    public fabricacion() {
    }

}
