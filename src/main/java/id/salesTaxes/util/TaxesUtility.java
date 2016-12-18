package id.salesTaxes.util;

import id.salesTaxes.consts.Consts;

public class TaxesUtility {

	public TaxesUtility() {

	}

	/**
	 * Rounds taxes to the closes 0.05
	 * @param taxes to be rounded
	 * @return rounded taxes amount
	 */
	public static double roundTaxes (double taxes){
		return Math.round(taxes * Consts.roundingOperator) / Consts.roundingOperator;
	}
}
