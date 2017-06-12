package pe.com.bbva.visitame.dominio.gt;

import java.util.List;

public class AuthenticationDatum {
	private String idAuthenticationData;
	public String getIdAuthenticationData() { return idAuthenticationData; }
	public void setIdAuthenticationData(String idAuthenticationData) { this.idAuthenticationData = idAuthenticationData; }
	
	private List<String> authenticationData;
	public List<String> getAuthenticationData() { return authenticationData; }
	public void setAuthenticationData(List<String> authenticationData) { this.authenticationData = authenticationData; }

}
