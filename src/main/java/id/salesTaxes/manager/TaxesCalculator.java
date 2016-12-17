package id.salesTaxes.manager;

import id.salesTaxes.bean.interfaces.IItem;
import id.salesTaxes.manager.interfaces.ITaxesCalculator;

/**
 * Taxes Calculator Manger for items not imported
 */
public class TaxesCalculator implements ITaxesCalculator{

	private static TaxesCalculator instance;

	private TaxesCalculator() {

	}

	/**
	 * 
	 * @return the instance of TaxesCalculator
	 */
	public static TaxesCalculator getInstance() {
		if (instance == null) {
			instance = new TaxesCalculator();
		}
		return instance;
	}

	/**
	 * @return the amount of taxes for items
	 */
	public double getSalesTaxes(IItem items) {
		return 0;
	}

}
