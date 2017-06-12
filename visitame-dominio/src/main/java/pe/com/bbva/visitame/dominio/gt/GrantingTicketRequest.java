package pe.com.bbva.visitame.dominio.gt;

public class GrantingTicketRequest {
	
	private AuthenticationRequest authentication;
	public AuthenticationRequest getAuthentication() { return authentication; }
	public void setAuthentication(AuthenticationRequest authentication) { this.authentication = authentication; }
	
	private BackendUserRequest backendUserRequest;
	public BackendUserRequest getBackendUserRequest() { return backendUserRequest; }
	public void setBackendUserRequest(BackendUserRequest backendUserRequest) { this.backendUserRequest = backendUserRequest; }
	
}
