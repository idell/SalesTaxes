package id.salesTaxes.bean;

import id.salesTaxes.bean.interfaces.IItem;

public class Item implements IItem {
	
	private double netPrice;
	private Categories category;
	private boolean imported;
	
	
	public Item(double netPrice, Categories category, boolean imported) {
		this.netPrice = netPrice;
		this.category = category;
		this.imported = imported;
	}

	public double getNetPrice() {
		return netPrice;
	}

	public Categories getCategory() {
		return category;
	}

	public boolean isImported() {
		return imported;
	}
	
	

}
