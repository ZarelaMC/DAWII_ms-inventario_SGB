package pe.edu.cibertec.dawii.ms.ecc.inventario.rmq;

import java.io.Serializable;
import java.util.Date;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
		 
@Data				 
@NoArgsConstructor    
@AllArgsConstructor 
@Builder
public class Notificacion implements Serializable {
	private static final long serialVersionUI = 1L;
	
	private Long id;
	private String asunto;
	private String contenido;
	private Date fechaRegistro;
}
