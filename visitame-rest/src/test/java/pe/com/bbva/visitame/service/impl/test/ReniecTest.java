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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { 
									"classpath:test-context-datasource.xml",
									"classpath:spring/applicationContext-Service.xml" 
									}) 
public class ReniecTest {
	
@Autowired
private ReniecServiceHelper reniecServiceHelper;

@Test
public void reniecTest() throws SOAPException, NegocioException{
	Ciudadano c= reniecServiceHelper.obtenerPersonaXDNI("09243165");
	Gson g = new Gson();
	System.out.println(g.toJson(c));
	

}


}
