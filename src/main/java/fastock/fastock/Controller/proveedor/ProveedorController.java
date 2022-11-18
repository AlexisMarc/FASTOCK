package fastock.fastock.Controller.proveedor;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import fastock.fastock.Service.proveedor.ImpProveedor;
import fastock.fastock.Mapping.proveedor.DTOCreateProveedor;
import fastock.fastock.Mapping.proveedor.DTOUpdateProveedor;
import fastock.fastock.Mapping.proveedor.DTOproveedor;

@RestController

@SessionAttributes("proveedor")
@RequestMapping("/proveedor") 
public class ProveedorController {

    @Autowired
    private ImpProveedor iproveedor;

// ****************************************//
// --------------METODO GET----------------//
// ****************************************//

// --------------LISTAR TODOS--------------//
@GetMapping
	public ResponseEntity<List<DTOproveedor>> proveedores(){
		return ResponseEntity.ok(iproveedor.listado());
	}


// ---------------LISTAR UNO---------------//


@GetMapping("/{id}")
	public ResponseEntity<DTOproveedor> proveedor(@PathVariable Integer id){
		DTOproveedor proveedorOptional = iproveedor.consulta(id);
		
		if(proveedorOptional==null){
			return ResponseEntity.unprocessableEntity().build();
		}
		
		return ResponseEntity.ok(proveedorOptional);
	}

// ****************************************//
// -------------METODO POST----------------//
// ****************************************//

// ---------------REGISTRAR----------------//

@PostMapping
	public ResponseEntity<DTOproveedor> guardarproveedor(@Valid @RequestBody DTOCreateProveedor proveedor){
		DTOproveedor proveedorGuardada = iproveedor.registrar(proveedor);
		URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(proveedorGuardada.getId()).toUri();
		return ResponseEntity.created(ubicacion).body(proveedorGuardada);
	}


// ****************************************//
// --------------METODO PUT----------------//
// ****************************************//

// ----------------EDITAR------------------//

@PutMapping("/{id}")
	public ResponseEntity<DTOproveedor> actualizarproveedor(@PathVariable Integer id,@Valid @RequestBody DTOUpdateProveedor proveedor){
		DTOproveedor proveedorID = iproveedor.consulta(id);
		if(proveedorID==null){
			return ResponseEntity.unprocessableEntity().build();
		}else{
			proveedor.setId(proveedorID.getId());
			DTOproveedor pro = iproveedor.editar(proveedor);

			URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(proveedor.getId()).toUri();

			return ResponseEntity.created(ubicacion).body(pro);
		}
	}

// ----------------ESTADO------------------//

@PutMapping("/estado/{id}")
	public ResponseEntity<DTOproveedor> EstadoProveedor(@PathVariable Integer id){
		iproveedor.estado(id);
		return ResponseEntity.ok(iproveedor.consulta(id));
	}

// ----------------EXPORTAR PDDF EN ORDEN------------------//

@GetMapping("exportInvoice")
public ResponseEntity<Resource> exportInvoice(@RequestParam int id, @RequestParam int idOrden){
	return this.service.exportInvoice(id, idOrden);
}
