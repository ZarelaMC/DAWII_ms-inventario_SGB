package pe.edu.cibertec.dawii.ms.ecc.inventario.service;
  
import java.util.List;
import java.util.Optional;

import pe.edu.cibertec.dawii.ms.ecc.inventario.model.Sala;

public interface SalaService {
	List<Sala> listaSalasTodos();
	Optional<Sala> obtenerSalaPorId(Integer idSala);
	Sala registrarSala(Sala sala);
	Optional<Sala> actualizarSala(Sala sala, Integer idProd);
	void eliminarSala(Integer idSala); 

}
