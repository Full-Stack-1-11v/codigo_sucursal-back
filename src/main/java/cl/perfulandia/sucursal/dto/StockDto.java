package cl.perfulandia.sucursal.dto;

public class StockDto {
    private Long productoId;
    private int nuevaCantidad;

    // Getters y setters
    public Long getProductoId() {
        return productoId;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }

    public int getNuevaCantidad() {
        return nuevaCantidad;
    }

    public void setNuevaCantidad(int nuevaCantidad) {
        this.nuevaCantidad = nuevaCantidad;
    }
}

