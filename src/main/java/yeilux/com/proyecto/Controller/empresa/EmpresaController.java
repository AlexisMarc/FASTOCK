package yeilux.com.proyecto.Controller.empresa;

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
import yeilux.com.proyecto.Model.Class.empresa.empresa;
import yeilux.com.proyecto.Model.Class.empresa.especialidad;
import yeilux.com.proyecto.Service.empresa.IServiceEmpresa;
import yeilux.com.proyecto.Service.empresa.IServiceEspecialidad;

@Controller
@SessionAttributes("empresa")
@RequestMapping("/empresa")
public class EmpresaController {
    @Autowired
    private IServiceEmpresa iempresa;
    @Autowired
    private IServiceEspecialidad iespecialidad;

    // ************************************************//
    // -------------METODO GET---------------//
    // ************************************************//
    // ------------LISTAR------------//
    @GetMapping(path = { "/listar", "", "/" })
    public String listar(Model m) {
        m.addAttribute("empresas", iempresa.listar());
        empresa empresa = new empresa();
        m.addAttribute("empresa", empresa);
        return "views/empresa/listar";
    }

    // -----------------FORMULARIO----------------//
    @GetMapping("/formulario")
    public String formulario(Model m) {
        empresa empresa = new empresa();
        m.addAttribute("empresa", empresa);
        m.addAttribute("especialidades", iespecialidad.listar());
        especialidad especialidad = new especialidad();
        m.addAttribute("especialidad", especialidad);
        return "views/empresa/formulario";
    }

    // ************************************************//
    // -------------METODO POST---------------//
    // ************************************************//
    // -------------GUARDAR-------------//
    @PostMapping("/add")
    public String add(@Valid empresa empresa, BindingResult respuesta, Model m, SessionStatus status) {
        if (respuesta.hasErrors()) {
            m.addAttribute("empresas", empresa);
            m.addAttribute("especialidades", iespecialidad.listar());
            especialidad especialidad = new especialidad();
            m.addAttribute("especialidad", especialidad);
            return "views/empresa/formulario";
        }
        iempresa.guardar(empresa);
        status.setComplete();
        return "redirect:listar";
    }

    // -----------------------Editar------------------------//
    @GetMapping("/edit/{id}")
    public String ver(@PathVariable Integer id, Model m) {

        empresa empresa = new empresa();
        if (id > 0) {
            empresa = iempresa.consultar(id);
        } else {
            return "redirect:listar";
        }
        especialidad especialidad = new especialidad();
        m.addAttribute("especialidad", especialidad);
        m.addAttribute("empresa", empresa);
        m.addAttribute("especialidades", iespecialidad.listar());
        return "views/empresa/formulario";

    }
}
