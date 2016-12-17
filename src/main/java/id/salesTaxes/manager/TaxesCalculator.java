package id.salesTaxes.manager;

import id.salesTaxes.bean.Categories;
import id.salesTaxes.bean.interfaces.IItem;
import id.salesTaxes.consts.Consts;
import id.salesTaxes.exception.UnableToCalculateTaxesException;
import id.salesTaxes.manager.interfaces.ITaxesCalculator;

/**
 * Taxes Calculator Manger for items not imported
 */
public class TaxesCalculator implements ITaxesCalculator {

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
	 * @throws UnableToCalculateTaxesException
	 */
	public double getSalesTaxes(IItem item) throws UnableToCalculateTaxesException {
		if (item == null) {
			return Consts.zero;
		}
		if (item.isImported()) {
			throw new UnableToCalculateTaxesException(Consts.IMPORTED_ITEM_ERR);
		}
		if (item.getCategory().equals(Categories.BOOK) || item.getCategory().equals(Categories.FOOD)
				|| item.getCategory().equals(Categories.MEDICAL_PRODUCTS)) {
			return Consts.zero;
		}

		return roundTaxes(item.getNetPrice() * Consts.genericItemTaxRate);
	}

	/**
	 * Rounds taxes to the closes 0.05
	 * @param taxes to be rounded
	 * @return rounded taxes amount
	 */
	private static double roundTaxes(double taxes) {
		return Math.round(taxes * Consts.roundingOperator) / Consts.roundingOperator;
	}

}
