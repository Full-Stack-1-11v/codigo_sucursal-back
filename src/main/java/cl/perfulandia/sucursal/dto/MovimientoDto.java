package cl.perfulandia.sucursal.dto;

import java.time.LocalDateTime;

import lombok.Data;
@Data
public class MovimientoDto {
    private Long id;
    private String tipo;
    private int cantidad;
    private LocalDateTime fecha;
    private Long productoId;
    private Long sucursalId;
}