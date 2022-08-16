package yeilux.com.proyecto.Controller.insumo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import jakarta.validation.Valid;
import yeilux.com.proyecto.Model.Class.insumo.tipo;
import yeilux.com.proyecto.Service.insumo.IServiceTipo;
@Controller
@SessionAttributes("tipo")
@RequestMapping("/tipo")
public class TipoController {

    @Autowired
    private IServiceTipo itipo;

// ************************************************//
// -------------MÉTODO GET----------------//
// ************************************************//

// -------------LISTAR----------------//
/*@GetMapping(path = {"/listar", "", "/"})
public String listar(Model m){
    m.addAttribute("tipos", itipo.listar());
    tipo tipo= new tipo();
    m.addAttribute("tipo", tipo);
    return "views/insumo/formulario";
}*/
// ************************************************//
// -------------MÉTODO POST----------------//
// ************************************************//

// --------------GUARDAR---------------//

@PostMapping("/add")
public String add(@Valid tipo tipo, BindingResult respuesta, Model m, SessionStatus status){
    if(respuesta.hasErrors()){
        m.addAttribute("tipo", tipo);
        return "views/insumo/formulario";
    }
    itipo.guardar(tipo);
    status.setComplete();
    return"redirect:../insumo/formulario";
}
}
