package pe.edu.cibertec.dawii.ms.ecc.notificaciones.rmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import pe.edu.cibertec.dawii.ms.ecc.notificaciones.model.Notificacion;
import pe.edu.cibertec.dawii.ms.ecc.notificaciones.service.NotificacionService;

@Component
public class NotificacionListener {
	
	private final NotificacionService notificacionService;

	//Constructor
	public NotificacionListener(NotificacionService notificacionService) {
		this.notificacionService = notificacionService;
	}
	
	//Método para RECIBE las peticiones enviadas por el usuario 
	@RabbitListener
	public void recibirPeticion(Notificacion notificacion) {
		System.out.println("Notificación recibida con éxito " + notificacion);
		notificacionService.registrarNotificacion(notificacion);
	}
}
