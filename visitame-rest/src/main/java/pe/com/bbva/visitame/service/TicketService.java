package pe.com.bbva.visitame.service;

import pe.com.bbva.visitame.exception.NegocioException;

public interface TicketService {
	
	String generarTicket(String codEmpresa, String dni)  throws NegocioException;
}
