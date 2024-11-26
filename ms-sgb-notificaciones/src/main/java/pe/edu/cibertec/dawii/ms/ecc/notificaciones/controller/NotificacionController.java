package pe.edu.cibertec.dawii.ms.ecc.notificaciones.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.cibertec.dawii.ms.ecc.notificaciones.model.Notificacion;
import pe.edu.cibertec.dawii.ms.ecc.notificaciones.service.NotificacionService;

@RestController
@RequestMapping("/api/notificaciones")
public class NotificacionController {

	@Autowired
	NotificacionService notificacionService;
	
	@GetMapping
	public List<Notificacion> buscarNotificacionesTodas() {
		return notificacionService.listaNotificacionsTodos();
	}
	
	@GetMapping("/filtros/id/{id}")
	public Optional<Notificacion> buscarNotificacionId(@PathVariable("id") int idNotificacion) {
		return notificacionService.buscarNotificacionId(idNotificacion);
	}

	/*
	 * @GetMapping("/filtros/email/{email}")
	public Optional<Notificacion> buscarNotificacionId(@PathVariable("email") String email) {
		return notificacionService.buscarNotificacionEmail(email);
	}*/
	
	@PostMapping
	public Notificacion registrarNotificacion(@RequestBody Notificacion notificacion) {
		notificacion.setFechaRegistro(new Date());
		return notificacionService.registrarNotificacion(notificacion);
	}
}