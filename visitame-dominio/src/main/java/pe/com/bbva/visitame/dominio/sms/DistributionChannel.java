package pe.com.bbva.visitame.dominio.sms;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

public class DistributionChannel {
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	protected Type type;
	public Type getType() {return type;}
	public void setType(Type type) {this.type = type;}

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	protected String channelSender;
	public String getChannelSender() {return channelSender;}
	public void setChannelSender(String channelSender) {this.channelSender = channelSender;}

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	protected Type sendingType;
	public Type getSendingType() {return sendingType;}
	public void setSendingType(Type sendingType) {this.sendingType = sendingType;}
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	protected List<CelularSMS> recipients;
	public List<CelularSMS> getRecipients() {return recipients;	}
	public void setRecipients(List<CelularSMS> recipients) {this.recipients = recipients;}

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	protected Type template;
	public Type getTemplate() {return template;}
	public void setTemplate(Type template) {this.template = template;}
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	protected Type inboxDestination;
	public Type getInboxDestination() {return inboxDestination;}
	public void setInboxDestination(Type inboxDestination) {this.inboxDestination = inboxDestination;}
	
	
}