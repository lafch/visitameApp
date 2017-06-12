package pe.com.bbva.visitame.dominio.dto.cuenta;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
@JsonIgnoreProperties(ignoreUnknown=true)
public class Residence {
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	protected OptionsList country;
	public OptionsList getCountry() { return country; }
	public void setCountry(OptionsList country) { this.country = country; }
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	protected Date startDate;
	public Date getStartDate() { return startDate; }
	public void setStartDate(Date startDate) { this.startDate = startDate; }
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	protected OptionsList residenceType;
	public OptionsList getResidenceType() { return residenceType; }
	public void setResidenceType(OptionsList residenceType) { this.residenceType = residenceType; }	
}
