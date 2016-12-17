package id.salesTaxes.manager;

import id.salesTaxes.bean.interfaces.IItem;
import id.salesTaxes.manager.interfaces.ITaxesCalculator;

public class ImportedItemTaxesCalculator implements ITaxesCalculator {

	private static ImportedItemTaxesCalculator instance;

	private ImportedItemTaxesCalculator() {

	}

	/**
	 * 
	 * @return the instance of ImportedItemTaxesCalculator
	 */
	public static ImportedItemTaxesCalculator getInstance() {
		if (instance == null) {
			instance = new ImportedItemTaxesCalculator();
		}
		return instance;
	}
	/**
	 * @return the taxes amount of the 
	 */
	public double getSalesTaxes(IItem item) {
		return 0;
	}

}
