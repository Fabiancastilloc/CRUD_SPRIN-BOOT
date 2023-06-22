package udc.fabiancastillo.crudspring.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import udc.fabiancastillo.crudspring.modelo.Contrato;
import udc.fabiancastillo.crudspring.services.ContratoService;

@Controller
@RequestMapping("/contrato")
public class ContratoController {

    private final ContratoService contratoService;

    @Autowired
    public ContratoController(ContratoService contratoService) {
        this.contratoService = contratoService;
    }

    @GetMapping("/agregar")
    public String mostrarFormularioAgregar(Model model) {
        model.addAttribute("contrato", new Contrato());
        model.addAttribute("cedulas", contratoService.obtenerCedulasUsuarios());
        return "Contrato/agregar";
    }

    @PostMapping("/agregar")
    public String agregarContrato(@ModelAttribute("contrato") Contrato contrato) {
        contratoService.agregarContrato(contrato);
        return "redirect:/contrato/agregar";
    }

    @GetMapping("/listar")
    public String listarContratos(Model model) {
        model.addAttribute("contratos", contratoService.obtenerTodosContratos());
        return "Contrato/listar";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable("id") int id, Model model) {
        Contrato contrato = contratoService.obtenerContratoPorId(id);
        if (contrato != null) {
            model.addAttribute("contrato", contrato);
            model.addAttribute("cedulas", contratoService.obtenerCedulasUsuarios());
            return "Contrato/editar";
        }
        return "redirect:/contrato/listar";
    }

    @PostMapping("/editar")
    public String editarContrato(@ModelAttribute("contrato") Contrato contrato) {
        contratoService.editarContrato(contrato);
        return "redirect:/contrato/listar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarContrato(@PathVariable("id") int id) {
        contratoService.eliminarContrato(id);
        return "redirect:/contrato/listar";
    }
}






