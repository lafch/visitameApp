package pe.com.bbva.visitame.dominio.gt;

import java.util.List;

public class AuthenticationRequest {
	
	private String userID;
	public String getUserID() { return userID; }
	public void setUserID(String userID) { this.userID = userID; }
	
	private String consumerID;
	public String getConsumerID() { return consumerID; }
	public void setConsumerID(String consumerID) { this.consumerID = consumerID; }
	
	private String authenticationType;
	public String getAuthenticationType() { return authenticationType; }
	public void setAuthenticationType(String authenticationType) { this.authenticationType = authenticationType; }
	
	private List<AuthenticationDatum> authenticationData;
	public List<AuthenticationDatum> getAuthenticationData() { return authenticationData; }
	public void setAuthenticationData(List<AuthenticationDatum> authenticationData) { this.authenticationData = authenticationData; }

}
