package pe.com.bbva.visitame.dominio.dto.geolocalizacion;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown=true)
public class PoiDetail implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String value;
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Boolean hasMoreData;  
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private List<Poi> pois;
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String type;
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Boolean getHasMoreData() {
		return hasMoreData;
	}

	public void setHasMoreData(Boolean hasMoreData) {
		this.hasMoreData = hasMoreData;
	}

	public List<Poi> getPois() {
		return pois;
	}

	public void setPois(List<Poi> pois) {
		this.pois = pois;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
