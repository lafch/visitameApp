package pe.com.bbva.visitame.dominio.sms;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Type {
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	protected String id;
	public String getId() { return id; }
	public void setId(String id) { this.id = id; }
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	protected String name;
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
}
