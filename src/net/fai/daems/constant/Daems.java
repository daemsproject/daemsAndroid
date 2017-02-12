package net.fai.daems.constant;

public class Daems {
	
	public static class Action {
		public final static String BOOT_COMPLETED = "android.intent.action.BOOT_COMPLETED";
		public final static String MESSAGE_IN = "net.fai.daems.message.in";
		public final static String SERVICE_DESTROY = "net.fai.daems.service.destroy";
	}
	
	public static class View {
		public final static int NONE_VIEW = -1;
	}
	
	/**
	 * Command ID
	 * @author Administrator
	 *
	 */
	public static class CID {
		/**
		 * 广播
		 */
		public final static int BROADCAST = 1;
		/**
		 * 订阅
		 */
		public final static int SUBSCRIBE = 2;
		/**
		 * 查询
		 */
		public final static int QUERY = 3;
		/**
		 * 秘钥
		 */
		public final static int KEY = 4;
		/**
		 * 节点
		 */
		public final static int NODE = 5;
		/**
		 * 通知
		 */
		public final static int NOTIFICATION = 6;
	}
	
	/**
	 * Application ID
	 * @author Administrator
	 *
	 */
	public static class AID {
		/**
		 * 聊天消息
		 */
		public final static int SendChatContent = 1;
		
	}
	
	/**
	 * Message ID
	 * @author Administrator
	 *
	 */
	public static class MID {
		public final static int SendChatContent_Req = 1;
		public final static int SendChatContent_Resp = 2;
	}

}
