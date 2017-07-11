package pe.com.bbva.visitame.dao.impl;

import java.sql.SQLException;
import java.sql.Types;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import pe.com.bbva.visitame.dao.OficinaDAO;
import pe.com.bbva.visitame.dominio.Oficina;
import pe.com.bbva.visitame.exception.DAOException;
import pe.com.bbva.visitame.util.DateUtil;

@Component
public class OficinaDAOImpl extends BaseDAOImpl<Oficina, String> implements OficinaDAO {

	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LogManager.getLogger(OficinaDAOImpl.class);
	
	@Autowired 
	private JdbcTemplate jdbcTemplate;
	
	@Override
	protected Class<Oficina> getClase() { return Oficina.class; }

	@Override
	public int generarTicket(String codEmpresa) throws DAOException {
	/*	String sql = "SELECT max (nu_sec_ticket) + 1  as ticket FROM appvisitame.tvisita006_ofi_oficina where appvisitame.tvisita006_ofi_oficina.cd_oficina = ?";
		int numSeq = 0;
		try {
			numSeq = (int) jdbcTemplate.queryForObject(sql, new Object[] { idOficina }, Integer.class);
		} catch (Exception e) {
			logger.error("ERROR " +sql, e);
		}
		return numSeq;*/
		
		java.sql.Connection conexion = null;
		java.sql.CallableStatement invocacion = null;
		try {
			conexion = jdbcTemplate.getDataSource().getConnection();
			invocacion = conexion.prepareCall("{ ? = call  appvisitame.sp_generar_ticket_oficina(?) }");
			invocacion.registerOutParameter(1,  Types.INTEGER);
			invocacion.setString(2, codEmpresa);
			invocacion.execute();
			Integer numSeq = invocacion.getInt(1);
			invocacion.close();
			conexion.close();
			return numSeq;
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
	
}
