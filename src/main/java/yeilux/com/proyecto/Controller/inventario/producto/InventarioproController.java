package yeilux.com.proyecto.Controller.inventario.producto;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
import yeilux.com.proyecto.Model.Class.inventario.producto.ListInventario;
import yeilux.com.proyecto.Model.Class.inventario.producto.entradapro;
import yeilux.com.proyecto.Model.Class.inventario.producto.inventariopro;
import yeilux.com.proyecto.Model.Class.inventario.producto.salidapro;
import yeilux.com.proyecto.Model.Class.producto.producto;
import yeilux.com.proyecto.Service.inventario.producto.IServiceEntradapro;
import yeilux.com.proyecto.Service.inventario.producto.IServiceInventariopro;
import yeilux.com.proyecto.Service.inventario.producto.IServiceSalidapro;
import yeilux.com.proyecto.Service.producto.IServiceProducto;

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

    @Autowired
    private IServiceProducto iproducto;


    // ************************************************//
    // -------------Metodo Get--------------//
    // ************************************************//

    // -------------Listar--------------//

    @GetMapping(path = { "/inventariopro", "", "/" })
    public String listar(Model m) {
        // -------------INVENTARIOPRO--------------//
        List<ListInventario> inventario = list(iinventariopro.listar());
        m.addAttribute("inventariopros", inventario);
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
        // -------------PRODUCTO--------------//
        m.addAttribute("productos", iproducto.listar());
        return "views/inventariopro/listar";

    }
// -------------LIST INVENTARIOPRO--------------//
    public List<ListInventario> list(List<inventariopro> inventario) {

        List<ListInventario> listado = new ArrayList<ListInventario>();
        Iterator<inventariopro> inte=inventario.iterator();

        while (inte.hasNext()) {
            inventariopro in= inte.next();

            ListInventario list = new ListInventario();
            list.setId(in.getId());
            if(ListInventario.TotalEntrada(in.getEntrada())==null){
                list.setEntrada(0);
            }else{
                list.setEntrada(ListInventario.TotalEntrada(in.getEntrada()));
            }
            if (ListInventario.TotalSalida(in.getSalida())==null) {
                list.setSalida(0);
            } else {
                list.setSalida(ListInventario.TotalSalida(in.getSalida()));
            }
            
            list.setProducto(in.getProducto());
            list.setEstado(in.getEstado());

            listado.add(list);
        }
        return listado;
    }

    
    // -------------GuardarINVENTARIOPRO--------------//

    @PostMapping("/addinventario")
    public String add(@Valid inventariopro inventariopro, BindingResult respuesta, Model m, SessionStatus status) {
        if (respuesta.hasErrors()) {
        // -------------INVENTARIOPRO--------------//
        m.addAttribute("inventariopros", iinventariopro.listar());
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
        producto producto=iproducto.consulta(inventariopro.getProducto().getId());
        producto.setEstado(true);
        iproducto.guardar(producto);

        iinventariopro.guardar(inventariopro);
        return "redirect:";
    }

    // -------------GuardarENTRADAPRO--------------//

    @PostMapping("/addentrada")
    public String add(@Valid entradapro entradapro, BindingResult respuesta, Model m, SessionStatus status) {
        if (respuesta.hasErrors()) {
        // -------------INVENTARIOPRO--------------//
        m.addAttribute("inventariopros", iinventariopro.listar());
        inventariopro inventariopro = new inventariopro();
        m.addAttribute("inventariopro", inventariopro);
        // -------------ENTRADAPRO--------------//
        m.addAttribute("entradapros", ientradapro.listar());
        m.addAttribute("entradapro", entradapro);
        // -------------ESALIDAPRO--------------//
        m.addAttribute("salidapros", isalidapro.listar());
        salidapro salidapro = new salidapro();
        m.addAttribute("salidapro", salidapro);
            return "views/inventariopro/listar";
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
        m.addAttribute("salidapro", salidapro);
        return "views/inventariopro/listar";
             
         }
         isalidapro.guardar(salidapro);
         status.setComplete();
         return "redirect:";
     }


     // -------------Formulario--------------//

    @GetMapping("/formulario")
    public String formulario(Model m) {
        producto producto = new producto();
        m.addAttribute("producto", producto);
        m.addAttribute("inventariopros", iinventariopro.listar());
        inventariopro inventariopro = new inventariopro();
        m.addAttribute("inventariopro", inventariopro);
        return "views/producto/formulario";
    }


}
