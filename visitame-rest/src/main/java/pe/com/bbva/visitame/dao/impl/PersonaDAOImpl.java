package pe.com.bbva.visitame.dao.impl;


import org.springframework.stereotype.Component;

import pe.com.bbva.visitame.dao.PersonaDAO;
import pe.com.bbva.visitame.dominio.Persona;

@Component 
public class PersonaDAOImpl extends BaseDAOImpl<Persona, String> implements PersonaDAO {

	private static final long serialVersionUID = 1L;

	@Override
	protected Class<Persona> getClase() { return Persona.class; }

}
