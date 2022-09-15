package yeilux.com.proyecto.Model.Class.inventario.producto;

import java.util.Iterator;
import java.util.List;

import yeilux.com.proyecto.Model.Class.producto.producto;

public class ListInventario {
    // -----------------------ID-----------------------//
    private Integer id;
    // -----------------------ENTRADA-----------------------//
    private Integer entrada;
    // -----------------------SALIDA-----------------------//
    private Integer salida;
    // -----------------------ESTADO-----------------------//
    private Boolean estado;
    private producto producto;

    public static Integer TotalEntrada(List<entradapro> entrada) {
        
        entradapro entradaa;
        Integer total=0;
        Iterator<entradapro> inte=entrada.iterator();

        while (inte.hasNext()){
            entradapro in= inte.next();
                entradaa=in;
                total=total+entradaa.getCantidad();
        }
        return total;
    }
    public static Integer TotalSalida(List<salidapro> salida) {
        
        salidapro salidaa;
        Integer total=0;
        Iterator<salidapro> inte=salida.iterator();

        while (inte.hasNext()){
            salidapro in= inte.next();
                salidaa=in;
                total=total+salidaa.getCantidad();
        }return total;
        }

    // ************************************************//
    // -------------Contructores accesores--------------//
    // ************************************************//

    
    public ListInventario() {
    }
    public ListInventario(Integer id, Integer entrada, Integer salida, Boolean estado,
            yeilux.com.proyecto.Model.Class.producto.producto producto) {
        this.id = id;
        this.entrada = entrada;
        this.salida = salida;
        this.estado = estado;
        this.producto = producto;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getEntrada() {
        return entrada;
    }
    public void setEntrada(Integer entrada) {
        this.entrada = entrada;
    }
    public Integer getSalida() {
        return salida;
    }
    public void setSalida(Integer salida) {
        this.salida = salida;
    }
    public Boolean getEstado() {
        return estado;
    }
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    public producto getProducto() {
        return producto;
    }
    public void setProducto(producto producto) {
        this.producto = producto;
    }

    
}
