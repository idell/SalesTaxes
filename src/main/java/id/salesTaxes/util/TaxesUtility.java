package id.salesTaxes.util;

import id.salesTaxes.consts.Consts;

public class TaxesUtility {

	public TaxesUtility() {

	}

	/**
	 * Rounds up taxes to the closes 0.05
	 * 
	 * @param taxes
	 *            to be rounded
	 * @return rounded taxes amount
	 */
	public static double roundTaxes(double taxes) {
		return Math.ceil(taxes * Consts.roundingOperator) / Consts.roundingOperator;
	}

	/**
	 * Rounds the total to the second decimal place
	 * 
	 * @param total
	 * @return total value rounded to the second decimal place
	 */
	public static double roundTotal(double total) {
		return Math.round(total * Consts.uneHundredThousand) / Consts.uneHundredThousand;
	}
}
