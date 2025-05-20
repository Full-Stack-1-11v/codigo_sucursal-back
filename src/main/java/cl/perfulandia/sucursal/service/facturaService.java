package cl.perfulandia.sucursal.service;

import java.util.List;

import org.springframework.stereotype.Service;
import cl.perfulandia.sucursal.modelo.Factura;
import cl.perfulandia.sucursal.repository.facturaRepository;

@Service
public class facturaService {
    private final facturaRepository repository;

    public facturaService(facturaRepository repository) {
        this.repository = repository; 
    }

    public List<Factura> listar() {
        return repository.findAll(); 
    }

    public Factura guardar(Factura factura) {
        return repository.save(factura); 
    }
    
    public void eliminar (long id){
        repository.deleteById(id);
    }

    public Factura buscar(long id){
        return repository.findById(id).get();
    }
}