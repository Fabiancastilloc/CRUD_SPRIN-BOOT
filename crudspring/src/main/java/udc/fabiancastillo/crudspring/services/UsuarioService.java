package udc.fabiancastillo.crudspring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import udc.fabiancastillo.crudspring.modelo.Usuario;
import udc.fabiancastillo.crudspring.repositorio.UsuarioRepository;


import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void registrarUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public List<Usuario> obtenerTodosUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario obtenerUsuarioPorCc(int cc) {
        return usuarioRepository.findById(cc).orElse(null);
    }

    public void actualizarUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public void eliminarUsuario(int cc) {
        usuarioRepository.deleteById(cc);
    }

    public List<String> obtenerTodasCedulas() {
        return usuarioRepository.obtenerTodasCedulas();
    }
    public boolean validarCredenciales(int cc, String pass) {
        Usuario usuario = usuarioRepository.findById(cc).orElse(null);
        if (usuario != null) {
            return usuario.getPass().equals(pass);
        }
        return false;
    }
}


