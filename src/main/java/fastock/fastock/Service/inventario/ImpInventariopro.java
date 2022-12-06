package fastock.fastock.Service.inventario;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fastock.fastock.Class.inventario.producto.inventariopro;
import fastock.fastock.Mapping.inventario.DTOCreateInventariopro;
import fastock.fastock.Mapping.inventario.DTOinventariopro;
import fastock.fastock.Service.inventario.producto.IInventariopro;
import fastock.fastock.Service.producto.IProducto;
import fastock.fastock.Utils.EnumEntradaSalida;

@Service
public class ImpInventariopro {
    @Autowired
    private ImpSalidas salidasi;
    @Autowired
    private ImpEntradas entradasi;
    @Autowired
    private IInventariopro inventarioi;
    @Autowired
    private IProducto productoi;

    // LISTAR
    private List<inventariopro> listar() {
        return (List<inventariopro>) inventarioi.findAll();
    }

    // GUARDAR
    private inventariopro guardar(inventariopro inventario) {
        inventariopro pro = inventarioi.save(inventario);
        return pro;
    }

    // CONSULTAR
    private inventariopro consultar(Integer id) {
        return inventarioi.findById(id).orElse(null);
    }

    // DTOCREATE A ENTITY
    private inventariopro DTOCreate(DTOCreateInventariopro DTO) {
        inventariopro inventario = new inventariopro();

        inventario.setProducto(productoi.findById(DTO.getProducto()).get());
        inventario.setEstado(true);

        return inventario;
    }

    // ENTITY A DTOinventario
    private DTOinventariopro DTOinventario(inventariopro inventario) {
        DTOinventariopro DTO = new DTOinventariopro();

        DTO.setId(inventario.getId());
        DTO.setSalida(salidasi.salida(EnumEntradaSalida.PRODUCTO, inventario.getId()));
        DTO.setEntrada(entradasi.Entrada(EnumEntradaSalida.PRODUCTO, inventario.getId()));
        DTO.setProducto(inventario.getProducto().getNombre());
        DTO.setImg(inventario.getProducto().getImagen());
        DTO.setIdProducto(inventario.getProducto().getId());
        DTO.setEstado(inventario.getEstado());

        return DTO;
    }

    // INSUMO

    // ***************************************************************//
    // PUBLICOS
    // ***************************************************************//

    // LISTADO
    public List<DTOinventariopro> listado() {
        List<DTOinventariopro> DTO = new ArrayList<DTOinventariopro>();
        List<inventariopro> inventarioes = listar();
        
        Iterator<inventariopro> i = inventarioes.iterator();

        while (i.hasNext()) {
            inventariopro interar = i.next();
            if (interar.getEstado()) {
                DTOinventariopro DTOs = DTOinventario(interar);
                DTO.add(DTOs);
            }

        }
        return DTO;
    }

    // CONSULTAR
    public DTOinventariopro consulta(Integer id) {
        if (inventarioi.existsById(id)) {
            return DTOinventario(consultar(id));
        } else {
            return null;
        }
    }

    // REGISTAR
    public DTOinventariopro registrar(DTOCreateInventariopro DTO) {
        inventariopro inventario = guardar(DTOCreate(DTO));
        return DTOinventario(inventario);
    }

    // ESTADO
    public void estado(Integer id) {
        inventariopro inventario = consultar(id);
        if (inventario.getEstado()) {
            inventario.setEstado(false);
        } else {
            inventario.setEstado(true);
        }
        guardar(inventario);
    }

}