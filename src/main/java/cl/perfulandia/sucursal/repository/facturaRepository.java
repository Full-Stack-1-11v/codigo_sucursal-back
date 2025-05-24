package cl.perfulandia.sucursal.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.perfulandia.sucursal.modelo.Factura;

@Repository
public interface facturaRepository extends JpaRepository<Factura, Long> {
    List<Factura> findBySucursalSucursalId(Long sucursalId);
    List<Factura> findByFechaBetween(LocalDate inicio, LocalDate fin);
}
