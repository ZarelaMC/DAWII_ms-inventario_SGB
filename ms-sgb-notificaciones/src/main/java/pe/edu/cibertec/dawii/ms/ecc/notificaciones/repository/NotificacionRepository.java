package pe.edu.cibertec.dawii.ms.ecc.notificaciones.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.cibertec.dawii.ms.ecc.notificaciones.model.Notificacion;

public interface NotificacionRepository extends JpaRepository<Notificacion,Integer>{
  //public Optional<Notificacion> findByEmail(String email);
}
   