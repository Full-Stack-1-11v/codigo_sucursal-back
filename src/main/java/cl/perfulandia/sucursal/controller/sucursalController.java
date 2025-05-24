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
import cl.perfulandia.sucursal.modelo.Sucursal;
import cl.perfulandia.sucursal.service.sucursalService;

@RestController
@RequestMapping("/sucursal/sucursal")
public class sucursalController {
    private final sucursalService sucursalService;
    public sucursalController(sucursalService sucursalService) {
        this.sucursalService = sucursalService;
    }
    


    @GetMapping("/nombre")
    public ResponseEntity<Sucursal> BuscarPorNombre(@RequestParam String nombre) {
        return sucursalService.obtenerPorNombre(nombre)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
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