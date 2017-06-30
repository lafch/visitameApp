package pe.com.bbva.visitame.dao.impl;

import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Component;

import pe.com.bbva.visitame.dao.IntentoLogueoDAO;
import pe.com.bbva.visitame.dominio.IntentoLogueo;
import pe.com.bbva.visitame.exception.DAOException;

@Component
public class IntentoLogueoDAOImpl extends BaseDAOImpl<IntentoLogueo, String> implements IntentoLogueoDAO {
	
	private static final long serialVersionUID = 1L;
	
	@Autowired private JdbcTemplate jdbcTemplate;
	
	@Override
	protected Class<IntentoLogueo> getClase() { return IntentoLogueo.class; }

	@Override
	public Integer contarIntentosPorDia(Integer doi, String numDoc, Date fecha) throws DAOException {
		java.sql.Connection conexion = null;
		java.sql.CallableStatement invocacion = null;
		
		try {
			SimpleJdbcCall simpleCall = new SimpleJdbcCall(jdbcTemplate).withFunctionName("appvisitame.sp_contar_intentos_dia");
//			conexion = jdbcTemplate.getDataSource().getConnection();
//			invocacion = conexion.prepareCall("{ ? = call appvisitame.sp_contar_intentos_dia(?,?,?) }");
//			invocacion.registerOutParameter(1, Types.INTEGER);
//			invocacion.setInt(2, doi);
//			invocacion.setString(3, numDoc);
//			invocacion.setString(4, "2017-06-30");
//			invocacion.execute();
//			Integer count = invocacion.getInt(1);
//			invocacion.close();
//			return count;
		} catch (Exception e) {
			e.printStackTrace();
			try {
				if (conexion != null && !conexion.isClosed())
					try {
						conexion.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		
		return 0;
	}
	
	
	
}
