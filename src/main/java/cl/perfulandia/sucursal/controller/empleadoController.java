package cl.perfulandia.sucursal.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import cl.perfulandia.sucursal.modelo.Empleado;
import cl.perfulandia.sucursal.service.empleadoService;

@RestController
@RequestMapping("/empleado")
public class empleadoController {
    private final empleadoService service;

    public empleadoController(empleadoService service) {
        this.service = service; 
    }
    
    //Listo todos los empleados
    @GetMapping("/listar")
    public List<Empleado> listar() {
        return service.listar(); 
    }

    //agrego empleados
    @PostMapping("/agregar")
    public Empleado guardar(@RequestBody Empleado empleado) {
        return service.guardar(empleado); 
    }

    //Busco empleado por nombre
    @GetMapping("/buscar/nombre")
    public ResponseEntity<List<Empleado>> buscarPorNombre(@RequestParam String nombreEmpleado) {
        return ResponseEntity.ok(service.buscarPorNombre(nombreEmpleado));
    }

    //Obtengo empleados por sucursal
    @GetMapping("/sucursal/{sucursalId}")
    public ResponseEntity<List<Empleado>> obtenerPorSucursal(@PathVariable Long sucursalId) {
        return ResponseEntity.ok(service.obtenerPorSucursal(sucursalId));
    }

    //elimino un empleado
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarSucursal(@PathVariable long sucursalId){
        try {
            service.eliminar(sucursalId);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    //Busco empleado por id
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Empleado> buscarEmpleado (@PathVariable long sucursalId){
        try{
            Empleado empleado = service.buscar(sucursalId);
            return ResponseEntity.ok(empleado);
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }

}
