package pe.com.bbva.visitame.service.impl;

import java.net.ConnectException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import pe.com.bbva.visitame.dao.IntentoLogueoDAO;
import pe.com.bbva.visitame.dao.PersonaDAO;
import pe.com.bbva.visitame.dominio.IntentoLogueo;
import pe.com.bbva.visitame.dominio.Parametro;
import pe.com.bbva.visitame.dominio.Persona;
import pe.com.bbva.visitame.dominio.dto.cuenta.Customer;
import pe.com.bbva.visitame.dominio.dto.cuenta.CustomerDetail;
import pe.com.bbva.visitame.dominio.dto.zic.ZicResult;
import pe.com.bbva.visitame.dominio.util.Constantes;
import pe.com.bbva.visitame.dominio.util.Mensajes;
import pe.com.bbva.visitame.exception.DAOException;
import pe.com.bbva.visitame.exception.NegocioException;
import pe.com.bbva.visitame.helper.cuenta.ZICServiceAccountHelper;
import pe.com.bbva.visitame.service.AccountService;
import pe.com.bbva.visitame.service.ConfiguracionService;
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
	
	@Autowired
	private ConfiguracionService configuracionService;

	@Override 
	public CustomerDetail getCustomer(String documentNumber, String documentType , String test) throws NegocioException {

		CustomerDetail customerDetail = null;
		try {
			ZicResult result = null;
			if(StringUtils.isBlank(test)){
				result =  zicServiceAccountHelper.getListCustomers(documentNumber, documentType);
			}else{
				result =  zicServiceAccountHelper.getListCustomers(test);
			}
			
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
			return persona;
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
			return intento;
		} catch (Exception e) {
			lanzarExcepcionGrave(NegocioException.CODIGO.NEG_CONSULTA_FALLIDA, new Object[] { e.getMessage() }, "No se pudo ejecutar satisfactoriamente la consulta: " + e.getMessage(), e);
		}
		return null;
	}

	@Override
	public Integer contarIntentosLogueo(String doi , String numDoc) throws NegocioException {

		Busqueda busqueda = Busqueda.forClass(Persona.class);
		busqueda.add(Restrictions.eq("cdTipoDoi", Integer.parseInt(doi)));
		busqueda.add(Restrictions.eq("nbNumDoi", numDoc));
		List<Persona> list = this.obtenerPersona(busqueda);
		
		if(list != null & list.size() > 0){
			return list.size();
		}
		return 0;
	}

	public void validarIntentos(String documentNumber, String documentType) throws NegocioException{
		
		Parametro pMaxIntencionesPorDia = configuracionService.obtenerParametro(Constantes.PARAMETRO.NUM_MAX_INTENTO_TICKET);
		Parametro pMaxHorasUltimoIntento = configuracionService.obtenerParametro(Constantes.PARAMETRO.HORAS_ESPERA_ULT_INTENTO);
		
		Integer numeroIntenciones = this.contarIntentosPorDia(Integer.parseInt(documentType), documentNumber, new Date());
		Integer horasUltimoIntento = this.numeroHorasUltimoIntentoHoy(Integer.parseInt(documentType), documentNumber);

		if(numeroIntenciones >= Integer.parseInt(pMaxIntencionesPorDia.getTxValor())){
			lanzarExcepcionLeve(Mensajes.TICKET.MAX_CUOTA_TICKET_DIA, new Object[] {  }, "UD. ha agotado la cuota máxima de tickets por día.", null);
		}else{
			if(horasUltimoIntento <= Integer.parseInt(pMaxHorasUltimoIntento.getTxValor())){
				String txtHoras = (Integer.parseInt(pMaxHorasUltimoIntento.getTxValor())==1? "1 hora":pMaxHorasUltimoIntento.getTxValor()+" horas");
				lanzarExcepcionLeve(Mensajes.TICKET.TIEMPO_ESPERA_SIGUIENTE_TICKET , new Object[] { txtHoras }, "UD. ha generado un ticket de atención recientemente, vuelva a intentarlo dentro de "+txtHoras+".", null);
			}
		}
		
	}
	
	@Override
	public Map<String, Object> validarUsuario(String documentNumber, String documentType , String desDocumentType) throws NegocioException {
		
		Map<String, Object> result = new HashMap<String, Object>();		
		CustomerDetail datosCustumer = getCustomer(documentNumber, documentType,documentNumber+".json");

		Boolean iscliente = true;
		
		if(datosCustumer == null){
			iscliente = false;
		}
		
		//validamos los intentos realizados
		this.validarIntentos(documentNumber, documentType);
		
		//Verificamos si la persona este en nustra BD PG
		Persona persona = this.obtenerPersonaDoiNumdocumento(documentType, documentNumber);
		
		//Si no existe persona en nuestra BD
		//La registramos detectando si es cliente o no
		//por el metodo "getCustomer"
		if(persona == null){
				if(iscliente){
					Customer dataCliente = datosCustumer.getData().get(0);
					persona = new Persona();
					persona.setCdTipoDoi(Integer.parseInt(documentType));
					persona.setNbNumDoi(documentNumber);
					persona.setIsCliente("S");
					persona.setNbNombre(dataCliente.getFirstName());
					persona.setNbPaterno(dataCliente.getLastName());
					persona.setNbMaterno(dataCliente.getSurnames());
					persona.setTmCreacion(new Date());
					persona.setCdCreador(1);
					persona = this.registrarPersona(persona);
				}else{
					
					//Verificar datos de la reniec
					//si existe la persona se crearia en base a los datos de la reniec
					
				}
			
		}else{
			//si la persona existe en nuestra BD
			//solo actualizamos el estado de si es cliente
			//por si se ha modificado
			if(datosCustumer != null){
				persona.setIsCliente("S");
			}else{
				persona.setIsCliente("N");
			}
			
			this.registrarPersona(persona);
			
		}
		
		//finalmente si la persona existe
		//se registra el intento de logueo
		if(persona != null){
			
			IntentoLogueo intento = new IntentoLogueo();
			intento.setCdTipoDoi(persona.getCdTipoDoi());
			intento.setNbNumDoi(persona.getNbNumDoi());
			intento.setTmCreacion(new Date());
			intento.setCdCreador(1);
			this.registrarIntentoLogueo(intento);
			
			result.put("success", true);
		}else{
			result.put("success", false);
		}
		
		
		result.put("persona", datosCustumer);
		return result;
	}

	@Override
	public Persona obtenerPersonaDoiNumdocumento(String doi, String numDoc) throws NegocioException {
		Busqueda busqueda = Busqueda.forClass(Persona.class);
		busqueda.add(Restrictions.eq("cdTipoDoi", Integer.parseInt(doi)));
		busqueda.add(Restrictions.eq("nbNumDoi", numDoc));
		List<Persona> list = this.obtenerPersona(busqueda);
		if(list != null & list.size() > 0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	public Map<String, Object> actualizarDatosContacto(String documentNumber, String documentType , String desDocumentType,
			String email, String telefono) throws NegocioException {
		
		Map<String, Object> result = new HashMap<String, Object>();		
		CustomerDetail datosCustumer = getCustomer(documentNumber, documentType,documentNumber+".json");
		
		//Verificamos si la persona este en nustra BD PG
		Persona persona = this.obtenerPersonaDoiNumdocumento(documentType, documentNumber);
		
		//Si no existe persona en nuestra BD
		if(persona != null){
			if(email != null && !email.isEmpty()){
				persona.setNbEmail(email);
			}
			if(telefono != null && !telefono.isEmpty()){
				persona.setNbTelefono(telefono);
			}
			persona.setCdEditor(1);
			persona.setTmEdicion(new Date());
			this.registrarPersona(persona);
			
		}else{
			System.out.println("Persona no está registrada en la Base de Datos");
		}

		result.put("persona", datosCustumer);
		return result;
	}

	@Override
	public Integer contarIntentosPorDia(Integer documentType, String documentNumber, Date fecha)
			throws NegocioException {
		try {
			return intentoLogueoDAO.contarIntentosPorDia(documentType, documentNumber, new Date());
		} catch (DAOException e) {
			lanzarExcepcionGrave(NegocioException.CODIGO.NEG_CONSULTA_FALLIDA, new Object[] { e.getMessage() }, "No se pudo ejecutar satisfactoriamente la consulta: " + e.getMessage(), e);
		}
		return 0;
	}

	@Override
	public Integer numeroHorasUltimoIntentoHoy(Integer documentType, String documentNumber) throws NegocioException {
		try {
			return intentoLogueoDAO.numeroHorasUltimoIntentoHoy(documentType , documentNumber);
		} catch (DAOException e) {
			lanzarExcepcionGrave(NegocioException.CODIGO.NEG_CONSULTA_FALLIDA, new Object[] { e.getMessage() }, "No se pudo ejecutar satisfactoriamente la consulta: " + e.getMessage(), e);
		}
		return 0;
	}
	

}
