package pe.edu.cibertec.dawii.ms.ecc.notificaciones.service;

import java.util.List;
import java.util.Optional;

import pe.edu.cibertec.dawii.ms.ecc.notificaciones.model.Notificacion;

public interface NotificacionService {
	List<Notificacion> listaNotificacionsTodos();
	Optional<Notificacion> buscarNotificacionId(int idNotificacion);
	//Optional<Notificacion> buscarNotificacionEmail(String email);
	Notificacion registrarNotificacion(Notificacion notificacion); 
}
