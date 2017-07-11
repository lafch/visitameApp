package pe.com.bbva.visitame.rest;

import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import pe.com.bbva.visitame.exception.NegocioException;
import pe.com.bbva.visitame.exception.ValidacionException;

@Path("/oficina")
public interface IVISTServiceTicket {
	
	@GET
	@Path("/ticket")
	@Produces({MediaType.APPLICATION_JSON})
	public Map<String, String> obtenerOficinas(
			@QueryParam("codOficina") String oficina,
			@QueryParam("dni") String dni
			) throws ValidacionException, NegocioException;
}