package pe.edu.cibertec.dawii.ms.ecc.inventario.service;
 
import java.util.List;
import java.util.Optional;

import pe.edu.cibertec.dawii.ms.ecc.inventario.model.Libro;

public interface LibroService {
	List<Libro> listaLibrosTodos();
	Optional<Libro> obtenerLibroPorId(Integer idLibro);
	Libro registrarLibro(Libro libro);
	Optional<Libro> actualizarLibro(Libro libro, Integer idLibro);
	void eliminarLibro(Integer idLibro);
  
}
