package id.salesTaxes.bean;

import id.salesTaxes.bean.interfaces.IItem;
import id.salesTaxes.consts.Consts;

public class Item implements IItem {

	private double netPrice;
	private Categories category;
	private boolean imported;
	private String description = Consts.EMPTY;

	public Item(double netPrice, Categories category, boolean imported, String description) {
		this.netPrice = netPrice;
		this.category = category;
		this.imported = imported;
		this.description = description;
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

	public String getDescription() {
		return description;
	}

}
