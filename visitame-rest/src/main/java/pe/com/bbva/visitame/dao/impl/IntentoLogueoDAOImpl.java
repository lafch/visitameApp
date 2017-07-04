package pe.com.bbva.visitame.dao.impl;

import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import pe.com.bbva.visitame.dao.IntentoLogueoDAO;
import pe.com.bbva.visitame.dominio.IntentoLogueo;
import pe.com.bbva.visitame.exception.DAOException;
import pe.com.bbva.visitame.util.DateUtil;

@Component
public class IntentoLogueoDAOImpl extends BaseDAOImpl<IntentoLogueo, String> implements IntentoLogueoDAO {
	
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LogManager.getLogger(IntentoLogueoDAOImpl.class);
	
	@Autowired private JdbcTemplate jdbcTemplate;
	
	@Override
	protected Class<IntentoLogueo> getClase() { return IntentoLogueo.class; }

	@Override
	public Integer contarIntentosPorDia(Integer doi, String numDoc, Date fecha) throws DAOException {
		java.sql.Connection conexion = null;
		java.sql.CallableStatement invocacion = null;
		try {
			conexion = jdbcTemplate.getDataSource().getConnection();
			invocacion = conexion.prepareCall("{ ? = call appvisitame.sp_contar_intentos_dia(?,?,?) }");
			invocacion.registerOutParameter(1, Types.INTEGER);
			invocacion.setInt(2, doi);
			invocacion.setString(3, numDoc);
			invocacion.setString(4,DateUtil.getFecha2(fecha));
			invocacion.execute();
			Integer count = invocacion.getInt(1);
			invocacion.close();
			conexion.close();
			return count;
		} catch (Exception e) {
			logger.error("ERROR al invocar al procedimiento appvisitame.sp_contar_intentos_dia", e);
			try {
				if (conexion != null && !conexion.isClosed())
					try {
						conexion.close();
					} catch (SQLException e1) {
						logger.error("ERROR al cerrar conexion del procedimiento appvisitame.sp_contar_intentos_dia", e1);
					}
			} catch (SQLException e1) {
				logger.error("ERROR de sintaxis del procedimiento appvisitame.sp_contar_intentos_dia", e1);
			}
		}
		return 0;
	}

	@Override
	public Integer numeroMinutosUltimoIntentoHoy(Integer doi, String numDoc) throws DAOException {
		java.sql.Connection conexion = null;
		java.sql.CallableStatement invocacion = null;
		try {
			conexion = jdbcTemplate.getDataSource().getConnection();
			invocacion = conexion.prepareCall("{ ? = call appvisitame.sp_minutos_ultimo_intento(?,?) }");
			invocacion.registerOutParameter(1, Types.INTEGER);
			invocacion.setInt(2, doi);
			invocacion.setString(3, numDoc);
			invocacion.execute();
			Integer count = invocacion.getInt(1);
			invocacion.close();
			conexion.close();
			return count;
		} catch (Exception e) {
			logger.error("ERROR al invocar al procedimiento appvisitame.sp_horas_ultimo_intento", e);
			try {
				if (conexion != null && !conexion.isClosed())
					try {
						conexion.close();
					} catch (SQLException e1) {
						logger.error("ERROR al cerrar conexion del procedimiento appvisitame.sp_horas_ultimo_intento", e1);
					}
			} catch (SQLException e1) {
				logger.error("ERROR de sintaxis del procedimiento appvisitame.sp_horas_ultimo_intento", e1);
			}
		}
		return 0;
	}
	
}
