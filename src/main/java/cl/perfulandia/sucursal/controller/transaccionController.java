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
import cl.perfulandia.sucursal.modelo.TransaccionContable;
import cl.perfulandia.sucursal.service.transaccionService;

@RestController
@RequestMapping("/sucursal/contabilidad")
public class transaccionController {
    private final transaccionService service;

    public transaccionController(transaccionService service) {
        this.service = service; 
    }

    @GetMapping("/sucursal/{sucursalId}")
    public ResponseEntity<List<TransaccionContable>> porSucursal(@PathVariable Long sucursalId) {
        return ResponseEntity.ok(service.obtenerPorSucursal(sucursalId));
    }

    @GetMapping("/tipo")
    public ResponseEntity<List<TransaccionContable>> porTipo(@RequestParam String tipo) {
        return ResponseEntity.ok(service.obtenerPorTipo(tipo));
    }

    @GetMapping("/listar")
    public List<TransaccionContable> listar() {
        return service.listar(); 
    }

    @PostMapping("/agregar")
    public TransaccionContable guardar(@RequestBody TransaccionContable transaccion) {
        return service.guardar(transaccion); 
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
