package fastock.fastock.Service.proveedor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import fastock.fastock.Class.proveedor.proveedor;
import fastock.fastock.Mapping.proveedor.DTOCreateProveedor;
import fastock.fastock.Mapping.proveedor.DTOUpdateProveedor;
import fastock.fastock.Mapping.proveedor.DTOproveedor;

@Service
public class ImpProveedor {

    @Autowired
    private IProveedor proveedori;

    // LISTAR
    private List<proveedor> listar() {
        return (List<proveedor>) proveedori.findAll();
    }

    // GUARDAR
    private proveedor guardar(proveedor proveedor) {
        proveedor pro = proveedori.save(proveedor);
        return pro;
    }

    // CONSULTAR
    private proveedor consultar(Integer id) {
        return proveedori.findById(id).orElse(null);
    }

    // DTOCREATE A ENTITY
    private proveedor DTOCreate(DTOCreateProveedor DTO) {
        proveedor proveedor = new proveedor();

        proveedor.setNombre(DTO.getNombre());
        proveedor.setEmail(DTO.getEmail());
        proveedor.setEstado(true);
        proveedor.setTelefono(DTO.getTelefono());
        proveedor.setDireccion(DTO.getDireccion());
        proveedor.setContacto(DTO.getContacto());

        return proveedor;
    }

    // DTOUPDATE A ENTITY
    private proveedor DTOUpdate(DTOUpdateProveedor DTO) {
        proveedor proveedor = new proveedor();

        proveedor.setId(DTO.getId());
        proveedor.setNombre(DTO.getNombre());
        proveedor.setEmail(DTO.getEmail());
        proveedor.setEstado(DTO.getEstado());
        proveedor.setTelefono(DTO.getTelefono());
        proveedor.setDireccion(DTO.getDireccion());
        proveedor.setContacto(DTO.getContacto());

        return proveedor;
    }

    // ENTITY A DTOPROVEEDOR
    private DTOproveedor DTOproveedor(proveedor proveedor) {
        DTOproveedor DTO = new DTOproveedor();

        DTO.setId(proveedor.getId());
        DTO.setNombre(proveedor.getNombre());
        DTO.setEmail(proveedor.getEmail());
        DTO.setContacto(proveedor.getContacto());
        DTO.setTelefono(proveedor.getTelefono());
        DTO.setDireccion(proveedor.getDireccion());
        DTO.setEstado(proveedor.getEstado());

        return DTO;
    }

    // ***************************************************************//
    // PUBLICOS
    // ***************************************************************//

    // LISTADO
    public List<DTOproveedor> listado() {
        List<DTOproveedor> DTO = new ArrayList<DTOproveedor>();
        List<proveedor> proveedores = listar();

        Iterator<proveedor> i = proveedores.iterator();

        while (i.hasNext()) {
            proveedor interar = i.next();
            if (interar.getEstado()) {
                DTOproveedor DTOs = DTOproveedor(interar);
                DTO.add(DTOs);
            }

        }
        return DTO;
    }

    // LISTADO DE ELIMINADOS
    public List<DTOproveedor> eliminados() {
        List<DTOproveedor> DTO = new ArrayList<DTOproveedor>();
        List<proveedor> proveedores = listar();

        Iterator<proveedor> i = proveedores.iterator();

        while (i.hasNext()) {
            proveedor interar = i.next();
            if (interar.getEstado()==false) {
                DTOproveedor DTOs = DTOproveedor(interar);
                DTO.add(DTOs);
            }

        }
        return DTO;
    }

    // CONSULTAR
    public DTOproveedor consulta(Integer id) {
        if (proveedori.existsById(id)) {
            return DTOproveedor(consultar(id));
        } else {
            return null;
        }

    }

    // EDITAR
    public DTOproveedor editar(DTOUpdateProveedor DTO) {
        proveedor proveedor = guardar(DTOUpdate(DTO));
        return DTOproveedor(proveedor);
    }

    // REGISTAR
    public DTOproveedor registrar(DTOCreateProveedor DTO) {
        proveedor proveedor = guardar(DTOCreate(DTO));
        return DTOproveedor(proveedor);
    }

    // ESTADO
    public void estado(Integer id) {
        proveedor proveedor = consultar(id);
        if (proveedor.getEstado()) {
            proveedor.setEstado(false);
        } else {
            proveedor.setEstado(true);
        }
        guardar(proveedor);
    }


    @NotNull
  public ResponseEntity<Resource> exportInvoice(int id, int idOrden) {
    proveedor optProveedor = this.repository.findByIdAndClienteId(id, idOrden);
    Double rpta = this.detalleProveedorRepository.totalByIdCustomer(id);
    if (optProveedor.isPresent()) {
      try {
        final Proveedor proveedor = optProveedor.get();
        final File file = ResourceUtils.getFile("classpath:exportInvoice.jasper");
        final File imgLogo = ResourceUtils.getFile("classpath:images/logoCevicheria.png");
        final JasperReport report = (JasperReport) JRLoader.loadObject(file);

        final HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("nombreCliente", proveedor.getCliente().getNombreCompletoCiente());
        parameters.put("imgLogo", new FileInputStream(imgLogo));
        parameters.put("total", rpta);
        parameters.put("dsInvoice", new JRBeanCollectionDataSource((Collection<?>) this.detalleProveedorRepository.findByProveedor(idOrden)));

        JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, new JREmptyDataSource());
        byte[] reporte = JasperExportManager.exportReportToPdf(jasperPrint);
        String sdf = (new SimpleDateFormat("dd/MM/yyyy")).format(new Date());
        StringBuilder stringBuilder = new StringBuilder().append("InvoicePDF:");
        ContentDisposition contentDisposition = ContentDisposition.builder("attachment")
            .filename(stringBuilder.append(Proveedor.getId())
                .append("generateDate:")
                .append(sdf)
                .append(".pdf")
                .toString())
            .build();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDisposition(contentDisposition);
        return ResponseEntity.ok().contentLength((long) reporte.length)
            .contentType(MediaType.APPLICATION_PDF)
            .headers(headers).body(new ByteArrayResource(reporte));
      } catch (Exception e) {
        e.printStackTrace();
      }
    } else {
      return ResponseEntity.noContent().build(); //No se encontro el reporte
    }
    return null;
  }
}
