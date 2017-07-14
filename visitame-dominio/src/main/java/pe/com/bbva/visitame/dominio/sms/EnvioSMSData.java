package pe.com.bbva.visitame.dominio.sms;

import com.fasterxml.jackson.annotation.JsonInclude;

public class EnvioSMSData {
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private PersonSender personSender;
	public PersonSender getPersonSender() {return personSender;}
	public void setPersonSender(PersonSender personSender) {this.personSender = personSender;}

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String title;
	public String getTitle() {return title;}
	public void setTitle(String title) {this.title = title;}

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String body;
	public String getBody() {return body;}
	public void setBody(String body) {this.body = body;}

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private DistributionChannel distributionChannel;
	public DistributionChannel getDistributionChannel() {return distributionChannel;}
	public void setDistributionChannel(DistributionChannel distributionChannel) {this.distributionChannel = distributionChannel;}
	

}