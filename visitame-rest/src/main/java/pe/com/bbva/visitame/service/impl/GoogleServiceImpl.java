package pe.com.bbva.visitame.service.impl;

import java.net.ConnectException;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import pe.com.bbva.visitame.dominio.dto.captcha.ResultCaptcha;
import pe.com.bbva.visitame.dominio.dto.zic.ZicResult;
import pe.com.bbva.visitame.dominio.util.Constantes;
import pe.com.bbva.visitame.exception.NegocioException;
import pe.com.bbva.visitame.helper.google.GoogleServiceHelper;
import pe.com.bbva.visitame.service.GoogleService;

@Service
public class GoogleServiceImpl extends BaseServiceImpl  implements GoogleService {

	private static final long serialVersionUID = 1L;

	@Autowired
	private GoogleServiceHelper googleServiceHelper;
	
	@Autowired
	private MessageSource messageSource;
	
	@Override
	public boolean validarReCaptcha(String remoteip, String llaveDinamica) throws NegocioException {
		
		ResultCaptcha resultCaptcha = null;
		try {
			ZicResult result = googleServiceHelper.validarReCaptcha(remoteip, llaveDinamica);
			
			if(result.getCodeError() != null){
				lanzarExcepcionLeve(result.getCodeError(), new Object[]{}, result.getMessageError(), null);
			}
			resultCaptcha = (ResultCaptcha)result.getEntidad();
			if(resultCaptcha == null){
				return false;
			}
			return resultCaptcha.isSuccess();
		} catch (ConnectException e) {
			throw new NegocioException(messageSource.getMessage(Constantes.MENSAJE.ERROR_ZIC_SERVICIO_DEFAULT, null, "", new Locale("es")));
		}
		
	}

}
