package pe.edu.cibertec.dawii.ms.ecc.inventario.service;

import java.util.List;
import java.util.Optional;

import pe.edu.cibertec.dawii.ms.ecc.inventario.model.Recurso;

public interface RecursoService {
	List<Recurso> listaRecursosTodos();
	Optional<Recurso> buscarRecursoId(int idRecurso);
	Recurso registrarRecurso(Recurso recurso);
	Optional<Recurso> actualizarRecurso(int idRecurso, Recurso recurso);
	Optional<Recurso> actualizarEstadoRecurso(int idRecurso);
	void eliminarRecurso(int idRecurso);   
}
