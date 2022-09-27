package yeilux.com.proyecto.Controller.producto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import yeilux.com.proyecto.Model.Class.producto.categoria;
import yeilux.com.proyecto.Model.Class.producto.producto;
import yeilux.com.proyecto.Service.producto.IServiceCategoria;
import yeilux.com.proyecto.Service.producto.IServiceProducto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        categoria categoria = new categoria();
        m.addAttribute("categoria", categoria);
        return "views/producto/formulario";
    }

    // ************************************************//
    // -------------Metodo POST--------------//
    // ************************************************//

    // -------------Guardar--------------//

    @PostMapping("/add")
    public String add(@Valid producto producto, BindingResult respuesta, Model m, SessionStatus status, @RequestParam("file") MultipartFile imagen) {
        if (respuesta.hasErrors()) {
            m.addAttribute("producto", producto);
            m.addAttribute("categorias", icategoria.listar());
            categoria categoria = new categoria();
            m.addAttribute("categoria", categoria);
            return "views/producto/formulario";
        }

        if(!imagen.isEmpty()){

            Path directorioImagenes =Paths.get("src//main//resources//static/assets/imagenes");
            String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();

            try {
                byte[] bytesImg = imagen.getBytes();
                Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + imagen.getOriginalFilename());
                Files.write(rutaCompleta,bytesImg);

                producto.setImagen(imagen.getOriginalFilename());

            } catch (IOException e) {
                
                e.printStackTrace();
            }
        }
        iproducto.guardar(producto);
        status.setComplete();
        return "redirect:";
    }

    //-----------------------Editar------------------------//
@GetMapping("/edit/{id}")
public String ver(@PathVariable Integer id,Model m){
 
   producto producto=new producto();
   if(id>0){
       producto=iproducto.consulta(id);
   }else{
       return "redirect:listar";
   }
   categoria categoria=new categoria();
   m.addAttribute("categoria", categoria);
   m.addAttribute("producto", producto);
   m.addAttribute("categorias", icategoria.listar());
   return "views/producto/formulario";
}


}
