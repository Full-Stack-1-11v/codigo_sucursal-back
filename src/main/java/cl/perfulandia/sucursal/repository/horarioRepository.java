package cl.perfulandia.sucursal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.perfulandia.sucursal.modelo.Horario;

public interface horarioRepository extends JpaRepository<Horario, Long> {

}