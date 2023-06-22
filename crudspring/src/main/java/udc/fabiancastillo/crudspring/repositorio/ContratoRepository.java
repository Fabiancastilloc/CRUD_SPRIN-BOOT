package udc.fabiancastillo.crudspring.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import udc.fabiancastillo.crudspring.modelo.Contrato;

import java.util.List;

@Repository
public interface ContratoRepository extends JpaRepository<Contrato, Integer> {

    @Query("SELECT DISTINCT c.usuarioCedula FROM Contrato c")
    List<Integer> findDistinctUsuarioCedula();
}



