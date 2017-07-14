package pe.com.bbva.visitame.helper.sms;
import java.net.ConnectException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import pe.com.bbva.visitame.dominio.dto.cuenta.CustomerDetail;
import pe.com.bbva.visitame.dominio.dto.zic.ZicResult;
import pe.com.bbva.visitame.dominio.sms.EnvioSMSData;
import pe.com.bbva.visitame.dominio.sms.EnvioSMSResponse;
import pe.com.bbva.visitame.exception.NegocioException;
import pe.com.bbva.visitame.helper.zic.ZICServiceHelper;
import org.springframework.http.HttpHeaders;

@Component
@EnableAsync
public class ZICServiceSMSHelper {

	private static final Logger logger = LogManager.getLogger(ZICServiceSMSHelper.class);	
	private static final String LOG_PROMPT = "ZICServiceSMSHelper > ";
	
	@Value("${visitame.servicio.rest.message.url}")
	private String urlMessageService;	
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ZICServiceHelper zicServiceHelper;

	private static final String HEADER_TSEC = "tsec";

	public ZicResult enviarSMS(EnvioSMSData payload) throws NegocioException, ConnectException {
		ZicResult resultService = null;
		String tSec = this.zicServiceHelper.generarTSecCalidad();
		for(int numeroIntento = 1; numeroIntento <= 2; numeroIntento++) {
			//if(numeroIntento == 1) { tSec = this.zicServiceHelper.generarTSec(false); }
			//else { tSec = this.zicServiceHelper.generarTSec(true); }			
			resultService = new ZicResult();
			HttpHeaders headers = new HttpHeaders();
			headers.add(HEADER_TSEC, tSec);
			
			HttpEntity<Object> httpEntity = new HttpEntity<Object>(payload, headers);
			
			StringBuilder url = new StringBuilder(urlMessageService);
			
			HttpMethod method = HttpMethod.POST;

			ResponseEntity<EnvioSMSResponse> responseEntity = null;			
			try {
				//ZICServiceHelper.imprimirPayload(payload);
				logger.info(LOG_PROMPT + "Enviar mensaje de descarga - enviarSMS(): " + url.toString());				
				Gson gson  =  new Gson();
				String body = gson.toJson(payload);
				logger.info(LOG_PROMPT + "body" + body);
				responseEntity = restTemplate.exchange(url.toString(), method, httpEntity, EnvioSMSResponse.class);		
				logger.info(LOG_PROMPT + "Envío de SMS exitoso");
				resultService.setEntidad(responseEntity.getBody());
			} catch (Exception e) { 
				resultService.calcularError(e); 
				logger.info(LOG_PROMPT + "Envío de SMS falló");
			}			
			if(resultService.getCodeError() != null && resultService.getCodeError().equals(ZicResult.CODIGO_TSEC_CADUCO)) { continue; }
			else if(resultService.getCodeError() != null) { return resultService; }
			else { break; }
		}		
		return resultService;
	}
    
}
