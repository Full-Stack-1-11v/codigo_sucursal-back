package cl.perfulandia.sucursal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.perfulandia.sucursal.modelo.Factura;

public interface facturaRepository extends JpaRepository<Factura, Long> {

}
