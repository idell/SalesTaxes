package id.salesTaxes.manager.interfaces;

import java.util.List;

import id.salesTaxes.bean.interfaces.IItem;

public interface ITaxesCalculator {

	public double getSalesTaxes(IItem items);
}
