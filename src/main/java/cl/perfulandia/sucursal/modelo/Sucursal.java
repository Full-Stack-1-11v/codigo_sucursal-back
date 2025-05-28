package cl.perfulandia.sucursal.modelo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="Sucursal")
@NoArgsConstructor
@AllArgsConstructor
public class Sucursal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="sucursal_id")
    private long sucursalId;
    @Column(name="nombre")
    private String nombre;
    @Column(name="direccion")
    private String direccion;
    
    public Long getId() {
        return sucursalId;
    }
    
    @OneToMany(mappedBy = "sucursal", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Empleado> empleados;

    @OneToMany(mappedBy = "sucursal", cascade = CascadeType.ALL)
    private List<Factura> facturas; 

    @OneToMany(mappedBy = "sucursal", cascade = CascadeType.ALL)
    private List<TransaccionContable> transacciones;
}
