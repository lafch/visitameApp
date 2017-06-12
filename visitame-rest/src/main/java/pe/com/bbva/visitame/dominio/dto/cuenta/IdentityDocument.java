package pe.com.bbva.visitame.dominio.dto.cuenta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown=true)
public class IdentityDocument {

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	protected OptionsList documentType;
	public OptionsList getDocumentType() { return documentType; }
	public void setDocumentType(OptionsList documentType) { this.documentType = documentType; }
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	protected String documentNumber;
	public String getDocumentNumber() { return documentNumber; }
	public void setDocumentNumber(String documentNumber) { this.documentNumber = documentNumber; }
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	protected String expirationDate;
	public String getExpirationDate() { return expirationDate; }
	public void setExpirationDate(String expirationDate) { this.expirationDate = expirationDate; }
	
}
