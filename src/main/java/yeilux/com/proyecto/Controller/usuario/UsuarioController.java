package yeilux.com.proyecto.Controller.usuario;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import yeilux.com.proyecto.Service.usuario.IUsuario;
import yeilux.com.proyecto.Class.usuario.usuario;

@RestController
@SessionAttributes("usuario")
@RequestMapping("/usuario")

public class UsuarioController {

    @Autowired
    private IUsuario iusuario;

// ****************************************//
// --------------METODO GET----------------//
// ****************************************//

// --------------LISTAR TODOS--------------//
@PreAuthorize("hasRole('ADMIN')")
@GetMapping
	public ResponseEntity<Collection<usuario>> listarusuarios(){
		return new ResponseEntity<>(iusuario.findAll(),HttpStatus.OK);
	}

// ---------------LISTAR UNO---------------//

@GetMapping("/{id}")
	public ResponseEntity<usuario> obtenerusuarioPorId(@PathVariable Integer id){
	usuario usuario = iusuario.findById(id).orElseThrow();
		
		if(usuario != null) {
			return new ResponseEntity<>(iusuario.findById(id).orElseThrow(),HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
	}

// ****************************************//
// -------------METODO POST----------------//
// ****************************************//

// ---------------REGISTRAR----------------//

@PostMapping
	public ResponseEntity<?> guardarusuario(@RequestBody usuario usuario){
		return new ResponseEntity<>(iusuario.save(usuario),HttpStatus.CREATED);
	}

// ****************************************//
// --------------METODO PUT----------------//
// ****************************************//

// ----------------EDITAR------------------//



// ----------------ESTADO------------------//



}