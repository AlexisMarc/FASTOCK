package yeilux.com.proyecto.Controller.inventario.insumo;

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
import yeilux.com.proyecto.Model.Class.inventario.insumo.entrada;
import yeilux.com.proyecto.Model.Class.inventario.insumo.inventario;
import yeilux.com.proyecto.Model.Class.inventario.insumo.salida;
import yeilux.com.proyecto.Service.inventario.insumo.IServiceEntrada;
import yeilux.com.proyecto.Service.inventario.insumo.IServiceInventario;
import yeilux.com.proyecto.Service.inventario.insumo.IServiceSalida;

@Controller
@SessionAttributes("inventario")
@RequestMapping("/inventario")
public class InventarioController {

public class InsumoController {

    @Autowired
    private IServiceInventario iinventario;
    @Autowired
    private IServiceEntrada ientrada;
    @Autowired
    private IServiceSalida isalida;
    
// ************************************************//
// -------------MÉTODO GET----------------//
// ************************************************//
// -------------LISTAR----------------//
@GetMapping(path = {"/listar", "", "/"})
public String listar(Model m){
    m.addAttribute("inventarios", iinventario.listar());
    inventario inventario = new inventario();
    m.addAttribute("inventario", inventario);
        m.addAttribute("entradas", ientrada.listar());
        entrada entrada = new entrada();
        m.addAttribute("entrada", entrada);
        m.addAttribute("salidas", isalida.listar());
        salida salida = new salida();
        m.addAttribute("salida", salida);
    return "views/insumo/listar";
}

//-------FORMULARIO---------//
@GetMapping(path = {"/formulario"})
public String formulario(Model m){
    inventario inventario = new inventario();
    m.addAttribute("inventario",inventario);
    m.addAttribute("tipos", iinventario.listar());
    return "views/inventario/insumo/formulario";
}
// ************************************************//
// -------------MÉTODO POST----------------//
// ************************************************//

// --------------GUARDAR---------------//
@PostMapping("/add")
public String add(@Valid inventario inventario, BindingResult respuesta, Model m, SessionStatus status){
    if(respuesta.hasErrors()){
        m.addAttribute("inventario", inventario);
        return "views/inventario/insumo/formulario";
    }
    iinventario.guardar(inventario);
    status.setComplete();
    return"redirect:";
}
@PostMapping("/addentrada")
public String add(@Valid entrada entrada, BindingResult respuesta, Model m, SessionStatus status){
    if(respuesta.hasErrors()){
        m.addAttribute("entrada", entrada);
        return "views/inventario/insumo/formulario";
    }
    ientrada.guardar(entrada);
    status.setComplete();
    return"redirect:";
}
@PostMapping("/addsalida")
public String add(@Valid salida salida, BindingResult respuesta, Model m, SessionStatus status){
    if(respuesta.hasErrors()){
        m.addAttribute("salida",salida);
        return "views/inventario/insumo/formulario";
    }
    isalida.guardar(salida);
    status.setComplete();
    return"redirect:";
}
}

}
