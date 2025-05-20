package cl.perfulandia.sucursal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.perfulandia.sucursal.modelo.TransaccionContable;

public interface TransaccionRepository extends JpaRepository<TransaccionContable, Long> {

}