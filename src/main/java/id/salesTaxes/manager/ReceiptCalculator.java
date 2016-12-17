package id.salesTaxes.manager;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import id.salesTaxes.bean.interfaces.ICalculatedItem;
import id.salesTaxes.bean.interfaces.IItem;

public class ReceiptCalculator {
	private Map<IItem, ICalculatedItem> taxesMap = null;

	public ReceiptCalculator() {
		taxesMap = new TreeMap<IItem, ICalculatedItem>();
	}
	/**
	 * Calculate taxes and total amount of items in basket
	 * @param items IItems in basket
	 * @return total amount
	 */
	public double calculateTotal(List<IItem> items) {
		return 0;
	}
	/**
	 * Prints the receipt
	 * @return a String containing the receipt
	 */
	public String printReceipt(){
		return null;
	}

}
