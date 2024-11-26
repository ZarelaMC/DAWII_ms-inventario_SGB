package pe.edu.cibertec.dawii.ms.ecc.inventario.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.cibertec.dawii.ms.ecc.inventario.model.Sala;
import pe.edu.cibertec.dawii.ms.ecc.inventario.repository.SalaRepository;
import pe.edu.cibertec.dawii.ms.ecc.inventario.service.SalaService;

@Service
public class SalaServiceImpl implements SalaService{  

	@Autowired
	SalaRepository salaRepository;
	 
	@Override
	public List<Sala> listaSalasTodos() {
		return salaRepository.findAll();
	}

	@Override
	public Optional<Sala> obtenerSalaPorId(Integer idSala) {
		return salaRepository.findById(idSala);
	}

	@Override
	public Sala registrarSala(Sala sala) {
		return salaRepository.save(sala);
	}

	@Override
	public Optional<Sala> actualizarSala(Sala sala, Integer idProd) {
		return Optional.empty();
	}

	@Override
	public void eliminarSala(Integer idSala) {
		salaRepository.deleteById(idSala);
	}

}
