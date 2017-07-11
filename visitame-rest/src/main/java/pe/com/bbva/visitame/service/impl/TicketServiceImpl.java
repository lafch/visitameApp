package pe.com.bbva.visitame.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.bbva.visitame.dao.OficinaDAO;
import pe.com.bbva.visitame.dominio.util.Mensajes;
import pe.com.bbva.visitame.exception.NegocioException;
import pe.com.bbva.visitame.service.TicketService;

@Service
public class TicketServiceImpl extends BaseServiceImpl implements TicketService {

	private static final long serialVersionUID = 1229565922149112061L;
		
	@Autowired
	private OficinaDAO oficinaDAO;

	@Override
	public String generarTicket(String codOficina, String dni) throws NegocioException {
		
		String ticketFinal = "";
		
		try {
			
			if(dni.isEmpty() )
				lanzarExcepcionLeve(Mensajes.TICKET.DNI_EMPTY , new Object[] { }, "Parámetro DNI vacío", null);
			
			if(codOficina.isEmpty())
				lanzarExcepcionLeve(Mensajes.TICKET.OFICINA_EMPTY , new Object[] { }, "Parámetro Codigo Cod Oficina vacío", null);
				
			int numSeq = oficinaDAO.generarTicket(codOficina);
			
			if(numSeq == 0)
				lanzarExcepcionLeve(Mensajes.TICKET.OFICINA_NOT_FOUND , new Object[] { }, "No se encontró oficina", null);
			
			ticketFinal = setTicketComplementar(numSeq, dni);
			
		} catch (Exception e) {
			lanzarExcepcionMedia(NegocioException.CODIGO.NEG_ERROR_INESPERADO, null, "Ocurrio un error inesperado.", e);
		}
		return ticketFinal;
	}
	
	public String setTicketComplementar(int numSeq,String dni) throws NegocioException {
		
		String finalTicket  = "";
		String letraInicio = getLetraIni();
		finalTicket = completarCero(letraInicio,numSeq);
		return finalTicket;
		
	}

	private String getLetraIni(){
		String letraInicio = "";
		int numero = (int) (Math.random() * 3) + 1;
		switch (numero) {
		case 1:
			letraInicio = "C";
			break;
		case 2:
			letraInicio = "N";
			break;
		case 3:
			letraInicio = "S";
			break;
		}
		return letraInicio; //Sumamos al numero de letras (sin ñ) el valor en ASCII 
	}
	
	private String completarCero(String letraInicio, int ticket){
		String finalS ="";
		int tamanionormal = 2;
		finalS += letraInicio;
		for ( int i=0;i < tamanionormal;i++) {
			finalS+='0';
			if(i == tamanionormal-1){
				finalS.substring(tamanionormal- String.valueOf(ticket).length(),finalS.length());
				finalS += ticket;
				break;
			}
		}
		return finalS;
	}
}
