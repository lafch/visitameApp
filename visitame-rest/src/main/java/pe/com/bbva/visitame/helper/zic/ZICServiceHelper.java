package pe.com.bbva.visitame.helper.zic;

import java.util.ArrayList;


import java.util.List;

import org.apache.commons.lang3.StringUtils;
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
public class ZICServiceHelper {
	
	private static final String IVTICKET_AUTHENTICATION_TYPE = "04";
	private static final String IVTICKET_KEY = "password";
	private static final String DEFAULT_VISITAME_USER = "13000006";
	private static final String HEADER_KEY_TSEC = "tsec";
	private static final String DEFAULT_USER_ID = "ZM13006";
	private static final String DEFAULT_AUTHENTICATION_DATA = "ZM13006";

	@Value("${visitame.servicio.rest.grantingTicket.url}")
	private String urlGrantingTicket;	

	@Autowired
	private RestTemplate restTemplate;
	
    public String generarTSec() throws NegocioException {
		
    	
//    	{
//    		"authentication": {
//    		  "userID": "ZM13006",
//    		  "consumerID": "13000006",
//    		  "authenticationType": "04",
//    		  "authenticationData": [
//    		    {
//    		               "idAuthenticationData": "password",
//    		       "authenticationData": [
//    		             "147258"
//    		       ]
//    		    }
//    		   ]
//    		},
//    		"backendUserRequest": {
//    		   "userId": "",
//    		   "accessCode": "",
//    		   "dialogId": ""
//    		}
//    		}
    	String picUser = DEFAULT_VISITAME_USER;		
		
    	AuthenticationRequest aReq = new AuthenticationRequest();
		aReq.setUserID(DEFAULT_USER_ID); 
		aReq.setConsumerID(picUser);
		aReq.setAuthenticationType(IVTICKET_AUTHENTICATION_TYPE);
		
		AuthenticationDatum aDat = new AuthenticationDatum();
		aDat.setIdAuthenticationData(IVTICKET_KEY);
		aDat.setAuthenticationData(new ArrayList<String>());
		aDat.getAuthenticationData().add(DEFAULT_AUTHENTICATION_DATA);
		
		List<AuthenticationDatum> listAuthenticationDatum = new ArrayList<AuthenticationDatum>();
		listAuthenticationDatum.add(aDat);
		aReq.setAuthenticationData(listAuthenticationDatum);
		
			
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
