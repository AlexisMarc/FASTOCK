package yeilux.com.proyecto.Controller.empleado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import jakarta.validation.Valid;
import yeilux.com.proyecto.Model.Class.empleado.cargo;
import yeilux.com.proyecto.Service.empleado.IServiceCargo;

@Controller
@SessionAttributes("cargo")
@RequestMapping("/cargo")
public class CargoController {
    @Autowired
    private IServiceCargo icargo;

// **************************************//
// -------------METODO GET--------------//
// *************************************//

// -------------LISTAR--------------//
// @GetMapping(path = {"/listar", "", "/"})
// public String listar(Model m){
//     m.addAttribute("cargos", icargo.listar());
//     cargo cargo=new cargo();
//     m.addAttribute("cargo", cargo);
//     return "views/empleado/formulario";
// }




// **************************************//
// -------------METODO POST-------------//
// *************************************//

// -------------GUARDAR--------------//
@PostMapping("/add")
public String add(@Valid cargo cargo, BindingResult respuesta, Model m, SessionStatus status){
    if(respuesta.hasErrors()){
        m.addAttribute("cargo", cargo);
        return "views/empleado/formulario";
    }
    icargo.guardar(cargo);
    status.setComplete();
    return "redirect:../empleado/formulario";
}
}
