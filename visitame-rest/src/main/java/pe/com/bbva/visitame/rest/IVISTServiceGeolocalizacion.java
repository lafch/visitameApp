package pe.com.bbva.visitame.rest;

import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import pe.com.bbva.visitame.dominio.dto.gelocalizacion.ResultGeolocalizacion;
import pe.com.bbva.visitame.exception.NegocioException;
import pe.com.bbva.visitame.exception.ValidacionException;

@Path("/geolocalizacion")
public interface IVISTServiceGeolocalizacion {
	
	@GET
	@Path("/pois")
	@Produces({MediaType.APPLICATION_JSON})
	public Map<String, ResultGeolocalizacion> obtenerOficinas(
			@QueryParam("latitud") String latitud,
			@QueryParam("longitud") String longitud,
			@QueryParam("radius") String radius,
			@QueryParam("filter") String filter,
			@QueryParam("startAt") String startAt,
			@QueryParam("limit") String limit,
			@QueryParam("type") String type
			) throws ValidacionException, NegocioException;
}