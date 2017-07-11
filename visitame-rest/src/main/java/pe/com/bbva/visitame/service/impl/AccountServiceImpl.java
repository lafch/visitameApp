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

import pe.com.bbva.visitame.dao.HistoricoDAO;
import pe.com.bbva.visitame.dao.IntentoLogueoDAO;
import pe.com.bbva.visitame.dao.PersonaDAO;
import pe.com.bbva.visitame.dominio.Historico;
import pe.com.bbva.visitame.dominio.IntentoLogueo;
import pe.com.bbva.visitame.dominio.Parametro;
import pe.com.bbva.visitame.dominio.Persona;
import pe.com.bbva.visitame.dominio.Valor;
import pe.com.bbva.visitame.dominio.dto.cuenta.Customer;
import pe.com.bbva.visitame.dominio.dto.cuenta.CustomerDetail;
import pe.com.bbva.visitame.dominio.dto.zic.ZicResult;
import pe.com.bbva.visitame.dominio.reniec.Ciudadano;
import pe.com.bbva.visitame.dominio.util.Constantes;
import pe.com.bbva.visitame.dominio.util.Mensajes;
import pe.com.bbva.visitame.exception.DAOException;
import pe.com.bbva.visitame.exception.NegocioException;
import pe.com.bbva.visitame.exception.SOAPException;
import pe.com.bbva.visitame.helper.cuenta.ZICServiceAccountHelper;
import pe.com.bbva.visitame.helper.reniec.ReniecServiceHelper;
import pe.com.bbva.visitame.service.AccountService;
import pe.com.bbva.visitame.service.ConfiguracionService;
import pe.com.bbva.visitame.service.GoogleService;
import pe.com.bbva.visitame.service.TicketService;
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
	
	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private GoogleService googleService;

	@Autowired 
	private ReniecServiceHelper reniecServiceHelper;
	
	@Autowired 
	private HistoricoDAO historicoDAO;

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
	public Historico registrarHistorico(Historico historico) throws NegocioException {
		try {
			if(historico.getCodigo() == null){
				historicoDAO.crear(historico);
			}else{
				historicoDAO.modificar(historico);
			}
			return historico;
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
	
	public Persona consultarReniec(String documentNumber, String documentType) throws NegocioException{
		
		Persona persona = null;
		Ciudadano ciudadano = null;
	
		try {
			ciudadano = reniecServiceHelper.obtenerPersonaXDNI(documentNumber);
			if(ciudadano.getDomicilio() !=null){
				persona = new Persona();
				persona.setCdTipoDoi(Integer.parseInt(documentType));
				persona.setNbNumDoi(documentNumber);
				persona.setNbNombre(ciudadano.getNombres());
				persona.setNbPaterno(ciudadano.getApellidoPaterno());
				persona.setNbMaterno(ciudadano.getApellidoMaterno());
				persona.setTmCreacion(new Date());
				persona.setCdCreador(1);
			}
		} catch (SOAPException e) {
			lanzarExcepcionLeve(Constantes.MENSAJE.UI_SERVICIO_NO_DISPONIBLE , new Object[] {  }, "Servicio no disponible.", null);
		}
		return persona;
	}
	
	public void validarIntentos(String documentNumber, String documentType) throws NegocioException{
		
		Parametro pMaxIntencionesPorDia = configuracionService.obtenerParametro(Constantes.PARAMETRO.NUM_MAX_INTENTO_TICKET);
		Parametro pMaxHorasUltimoIntento = configuracionService.obtenerParametro(Constantes.PARAMETRO.HORAS_ESPERA_ULT_INTENTO);
		
		Integer numeroIntenciones = this.contarIntentosPorDia(Integer.parseInt(documentType), documentNumber, new Date());
		Integer minutosUltimoIntento = this.numeroMinutosUltimoIntentoHoy(Integer.parseInt(documentType), documentNumber);

		if(numeroIntenciones >= Integer.parseInt(pMaxIntencionesPorDia.getTxValor())){
			lanzarExcepcionLeve(Mensajes.TICKET.MAX_CUOTA_TICKET_DIA, new Object[] {  }, "UD. ha agotado la cuota máxima de tickets por día.", null);
		}else{
			Integer horasUltimoIntento = (minutosUltimoIntento/60);
			Integer minutosFaltantes = 60- (minutosUltimoIntento -(horasUltimoIntento*60));
			
			if(numeroIntenciones > 0 && horasUltimoIntento <= Integer.parseInt(pMaxHorasUltimoIntento.getTxValor())){
				String txtHoras = "";
				
				if(horasUltimoIntento > 0){
					txtHoras+=(horasUltimoIntento==1? "1 hora con ":horasUltimoIntento+" horas con ");
					txtHoras+=(minutosFaltantes==1? "1 minuto":minutosFaltantes+" minutos");
				}else{
					if(minutosFaltantes == 60){
						txtHoras+="1 hora";
					}else{
						txtHoras+=(minutosFaltantes==1? "1 minuto":minutosFaltantes+" minutos");
					}
					
				}
				lanzarExcepcionLeve(Mensajes.TICKET.TIEMPO_ESPERA_SIGUIENTE_TICKET , new Object[] { txtHoras }, "UD. ha generado un ticket de atención recientemente, vuelva a intentarlo dentro de "+txtHoras+".", null);
			}
		}
		
	}
	
	@Override
	public Map<String, Object> validarUsuario(String documentNumber, String documentType , String desDocumentType ,String captchaResponse ,String ipRemote, String codOficina) throws NegocioException {
		
		this.validarCaptcha(captchaResponse , ipRemote);
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
					persona.setIsCliente(Constantes.ETIQUETAS_CLASES.ES_CLIENTE);
					persona.setNbNombre(dataCliente.getFirstName());
					persona.setNbPaterno(dataCliente.getLastName());
					persona.setNbMaterno(dataCliente.getSurnames());
					persona.setTmCreacion(new Date());
					persona.setCdCreador(1);
					persona = this.registrarPersona(persona);
					
				}else{	
					//Verificar datos de la reniec
					//si existe la persona se crearia en base a los datos de la reniec
					if(desDocumentType.equals(Constantes.ETIQUETAS_CLASES.CARNET_EXTRANJERIA)){
						result.put(Constantes.ETIQUETAS_CLASES.PERSONA, datosCustumer);
						result.put(Constantes.ETIQUETAS_CLASES.SUCCESS, false);
						return result;
					}
					persona = this.consultarReniec(documentNumber, desDocumentType);
					if(persona!=null)
						this.registrarPersona(datosCustumer, persona);	
				}
			
		}else{
			//si la persona existe en nuestra BD
			//solo actualizamos el estado de si es cliente
			//por si se ha modificado
			this.registrarPersona(datosCustumer, persona);
		}
		
		//finalmente si la persona existe
		//se registra el intento de logueo
		if(persona != null){
			
			//Generación de Ticket 
			String ticket =  ticketService.generarTicket(codOficina, documentNumber);
			Map<String, Object> ticketResponse = new HashMap<String, Object>();	
			ticketResponse.put("ticket", ticket);
			ticketResponse.put("fecGenerado", new Date());
			result.put("ticketResponse", ticketResponse);
			
			IntentoLogueo intento = new IntentoLogueo();
			intento.setCdTipoDoi(persona.getCdTipoDoi());
			intento.setNbNumDoi(persona.getNbNumDoi());
			intento.setTmCreacion(new Date());
			intento.setCdCreador(1);
			this.registrarIntentoLogueo(intento);
			result.put(Constantes.ETIQUETAS_CLASES.SUCCESS, true);
			
		}else{
			result.put(Constantes.ETIQUETAS_CLASES.SUCCESS, false);
		}
		result.put(Constantes.ETIQUETAS_CLASES.PERSONA, datosCustumer);
		return result;
	}

	private void validarCaptcha(String captchaResponse , String ipRemote) throws NegocioException{
		if(StringUtils.isBlank(captchaResponse)){
			lanzarExcepcionLeve(Mensajes.GOOGLE.CAPTCHA_NO_VERIFICADO , new Object[] { }, "No se ha verificado el captcha.", null);
		}
		
		boolean captchaValido = googleService.validarReCaptcha(ipRemote, captchaResponse);
		
		if(!captchaValido){
			lanzarExcepcionLeve(Mensajes.GOOGLE.CAPTCHA_NO_VALIDO , new Object[] { }, "La verificación del captcha es incorrecta.", null);
		}
		
	}

	
	private void registrarPersona(CustomerDetail datosCustumer, Persona persona) throws NegocioException{
		
		if(datosCustumer != null)
			persona.setIsCliente(Constantes.ETIQUETAS_CLASES.ES_CLIENTE);
		else
			persona.setIsCliente(Constantes.ETIQUETAS_CLASES.NO_ES_CLIENTE);
		
		this.registrarPersona(persona);
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
	public Map<String, Object> actualizarDatosContacto(String documentNumber, String documentType ,
			String email, String telefono,String tipoOperador) throws NegocioException {
		
		Map<String, Object> result = new HashMap<String, Object>();		
			
		Persona persona = this.obtenerPersonaDoiNumdocumento(documentType, documentNumber);
		
		//Si no existe persona en nuestra BD
		if(persona != null){
			if(email != null && !email.isEmpty()){
				persona.setNbEmail(email);
				//historico.setCorreo(email);
			}
			if(telefono != null && !telefono.isEmpty()){
				persona.setNbTelefono(telefono);
				//historico.setTelefono(telefono);
			}
			persona.setCdEditor(1);
			persona.setTmEdicion(new Date());
			
			validarDatosHistorico(email, telefono,tipoOperador,persona);
			
			this.registrarPersona(persona);

			result.put(Constantes.ETIQUETAS_CLASES.SUCCESS, true);
		}else{
			result.put(Constantes.ETIQUETAS_CLASES.SUCCESS, false);
			System.out.println("Persona no está registrada en la Base de Datos");
		}

		result.put(Constantes.ETIQUETAS_CLASES.PERSONA, persona);
		return result;
	}

	
	public void validarDatosHistorico(String email, String telefono, String tipoOperador,Persona persona) throws NegocioException{
		
		if(email != null && !email.isEmpty() && !email.equals("undefined")  || telefono != null && !telefono.isEmpty() && !telefono.equals("undefined")  && tipoOperador!=null ){
			Historico historico = new Historico();
			if(email != null && !email.isEmpty()){
				historico.setCorreo(email);
			}
			if(telefono != null && !telefono.isEmpty() && !telefono.equals("undefined")){
				historico.setTelefono(telefono);
			}
			historico.setPersona(persona);
			Valor valorTipoOperador=null;
			if(tipoOperador!=null){
				valorTipoOperador = configuracionService.obtenerValor(Constantes.LISTA.LISTA_TIPO_OPERADOR, tipoOperador);
			}
			
			Valor estadoTicket = configuracionService.obtenerValor(Constantes.LISTA.LISTA_ESTADO_TICKET,
					Constantes.VALOR.ESTADO_TICKETS.ENVIADO);
			
			historico.setTipoOperador(valorTipoOperador);
			historico.setEstadoEnvio(estadoTicket);

			historico.setTmCreacion(new Date());
			historico.setCreador(1);
			registrarHistorico(historico);
			
		}else{
			lanzarExcepcionLeve(Mensajes.DATOS.INGRESAR_DATO_CONTACTO , new Object[] {  }, "Usted debe ingresar almenos un dato de contacto.", null);
		}

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
	public Integer numeroMinutosUltimoIntentoHoy(Integer documentType, String documentNumber) throws NegocioException {
		try {
			return intentoLogueoDAO.numeroMinutosUltimoIntentoHoy(documentType , documentNumber);
		} catch (DAOException e) {
			lanzarExcepcionGrave(NegocioException.CODIGO.NEG_CONSULTA_FALLIDA, new Object[] { e.getMessage() }, "No se pudo ejecutar satisfactoriamente la consulta: " + e.getMessage(), e);
		}
		return 0;
	}
	

}
