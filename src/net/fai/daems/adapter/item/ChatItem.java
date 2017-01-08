package net.fai.daems.adapter.item;

public class ChatItem extends DaemsItem  {
	
	public int imageId;
	public String name;
	public String info;
	public String date;
	
	public ChatItem(int imageId, String name, String info, String date) {
		this.imageId = imageId;
		this.name = name;
		this.info = info;
		this.date = date;
	}
	
}
