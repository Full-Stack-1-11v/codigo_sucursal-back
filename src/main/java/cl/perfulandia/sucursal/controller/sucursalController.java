package cl.perfulandia.sucursal.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
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
import cl.perfulandia.sucursal.dto.SucursalDto;
import cl.perfulandia.sucursal.modelo.Sucursal;
import cl.perfulandia.sucursal.service.sucursalService;
import jakarta.persistence.EntityNotFoundException;



@RestController
@RequestMapping("/sucursal/sucursal")
public class sucursalController {
    private final sucursalService sucursalService;
    public sucursalController(sucursalService sucursalService) {
        this.sucursalService = sucursalService;
    }
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

    @GetMapping("/{id}")
    public ResponseEntity<SucursalDto> obtenerSucursalPorId(@PathVariable Long id) {
        try {
            SucursalDto dto = sucursalService.obtenerSucursalPorId(id);
            return ResponseEntity.ok(dto);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/listar")  
    public List<Sucursal> listar() { 
        return sucursalService.listar(); 
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Sucursal> buscarSucursal (@PathVariable long id){
        try{
            Sucursal sucursal = sucursalService.buscarSucursal(id);
            return ResponseEntity.ok(sucursal);
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping("/agregar")
    public Sucursal guardar(@RequestBody Sucursal sucursal) {
         return sucursalService.guardar(sucursal);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarSucursal(@PathVariable long id){
        try {
            sucursalService.eliminarSucursal(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }


    
}