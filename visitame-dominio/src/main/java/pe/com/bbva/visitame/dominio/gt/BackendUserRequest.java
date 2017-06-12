package pe.com.bbva.visitame.dominio.gt;

public class BackendUserRequest {

	private String userId;
	public String getUserId() { return userId; }
	public void setUserId(String userId) { this.userId = userId; }
	
	private String accessCode;
	public String getAccessCode() { return accessCode; }
	public void setAccessCode(String accessCode) { this.accessCode = accessCode; }
	
	private String dialogId;
	public String getDialogId() { return dialogId; }
	public void setDialogId(String dialogId) { this.dialogId = dialogId; }
	
}
