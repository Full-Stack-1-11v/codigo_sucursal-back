package cl.perfulandia.sucursal.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.perfulandia.sucursal.dto.StockDto;
import cl.perfulandia.sucursal.modelo.Sucursal;
import cl.perfulandia.sucursal.service.sucursalService;



@RestController
@RequestMapping("/sucursal/sucursal")
public class sucursalController {
    private final sucursalService service;
    public sucursalController(sucursalService service) { this.service = service; }

    @PutMapping("/{sucursalId}/stock")
    public ResponseEntity<String> actualizarStock(
            @PathVariable Long sucursalId,
            @RequestBody StockDto dto) {

        // Por ahora, solo simulamos el comportamiento
        System.out.println("✅ [SUCURSAL] Stock recibido para sucursal ID: " + sucursalId +
                " | Producto ID: " + dto.getProductoId() +
                " | Nueva cantidad: " + dto.getNuevaCantidad());

        return ResponseEntity.ok("Stock actualizado");
    }
    @GetMapping("/listar")
    public List<Sucursal> listar() { 
        return service.listar(); 
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Sucursal> buscarSucursal (@PathVariable long id){
        try{
            Sucursal sucursal = service.buscarSucursal(id);
            return ResponseEntity.ok(sucursal);
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping("/agregar")
    public Sucursal guardar(@RequestBody Sucursal sucursal) {
         return service.guardar(sucursal);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarSucursal(@PathVariable long id){
        try {
            service.eliminarSucursal(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }


    
}