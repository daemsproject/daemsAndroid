package net.fai.daems.message;


public class DaemsMessage {
	
	private MessageHeader header;
	
	private MessagePayload payload;

	public MessageHeader getHeader() {
		return header;
	}

	public void setHeader(MessageHeader header) {
		this.header = header;
	}

	public MessagePayload getPayload() {
		return payload;
	}

	public void setPayload(MessagePayload payload) {
		this.payload = payload;
	}
}
