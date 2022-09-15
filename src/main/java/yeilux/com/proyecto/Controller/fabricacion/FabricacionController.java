package yeilux.com.proyecto.Controller.fabricacion;
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
import yeilux.com.proyecto.Model.Class.fabricacion.area;
import yeilux.com.proyecto.Model.Class.fabricacion.fabricacion;
import yeilux.com.proyecto.Model.Class.fabricacion.listFabricacion;
import yeilux.com.proyecto.Service.empleado.IServiceEmpleado;
import yeilux.com.proyecto.Service.fabricacion.IServiceArea;
import yeilux.com.proyecto.Service.fabricacion.IServiceFabricacion;
import yeilux.com.proyecto.Service.producto.IServiceProducto;

@Controller
@SessionAttributes("fabricacion")
@RequestMapping("/fabricacion") 
public class FabricacionController {
    @Autowired
    private IServiceFabricacion ifabricacion;
    @Autowired
    private IServiceArea iarea;
    @Autowired
    private IServiceProducto iproducto;
    @Autowired
    private IServiceEmpleado iempleado;
// ************************************************//
// -------------METODO GET---------------//
// ************************************************//
// ------------LISTAR------------//
@GetMapping(path = {"/listar", "", "/"})
public String listar(Model m){
    m.addAttribute("fabricacions", ifabricacion.listar());
    fabricacion fabricacion =new fabricacion();
    m.addAttribute("fabricacion", fabricacion);
    return "views/fabricacion/listar";
}
//-----------------FORMULARIO----------------//
@GetMapping("/formulario")
public String formulario(Model m){
    listFabricacion fabricacion =new listFabricacion();
    m.addAttribute("fabricacion", fabricacion);
    m.addAttribute("areaes", iarea.listar());
    m.addAttribute("productos", iproducto.listar());
    m.addAttribute("empleados", iempleado.listar());
    area area =new area();
    m.addAttribute("area", area);
    return "views/fabricacion/formulario";
}
// ************************************************//
// -------------METODO POST---------------//
// ************************************************//
// -------------GUARDAR-------------//
@PostMapping("/add")
public String add(@Valid listFabricacion fabricacion, BindingResult respuesta, Model m, SessionStatus status){
    if(respuesta.hasErrors()){
        m.addAttribute("fabricacions", fabricacion);
        m.addAttribute("areaes", iarea.listar());
        area area =new area();
        m.addAttribute("area", area);
    return "views/fabricacion/formulario";
    }
    status.setComplete();
    return "redirect:listar";
    }
}
