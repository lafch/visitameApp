package pe.com.bbva.visitame.dominio.sms;



import com.fasterxml.jackson.annotation.JsonInclude;

public class CelularSMS {
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Type type;
	public Type getType() {return type;}
	public void setType(Type type) {this.type = type;}

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String name;
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}


}