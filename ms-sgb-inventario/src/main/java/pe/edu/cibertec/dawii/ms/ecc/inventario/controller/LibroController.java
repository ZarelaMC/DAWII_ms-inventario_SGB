package pe.edu.cibertec.dawii.ms.ecc.inventario.controller;

  
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.cibertec.dawii.ms.ecc.inventario.model.Libro;
import pe.edu.cibertec.dawii.ms.ecc.inventario.service.LibroService;

@RestController
@RequestMapping("/api/libro")
public class LibroController {

	@Autowired
	LibroService libroService;
	
	@GetMapping
	public List<Libro> listaLibrosTodos() {
		return libroService.listaLibrosTodos();
	}

	@GetMapping("/{idLibro}")
	public Optional<Libro> obtenerLibroPorId(@PathVariable Integer idLibro) {
		return libroService.obtenerLibroPorId(idLibro);
	}

	@PostMapping
	public Libro registrarLibro(@RequestBody Libro libro) {
		return libroService.registrarLibro(libro);
	}

	@PutMapping("/{idLibro}")
	public ResponseEntity<Libro> actualizarLibro(@RequestBody Libro libro, @PathVariable Integer idLibro) {
		Optional<Libro> libroActualizar = libroService.actualizarLibro(libro, idLibro);
		return libroActualizar.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{idLibro}")
	public void eliminarLibro(@PathVariable Integer idLibro) {
		libroService.eliminarLibro(idLibro);
	}
}
