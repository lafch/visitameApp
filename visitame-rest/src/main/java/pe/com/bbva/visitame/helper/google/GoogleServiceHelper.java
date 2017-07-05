package pe.com.bbva.visitame.helper.google;

import java.net.ConnectException;
import java.text.MessageFormat;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pe.com.bbva.visitame.dominio.dto.captcha.ResultCaptcha;
import pe.com.bbva.visitame.dominio.dto.zic.ZicResult;

@Component
public class GoogleServiceHelper {

	@Value("${visitame.servicio.rest.google.captcha.url}")
	private String urlGoogleReCaptcha;
	
	@Value("${visitame.servicio.rest.google.captcha.keySecret}")
	private String keySecret;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public ZicResult validarReCaptcha(String remoteip , String llaveDinamica) throws ConnectException{
		
		ZicResult resultService = new ZicResult();
		
		HttpHeaders headers = new HttpHeaders();
		
		StringBuilder parametrosEnvio = new StringBuilder(StringUtils.EMPTY);
		
		StringBuilder url = new StringBuilder(urlGoogleReCaptcha);
		
		parametrosEnvio.append(
				MessageFormat.format(
						"secret={0}&remoteip={1}&response={2}"
						,keySecret
						,remoteip
						,llaveDinamica
						)
				);
		
		url.append(parametrosEnvio.toString());
		
		ResponseEntity<ResultCaptcha> responseEntity = null;
		try {
			responseEntity = restTemplate.exchange(url.toString(), HttpMethod.GET, new HttpEntity<String>(headers), ResultCaptcha.class);
			resultService.setEntidad(responseEntity.getBody());
		} catch (Exception e) { resultService.calcularError(e); } 
		
		return resultService;
	} 
	
}
