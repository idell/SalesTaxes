package id.salesTaxes.bean;

import id.salesTaxes.bean.interfaces.ICalculatedItem;

public class CalculatedItem extends Item implements ICalculatedItem {

	private double taxes = 0.0;
	
	public CalculatedItem(double netPrice, Categories category, boolean imported, double taxesAmount) {
		super(netPrice, category, imported);
		this.taxes = taxesAmount;
	}

	public double getTaxes() {
		return taxes;
	}

}
