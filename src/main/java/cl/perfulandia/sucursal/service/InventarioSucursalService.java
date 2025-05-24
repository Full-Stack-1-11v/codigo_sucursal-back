package cl.perfulandia.sucursal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cl.perfulandia.sucursal.Feign.InventarioClient;
import cl.perfulandia.sucursal.dto.MovimientoDto;
import cl.perfulandia.sucursal.dto.ProductoDto;

@Service
public class InventarioSucursalService {

    private final InventarioClient inventarioClient;

    public InventarioSucursalService(InventarioClient inventarioClient) {
        this.inventarioClient = inventarioClient;
    }
   
    public List<ProductoDto> obtenerProductos(Long sucursalId) {
        return inventarioClient.obtenerProductosPorSucursal(sucursalId);
    }

    public List<MovimientoDto> obtenerMovimientos(Long sucursalId) {
        return inventarioClient.obtenerMovimientosPorSucursal(sucursalId);
    }
}
