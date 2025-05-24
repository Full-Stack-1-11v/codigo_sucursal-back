package cl.perfulandia.sucursal.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.perfulandia.sucursal.dto.MovimientoDto;
import cl.perfulandia.sucursal.dto.ProductoDto;
import cl.perfulandia.sucursal.service.InventarioSucursalService;

@RestController
@RequestMapping("/api/sucursal/inventario")
public class inventarioSucursalController {

    private final InventarioSucursalService inventarioService;

    public inventarioSucursalController(InventarioSucursalService inventarioService) {
        this.inventarioService = inventarioService;
    }

    //Obtengo productos por id de la sucursal
    @GetMapping("/{sucursalId}/productos")
    public ResponseEntity<List<ProductoDto>> productosPorSucursal(@PathVariable Long sucursalId) {
        return ResponseEntity.ok(inventarioService.obtenerProductos(sucursalId));
    }

    //Obtengo movimientos por id de la sucursal
    @GetMapping("/{sucursalId}/movimientos")
    public ResponseEntity<List<MovimientoDto>> movimientosPorSucursal(@PathVariable Long sucursalId) {
        return ResponseEntity.ok(inventarioService.obtenerMovimientos(sucursalId));
    }
}
