package cl.perfulandia.sucursal.Feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import cl.perfulandia.sucursal.dto.MovimientoDto;
import cl.perfulandia.sucursal.dto.ProductoDto;

@FeignClient(name = "inventario-service", url = "https://codigo-inventario-back-1.onrender.com")
public interface InventarioClient {

    @GetMapping("/inventario/sucursal/{sucursalId}")
    List<ProductoDto> obtenerProductosPorSucursal(@PathVariable("sucursalId") Long sucursalId);

    @GetMapping("/movimientos/sucursal/{sucursalId}")
    List<MovimientoDto> obtenerMovimientosPorSucursal(@PathVariable("sucursalId") Long sucursalId);
}