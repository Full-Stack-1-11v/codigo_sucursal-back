package cl.perfulandia.sucursal.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cl.perfulandia.sucursal.modelo.Horario;
import cl.perfulandia.sucursal.service.horarioService;

@RestController
@RequestMapping("/sucursal/horario")
public class horarioController {
    private final horarioService service;

    public horarioController(horarioService service) {
        this.service = service; 
    }

    @GetMapping("/listar")
    public List<Horario> listar() {
        return service.listar(); 
    }

    @PostMapping("/agregar")
    public Horario guardar(@RequestBody Horario h) {
        return service.guardar(h); 
    }

     @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarSucursal(@PathVariable long id){
        try {
            service.eliminar(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Horario> buscarSucursal (@PathVariable long id){
        try{
            Horario horario = service.buscar(id);
            return ResponseEntity.ok(horario);
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }
    
}