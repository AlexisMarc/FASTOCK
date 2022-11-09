package yeilux.com.proyecto.Service.inventario;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import yeilux.com.proyecto.Class.inventario.insumo.salida;
import yeilux.com.proyecto.Class.inventario.insumo.inventario;
import yeilux.com.proyecto.Class.inventario.producto.inventariopro;
import yeilux.com.proyecto.Class.inventario.producto.salidapro;
import yeilux.com.proyecto.Class.usuario.usuario;
import yeilux.com.proyecto.Mapping.inventario.DTOCreateEntradaSalida;
import yeilux.com.proyecto.Service.inventario.insumo.IInventario;
import yeilux.com.proyecto.Service.inventario.insumo.ISalida;
import yeilux.com.proyecto.Service.inventario.producto.IInventariopro;
import yeilux.com.proyecto.Service.inventario.producto.ISalidapro;
import yeilux.com.proyecto.Service.usuario.IUsuario;
import yeilux.com.proyecto.Utils.DataTime;
import yeilux.com.proyecto.Utils.EnumEntradaSalida;

public class ImpSalidas {
    @Autowired
    private ISalida salidai;
    @Autowired
    private IUsuario usuarioi;
    @Autowired
    private ISalidapro salidaproi;
    @Autowired
    private IInventario inventarioi;
    @Autowired
    private IInventariopro inventarioproi;
    @Autowired
    private DataTime fecha;

    // LISTAR
    private List<salida> listar() {
        return (List<salida>) salidai.findAll();
    }

    // LISTAR PRO
    private List<salidapro> listarpro() {
        return (List<salidapro>) salidaproi.findAll();
    }

    // GUARDAR
    private salida guardar(salida salida) {
        salida pro = salidai.save(salida);
        return pro;
    }

    // GUARDAR PRO
    private salidapro guardarpro(salidapro salida) {
        salidapro pro = salidaproi.save(salida);
        return pro;
    }

    // CONSULTAR
    private salida consultar(Integer id) {
        return salidai.findById(id).orElse(null);
    }

    // CONSULTAR PRO
    private salidapro consultarpro(Integer id) {
        return salidaproi.findById(id).orElse(null);
    }

    // USUARIO
    private usuario usuario(Integer id) {
        Optional<usuario> usuario = usuarioi.findById(id);
        return usuario.get();
    }

    // INVENTARIO
    private inventario inventario(EnumEntradaSalida dato, Integer id) {

        if (dato == EnumEntradaSalida.INSUMO) {
            inventario inventario = inventarioi.findById(id).get();
            return inventario;
        }
        return null;
    }

    // INVENTARIO PRO
    private inventariopro inventariopro(EnumEntradaSalida dato, Integer id) {

        if (dato == EnumEntradaSalida.PRODUCTO) {
            inventariopro inventario = inventarioproi.findById(id).get();
            return inventario;
        }
        return null;
    }

    // DTOCREATE A ENTITY
    private salida DTOCreate(DTOCreateEntradaSalida DTO) {
        salida salida = new salida();

        salida.setCantidad(DTO.getCantidad());
        salida.setFecha(fecha.obtenerFecha());
        salida.setEstado(true);
        salida.setInventario(inventario(DTO.getTipo(), DTO.getInventario()));
        salida.setUsuario(usuario(DTO.getUsuario()));

        return salida;
    }

    // DTOCREATE A ENTITY PRO
    private salidapro DTOCreatePro(DTOCreateEntradaSalida DTO) {
        salidapro salidapro = new salidapro();

        salidapro.setCantidad(DTO.getCantidad());
        salidapro.setFecha(fecha.obtenerFecha());
        salidapro.setEstado(true);
        salidapro.setInventario(inventariopro(DTO.getTipo(), DTO.getInventario()));
        salidapro.setUsuario(usuario(DTO.getUsuario()));

        return salidapro;
    }

    // ***************************************************************//
    // PUBLICOS
    // ***************************************************************//

    // LISTADO salida
    public Integer salida(EnumEntradaSalida dato) {
        if (dato == EnumEntradaSalida.INSUMO) {

            List<salida> salidaes = listar();
            Iterator<salida> i = salidaes.iterator();
            Integer salida = 0;

            while (i.hasNext()) {
                salida interar = i.next();
                if (interar.getEstado()) {
                    salida = salida + interar.getCantidad();
                }
            }
            return salida;

        } else if (dato == EnumEntradaSalida.PRODUCTO) {
            List<salidapro> salidaes = listarpro();
            Iterator<salidapro> i = salidaes.iterator();
            Integer salidapro = 0;

            while (i.hasNext()) {
                salidapro interar = i.next();
                if (interar.getEstado()) {
                    salidapro = salidapro + interar.getCantidad();
                }
            }
            return salidapro;
        }
        return null;

    }

    // REGISTAR
    public void registrar(DTOCreateEntradaSalida DTO) {
        if (DTO.getTipo() == EnumEntradaSalida.INSUMO) {
            guardar(DTOCreate(DTO));
        } else if (DTO.getTipo() == EnumEntradaSalida.PRODUCTO) {
            guardarpro(DTOCreatePro(DTO));
        }

    }

    // ESTADO
    public void estado(Integer id, EnumEntradaSalida dato) {

        if (dato == EnumEntradaSalida.INSUMO) {

            salida salida = consultar(id);
            if (salida.getEstado()) {
                salida.setEstado(false);
            } else {
                salida.setEstado(true);
            }
            guardar(salida);

        } else if (dato == EnumEntradaSalida.PRODUCTO) {

            salidapro salidapro = consultarpro(id);
            if (salidapro.getEstado()) {
                salidapro.setEstado(false);
            } else {
                salidapro.setEstado(true);
            }
            guardarpro(salidapro);
        }

    }

}
