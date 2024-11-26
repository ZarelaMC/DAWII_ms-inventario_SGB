package pe.edu.cibertec.dawii.ms.ecc.inventario.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity 
@Data  
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Revistas")
public class Revista {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRevista;
    private int idRecurso;
    private String nombre;
    private String edicion;
    private String categoria;
    private Date fechaPublicacion;
    private String estado = "Disponible";
    private String descripcion;
}
