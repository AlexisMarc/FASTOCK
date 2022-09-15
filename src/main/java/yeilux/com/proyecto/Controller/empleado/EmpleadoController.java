package yeilux.com.proyecto.Controller.empleado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import jakarta.validation.Valid;
import yeilux.com.proyecto.Model.Class.empleado.cargo;
import yeilux.com.proyecto.Model.Class.empleado.empleado;
import yeilux.com.proyecto.Service.empleado.IServiceCargo;
import yeilux.com.proyecto.Service.empleado.IServiceEmpleado;

@Controller
@SessionAttributes("empleado")
@RequestMapping("/empleado")

public class EmpleadoController {
    @Autowired
    private IServiceEmpleado iempleado;

    @Autowired
    private IServiceCargo icargo;

// **************************************//
// -------------METODO GET--------------//
// *************************************//

// -------------LISTAR--------------//
@GetMapping(path = {"/listar", "", "/"})
public String listar(Model m){
    m.addAttribute("empleados", iempleado.listar());
    empleado empleado=new empleado();
    m.addAttribute("empleado", empleado);
    return "views/empleado/listar";
}

// -------------FORMULARIO--------------//
@GetMapping("/formulario")
public String formulario(Model m){
    empleado empleado=new empleado();
    m.addAttribute("empleado", empleado);
    m.addAttribute("cargos", icargo.listar());
    cargo cargo=new cargo();
    m.addAttribute("cargo", cargo);
    return "views/empleado/formulario";
}

// **************************************//
// -------------METODO POST-------------//
// *************************************//

// -------------GUARDAR--------------//
@PostMapping("/add")
public String add(@Valid empleado empleado, BindingResult respuesta, Model m, SessionStatus status){
    if(respuesta.hasErrors()){
        m.addAttribute("empleado", empleado);
        m.addAttribute("cargos", icargo.listar());
        cargo cargo=new cargo();
        m.addAttribute("cargo", cargo);
        return "views/empleado/formulario";
    }
    iempleado.guardar(empleado);
    status.setComplete();
    return "redirect:listar";
}

//-----------------------Editar------------------------//
@GetMapping("/edit/{id}")
public String ver(@PathVariable Integer id,Model m){

    empleado empleado=new empleado();
    if(id>0){
        empleado=iempleado.consulta(id);
    }else{
        return "redirect:listar";
    }
    cargo cargo=new cargo();
    m.addAttribute("cargo", cargo);
    m.addAttribute("empleado", empleado);
    m.addAttribute("cargos", icargo.listar());
    return "views/empleado/formulario";
}
}