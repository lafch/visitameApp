package pe.com.bbva.visitame.dao.impl;

import org.springframework.stereotype.Component;

import pe.com.bbva.visitame.dao.OficinaDAO;
import pe.com.bbva.visitame.dominio.Oficina;

@Component
public class OficinaDAOImpl extends BaseDAOImpl<Oficina, String> implements OficinaDAO {

	private static final long serialVersionUID = 1L;

	@Override
	protected Class<Oficina> getClase() { return Oficina.class; }
	
}
