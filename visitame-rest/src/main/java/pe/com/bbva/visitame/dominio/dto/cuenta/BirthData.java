package pe.com.bbva.visitame.dominio.dto.cuenta;


import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown=true)
public class BirthData {
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	protected Date birthDate;
	public Date getBirthDate() { return birthDate; }
	public void setBirthDate(Date birthDate) { this.birthDate = birthDate; }
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	protected OptionsList country;
	public OptionsList getCountry() { return country; }
	public void setCountry(OptionsList country) { this.country = country; }
	
}
