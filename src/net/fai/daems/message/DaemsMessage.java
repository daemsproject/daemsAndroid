package net.fai.daems.message;



public class DaemsMessage {
	
	private MessageHeader header;
	
	protected DaemsMessage() {
		
	}

	public MessageHeader getHeader() {
		return header;
	}

	protected void setHeader(MessageHeader header) {
		this.header = header;
	}
}
