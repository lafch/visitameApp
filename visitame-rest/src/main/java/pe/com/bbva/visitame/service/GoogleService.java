package pe.com.bbva.visitame.service;

import pe.com.bbva.visitame.exception.NegocioException;

public interface GoogleService {

	boolean validarReCaptcha(String remoteip , String llaveDinamica)  throws NegocioException;
	
}
