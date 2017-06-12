package pe.com.bbva.visitame.dominio.dto.cuenta;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class CustomerDetail {
	
	protected List<Customer> data;
	public List<Customer> getData() { return data; }
	public void setData(List<Customer> data) { this.data = data; }

}
