package id.salesTaxes.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import id.salesTaxes.bean.CalculatedItem;
import id.salesTaxes.bean.interfaces.ICalculatedItem;
import id.salesTaxes.bean.interfaces.IItem;
import id.salesTaxes.consts.Consts;
import id.salesTaxes.exception.UnableToCalculateTaxesException;
import id.salesTaxes.util.TaxesUtility;

public class ReceiptCalculator {
	private Map<IItem, ICalculatedItem> itemsMap = null;

	public ReceiptCalculator() {
		itemsMap = new HashMap<IItem, ICalculatedItem>();
	}

	/**
	 * Calculate taxes and total amount of items in basket
	 * 
	 * @param items
	 *            IItems in basket
	 * @return total amount
	 * @throws UnableToCalculateTaxesException
	 */
	public double calculateTotal(List<IItem> items) throws UnableToCalculateTaxesException {
		if (items == null || items.isEmpty()) {
			return Consts.zero;
		}
		for (IItem item : items) {

			double taxes = TaxesManagerFactory.getCalculator(item).getSalesTaxes(item);
			if (itemsMap.containsKey(item)) {
				ICalculatedItem calculated = calculateAddingItems(item, taxes);
				itemsMap.put(item, calculated);
			} else {
				ICalculatedItem calculatedItem = new CalculatedItem(item, taxes);
				itemsMap.put(item, calculatedItem);
			}

		}

		return calculateTotalForReceipt();
	}
	
	/**
	 * Method to calculate taxes in order to add an existing item
	 * @param item to be added
	 * @param taxes value
	 * @return 
	 */
	private ICalculatedItem calculateAddingItems(IItem item, double taxes) {
		ICalculatedItem calculated = new CalculatedItem(item, taxes);
		double oldTaxes = itemsMap.get(item).getTaxes();
		oldTaxes += taxes;
		double newTaxes = oldTaxes + taxes;
		int quantity = itemsMap.get(item).getQuantity();
		quantity++;
		calculated = new CalculatedItem(item, newTaxes, quantity);
		return calculated;
	}
	
	/**
	 * Extract total amount for item in basket
	 * @return total amount
	 */
	private double calculateTotalForReceipt() {
		double total = Consts.zero;
		for (ICalculatedItem calculatedItem : itemsMap.values()) {
			total += calculatedItem.getNetPrice();
			total += calculatedItem.getTaxes();
		}
		return TaxesUtility.roundTotal(total);
	}

	/**
	 * Prints the receipt
	 * 
	 * @return a String containing the receipt
	 */
	public String printReceipt() {
		return null;
	}

}
