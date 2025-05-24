package cl.perfulandia.sucursal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cl.perfulandia.sucursal.modelo.TransaccionContable;
import cl.perfulandia.sucursal.repository.TransaccionRepository;

@Service
public class transaccionService {
    private final TransaccionRepository repository;

    public transaccionService(TransaccionRepository repository) {
        this.repository = repository; 
    }

    public List<TransaccionContable> obtenerPorSucursal(Long sucursalId) {
        return repository.findBySucursalSucursalId(sucursalId);
    }

    public List<TransaccionContable> obtenerPorTipo(String tipo) {
        return repository.findByTipo(tipo);
    }

    public List<TransaccionContable> listar() {
        return repository.findAll(); 
    }

    public TransaccionContable guardar(TransaccionContable transa) {
        return repository.save(transa); 
    }

    public TransaccionContable buscar(long id){
        return repository.findById(id).get();
    }

    public void eliminar (long id){
        repository.deleteById(id);
    }
}