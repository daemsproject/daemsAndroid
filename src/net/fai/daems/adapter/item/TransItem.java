package net.fai.daems.adapter.item;

/**
 * 交易记录Item
 * @author Administrator
 *
 */
public class TransItem extends DaemsItem  {
	
	public int imageId;
	public String name;
	public String date;
	public boolean income = false;
	public String amount;
	
	public TransItem(int imageId, String name, String date, boolean income, String amount) {
		this.imageId = imageId;
		this.name = name;
		this.date = date;
		this.income = income;
		this.amount = amount;
	}
	
}
