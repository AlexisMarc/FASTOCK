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
import yeilux.com.proyecto.Service.producto.IServiceCategoria;

import org.springframework.web.bind.annotation.PostMapping;



@Controller
@SessionAttributes("categoria")
@RequestMapping("/categoria")



public class CategoriaController {
    
@Autowired
private IServiceCategoria icategoria;


  // ************************************************//
    // -------------Metodo Get--------------//
    // ************************************************//

    // -------------Listar--------------//
     
    // @GetMapping(path={"/listar","","/"} )
    // public String listar(Model m) {
    //     m.addAttribute("categorias", icategoria.listar());
    //     categoria categoria = new categoria();
    //     m.addAttribute("categoria", categoria);
    //     return"views/producto/formulario";
    // }

     // ************************************************//
    // -------------Metodo POST--------------//
    // ************************************************//

    // -------------Guardar--------------//

    @PostMapping("/add")
    public String add(@Valid categoria categoria, BindingResult respuesta, Model m, SessionStatus status){
        if(respuesta.hasErrors()){
            m.addAttribute("categoria",categoria);
            return"views/producto/formulario";
        }
        icategoria.guardar(categoria);
        status.setComplete();
        return"redirect:../producto/formulario";
    }
    



    

    






}
