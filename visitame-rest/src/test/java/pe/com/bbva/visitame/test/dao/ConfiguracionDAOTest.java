package pe.com.bbva.visitame.test.dao;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.bbva.visitame.dao.ParametroDAO;
import pe.com.bbva.visitame.dominio.Parametro;
import pe.com.bbva.visitame.exception.DAOException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:test-context-datasource.xml" })
public class ConfiguracionDAOTest {
	
	@Autowired
	private ParametroDAO parametroDAO;
	
	@Test
	public void pruebaConexion() {
		
		try {
			Parametro p = parametroDAO.obtener("RADIO_ALCANCE_APP");
			System.out.println("valor->"+p.getTxValor());
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	



}
