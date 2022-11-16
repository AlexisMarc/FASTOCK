package fastock.fastock.Controller.producto;

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

import fastock.fastock.Service.inventario.ImpEntradas;
import fastock.fastock.Service.inventario.ImpInventariopro;
import fastock.fastock.Service.inventario.ImpSalidas;
import fastock.fastock.Service.producto.ImpCategoria;
import fastock.fastock.Service.producto.ImpProducto;
import fastock.fastock.Utils.EnumEntradaSalida;
import fastock.fastock.Mapping.inventario.DTOCreateEntradaSalida;
import fastock.fastock.Mapping.inventario.DTOCreateInventariopro;
import fastock.fastock.Mapping.inventario.DTOinventariopro;
import fastock.fastock.Mapping.producto.DTOCreateCategoria;
import fastock.fastock.Mapping.producto.DTOCreateProducto;
import fastock.fastock.Mapping.producto.DTOUpdateCategoria;
import fastock.fastock.Mapping.producto.DTOUpdateProducto;
import fastock.fastock.Mapping.producto.DTOcategoria;
import fastock.fastock.Mapping.producto.DTOproducto;

@RestController

@SessionAttributes("producto")
@RequestMapping("/producto")

public class ProductoController {
    @Autowired
    private ImpProducto iproducto;

	@Autowired
	private ImpCategoria icategoria;

	@Autowired
	private ImpInventariopro iinventariopro;

	@Autowired
	private ImpEntradas ientradas;

	@Autowired
	private ImpSalidas isalidas;

// ****************************************//
// --------------METODO GET----------------//
// ****************************************//

// --------------LISTAR TODOS--------------//
@GetMapping
	public ResponseEntity<List<DTOproducto>> productoes(){
		return ResponseEntity.ok(iproducto.listado());
	}


// ---------------LISTAR UNO---------------//


@GetMapping("/{id}")
	public ResponseEntity<DTOproducto> producto(@PathVariable Integer id){
		DTOproducto productoOptional = iproducto.consulta(id);
		
		if(productoOptional==null){
			return ResponseEntity.unprocessableEntity().build();
		}
		
		return ResponseEntity.ok(productoOptional);
	}

// ****************************************//
// -------------METODO POST----------------//
// ****************************************//

// ---------------REGISTRAR----------------//

@PostMapping
	public ResponseEntity<DTOproducto> guardarproducto(@Valid @RequestBody DTOCreateProducto producto){
		DTOproducto productoGuardada = iproducto.registrar(producto);
		URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(productoGuardada.getId()).toUri();
		return ResponseEntity.created(ubicacion).body(productoGuardada);
	}


// ****************************************//
// --------------METODO PUT----------------//
// ****************************************//

// ----------------EDITAR------------------//

@PutMapping("/{id}")
	public ResponseEntity<DTOproducto> actualizarproducto(@PathVariable Integer id,@Valid @RequestBody DTOUpdateProducto producto){
		DTOproducto productoID = iproducto.consulta(id);
		if(productoID==null){
			return ResponseEntity.unprocessableEntity().build();
		}else{
			producto.setId(productoID.getId());
			DTOproducto pro = iproducto.editar(producto);

			URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(producto.getId()).toUri();

			return ResponseEntity.created(ubicacion).body(pro);
		}
	}

// ----------------ESTADO------------------//

@PutMapping("/estado/{id}")
	public ResponseEntity<DTOproducto> Estadoproducto(@PathVariable Integer id){
		iproducto.estado(id);
		return ResponseEntity.ok(iproducto.consulta(id));
	}
// ************************************************************************************************************//
// --------------------------------------------CATEGORIA-------------------------------------------------------//
// ************************************************************************************************************//

// --------------LISTAR TODOS--------------//
@GetMapping("/categoria")
	public ResponseEntity<List<DTOcategoria>> categoriaes(){
		return ResponseEntity.ok(icategoria.listado());
	}


// ---------------LISTAR UNO---------------//


@GetMapping("/categoria/{id}")
	public ResponseEntity<DTOcategoria> categoria(@PathVariable Integer id){
		DTOcategoria categoriaOptional = icategoria.consulta(id);
		
		if(categoriaOptional==null){
			return ResponseEntity.unprocessableEntity().build();
		}
		
		return ResponseEntity.ok(categoriaOptional);
	}

// ****************************************//
// -------------METODO POST----------------//
// ****************************************//

// ---------------REGISTRAR----------------//

@PostMapping("/categoria")
	public ResponseEntity<DTOcategoria> guardarcategoria(@Valid @RequestBody DTOCreateCategoria categoria){
		DTOcategoria categoriaGuardada = icategoria.registrar(categoria);
		URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(categoriaGuardada.getId()).toUri();
		return ResponseEntity.created(ubicacion).body(categoriaGuardada);
	}


// ****************************************//
// --------------METODO PUT----------------//
// ****************************************//

// ----------------EDITAR------------------//

@PutMapping("/categoria/{id}")
	public ResponseEntity<DTOcategoria> actualizarcategoria(@PathVariable Integer id, @Valid @RequestBody DTOUpdateCategoria categoria){
		DTOcategoria categoriaID = icategoria.consulta(id);
		if(categoriaID==null){
			return ResponseEntity.unprocessableEntity().build();
		}else{
			categoria.setId(categoriaID.getId());
			DTOcategoria pro = icategoria.editar(categoria);

			URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(categoria.getId()).toUri();

			return ResponseEntity.created(ubicacion).body(pro);
		}
	}

// ----------------ESTADO------------------//

@PutMapping("/categoria/estado/{id}")
	public ResponseEntity<DTOcategoria> Estadocategoria(@PathVariable Integer id){
		icategoria.estado(id);
		return ResponseEntity.ok(icategoria.consulta(id));
	}

// ****************************************************************************************************************//
// ------------------------------------------INVENTARIO PRO --------------------------------------------------------//
// ************************************************************************************************************//

// ****************************************//
// --------------METODO GET----------------//
// ****************************************//

// --------------LISTAR TODOS--------------//
@GetMapping("/inventario")
	public ResponseEntity<List<DTOinventariopro>> inventarioproes(){
		return ResponseEntity.ok(iinventariopro.listado());
	}


// ---------------LISTAR UNO---------------//


@GetMapping("/inventario/{id}")
	public ResponseEntity<DTOinventariopro> inventariopro(@PathVariable Integer id){
		DTOinventariopro inventarioproOptional = iinventariopro.consulta(id);
		
		if(inventarioproOptional==null){
			return ResponseEntity.unprocessableEntity().build();
		}
		
		return ResponseEntity.ok(inventarioproOptional);
	}

// ****************************************//
// -------------METODO POST----------------//
// ****************************************//

// ---------------REGISTRAR----------------//

@PostMapping("/inventario")
	public ResponseEntity<DTOinventariopro> guardarinventariopro(@Valid @RequestBody DTOCreateInventariopro inventariopro){
		DTOinventariopro inventarioproGuardada = iinventariopro.registrar(inventariopro);
		URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(inventarioproGuardada.getId()).toUri();
		return ResponseEntity.created(ubicacion).body(inventarioproGuardada);
	}


// ****************************************//
// --------------METODO PUT----------------//
// ****************************************//


// ----------------ESTADO------------------//

@PutMapping("/inventario/estado/{id}")
	public ResponseEntity<DTOinventariopro> Estadoinventariopro(@PathVariable Integer id){
		iinventariopro.estado(id);
		return ResponseEntity.ok(iinventariopro.consulta(id));
	}

// ****************************************************************************************************************//
// ------------------------------------------ENTRADA---------------------------------------------------//
// ************************************************************************************************************//

// ****************************************//
// -------------METODO POST----------------//
// ****************************************//

// ---------------REGISTRAR----------------//

@PostMapping("/inventario/entrada")
	public ResponseEntity<?> guardarentrada(@Valid @RequestBody DTOCreateEntradaSalida entrada){
		entrada.setTipo(EnumEntradaSalida.PRODUCTO);
		ientradas.registrar(entrada);

		return ResponseEntity.ok(null);
	}


// ****************************************//
// --------------METODO PUT----------------//
// ****************************************//

// ----------------ESTADO------------------//

@PutMapping("/inventario/entrada/estado/{id}")
	public ResponseEntity<?> Estadoentrada(@PathVariable Integer id){
		ientradas.estado(id, EnumEntradaSalida.PRODUCTO);
		return ResponseEntity.ok(null);
	}

// ****************************************************************************************************************//
// ------------------------------------------SALIDA--------------------------------------------------------//
// ************************************************************************************************************//

// ****************************************//
// -------------METODO POST----------------//
// ****************************************//

// ---------------REGISTRAR----------------//

@PostMapping("/inventario/salida")
	public ResponseEntity<?> guardarsalida(@Valid @RequestBody DTOCreateEntradaSalida salida){
		salida.setTipo(EnumEntradaSalida.PRODUCTO);
		isalidas.registrar(salida);

		return ResponseEntity.ok(null);
	}


// ****************************************//
// --------------METODO PUT----------------//
// ****************************************//

// ----------------ESTADO------------------//

@PutMapping("/inventario/salida/estado/{id}")
	public ResponseEntity<?> Estadosalida(@PathVariable Integer id){
		isalidas.estado(id, EnumEntradaSalida.PRODUCTO);
		return ResponseEntity.ok(null);
	}

}
