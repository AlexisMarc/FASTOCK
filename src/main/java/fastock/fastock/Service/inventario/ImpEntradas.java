package fastock.fastock.Service.inventario;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import fastock.fastock.Class.inventario.insumo.entrada;
import fastock.fastock.Class.inventario.insumo.inventario;
import fastock.fastock.Class.inventario.producto.inventariopro;
import fastock.fastock.Class.inventario.producto.entradapro;
import fastock.fastock.Class.usuario.usuario;
import fastock.fastock.Mapping.inventario.DTOCreateEntradaSalida;
import fastock.fastock.Service.inventario.insumo.IEntrada;
import fastock.fastock.Service.inventario.insumo.IInventario;
import fastock.fastock.Service.inventario.producto.IEntradapro;
import fastock.fastock.Service.inventario.producto.IInventariopro;
import fastock.fastock.Service.usuario.IUsuario;
import fastock.fastock.Utils.DataTime;
import fastock.fastock.Utils.EnumEntradaSalida;

public class ImpEntradas {
    @Autowired
    private IEntrada entradai;
    @Autowired
    private IUsuario usuarioi;
    @Autowired
    private IEntradapro entradaproi;
    @Autowired
    private IInventario inventarioi;
    @Autowired
    private IInventariopro inventarioproi;
    @Autowired
    private DataTime fecha;

    // LISTAR
    private List<entrada> listar() {
        return (List<entrada>) entradai.findAll();
    }

    // LISTAR PRO
    private List<entradapro> listarpro() {
        return (List<entradapro>) entradaproi.findAll();
    }

    // GUARDAR
    private entrada guardar(entrada entrada) {
        entrada pro = entradai.save(entrada);
        return pro;
    }

    // GUARDAR PRO
    private entradapro guardarpro(entradapro entrada) {
        entradapro pro = entradaproi.save(entrada);
        return pro;
    }

    // CONSULTAR
    private entrada consultar(Integer id) {
        return entradai.findById(id).orElse(null);
    }

    // CONSULTAR PRO
    private entradapro consultarpro(Integer id) {
        return entradaproi.findById(id).orElse(null);
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
    private entrada DTOCreate(DTOCreateEntradaSalida DTO) {
        entrada entrada = new entrada();

        entrada.setCantidad(DTO.getCantidad());
        entrada.setFecha(fecha.obtenerFecha());
        entrada.setEstado(true);
        entrada.setInventario(inventario(DTO.getTipo(), DTO.getInventario()));
        entrada.setUsuario(usuario(DTO.getUsuario()));

        return entrada;
    }

    // DTOCREATE A ENTITY PRO
    private entradapro DTOCreatePro(DTOCreateEntradaSalida DTO) {
        entradapro entradapro = new entradapro();

        entradapro.setCantidad(DTO.getCantidad());
        entradapro.setFecha(fecha.obtenerFecha());
        entradapro.setEstado(true);
        entradapro.setInventario(inventariopro(DTO.getTipo(), DTO.getInventario()));
        entradapro.setUsuario(usuario(DTO.getUsuario()));

        return entradapro;
    }

    // ***************************************************************//
    // PUBLICOS
    // ***************************************************************//

    // LISTADO ENTRADA
    public Integer Entrada(EnumEntradaSalida dato, Integer id) {
        if (dato == EnumEntradaSalida.INSUMO) {

            inventario pro = inventario(dato, id);

            List<entrada> entradaes = listar();
            Iterator<entrada> i = entradaes.iterator();
            Integer Entrada = 0;

            while (i.hasNext()) {
                entrada interar = i.next();
                if (interar.getEstado()) {
                    if (interar.getInventario().getId()==pro.getId()) {
                        Entrada = Entrada + interar.getCantidad();
                    }
                }
            }
            return Entrada;

        } else if (dato == EnumEntradaSalida.PRODUCTO) {
            List<entradapro> entradaes = listarpro();
            Iterator<entradapro> i = entradaes.iterator();
            Integer Entradapro = 0;

            inventariopro pro = inventariopro(dato, id);

            while (i.hasNext()) {
                entradapro interar = i.next();
                if (interar.getEstado()) {
                    if (interar.getInventario().getId()==pro.getId()) {
                        Entradapro = Entradapro + interar.getCantidad();
                    }
                }
            }
            return Entradapro;
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

            entrada entrada = consultar(id);
            if (entrada.getEstado()) {
                entrada.setEstado(false);
            } else {
                entrada.setEstado(true);
            }
            guardar(entrada);

        } else if (dato == EnumEntradaSalida.PRODUCTO) {

            entradapro entradapro = consultarpro(id);
            if (entradapro.getEstado()) {
                entradapro.setEstado(false);
            } else {
                entradapro.setEstado(true);
            }
            guardarpro(entradapro);
        }

    }
}
