package pe.com.bbva.visitame.rest;


import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import pe.com.bbva.visitame.dominio.dto.cuenta.CustomerDetail;
import pe.com.bbva.visitame.exception.NegocioException;
import pe.com.bbva.visitame.exception.ValidacionException;

@Path("/account")
public interface IVISTServiceAccount {
	
	@GET
	@Path("/getCustomer")
	@Produces({MediaType.APPLICATION_JSON})
	public CustomerDetail getCustomer(
			@QueryParam("documentNumber") String documentNumber,
			@QueryParam("documentType") String documentType
			) throws ValidacionException, NegocioException;

	
	@POST
	@Path("/validate")
	@Produces({MediaType.APPLICATION_JSON})
	public Map<String, Object> validarUsuario(
			@QueryParam("documentNumber") String documentNumber,
			@QueryParam("documentType") String documentType
			) throws ValidacionException, NegocioException;
	
}
