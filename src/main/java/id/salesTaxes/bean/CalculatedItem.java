package id.salesTaxes.bean;

import id.salesTaxes.bean.interfaces.ICalculatedItem;
import id.salesTaxes.bean.interfaces.IItem;

public class CalculatedItem extends Item implements ICalculatedItem {

	private double taxes = 0.0;
	private int quantity = 0;

	public CalculatedItem(IItem item, double taxesAmount) {
		super(item.getNetPrice(), item.getCategory(), item.isImported());
		this.taxes = taxesAmount;
		this.quantity = 1;
	}

	public CalculatedItem(IItem item, double taxes, int quantity) {
		super(item.getNetPrice(), item.getCategory(), item.isImported());
		this.taxes = taxes;
		this.quantity = quantity;
	}

	public double getTaxes() {
		return taxes;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setTaxes(double taxes) {
		this.taxes = taxes;
	}

}
