package pe.com.bbva.visitame.rest.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.com.bbva.visitame.exception.NegocioException;
import pe.com.bbva.visitame.exception.ValidacionException;
import pe.com.bbva.visitame.rest.IVISTServiceTicket;
import pe.com.bbva.visitame.service.TicketService;

@Component
public class IVISTServiceTicketImpl implements IVISTServiceTicket {

	@Autowired
	private TicketService ticketService;

	@Override
	public Map<String, String> obtenerOficinas(String oficina, String dni)
			throws ValidacionException, NegocioException {

		Map<String, String> data = new HashMap<String, String>();
		data.put("ticket", ticketService.generarTicket(oficina, dni));
		return data;
	}

}
