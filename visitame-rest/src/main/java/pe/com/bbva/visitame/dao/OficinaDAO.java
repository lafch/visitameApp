package pe.com.bbva.visitame.dao;

import pe.com.bbva.visitame.dominio.Oficina;
import pe.com.bbva.visitame.exception.DAOException;

public interface OficinaDAO extends BaseDAO<Oficina, String>{
	
	int generarTicket(String codOficina)  throws DAOException;

}
