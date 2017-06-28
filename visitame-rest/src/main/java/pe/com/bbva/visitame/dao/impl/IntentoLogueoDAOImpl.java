package pe.com.bbva.visitame.dao.impl;

import org.springframework.stereotype.Component;

import pe.com.bbva.visitame.dao.IntentoLogueoDAO;
import pe.com.bbva.visitame.dominio.IntentoLogueo;

@Component
public class IntentoLogueoDAOImpl extends BaseDAOImpl<IntentoLogueo, String> implements IntentoLogueoDAO {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected Class<IntentoLogueo> getClase() { return IntentoLogueo.class; }
	
}
