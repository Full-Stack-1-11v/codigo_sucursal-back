package cl.perfulandia.sucursal.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import cl.perfulandia.sucursal.modelo.Factura;
import cl.perfulandia.sucursal.repository.facturaRepository;

@Service
public class facturaService {
    private final facturaRepository facturaRepository;

    public facturaService(facturaRepository facturaRepository) {
        this.facturaRepository = facturaRepository;
    }

    public List<Factura> listar() {
        return facturaRepository.findAll(); 
    }

    public List<Factura> obtenerPorSucursal(Long sucursalId) {
        return facturaRepository.findBySucursalSucursalId(sucursalId);
    }

    public List<Factura> obtenerPorFechas(LocalDate inicio, LocalDate fin) {
        return facturaRepository.findByFechaBetween(inicio, fin);
    }

    public Factura guardar(Factura factura) {
        return facturaRepository.save(factura);
    }

    public Optional<Factura> obtenerPorId(Long id) {
        return facturaRepository.findById(id);
    }

    public void eliminar(long id){
        facturaRepository.deleteById(id);
    }
}
