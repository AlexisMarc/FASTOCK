package yeilux.com.proyecto.Controller.proveedor;

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
import yeilux.com.proyecto.Model.Class.proveedor.proveedor;
import yeilux.com.proyecto.Service.proveedor.IServiceProveedor;

@Controller
@SessionAttributes("proveedor")
@RequestMapping("/proveedor") 
public class ProveedorController {
    @Autowired
    private IServiceProveedor iproveedor;
// ************************************************//
// -------------METODO GET---------------//
// ************************************************//
// ------------LISTAR------------//
@GetMapping(path = {"/listar", "", "/"})
public String listar(Model m){
    m.addAttribute("proveedores", iproveedor.listar());
    return "views/proveedor/listar";
}
//-----------------FORMULARIO----------------//
@GetMapping("/formulario")
public String formulario(Model m){
    proveedor proveedor =new proveedor();
    m.addAttribute("proveedor", proveedor);
    return "views/proveedor/formulario";
}
// ************************************************//
// -------------METODO POST---------------//
// ************************************************//
// -------------GUARDAR-------------//
@PostMapping("/add")
public String add(@Valid proveedor proveedor, BindingResult respuesta, Model m, SessionStatus status){
    if(respuesta.hasErrors()){
        m.addAttribute("proveedors", proveedor);
    return "views/proveedor/formulario";
    }
    iproveedor.guardar(proveedor);
    status.setComplete();
    return "redirect:listar";
    }
}
