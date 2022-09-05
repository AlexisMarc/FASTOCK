package yeilux.com.proyecto.Controller.producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import jakarta.validation.Valid;
import yeilux.com.proyecto.Model.Class.producto.categoria;
import yeilux.com.proyecto.Model.Class.producto.producto;
import yeilux.com.proyecto.Service.producto.IServiceCategoria;
import yeilux.com.proyecto.Service.producto.IServiceProducto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@SessionAttributes("producto")
@RequestMapping("/producto")

public class ProductoController {

    @Autowired
    private IServiceProducto iproducto;

    @Autowired
    private IServiceCategoria icategoria;

    // ************************************************//
    // -------------Metodo Get--------------//
    // ************************************************//

    // -------------Listar--------------//

    @GetMapping(path = { "/producto", "", "/" })
    public String listar(Model m) {
        m.addAttribute("productos", iproducto.listar());
        producto producto = new producto();
        m.addAttribute("producto", producto);
        return "views/producto/listar";
    }

    // -------------Formulario--------------//

    @GetMapping("/formulario")
    public String formulario(Model m) {
        producto producto = new producto();
        m.addAttribute("producto", producto);
        m.addAttribute("categorias", icategoria.listar());
        m.addAttribute("productoCategoria",icategoria.productoCategoria());
        categoria categoria = new categoria();
        m.addAttribute("categoria", categoria);
        return "views/producto/formulario";
    }

    // ************************************************//
    // -------------Metodo POST--------------//
    // ************************************************//

    // -------------Guardar--------------//

    @PostMapping("/add")
    public String add(@Valid producto producto, BindingResult respuesta, Model m, SessionStatus status) {
        if (respuesta.hasErrors()) {
            m.addAttribute("producto", producto);
            m.addAttribute("categorias", icategoria.listar());
            categoria categoria = new categoria();
            m.addAttribute("categoria", categoria);
            return "views/producto/formulario";
        }
        producto.setCategoria(icategoria.productoCategoria());
        iproducto.guardar(producto);
        icategoria.eliminarCategorias();
        status.setComplete();
        return "redirect:";
    }

}
