package id.salesTaxes.bean;

import id.salesTaxes.bean.interfaces.ICalculatedItem;

public class CalculatedItem extends Item implements ICalculatedItem {

	public CalculatedItem(double netPrice, Categories category, boolean imported) {
		super(netPrice, category, imported);
	}

	public double getTaxes() {
		return 0;
	}

}
