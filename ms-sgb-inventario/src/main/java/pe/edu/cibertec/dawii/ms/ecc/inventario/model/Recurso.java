package pe.edu.cibertec.dawii.ms.ecc.inventario.model;

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
@Table(name = "Recursos")
public class Recurso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRecurso;
	
    private String tipo;
    private String estado = "Disponible";
    private String ubicacion;

}