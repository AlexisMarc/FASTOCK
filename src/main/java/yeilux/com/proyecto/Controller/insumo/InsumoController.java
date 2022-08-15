package yeilux.com.proyecto.Controller.insumo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import jakarta.validation.Valid;
import yeilux.com.proyecto.Model.Class.insumo.insumo;
import yeilux.com.proyecto.Model.Class.insumo.tipo;
import yeilux.com.proyecto.Service.insumo.IServiceInsumo;
import yeilux.com.proyecto.Service.insumo.IServiceTipo;


@Controller
@SessionAttributes("insumo")
@RequestMapping("/insumo")

public class InsumoController {

    @Autowired
    private IServiceInsumo iinsumo;
    
    @Autowired
    private IServiceTipo itipo;
    
// ************************************************//
// -------------MÉTODO GET----------------//
// ************************************************//
// -------------LISTAR----------------//
@GetMapping(path = {"/listar", "", "/"})
public String listar(Model m){
    m.addAttribute("insumos", iinsumo.listar());
    insumo insumo = new insumo();
    m.addAttribute("insumo", insumo);
    return "views/insumo/listar";
}

//-------FORMULARIO---------//
@GetMapping(path = {"/formulario"})
public String formulario(Model m){
    insumo insumo = new insumo();
    m.addAttribute("insumo", insumo);
    m.addAttribute("tipos", itipo.listar());
    tipo tipo= new tipo();
    m.addAttribute("tipo", tipo);
    return "views/insumo/formulario";
}
// ************************************************//
// -------------MÉTODO POST----------------//
// ************************************************//

// --------------GUARDAR---------------//
@PostMapping("/add")
public String add(@Valid insumo insumo, BindingResult respuesta, Model m, SessionStatus status){
    if(respuesta.hasErrors()){
        m.addAttribute("insumo", insumo);
        return "views/insumo/formulario";
    }
    iinsumo.guardar(insumo);
    status.setComplete();
    return"redirect:listar";
}
}

