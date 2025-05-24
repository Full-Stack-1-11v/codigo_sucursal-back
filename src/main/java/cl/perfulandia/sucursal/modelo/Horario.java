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
public class Horario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="horario_id")
    private Long horarioId;
    @Column(name="inicio_horario")
    private LocalDateTime inicioHorario;
    @Column(name="fin_horario")
    private LocalDateTime finHorario;
    @Column(name="dia_semana")
    private String diaSemana;
    @ManyToOne
    @JoinColumn(name = "empleado_id")
    private Empleado empleado;

}
