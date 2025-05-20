package cl.perfulandia.sucursal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.perfulandia.sucursal.modelo.Empleado;

public interface empleadoRepository extends JpaRepository<Empleado, Long> {

}
