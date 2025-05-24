package cl.perfulandia.sucursal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import cl.perfulandia.sucursal.modelo.Horario;
import cl.perfulandia.sucursal.repository.horarioRepository;

@Service
public class horarioService {
    private final horarioRepository horarioRepository;

    public horarioService(horarioRepository horarioRepository) {
        this.horarioRepository = horarioRepository;
    }

    public List<Horario> obtenerPorEmpleado(Long empleadoId) {
        return horarioRepository.findByEmpleadoEmpleadoId(empleadoId);
    }

    public List<Horario> obtenerPorDiaSemana(String diaSemana) {
        return horarioRepository.findByDiaSemana(diaSemana);
    }

    public Horario guardar(Horario horario) {
        return horarioRepository.save(horario);
    }

    public Optional<Horario> obtenerPorId(Long id) {
        return horarioRepository.findById(id);
    }

    public void eliminar (Long id){
        horarioRepository.deleteById(id);
    }
}
