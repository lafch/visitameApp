package pe.com.bbva.visitame.service.impl;

import java.net.ConnectException;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import pe.com.bbva.visitame.dao.IntentoLogueoDAO;
import pe.com.bbva.visitame.dao.PersonaDAO;
import pe.com.bbva.visitame.dominio.IntentoLogueo;
import pe.com.bbva.visitame.dominio.Persona;
import pe.com.bbva.visitame.dominio.dto.cuenta.Customer;
import pe.com.bbva.visitame.dominio.dto.cuenta.CustomerDetail;
import pe.com.bbva.visitame.dominio.dto.zic.ZicResult;
import pe.com.bbva.visitame.dominio.util.Constantes;
import pe.com.bbva.visitame.exception.NegocioException;
import pe.com.bbva.visitame.helper.cuenta.ZICServiceAccountHelper;
import pe.com.bbva.visitame.service.AccountService;
import pe.com.bbva.visitame.util.Busqueda;

@Service
public class AccountServiceImpl extends BaseServiceImpl implements AccountService {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ZICServiceAccountHelper zicServiceAccountHelper;
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private PersonaDAO personaDAO;
	
	@Autowired
	private IntentoLogueoDAO intentoLogueoDAO;

	@Override 
	public CustomerDetail getCustomer(String documentNumber, Integer documentType) throws NegocioException {

		CustomerDetail customerDetail = null;
		try {
			
			ZicResult result =  zicServiceAccountHelper.getListCustomers(documentNumber, documentType);
			if(result.getCodeError() != null){
				lanzarExcepcionLeve(result.getCodeError(), new Object[]{}, result.getMessageError(), null);
			}
			customerDetail = (CustomerDetail)result.getEntidad();
			return customerDetail;
		} catch (ConnectException e) {
			throw new NegocioException(messageSource.getMessage(Constantes.MENSAJE.ERROR_ZIC_SERVICIO_DEFAULT, null, "", new Locale("es")));
		}
		
		
	}

	@Override
	public List<Persona> obtenerPersona(Busqueda b) throws NegocioException {
		try {
			return personaDAO.listar(b); 
		} catch (Exception e) {
			lanzarExcepcionGrave(NegocioException.CODIGO.NEG_CONSULTA_FALLIDA, new Object[] { e.getMessage() }, "No se pudo ejecutar satisfactoriamente la consulta: " + e.getMessage(), e);
		}
		return null;
	}

	@Override
	public Persona obtenerPersonaPorId(String id) throws NegocioException {
		try {
			return personaDAO.obtener(id);
		} catch (Exception e) {
			lanzarExcepcionGrave(NegocioException.CODIGO.NEG_CONSULTA_FALLIDA, new Object[] { e.getMessage() }, "No se pudo ejecutar satisfactoriamente la consulta: " + e.getMessage(), e);
		}
		return null;
	}

	@Override
	public Persona registrarPersona(Persona persona) throws NegocioException {
		try {
			if(persona.getCdPersona() == null){
				personaDAO.crear(persona);
			}else{
				personaDAO.modificar(persona);
			}
		} catch (Exception e) {
			lanzarExcepcionGrave(NegocioException.CODIGO.NEG_CONSULTA_FALLIDA, new Object[] { e.getMessage() }, "No se pudo ejecutar satisfactoriamente la consulta: " + e.getMessage(), e);
		}
		return null;
	}

	@Override
	public IntentoLogueo registrarIntentoLogueo(IntentoLogueo intento) throws NegocioException {
		try {
			if(intento.getCdIntento() == null){
				intento.setTmCreacion(new Date());
				intentoLogueoDAO.crear(intento);
			}else{
				intentoLogueoDAO.modificar(intento);
			}
		} catch (Exception e) {
			lanzarExcepcionGrave(NegocioException.CODIGO.NEG_CONSULTA_FALLIDA, new Object[] { e.getMessage() }, "No se pudo ejecutar satisfactoriamente la consulta: " + e.getMessage(), e);
		}
		return null;
	}

	@Override
	public Integer contarIntentosLogueo() throws NegocioException {
		// TODO Auto-generated method stub
		//buscar en la tabla intento por num doc , tipo doc, en un rango de 12 horas
		//la cantidad obtenida no debe ser mayor que la parametroia de intentos maximos
		//crear la parametria
		return null;
	}

	@Override
	public Map<String, Object> validarUsuario(Persona persona) throws NegocioException {
		// Implementacion del servicio expuesto
		// donde se valida a la persona
		// getCustomer
		// crear si no existe persona
		// registrar intento si todo es correcto
		CustomerDetail datosPersona = getCustomer(persona.getNbNumDoi(), persona.getCdTipoDoi());
		System.out.println(datosPersona);
		
		if(datosPersona==null){
			//Insertar Persona
			
			
		}else{
			
		}
		
		
		
		return null;
	}

}
