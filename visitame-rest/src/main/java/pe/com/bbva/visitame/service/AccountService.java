package pe.com.bbva.visitame.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import pe.com.bbva.visitame.dominio.Historico;
import pe.com.bbva.visitame.dominio.IntentoLogueo;
import pe.com.bbva.visitame.dominio.Persona;
import pe.com.bbva.visitame.dominio.dto.cuenta.CustomerDetail;
import pe.com.bbva.visitame.exception.NegocioException;
import pe.com.bbva.visitame.exception.SOAPException;
import pe.com.bbva.visitame.util.Busqueda;

public interface AccountService {

	CustomerDetail getCustomer( String documentNumber , String documentType , String test) throws NegocioException;
	
	List<Persona> obtenerPersona(Busqueda b) throws NegocioException;
	
	Persona obtenerPersonaPorId(String id) throws NegocioException;
	
	Persona registrarPersona(Persona persona) throws NegocioException;
	
	IntentoLogueo registrarIntentoLogueo(IntentoLogueo intento) throws NegocioException;
	
	Integer contarIntentosLogueo(String doi , String numDoc) throws NegocioException;
	
	Map<String, Object> validarUsuario(String documentNumber, String documentType , String desDocumentType ,String captchaResponse , String ipRemote, String codOficina) throws NegocioException;
	
	Persona obtenerPersonaDoiNumdocumento(String doi , String numDoc) throws NegocioException;
	
	Map<String, Object> actualizarDatosContacto(String documentNumber, String documentType , String email, String telefono, String tipoTelefono) throws NegocioException;
	
	Integer contarIntentosPorDia(Integer documentType , String documentNumber , Date fecha) throws NegocioException;
	
	Integer numeroMinutosUltimoIntentoHoy(Integer documentType , String documentNumber) throws NegocioException;
	
	Persona consultarReniec(String documentNumber, String documentType) throws NegocioException;
	
	Historico registrarHistorico(Historico historico) throws NegocioException;
}
