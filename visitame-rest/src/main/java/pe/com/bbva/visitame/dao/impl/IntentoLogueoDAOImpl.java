package pe.com.bbva.visitame.dao.impl;

import java.util.Date;

import org.springframework.stereotype.Component;

import pe.com.bbva.visitame.dao.IntentoLogueoDAO;
import pe.com.bbva.visitame.dominio.IntentoLogueo;
import pe.com.bbva.visitame.exception.DAOException;

@Component
public class IntentoLogueoDAOImpl extends BaseDAOImpl<IntentoLogueo, String> implements IntentoLogueoDAO {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected Class<IntentoLogueo> getClase() { return IntentoLogueo.class; }

	@Override
	public Integer contarIntentosPorDia(Integer doi, String numDoc, Date fecha) throws DAOException {
		// TODO Auto-generated method stub
//		this.
		return null;
	}
	
	
	
}
