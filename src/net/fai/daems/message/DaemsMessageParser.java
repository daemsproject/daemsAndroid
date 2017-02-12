package net.fai.daems.message;


import com.alibaba.fastjson.JSONObject;

public class DaemsMessageParser {
	
	public static DaemsMessage parse(String json) {
		JSONObject obj = JSONObject.parseObject(json);
		MessageHeader header = obj.getObject("header", MessageHeader.class);
		int cid = header.getCommandId();
		int aid = header.getAppId();
		int mid = header.getMessageId();
		DaemsMessage message = JSONObject.parseObject(json, MessageMatcher.findMessageClass(cid, aid, mid));
		message.setHeader(header);
		return message;
	}
}
