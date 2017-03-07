package net.fai.daems.adapter.item;

/**
 * 流量币即将过期Item
 * @author Administrator
 *
 */
public class ExpirationItem extends DaemsItem  {
	
	public String description;
	public String amount;
	
	public ExpirationItem(String description, String amount) {
		this.description = description;
		this.amount = amount;
	}
	
}
