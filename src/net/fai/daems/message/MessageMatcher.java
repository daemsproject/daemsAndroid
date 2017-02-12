package net.fai.daems.message;


public enum MessageMatcher {
	
	CHAT_MESSAGE(1, 1, 1, ChatMessage.class);
	
	private int cid;
	private int aid;
	private int mid;
	private Class<? extends DaemsMessage> clazz;
	
	private MessageMatcher(int cid, int aid, int mid, Class<? extends DaemsMessage> clazz) {
		this.cid = cid;
		this.aid = aid;
		this.mid = mid;
		this.clazz = clazz;
	}
	
	public static Class<? extends DaemsMessage> findMessageClass(int cid, int aid, int mid) {
		for (MessageMatcher matcher : MessageMatcher.values()) {
			if (cid == matcher.cid && aid == matcher.aid && mid == matcher.mid) {
				return matcher.clazz;
			}
		}
		throw new RuntimeException("");
	}

}
