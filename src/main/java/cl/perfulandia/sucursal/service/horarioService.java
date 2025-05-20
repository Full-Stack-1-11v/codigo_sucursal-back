package cl.perfulandia.sucursal.service;

import java.util.List;

import org.springframework.stereotype.Service;


import cl.perfulandia.sucursal.modelo.Horario;
import cl.perfulandia.sucursal.repository.horarioRepository;

@Service
public class horarioService {
    private final horarioRepository repository;

    public horarioService(horarioRepository repository) {
        this.repository = repository; 
    }

    public List<Horario> listar() {
        return repository.findAll(); 
    }

    public Horario guardar(Horario horario) {
        return repository.save(horario); 
    }

    public void eliminar (long id){
        repository.deleteById(id);
    }

    public Horario buscar(long id){
        return repository.findById(id).get();
    }
}
