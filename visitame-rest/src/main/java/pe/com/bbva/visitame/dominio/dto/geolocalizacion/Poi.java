package pe.com.bbva.visitame.dominio.dto.geolocalizacion;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Poi implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String idPoi;
	public String getIdPoi() { return idPoi; }
	public void setIdPoi(String idPoi) { this.idPoi = idPoi; }
	
	private String id;
	public String getId() { return id; }
	public void setId(String id) { this.id = id; }
	
	private String category;
	public String getCategory() { return category; }
	public void setCategory(String category) { this.category = category; }
	
	private String latitude;
	public String getLatitude() { return latitude; }
	public void setLatitude(String latitude) { this.latitude = latitude; }
	
	private String longitude;
	public String getLongitude() { return longitude; }
	public void setLongitude(String longitude) { this.longitude = longitude; }
	
	private String country;
	public String getCountry() { return country; }
	public void setCountry(String country) { this.country = country; }
	
	private String address1;
	public String getAddress1() { return address1; }

	public void setAddress1(String address1) { this.address1 = address1; }
	
	private String description;
	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; }
	
	private String telephone;
	public String getTelephone() { return telephone; }

	public void setTelephone(String telephone) { this.telephone = telephone; }
	
	private String city;
	public String getCity() { return city; }
	public void setCity(String city) { this.city = city; }
	
	private String accesibility;
	public String getAccesibility() { return accesibility; }
	public void setAccesibility(String accesibility) { this.accesibility = accesibility; }
	
	private String zip;
	public String getZip() { return zip; }
	public void setZip(String zip) { this.zip = zip; }
	
	private String address2;
	public String getAddress2() { return address2; }
	public void setAddress2(String address2) { this.address2 = address2; }
	
	private String bank;
	public String getBank() { return bank; }
	public void setBank(String bank) {	this.bank = bank; }
	
	private String province;
	public String getProvince() { return province; }
	public void setProvince(String province) {	this.province = province; }
	
	private String address;
	public String getAddress() { return address; }
	public void setAddress(String address) { this.address = address; }
	
	private String accesibility_action;
	public String getAccesibility_action() { return accesibility_action; }
	public void setAccesibility_action(String accesibility_action) { this.accesibility_action = accesibility_action; }
	
	private String distance;
	public String getDistance() { return distance; }
	public void setDistance(String distance) { this.distance = distance; }
	
	//Cajero
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String status;
	public String getStatus() { return status; }
	public void setStatus(String status) { this.status = status; }

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String branch_code;
	public String getBranch_code() { return branch_code; }
	public void setBranch_code(String branch_code) { this.branch_code = branch_code; }
	
	//Oficina
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String hours_sat;
	public String getHours_sat() { return hours_sat; }
	public void setHours_sat(String hours_sat) { this.hours_sat = hours_sat; }
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String hours_mf;
	public String getHours_mf() { return hours_mf; }
	public void setHours_mf(String hours_mf) { this.hours_mf = hours_mf; }
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String codoficina;
	public String getCodoficina() { return codoficina; }
	public void setCodoficina(String codoficina) { this.codoficina = codoficina; }
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String hours_sun;
	public String getHours_sun() { return hours_sun; }
	public void setHours_sun(String hours_sun) { this.hours_sun = hours_sun; }
	
	//Saturacion
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String saturacion;
	public String getSaturacion() { return saturacion; }
	public void setSaturacion(String saturacion) { this.saturacion = saturacion; }

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String iconoSaturacion;
	public String getIconoSaturacion() { return iconoSaturacion; }
	public void setIconoSaturacion(String iconoSaturacion) { this.iconoSaturacion = iconoSaturacion; }
	

}
