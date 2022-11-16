package fastock.fastock.Service.inventario;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fastock.fastock.Class.inventario.insumo.inventario;
import fastock.fastock.Mapping.inventario.DTOCreateInventario;
import fastock.fastock.Mapping.inventario.DTOinventario;
import fastock.fastock.Service.insumo.IInsumo;
import fastock.fastock.Service.inventario.insumo.IInventario;
import fastock.fastock.Utils.EnumEntradaSalida;

@Service
public class ImpInventario {
    @Autowired
    private ImpSalidas salidasi;
    @Autowired
    private ImpEntradas entradasi;
    @Autowired
    private IInventario inventarioi;
    @Autowired
    private IInsumo insumoi;

    // LISTAR
    private List<inventario> listar() {
        return (List<inventario>) inventarioi.findAll();
    }

    // GUARDAR
    private inventario guardar(inventario inventario) {
        inventario pro = inventarioi.save(inventario);
        return pro;
    }

    // CONSULTAR
    private inventario consultar(Integer id) {
        return inventarioi.findById(id).orElse(null);
    }

    // DTOCREATE A ENTITY
    private inventario DTOCreate(DTOCreateInventario DTO) {
        inventario inventario = new inventario();

        inventario.setInsumo(insumoi.findById(DTO.getInsumo()).get());
        inventario.setEstado(true);
        inventario.setTipoUnidad(DTO.getTipoUnidad());

        return inventario;
    }

    // ENTITY A DTOinventario
    private DTOinventario DTOinventario(inventario inventario) {
        DTOinventario DTO = new DTOinventario();

        DTO.setId(inventario.getId());
        DTO.setTipoUnidad(inventario.getTipoUnidad());
        DTO.setSalida(salidasi.salida(EnumEntradaSalida.INSUMO, inventario.getId()));
        DTO.setEntrada(entradasi.Entrada(EnumEntradaSalida.INSUMO, inventario.getId()));
        DTO.setInsumo(inventario.getInsumo().getNombre());
        DTO.setImg(inventario.getInsumo().getImagen());
        DTO.setIdInsumo(inventario.getInsumo().getId());
        DTO.setEstado(inventario.getEstado());

        return DTO;
    }

    // INSUMO

    // ***************************************************************//
    // PUBLICOS
    // ***************************************************************//

    // LISTADO
    public List<DTOinventario> listado() {
        List<DTOinventario> DTO = new ArrayList<DTOinventario>();
        List<inventario> inventarioes = listar();
        
        Iterator<inventario> i = inventarioes.iterator();

        while (i.hasNext()) {
            inventario interar = i.next();
            if (interar.getEstado()) {
                DTOinventario DTOs = DTOinventario(interar);
                DTO.add(DTOs);
            }

        }
        return DTO;
    }

    // CONSULTAR
    public DTOinventario consulta(Integer id) {
        if (inventarioi.existsById(id)) {
            return DTOinventario(consultar(id));
        } else {
            return null;
        }
    }

    // REGISTAR
    public DTOinventario registrar(DTOCreateInventario DTO) {
        inventario inventario = guardar(DTOCreate(DTO));
        return DTOinventario(inventario);
    }

    // ESTADO
    public void estado(Integer id) {
        inventario inventario = consultar(id);
        if (inventario.getEstado()) {
            inventario.setEstado(false);
        } else {
            inventario.setEstado(true);
        }
        guardar(inventario);
    }

}