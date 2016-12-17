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
		// TODO Auto-generated method stub
		return 0;
	}

	public Categories getCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isImported() {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
