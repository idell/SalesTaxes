package id.salesTaxes.manager;

import id.salesTaxes.bean.Categories;
import id.salesTaxes.bean.interfaces.IItem;
import id.salesTaxes.consts.Consts;
import id.salesTaxes.exception.UnableToCalculateTaxesException;
import id.salesTaxes.manager.interfaces.ITaxesCalculator;
import id.salesTaxes.util.TaxesUtility;

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
	 * @throws UnableToCalculateTaxesException
	 */
	public double getSalesTaxes(IItem item) throws UnableToCalculateTaxesException {
		if (item == null) {
			return Consts.zero;
		}
		if (!item.isImported()) {
			throw new UnableToCalculateTaxesException(Consts.UNIMPORTED_ITEM_ERR);
		}
		double taxes = Consts.zero;
		if (item.getCategory().equals(Categories.BOOK) || item.getCategory().equals(Categories.FOOD)
				|| item.getCategory().equals(Categories.MEDICAL_PRODUCTS)) {
			taxes = TaxesUtility.roundTaxes(item.getNetPrice() * Consts.importedItemTaxRate);
			return taxes;
		}
		double unroundedTotal = TaxesUtility.roundTaxes(item.getNetPrice() * Consts.importedItemTaxRate)
				+ TaxesUtility.roundTaxes(item.getNetPrice() * Consts.genericItemTaxRate);
		return unroundedTotal;

	}

}
