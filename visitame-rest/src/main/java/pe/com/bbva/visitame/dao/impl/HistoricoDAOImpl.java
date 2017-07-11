package pe.com.bbva.visitame.dao.impl;


import org.springframework.stereotype.Component;

import pe.com.bbva.visitame.dao.HistoricoDAO;
import pe.com.bbva.visitame.dominio.Historico;

@Component 
public class HistoricoDAOImpl extends BaseDAOImpl<Historico, String> implements HistoricoDAO {

	private static final long serialVersionUID = 1L;

	@Override
	protected Class<Historico> getClase() { return Historico.class; }

}
