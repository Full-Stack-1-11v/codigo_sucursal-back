package cl.perfulandia.sucursal.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import cl.perfulandia.sucursal.modelo.Factura;
import cl.perfulandia.sucursal.service.facturaService;

@RestController
@RequestMapping("/factura")
public class facturaController {

   
    private final facturaService facturaService;

    public facturaController(facturaService facturaService) {
        this.facturaService = facturaService;
    }

    //Lista todas las facturas
    @GetMapping("/listarAll")
    public List<Factura> listarTodo() {
        return facturaService.listar(); 
    }

    //Obtengo facturas por la sucursal
    @GetMapping("/sucursal/{sucursalId}")
    public ResponseEntity<List<Factura>> BuscarPorSucursal(@PathVariable Long sucursalId) {
        return ResponseEntity.ok(facturaService.obtenerPorSucursal(sucursalId));
    }

    //Obtener factura buscando por fechas
    @GetMapping("/fechas")
    public ResponseEntity<List<Factura>> BuscarPorFechas(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicio,
                                                   @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fin) {
        return ResponseEntity.ok(facturaService.obtenerPorFechas(inicio, fin));
    }

    @PostMapping("/agregar")
    public Factura guardar(@RequestBody Factura factura) {
        return facturaService.guardar(factura); 
    }

    //obtengo factura por id
    @GetMapping("listar/{id}")
    public ResponseEntity<Factura> obtenerFactura(@PathVariable Long id) {
        return facturaService.obtenerPorId(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    //Eliminar factura por id
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarFactura(@PathVariable long id){
        try {
            facturaService.eliminar(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
