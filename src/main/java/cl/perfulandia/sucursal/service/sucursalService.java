package cl.perfulandia.sucursal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cl.perfulandia.sucursal.modelo.Sucursal;
import cl.perfulandia.sucursal.repository.sucursalRepository;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class sucursalService {
    @Autowired
    private sucursalRepository sucursalRepository;
    

    public List<Sucursal> listar() {
        return sucursalRepository.findAll();
    }

    public Sucursal guardar(Sucursal sucursal){
        return sucursalRepository.save(sucursal);
    }

    public Optional<Sucursal> obtenerPorNombre(String nombre) {
        return sucursalRepository.findByNombre(nombre);
    }
    
    public Sucursal buscarSucursal(long id){
        return sucursalRepository.findById(id).get();
    }

    public void eliminarSucursal (long id){
        sucursalRepository.deleteById(id);
    }

    
}
    
