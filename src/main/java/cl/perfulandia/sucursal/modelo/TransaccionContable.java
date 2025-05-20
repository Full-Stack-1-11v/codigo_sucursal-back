package cl.perfulandia.sucursal.modelo;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private Long transaccionId;

    private String descripcion;
    private Double monto;
    private LocalDateTime fecha;

    @ManyToOne
    private Sucursal sucursal;
}