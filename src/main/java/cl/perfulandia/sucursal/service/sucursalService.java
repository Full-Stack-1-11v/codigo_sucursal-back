package cl.perfulandia.sucursal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.perfulandia.sucursal.dto.SucursalDto;
import cl.perfulandia.sucursal.modelo.Sucursal;
import cl.perfulandia.sucursal.repository.sucursalRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

import java.util.List;
@Service
@Transactional
public class sucursalService {
    @Autowired
    private sucursalRepository sucursalRepository;
    

    public SucursalDto obtenerSucursalPorId(Long id) {
        Sucursal sucursal = sucursalRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Sucursal no encontrada"));
        SucursalDto dto = new SucursalDto();
        dto.setSucursalId(sucursal.getSucursalId());
        dto.setNombre(sucursal.getNombre());
        dto.setDireccion(sucursal.getDireccion());
        return dto;
    }

    public List<Sucursal> listar() {
        return sucursalRepository.findAll();
    }

    public Sucursal guardar(Sucursal sucursal){
        return sucursalRepository.save(sucursal);
    }

    public Sucursal buscarSucursal(long id){
        return sucursalRepository.findById(id).get();
    }

    public void eliminarSucursal (long id){
        sucursalRepository.deleteById(id);
    }

    
}
    
