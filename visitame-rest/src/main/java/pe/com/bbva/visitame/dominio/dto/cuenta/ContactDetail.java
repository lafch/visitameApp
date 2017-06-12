package pe.com.bbva.visitame.dominio.dto.cuenta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown=true)
public class ContactDetail {
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	protected String contactDetailId;
	public String getContactDetailId() { return contactDetailId; }
	public void setContactDetailId(String contactDetailId) { this.contactDetailId = contactDetailId; }
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	protected OptionsList contactType;
	public OptionsList getContactType() { return contactType; }
	public void setContactType(OptionsList contactType) { this.contactType = contactType; }
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	protected String contact;
	public String getContact() { return contact; }
	public void setContact(String contact) { this.contact = contact; }
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	protected OptionsList country;
	public OptionsList getCountry() { return country; }
	public void setCountry(OptionsList country) { this.country = country; }
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	protected String regionalCode;
	public String getRegionalCode() { return regionalCode; }
	public void setRegionalCode(String regionalCode) { this.regionalCode = regionalCode; }
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	protected String phoneCompany;
	public String getPhoneCompany() { return phoneCompany; }
	public void setPhoneCompany(String phoneCompany) { this.phoneCompany = phoneCompany; }

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	protected String extension;
	public String getExtension() { return extension; }
	public void setExtension(String extension) { this.extension = extension; }
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	protected Boolean isPreferential;
	public Boolean getIsPreferential() { return isPreferential; }
	public void setIsPreferential(Boolean isPreferential) { this.isPreferential = isPreferential; }
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	protected Boolean isChecked;
	public Boolean getIsChecked() { return isChecked; }
	public void setIsChecked(Boolean isChecked) { this.isChecked = isChecked; }
	
	
	
}
