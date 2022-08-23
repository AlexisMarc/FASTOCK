package yeilux.com.proyecto.Controller.inventario.producto;

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
import yeilux.com.proyecto.Model.Class.inventario.producto.entradapro;
import yeilux.com.proyecto.Model.Class.inventario.producto.inventariopro;
import yeilux.com.proyecto.Model.Class.inventario.producto.salidapro;
import yeilux.com.proyecto.Service.inventario.producto.IServiceEntradapro;
import yeilux.com.proyecto.Service.inventario.producto.IServiceInventariopro;
import yeilux.com.proyecto.Service.inventario.producto.IServiceSalidapro;

@Controller
@SessionAttributes("inventariopro")
@RequestMapping("/inventariopro")
public class InventarioproController {

    @Autowired
    private IServiceInventariopro iinventariopro;

    @Autowired
    private IServiceEntradapro ientradapro;

    @Autowired
    private IServiceSalidapro isalidapro;

    // ************************************************//
    // -------------Metodo Get--------------//
    // ************************************************//

    // -------------Listar--------------//

    @GetMapping(path = { "/inventariopro", "", "/" })
    public String listar(Model m) {
        // -------------INVENTARIOPRO--------------//
        m.addAttribute("inventariopros", iinventariopro.listar());
        inventariopro inventariopro = new inventariopro();
        m.addAttribute("inventariopro", inventariopro);
        // -------------ENTRADAPRO--------------//
        m.addAttribute("entradapros", ientradapro.listar());
        entradapro entradapro = new entradapro();
        m.addAttribute("entradapro", entradapro);
        // -------------ESALIDAPRO--------------//
        m.addAttribute("salidapros", isalidapro.listar());
        salidapro salidapro = new salidapro();
        m.addAttribute("salidapro", salidapro);
        return "views/inventariopro/listar";

    }

    // -------------GuardarINVENTARIOPRO--------------//

    @PostMapping("/addinventario")
    public String add(@Valid inventariopro inventariopro, BindingResult respuesta, Model m, SessionStatus status) {
        if (respuesta.hasErrors()) {
            m.addAttribute("inventariopro", inventariopro);
            return "views/inventariopro/formulario";
        }
        iinventariopro.guardar(inventariopro);
        status.setComplete();
        return "redirect:";
    }

    // -------------GuardarENTRADAPRO--------------//

    @PostMapping("/addentrada")
    public String add(@Valid entradapro entradapro, BindingResult respuesta, Model m, SessionStatus status) {
        if (respuesta.hasErrors()) {
            m.addAttribute("entradapro", entradapro);
            return "views/entradapro/formulario";
        }
        ientradapro.guardar(entradapro);
        status.setComplete();
        return "redirect:";
    }

     // -------------GuardarSALIDAPRO--------------//

     @PostMapping("/addsalida")
     public String add(@Valid salidapro salidapro, BindingResult respuesta, Model m, SessionStatus status) {
         if (respuesta.hasErrors()) {
             m.addAttribute("salidapro", salidapro);
             return "views/salidapro/formulario";
         }
         isalidapro.guardar(salidapro);
         status.setComplete();
         return "redirect:";
     }

}
