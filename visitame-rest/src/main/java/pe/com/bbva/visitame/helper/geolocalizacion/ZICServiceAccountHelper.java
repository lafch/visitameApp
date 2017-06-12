package pe.com.bbva.visitame.helper.geolocalizacion;


import java.io.IOException;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.text.MessageFormat;
import java.util.List;
import java.util.concurrent.Future;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pe.com.bbva.visitame.dominio.dto.cuenta.CustomerDetail;
import pe.com.bbva.visitame.dominio.zic.ZicResult;
import pe.com.bbva.visitame.exception.NegocioException;


@Component
public class ZICServiceAccountHelper {
	
	private static final Logger logger = LogManager.getLogger(ZICServiceAccountHelper.class);
	private static final String LOG_PROMPT = "ZICServiceAccountHelper > ";
	
	private static final String HEADER_TSEC = "tsec";
	private static final String INICIO_PARM = "?";
	
	@Value("${pic.servicio.rest.cuenta.customers.url}")
	private String urlCustomers;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public ZicResult getListCustomers(String documentNumber, String documentTypeId) throws NegocioException, ConnectException {
		ZicResult resultService = null;
		String tSec = null;
//			String tSec = zicServiceHelper.generarTSec("pe.p014654", "Gp1R425O9nty8wnI5uO1I4kL23mPIPJ8yLH1sRGZlrasiV1v17sbrA==");
		for(int numeroIntento = 1; numeroIntento <= 2; numeroIntento++) {
//			if(numeroIntento == 1) { tSec = this.zicServiceHelper.generarTSec(false); }
//			else { tSec = this.zicServiceHelper.generarTSec(true); }			
			resultService = new ZicResult();
			HttpHeaders headers = new HttpHeaders();
			headers.add(HEADER_TSEC, tSec);
			StringBuilder url = new StringBuilder(urlCustomers);
			url.append(INICIO_PARM);
			StringBuilder parametroenvio = new StringBuilder();
				if(StringUtils.isNotBlank(documentNumber) && StringUtils.isNotBlank(documentTypeId)) {
					parametroenvio.append(MessageFormat.format("identityDocument.documentNumber={0}&identityDocument.documentType.id={1}&", documentNumber, documentTypeId));
				} 
			url.append(parametroenvio.toString());
			ResponseEntity<CustomerDetail> responseEntity = null;
			try {
				logger.info(LOG_PROMPT + "Parametro de envio: " + parametroenvio.toString());
				logger.info(LOG_PROMPT + "Consulta lista clientes - getListCustomers(): " + url.toString());
				responseEntity = restTemplate.exchange(url.toString(), HttpMethod.GET, new HttpEntity<String>(headers), CustomerDetail.class);
				resultService.setEntidad(responseEntity.getBody());
			} catch (Exception e) { resultService.calcularError(e); }
		}
		return resultService;
	}
		
}