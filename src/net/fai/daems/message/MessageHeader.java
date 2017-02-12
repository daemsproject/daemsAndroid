package net.fai.daems.message;



public class MessageHeader {
	
	private long SendingTime;
	private int CommandId;
	private int AppId;
	private int MessageId;
	private int version;
	
	public MessageHeader() {
		
	}
	
	protected MessageHeader(int CommandId, int AppId, int MessageId) {
		this.CommandId = CommandId;
		this.AppId = AppId;
		this.MessageId = MessageId;
		SendingTime = System.currentTimeMillis() / 1000;
	}

	public long getSendingTime() {
		return SendingTime;
	}

	public int getCommandId() {
		return CommandId;
	}

	public void setCommandId(int commandId) {
		CommandId = commandId;
	}

	public int getAppId() {
		return AppId;
	}

	public void setAppId(int appId) {
		AppId = appId;
	}

	public int getMessageId() {
		return MessageId;
	}

	public void setMessageId(int messageId) {
		MessageId = messageId;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public void setSendingTime(long sendingTime) {
		SendingTime = sendingTime;
	}
}
