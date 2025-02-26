package pe.edu.cibertec.dawii.ms.ecc.inventario.rmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import pe.edu.cibertec.dawii.ms.ecc.inventario.model.Recurso;

@Component
public class NotificacionSender {
	
	private final RabbitTemplate rabbitTemplate;

	//Constructor
	public NotificacionSender(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}
	
	//Método para ENVIAR mensajes
	public void enviarNotificacion(Notificacion notificacion) {
		rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME,
										RabbitMQConfig.ROUTING_KEY);
		System.out.println("Notificación enviada, recurso " + notificacion);
	}
}
