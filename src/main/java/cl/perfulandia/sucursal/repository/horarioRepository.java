package cl.perfulandia.sucursal.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import cl.perfulandia.sucursal.modelo.Horario;

@Repository
public interface horarioRepository extends JpaRepository<Horario, Long> {
    List<Horario> findByEmpleadoEmpleadoId(Long empleadoId);
    List<Horario> findByDiaSemana(String diaSemana);
}