package pe.com.bbva.visitame.service.impl.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.gson.Gson;

import pe.com.bbva.visitame.dominio.reniec.Ciudadano;
import pe.com.bbva.visitame.exception.NegocioException;
import pe.com.bbva.visitame.exception.SOAPException;
import pe.com.bbva.visitame.helper.reniec.ReniecServiceHelper;
import pe.com.bbva.visitame.service.AccountService;
import pe.com.bbva.visitame.service.TicketService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { 
									"classpath:test-context-datasource.xml",
									"classpath:spring/applicationContext-Service.xml" 
									}) 
public class TicketTest {
	
@Autowired
private TicketService ticketService;

@Test
public void reniecTest() throws SOAPException, NegocioException{
	
	int i = 0;
	while (i<5) {
		i++;
		String ticket = ticketService.generarTicket("BR_PE_0486","84747383");
		System.out.println("Mi ticket ==>" +  ticket);
		
	}
	

}


}
