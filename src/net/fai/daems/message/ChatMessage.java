package net.fai.daems.message;

/**
 * 聊天消息
 * @author Administrator
 *
 */
public class ChatMessage extends MessagePayload {
	
	private int EventId;
	private String Sender;
	private String Recipient;
	private int ContentType;
	private int PackageSeq;
	private int TotalPackage;
	private String data;
	
	public int getEventId() {
		return EventId;
	}
	public void setEventId(int eventId) {
		EventId = eventId;
	}
	public String getSender() {
		return Sender;
	}
	public void setSender(String sender) {
		Sender = sender;
	}
	public String getRecipient() {
		return Recipient;
	}
	public void setRecipient(String recipient) {
		Recipient = recipient;
	}
	public int getContentType() {
		return ContentType;
	}
	public void setContentType(int contentType) {
		ContentType = contentType;
	}
	public int getPackageSeq() {
		return PackageSeq;
	}
	public void setPackageSeq(int packageSeq) {
		PackageSeq = packageSeq;
	}
	public int getTotalPackage() {
		return TotalPackage;
	}
	public void setTotalPackage(int totalPackage) {
		TotalPackage = totalPackage;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
}
