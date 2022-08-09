package yeilux.com.proyecto.Controller.empresa;

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
import yeilux.com.proyecto.Model.Class.empresa.especialidad;
import yeilux.com.proyecto.Service.empresa.IServiceEspecialidad;

@Controller
@SessionAttributes("especialidad")
@RequestMapping("/especialidad") 
public class EspecialidadController {
    @Autowired
    private IServiceEspecialidad iespecialidad;
// ************************************************//
// -------------METODO GET---------------//
// ************************************************//
// ------------LISTAR------------//
@GetMapping(path = {"/listar", "", "/"})
public String listar(Model m){
    m.addAttribute("especialidades", iespecialidad.listar());
    especialidad especialidad =new especialidad();
    m.addAttribute("especialidad", especialidad);
    return "views/empresa/formulario";
}
// ************************************************//
// -------------METODO POST---------------//
// ************************************************//
// -------------GUARDAR-------------//
@PostMapping("/add")
public String add(@Valid especialidad especialidad, BindingResult respuesta, Model m, SessionStatus status){
    if(respuesta.hasErrors()){
        m.addAttribute("especialidades", especialidad);
    return "views/empresa/formulario";
    }
    iespecialidad.guardar(especialidad);
    status.setComplete();
    return "redirect:listar";
    }
}
