package cl.perfulandia.sucursal.modelo;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@Table(name="Horario")
@NoArgsConstructor
@AllArgsConstructor
public class TransaccionContable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="transaccion_id")
    private Long transaccionId;
    @Column(name="descripcion")
    private String descripcion;
    @Column(name="monto")
    private Double monto;
    @Column(name="fecha")
    private LocalDateTime fecha;
    @Column(name="tipo")
    private String tipo;

    @ManyToOne
    @JoinColumn(name = "sucursal_id")
    private Sucursal sucursal;

    @ManyToOne
    @JoinColumn(name = "factura_id")
    private Factura factura;
}