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
import cl.perfulandia.sucursal.modelo.Empleado;
import cl.perfulandia.sucursal.service.empleadoService;

@RestController
@RequestMapping("/api/v1/empleado")
public class empleadoController {
    private final empleadoService service;

    public empleadoController(empleadoService service) {
        this.service = service; 
    }

    @GetMapping("/listar")
    public List<Empleado> listar() {
        return service.listar(); 
    }

    @PostMapping("/agregar")
    public Empleado guardar(@RequestBody Empleado empleado) {
        return service.guardar(empleado); 
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
    public ResponseEntity<Empleado> buscarSucursal (@PathVariable long id){
        try{
            Empleado empleado = service.buscar(id);
            return ResponseEntity.ok(empleado);
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }

}
