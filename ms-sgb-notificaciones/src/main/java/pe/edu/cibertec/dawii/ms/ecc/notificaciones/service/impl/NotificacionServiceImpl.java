package pe.edu.cibertec.dawii.ms.ecc.notificaciones.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.cibertec.dawii.ms.ecc.notificaciones.model.Notificacion;
import pe.edu.cibertec.dawii.ms.ecc.notificaciones.repository.NotificacionRepository;
import pe.edu.cibertec.dawii.ms.ecc.notificaciones.service.NotificacionService;

@Service
public class NotificacionServiceImpl implements NotificacionService {

	
	@Autowired
	private NotificacionRepository notificacionRepository;

	@Override
	public List<Notificacion> listaNotificacionsTodos() {
		return notificacionRepository.findAll();
	}

	@Override
	public Optional<Notificacion> buscarNotificacionId(int idNotificacion) {
		return notificacionRepository.findById(idNotificacion);
	}

	/*@Override
	public Optional<Notificacion> buscarNotificacionEmail(String email) {
		return notificacionRepository.findByEmail(email);
	}*/
	
	@Override
	public Notificacion registrarNotificacion(Notificacion notificacion) {
		return notificacionRepository.save(notificacion);
	}
}
