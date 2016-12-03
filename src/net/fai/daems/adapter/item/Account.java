package net.fai.daems.adapter.item;

public class Account {
	private String key;
	private String date;
	private String abbr;

	public Account(String key, String date) {
		this.key = key;
		this.date = date;
		this.abbr = key.length() > 5 ? key.substring(0, 5) : key;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAbbr() {
		return abbr;
	}

	public void setAbbr(String abbr) {
		this.abbr = abbr;
	}

}
