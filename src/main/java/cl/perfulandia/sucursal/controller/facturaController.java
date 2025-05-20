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
import cl.perfulandia.sucursal.modelo.Factura;
import cl.perfulandia.sucursal.service.facturaService;

@RestController
@RequestMapping("/api/v1/factura")
public class facturaController {
    private final facturaService service;

    public facturaController(facturaService service) {
        this.service = service; 
    }

    @GetMapping("/listar")
    public List<Factura> listar() {
        return service.listar(); 
    }

    @PostMapping("/agregar")
    public Factura guardar(@RequestBody Factura f) {
        return service.guardar(f); 
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
    public ResponseEntity<Factura> buscarSucursal (@PathVariable long id){
        try{
            Factura factura = service.buscar(id);
            return ResponseEntity.ok(factura);
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}