package pe.com.bbva.visitame.service;

import pe.com.bbva.visitame.dominio.sms.EnvioSMSData;
import pe.com.bbva.visitame.exception.NegocioException;

public interface EnvioSMSService {

	//Envio SMS
	int enviarSMSDescarga(EnvioSMSData envioSMSData) throws NegocioException;
	
}