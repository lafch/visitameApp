package pe.com.bbva.visitame.service.impl;


import java.net.ConnectException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.bbva.visitame.dominio.dto.zic.ZicResult;
import pe.com.bbva.visitame.dominio.sms.EnvioSMSData;
import pe.com.bbva.visitame.dominio.sms.EnvioSMSResponse;
import pe.com.bbva.visitame.dominio.util.Constantes;
import pe.com.bbva.visitame.exception.NegocioException;
import pe.com.bbva.visitame.helper.sms.ZICServiceSMSHelper;
import pe.com.bbva.visitame.service.EnvioSMSService;

@Service
public class EnvioSMSServiceImpl extends BaseServiceImpl implements EnvioSMSService {

	private static final long serialVersionUID = -2214341561996003286L;
	private static final String LOG_PROMPT = "CampanhasService > ";
	
	@Autowired
	private ZICServiceSMSHelper serviceSMSHelper;
	 
	@Override
	public int enviarSMSDescarga(EnvioSMSData envioSMSData) throws NegocioException {
		if (envioSMSData == null) {
			lanzarExcepcionMedia(NegocioException.CODIGO.NEG_ARGUMENTO_OBLIGATORIO, new Object[] { "envioSMSData" },
					"Debe ingresar los siguientes argumentos: envioSMSData", null);
		}
		if (envioSMSData.getDistributionChannel() == null) {
			lanzarExcepcionMedia(NegocioException.CODIGO.NEG_ARGUMENTO_OBLIGATORIO, new Object[] { "DistributionChannel" },
					"Debe ingresar los siguientes argumentos: DistributionChannel", null);
		}
		if (envioSMSData.getDistributionChannel().getRecipients() == null) {
			lanzarExcepcionMedia(NegocioException.CODIGO.NEG_ARGUMENTO_OBLIGATORIO, new Object[] { "Recipients" },
					"Debe ingresar los siguientes argumentos: Recipients", null);
		}
		ZicResult result = null;
		try {
			result = serviceSMSHelper.enviarSMS(envioSMSData);
		} catch (ConnectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(result != null) {
			if(StringUtils.isNotBlank(result.getCodeError()) && StringUtils.isNotBlank(result.getMessageError())) {
				
				throw new NegocioException(StringUtils.isNotBlank(result.getCodeError()) ? result.getCodeError() : Constantes.MENSAJE.ERROR_ZIC_SERVICIO_DEFAULT, 
										   StringUtils.join(new String[]{result.getCodeError(), result.getMessageError()}, StringUtils.EMPTY));
			}else {
				EnvioSMSResponse envioSMSResponse = (EnvioSMSResponse) result.getEntidad();
			}
		}	
		return 0;
	}
}
