package udc.fabiancastillo.crudspring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import udc.fabiancastillo.crudspring.modelo.Contrato;
import udc.fabiancastillo.crudspring.repositorio.ContratoRepository;

import java.util.List;

@Service
public class ContratoService {

    private final ContratoRepository contratoRepository;

    @Autowired
    public ContratoService(ContratoRepository contratoRepository) {
        this.contratoRepository = contratoRepository;
    }

    public void agregarContrato(Contrato contrato) {
        contratoRepository.save(contrato);
    }

    public List<Contrato> obtenerTodosContratos() {
        return contratoRepository.findAll();
    }

    public Contrato obtenerContratoPorId(int id) {
        return contratoRepository.findById(id).orElse(null);
    }

    public void editarContrato(Contrato contrato) {
        contratoRepository.save(contrato);
    }

    public void eliminarContrato(int id) {
        contratoRepository.deleteById(id);
    }

    public List<Integer> obtenerCedulasUsuarios() {
        return contratoRepository.findDistinctUsuarioCedula();
    }
}



