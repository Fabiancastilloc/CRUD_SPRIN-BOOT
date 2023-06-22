package udc.fabiancastillo.crudspring.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;
import udc.fabiancastillo.crudspring.modelo.Usuario;
import udc.fabiancastillo.crudspring.services.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/registrar")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "Usuario/registrar";
    }

    @PostMapping("/registrar")
    public String registrarUsuario(@ModelAttribute("usuario") Usuario usuario) {
        usuarioService.registrarUsuario(usuario);
        return "redirect:/usuario/listar";
    }

    @GetMapping("/listar")
    public String listarUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioService.obtenerTodosUsuarios());
        return "Usuario/listar";
    }

    @GetMapping("/editar/{cc}")
    public String mostrarFormularioEdicion(@PathVariable int cc, Model model) {
        Usuario usuario = usuarioService.obtenerUsuarioPorCc(cc);
        model.addAttribute("usuario", usuario);
        return "Usuario/editar";
    }

    @PostMapping("/editar")
    public String editarUsuario(@ModelAttribute("usuario") Usuario usuario) {
        usuarioService.actualizarUsuario(usuario);
        return "redirect:/usuario/listar";
    }

    @GetMapping("/eliminar/{cc}")
    public String eliminarUsuario(@PathVariable int cc) {
        usuarioService.eliminarUsuario(cc);
        return "redirect:/usuario/listar";
    }

    @GetMapping("/login")
    public String mostrarFormularioLogin(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "Usuario/login";
    }

    @PostMapping("/login")
    public String iniciarSesion(@ModelAttribute("usuario") Usuario usuario, HttpSession session, Model model) {
        if (usuarioService.validarCredenciales(usuario.getCc(), usuario.getPass())) {
            // Credenciales válidas, se inicia sesión
            session.setAttribute("loggedIn", true);
            model.addAttribute("loggedIn", true);
            model.addAttribute("usuarioLogueado", "Nombre de usuario"); // Reemplazar "Nombre de usuario" con el nombre real del usuario
            return "index";
        } else {
            // Credenciales inválidas, se redirige al formulario de inicio de sesión con un mensaje de error
            return "redirect:/usuario/login?error";
        }
    }
    
    @GetMapping("/")
    public String mostrarPaginaInicio(Model model, HttpSession session) {
        if (session.getAttribute("loggedIn") != null) {
            model.addAttribute("loggedIn", true);
            model.addAttribute("usuarioLogueado", "Nombre de usuario"); // Reemplazar "Nombre de usuario" con el nombre real del usuario
        }
        return "index";
    }


    @GetMapping("/cerrarSesion")
    public String cerrarSesion(HttpSession session) {
        session.invalidate();
        return "redirect:/usuario/login";
    }
}
