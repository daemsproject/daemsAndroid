package net.fai.daems.adapter.item;

public class AccountItem extends DaemsItem {
	
	public int imageId;
	public String name;
	public String info;
	public String date;
	public String abbr;
	
	public AccountItem(int imageId, String name, String info, String date) {
		this.imageId = imageId;
		this.name = name;
		this.info = info;
		this.date = date;
		this.abbr = name.length() > 5 ? name.substring(0, 5) : name;
	}

}
