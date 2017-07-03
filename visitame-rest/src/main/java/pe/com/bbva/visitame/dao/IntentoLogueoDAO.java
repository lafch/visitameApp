package pe.com.bbva.visitame.dao;

import java.util.Date;

import pe.com.bbva.visitame.dominio.IntentoLogueo;
import pe.com.bbva.visitame.exception.DAOException;

public interface IntentoLogueoDAO extends BaseDAO<IntentoLogueo, String> {
	
	Integer contarIntentosPorDia(Integer doi , String numDoc , Date fecha) throws DAOException;
	
	Integer numeroMinutosUltimoIntentoHoy(Integer doi , String numDoc) throws DAOException;

}
