package pe.com.bbva.visitame.helper.cuenta;


import java.net.ConnectException;

import java.text.MessageFormat;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pe.com.bbva.visitame.dominio.dto.cuenta.CustomerDetail;
import pe.com.bbva.visitame.dominio.dto.zic.ZicResult;
import pe.com.bbva.visitame.exception.NegocioException;
import pe.com.bbva.visitame.helper.zic.ZICServiceHelper;


@Component
public class ZICServiceAccountHelper {
	
	private static final Logger logger = LogManager.getLogger(ZICServiceAccountHelper.class);
	private static final String LOG_PROMPT = "ZICServiceAccountHelper > ";
	
	private static final String HEADER_TSEC = "tsec";
	private static final String INICIO_PARM = "?";
	
	@Value("${visitame.servicio.rest.cuenta.customers.url}")
	private String urlCustomers;
	
	@Value("${visitame.servicio.rest.test}")
	private String urltest;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ZICServiceHelper zicServiceHelper;
	
	public ZicResult getListCustomers(String documentNumber, String documentTypeId) throws NegocioException, ConnectException {
		ZicResult resultService = null;
		String tSec = this.zicServiceHelper.generarTSec();
			resultService = new ZicResult();
			HttpHeaders headers = new HttpHeaders();
			headers.add(HEADER_TSEC, tSec);
			StringBuilder url = new StringBuilder(urlCustomers);
			url.append(INICIO_PARM);
			StringBuilder parametroenvio = new StringBuilder();
				if(StringUtils.isNotBlank(documentNumber) && StringUtils.isNotBlank(documentTypeId)) {
					parametroenvio.append(MessageFormat.format("identityDocument.documentNumber={0}&identityDocument.documentType.id={1}&expands=contact-details", documentNumber, documentTypeId));
				} 
			url.append(parametroenvio.toString());
			ResponseEntity<CustomerDetail> responseEntity = null;
			try {
				logger.info(LOG_PROMPT + "Parametro de envio: " + parametroenvio.toString());
				logger.info(LOG_PROMPT + "Consulta lista clientes - getListCustomers(): " + url.toString());
				responseEntity = restTemplate.exchange(url.toString(), HttpMethod.GET, new HttpEntity<String>(headers), CustomerDetail.class);
				resultService.setEntidad(responseEntity.getBody());
			} catch (Exception e) { resultService.calcularError(e); }
			
		return resultService;
	}
	
	public ZicResult getListCustomers(String tipoJson) throws NegocioException, ConnectException {
		ZicResult resultService = null;
			resultService = new ZicResult();
			HttpHeaders headers = new HttpHeaders();
			StringBuilder url = new StringBuilder(urltest+tipoJson);
			ResponseEntity<CustomerDetail> responseEntity = null;
			System.out.println(url);
			try {
				responseEntity = restTemplate.exchange(url.toString(), HttpMethod.GET, new HttpEntity<String>(headers), CustomerDetail.class);
				resultService.setEntidad(responseEntity.getBody());
			} catch (Exception e) { resultService.calcularError(e); }
			
		return resultService;
	}
		
}