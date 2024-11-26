package pe.edu.cibertec.dawii.ms.ecc.inventario.service.impl; 

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.cibertec.dawii.ms.ecc.inventario.model.Recurso;
import pe.edu.cibertec.dawii.ms.ecc.inventario.repository.RecursoRepository;
import pe.edu.cibertec.dawii.ms.ecc.inventario.rmq.Notificacion;
import pe.edu.cibertec.dawii.ms.ecc.inventario.rmq.NotificacionSender;
import pe.edu.cibertec.dawii.ms.ecc.inventario.service.RecursoService;

@Service 
public class RecursoServiceImpl implements RecursoService {

	@Autowired
	RecursoRepository recursoRepository;
	 
	@Autowired 
	NotificacionSender notificacionSender; 
	
	@Override
	public List<Recurso> listaRecursosTodos() {
		return recursoRepository.findAll();
	}

	@Override
	public Optional<Recurso> buscarRecursoId(int idRecurso) {
		return recursoRepository.findById(idRecurso);
	}

	@Override
	public Recurso registrarRecurso(Recurso recurso) {
		//Guardar recurso - registro síncrono, depende de la BD
		Recurso recursoRegistrado =  recursoRepository.save(recurso);
		//Construir notificación - registro asíncrono - dispara y olvida
		Notificacion notificacion = Notificacion.builder()
												.asunto("Recurso registrado")
												.contenido("El recurso fue registrado con éxito...")
												.build();
		//
		notificacionSender.enviarNotificacion(notificacion);
		return recursoRegistrado;
	}

	@Override
	public Optional<Recurso> actualizarRecurso(int idRecurso, Recurso recurso) {
		Optional<Recurso> recursoBuscado = recursoRepository.findById(idRecurso);
		return recursoBuscado.map(recursoExiste -> {
			recursoExiste.setEstado(recurso.getEstado());
			recursoExiste.setTipo(recurso.getTipo());
			recursoExiste.setUbicacion(recurso.getUbicacion());
			return recursoRepository.save(recursoExiste);
		});
	}

	@Override
	public void eliminarRecurso(int idRecurso) {
		 recursoRepository.deleteById(idRecurso);
	}

	@Override
	public Optional<Recurso> actualizarEstadoRecurso(int idRecurso) {
		Optional<Recurso> recursoBuscado = recursoRepository.findById(idRecurso);
		return recursoBuscado.map(recursoExiste -> {
			recursoExiste.setEstado("No disponible");
			return recursoRepository.save(recursoExiste);
		});
	}

}
