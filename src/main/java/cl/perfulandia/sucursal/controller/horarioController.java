package cl.perfulandia.sucursal.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import cl.perfulandia.sucursal.modelo.Horario;
import cl.perfulandia.sucursal.service.horarioService;

@RestController
@RequestMapping("horario")
public class horarioController {
    private final horarioService horarioService;

    public horarioController(horarioService horarioService) {
        this.horarioService = horarioService;
    }
    //Busco horario por empleado
    @GetMapping("/empleado/{empleadoId}")
    public ResponseEntity<List<Horario>> BuscarPorEmpleado(@PathVariable Long empleadoId) {
        return ResponseEntity.ok(horarioService.obtenerPorEmpleado(empleadoId));
    }

    //Busco por dia de la semana
    @GetMapping("/dia")
    public ResponseEntity<List<Horario>> BuscarPorDiaSemana(@RequestParam String diaSemana) {
        return ResponseEntity.ok(horarioService.obtenerPorDiaSemana(diaSemana));
    }

    //Creo un horario
    @PostMapping("/crear")
    public ResponseEntity<Horario> crearHorario(@RequestBody Horario horario) {
        return new ResponseEntity<>(horarioService.guardar(horario), HttpStatus.CREATED);
    }

    //Obtengo horario por id
    @GetMapping("/{id}")
    public ResponseEntity<Horario> obtenerHorario(@PathVariable Long id) {
        return horarioService.obtenerPorId(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
    
    //Eliminar horario
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarHorario(@PathVariable long id){
        try {
            horarioService.eliminar(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    
}
