package pe.com.bbva.visitame.dominio.gt;

import java.util.List;

public class AuthenticationResponse {
	
	private String authenticationState;
	public String getAuthenticationState() { return authenticationState; }
	public void setAuthenticationState(String authenticationState) { this.authenticationState = authenticationState; }
	
	private List<Object> authenticationData;
	public List<Object> getAuthenticationData() { return authenticationData; }
	public void setAuthenticationData(List<Object> authenticationData) { this.authenticationData = authenticationData; }
	
}
