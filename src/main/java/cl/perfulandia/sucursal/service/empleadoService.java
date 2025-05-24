package cl.perfulandia.sucursal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cl.perfulandia.sucursal.modelo.Empleado;

import cl.perfulandia.sucursal.repository.empleadoRepository;

@Service
public class empleadoService {
    private final empleadoRepository repository;

    public empleadoService(empleadoRepository repository) {
        this.repository = repository; 
    }

    public List<Empleado> buscarPorNombre(String nombreEmpleado) {
        return repository.findByNombreEmpleado(nombreEmpleado);
    }

    public List<Empleado> obtenerPorSucursal(Long sucursalId) {
        return repository.findBySucursalSucursalId(sucursalId);
    }

    public List<Empleado> listar() {
        return repository.findAll(); 
    }

    public Empleado guardar(Empleado empleado) {
        return repository.save(empleado); 
    }

    public void eliminar (long id){
        repository.deleteById(id);
    }

    public Empleado buscar(long id){
        return repository.findById(id).get();
    }
}