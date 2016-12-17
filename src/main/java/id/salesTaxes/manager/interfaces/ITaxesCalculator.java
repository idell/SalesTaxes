package id.salesTaxes.manager.interfaces;

import java.util.List;

import id.salesTaxes.bean.interfaces.IItem;
import id.salesTaxes.exception.UnableToCalculateTaxesException;

public interface ITaxesCalculator {

	public double getSalesTaxes(IItem items) throws UnableToCalculateTaxesException;
}
