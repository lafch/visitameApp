package pe.com.bbva.visitame.helper;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import pe.com.bbva.visitame.dominio.gt.AuthenticationDatum;
import pe.com.bbva.visitame.dominio.gt.AuthenticationRequest;
import pe.com.bbva.visitame.dominio.gt.BackendUserRequest;
import pe.com.bbva.visitame.dominio.gt.GrantingTicketRequest;
import pe.com.bbva.visitame.dominio.gt.GrantingTicketResponse;
import pe.com.bbva.visitame.exception.NegocioException;

@Component
@EnableAsync
public class ZICServiceHelper {
	
	private static final String IVTICKET_AUTHENTICATION_TYPE = "00";
	private static final String IVTICKET_KEY = "iv_ticketService";
	private static final String DEFAULT_PIC_USER = "13000004";
	private static final String HEADER_KEY_TSEC = "tsec";


	@Value("${visitame.servicio.rest.grantingTicket.url}")
	private String urlGrantingTicket;	

	@Autowired(required=true)
	private RestTemplate restTemplate;
	
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	
    public String generarTSec(String ivUser, String ivTicket) throws NegocioException {
		
    	String picUser = DEFAULT_PIC_USER;		
		
    	AuthenticationRequest aReq = new AuthenticationRequest();
		aReq.setUserID(ivUser); 
		aReq.setConsumerID(picUser);
		aReq.setAuthenticationType(IVTICKET_AUTHENTICATION_TYPE);
		aReq.setAuthenticationData(new ArrayList<AuthenticationDatum>());
		
		AuthenticationDatum aDat = new AuthenticationDatum();
		aDat.setIdAuthenticationData(IVTICKET_KEY);
		aDat.setAuthenticationData(new ArrayList<String>());
		aDat.getAuthenticationData().add(ivTicket);
		
		aReq.getAuthenticationData().add(aDat);
		
		GrantingTicketRequest request = new GrantingTicketRequest();
		request.setAuthentication(aReq);
		request.setBackendUserRequest(new BackendUserRequest());
		request.getBackendUserRequest().setAccessCode(StringUtils.EMPTY);
		request.getBackendUserRequest().setDialogId(StringUtils.EMPTY);
		request.getBackendUserRequest().setUserId(StringUtils.EMPTY);
		
		ResponseEntity<GrantingTicketResponse> responseEntity = restTemplate.postForEntity(urlGrantingTicket, request, GrantingTicketResponse.class);		
		List<String> respuestas = responseEntity.getHeaders().get(HEADER_KEY_TSEC);
		if(respuestas != null && !respuestas.isEmpty()){
			return respuestas.get(0);
		}		
		return null;
	}
	
}
