package udc.fabiancastillo.crudspring.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import udc.fabiancastillo.crudspring.modelo.Usuario;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query("SELECT DISTINCT u.cc FROM Usuario u")
    List<String> obtenerTodasCedulas();
}
