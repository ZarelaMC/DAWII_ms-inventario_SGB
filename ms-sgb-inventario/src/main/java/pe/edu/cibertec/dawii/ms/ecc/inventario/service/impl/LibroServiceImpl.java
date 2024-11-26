package pe.edu.cibertec.dawii.ms.ecc.inventario.service.impl;
  
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.cibertec.dawii.ms.ecc.inventario.model.Libro;
import pe.edu.cibertec.dawii.ms.ecc.inventario.repository.LibroRepository;
import pe.edu.cibertec.dawii.ms.ecc.inventario.service.LibroService;

@Service
public class LibroServiceImpl implements LibroService{

	@Autowired
	LibroRepository libroRepository;
	 
	
	@Override
	public List<Libro> listaLibrosTodos() {
		return libroRepository.findAll();
	}

	@Override
	public Optional<Libro> obtenerLibroPorId(Integer idLibro) {
		return libroRepository.findById(idLibro);
	}

	@Override
	public Libro registrarLibro(Libro libro) {
		return libroRepository.save(libro);
	}

	@Override
	public Optional<Libro> actualizarLibro(Libro libro, Integer idLibro) {
		Optional<Libro> libroBuscado = libroRepository.findById(idLibro);
		return libroBuscado.map(libroExiste -> {
			libroExiste.setNombre(libro.getNombre());
			libroExiste.setAnioPublicacion(idLibro);
			libroExiste.setNombre(libro.getNombre());
			libroExiste.setAutor(libro.getAutor());
			libroExiste.setDescripcion(libro.getDescripcion());
			libroExiste.setEditorial(libro.getEditorial());
			libroExiste.setEstado(libro.getEstado());
			libroExiste.setGenero(libro.getGenero());
			libroExiste.setRecurso(libro.getRecurso());
			libroExiste.setIsbn(libro.getIsbn());
			return libroRepository.save(libroExiste);
		});
	}

	@Override
	public void eliminarLibro(Integer idLibro) {
		libroRepository.deleteById(idLibro);
	}

}
