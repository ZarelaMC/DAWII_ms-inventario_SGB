package pe.edu.cibertec.dawii.ms.ecc.inventario.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Libros")
public class Libro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idLibro;
	
	@ManyToOne
	@JoinColumn(name = "idRecurso")
    private Recurso recurso;
	
    private String nombre;
    private String autor;
    private String genero;
    private String editorial;
    private Integer anioPublicacion;
    private String isbn;
    private String estado = "Disponible";
    private String descripcion;

}
