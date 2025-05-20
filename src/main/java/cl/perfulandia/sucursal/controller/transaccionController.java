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
import cl.perfulandia.sucursal.modelo.TransaccionContable;
import cl.perfulandia.sucursal.service.transaccionService;

@RestController
@RequestMapping("/api/v1/contabilidad")
public class transaccionController {
    private final transaccionService service;

    public transaccionController(transaccionService service) {
        this.service = service; 
    }

    @GetMapping("/listar")
    public List<TransaccionContable> listar() {
        return service.listar(); 
    }

    @PostMapping("/agregar")
    public TransaccionContable guardar(@RequestBody TransaccionContable t) {
        return service.guardar(t); 
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
    public ResponseEntity<TransaccionContable> buscarSucursal (@PathVariable long id){
        try{
            TransaccionContable transa = service.buscar(id);
            return ResponseEntity.ok(transa);
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
