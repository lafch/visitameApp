package pe.com.bbva.visitame.dominio.sms;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

public class PersonSender {
	

	protected String name;
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	protected String lastName;
	public String getLastName() {		return lastName;	}
	public void setLastName(String lastName) {		this.lastName = lastName;	}
	
	protected String mothersLastName;
	public String getMothersLastName() {return mothersLastName;}
	public void setMothersLastName(String mothersLastName) {this.mothersLastName = mothersLastName;}

}