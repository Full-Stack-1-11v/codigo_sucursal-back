package cl.perfulandia.sucursal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.perfulandia.sucursal.modelo.Empleado;

@Repository
public interface empleadoRepository extends JpaRepository<Empleado, Long> {
    List<Empleado> findByNombreEmpleado(String nombreEmpleado);
    List<Empleado> findBySucursalSucursalId(Long sucursalId);
}
