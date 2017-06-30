package pe.com.bbva.visitame.service;

import java.util.List;
import java.util.Map;

import pe.com.bbva.visitame.dominio.IntentoLogueo;
import pe.com.bbva.visitame.dominio.Persona;
import pe.com.bbva.visitame.dominio.dto.cuenta.CustomerDetail;
import pe.com.bbva.visitame.exception.NegocioException;
import pe.com.bbva.visitame.util.Busqueda;

public interface AccountService {

	CustomerDetail getCustomer( String documentNumber , String documentType , String test) throws NegocioException;
	
	List<Persona> obtenerPersona(Busqueda b) throws NegocioException;
	
	Persona obtenerPersonaPorId(String id) throws NegocioException;
	
	Persona registrarPersona(Persona persona) throws NegocioException;
	
	IntentoLogueo registrarIntentoLogueo(IntentoLogueo intento) throws NegocioException;
	
	Integer contarIntentosLogueo(String doi , String numDoc) throws NegocioException;
	
	Map<String, Object> validarUsuario(String documentNumber, String documentType , String desDocumentType) throws NegocioException;
	
	Persona obtenerPersonaDoiNumdocumento(String doi , String numDoc) throws NegocioException;
	
}
