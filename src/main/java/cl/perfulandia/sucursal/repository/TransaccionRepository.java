package cl.perfulandia.sucursal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.perfulandia.sucursal.modelo.TransaccionContable;

@Repository
public interface TransaccionRepository extends JpaRepository<TransaccionContable, Long> {
    List<TransaccionContable> findBySucursalSucursalId(Long sucursalId);
    List<TransaccionContable> findByTipo(String tipo);
}
