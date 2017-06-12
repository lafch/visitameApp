package pe.com.bbva.visitame.dominio.dto.cuenta;

import java.util.Date;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Customer {
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	protected String customerId;
	public String getCustomerId() { return customerId;	}
	public void setCustomerId(String customerId) { this.customerId = customerId; }
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	protected Date   membershipDate;
	public    Date getMembershipDate() { return membershipDate; }
	public void setMembershipDate(Date membershipDate) { this.membershipDate = membershipDate; }
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	protected Residence residence;
	public Residence getResidence() { return residence; }
	public void setResidence(Residence residence) { this.residence = residence;	}
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	protected String lastName;
	public String getLastName() { return lastName; }
	public void setLastName(String lastName) { this.lastName = lastName; }
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	protected String surnames;
	public String getSurnames() { return surnames; }
	public void setSurnames(String surnames) { this.surnames = surnames; }
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	protected String firstName;
	public String getFirstName() { return firstName; }
	public void setFirstName(String firstName) { this.firstName = firstName; }
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	protected OptionsList personalTitle;
	public OptionsList getPersonalTitle() { return personalTitle; }
	public void setPersonalTitle(OptionsList personalTitle) { this.personalTitle = personalTitle; }
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	protected OptionsList maritalStatus;
	public OptionsList getMaritalStatus() { return maritalStatus; }
	public void setMaritalStatus(OptionsList maritalStatus) { this.maritalStatus = maritalStatus; }
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	protected OptionsList gender;
	public OptionsList getGender() { return gender; }
	public void setGender(OptionsList gender) { this.gender = gender; }
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	protected BirthData birthData;
	public BirthData getBirthData() { return birthData; }
	public void setBirthData(BirthData birthData) { this.birthData = birthData; }
	
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	protected List<ContactDetail> contactDetails;
	public List<ContactDetail> getContactDetails() { return contactDetails; }
	public void setContactDetails(List<ContactDetail> contactDetails) { this.contactDetails = contactDetails; }

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	protected List<IdentityDocument>  identityDocuments;
	public List<IdentityDocument> getIdentityDocuments() { return identityDocuments; }
	public void setIdentityDocuments(List<IdentityDocument> identityDocuments) { this.identityDocuments = identityDocuments; }

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	protected List<OptionsList> nationalities;
	public List<OptionsList> getNationalities() { return nationalities; }
	public void setNationalities(List<OptionsList> nationalities) { this.nationalities = nationalities; }
	
	
}
