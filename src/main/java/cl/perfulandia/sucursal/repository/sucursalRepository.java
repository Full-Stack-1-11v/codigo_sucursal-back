package cl.perfulandia.sucursal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import cl.perfulandia.sucursal.modelo.Sucursal;
@Repository
public interface sucursalRepository extends JpaRepository<Sucursal , Long> {
    
}