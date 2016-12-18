package id.salesTaxes.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import id.salesTaxes.bean.CalculatedItem;
import id.salesTaxes.bean.Item;
import id.salesTaxes.bean.interfaces.ICalculatedItem;
import id.salesTaxes.bean.interfaces.IItem;
import id.salesTaxes.consts.Consts;
import id.salesTaxes.exception.UnableToCalculateTaxesException;
import id.salesTaxes.util.TaxesUtility;

public class ReceiptCalculator {
	private Map<IItem, ICalculatedItem> basket = null;
	private double totalTaxes;
	private double totalAmount;

	public ReceiptCalculator() {
		basket = new HashMap<IItem, ICalculatedItem>();
		totalTaxes = Consts.zero;
		totalAmount = Consts.zero;
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
			ICalculatedItem calculated = null;
			if (basket.containsKey(item)) {
				calculated = calculateAddingItems(item, taxes);
			} else {
				calculated = new CalculatedItem(item, taxes);
			}
			basket.put(item, calculated);

		}

		return calculateTotalForReceipt();
	}

	/**
	 * Method to calculate taxes in order to add an existing item
	 * 
	 * @param item
	 *            to be added
	 * @param taxes
	 *            value
	 * @return
	 */
	private ICalculatedItem calculateAddingItems(IItem item, double taxes) {
		ICalculatedItem calculated = new CalculatedItem(item, taxes);
		double oldTaxes = basket.get(item).getTaxes();
		double newTaxes = oldTaxes + taxes;
		int quantity = basket.get(item).getQuantity();
		double singleNetPrice = TaxesUtility.roundTotal(item.getNetPrice()/quantity);
		double newNetPrice = TaxesUtility.roundTotal(item.getNetPrice()+singleNetPrice);
		quantity++;
		Item itemAdded = new Item(newNetPrice, item.getCategory(),item.isImported(),item.getDescription());
		calculated = new CalculatedItem(itemAdded, newTaxes, quantity);
		return calculated;
	}

	/**
	 * Extract total amount for item in basket
	 * 
	 * @return total amount
	 */
	private double calculateTotalForReceipt() {
		for (ICalculatedItem calculatedItem : basket.values()) {
			totalAmount += calculatedItem.getNetPrice();
			totalAmount += calculatedItem.getTaxes();
			totalTaxes += calculatedItem.getTaxes();
		}
		totalAmount = TaxesUtility.roundTotal(totalAmount);
		totalTaxes = TaxesUtility.roundTotal(totalTaxes);
		return totalAmount;
	}

	/**
	 * Prints the receipt and empty the basket
	 * 
	 * @return a String containing the receipt
	 */
	public String printReceipt() {
		StringBuilder builder = new StringBuilder();
		if (basket.isEmpty()){
			return null;
		}
		for (ICalculatedItem calculatedItem : basket.values()) {
			builder.append(String.valueOf(calculatedItem.getQuantity()));
			builder.append(calculatedItem.isImported() ? Consts.IMPORTED : Consts.SPACE);
			builder.append(calculatedItem.getDescription());
			builder.append(Consts.COLON);
			builder.append(
					String.valueOf(TaxesUtility.roundTotal(calculatedItem.getNetPrice() + calculatedItem.getTaxes())));
			builder.append(Consts.NL);
		}
		builder.append(Consts.SALES_TAXES);
		builder.append(String.valueOf(totalTaxes));
		builder.append(Consts.NL);
		builder.append(Consts.TOTAL);
		builder.append(String.valueOf(totalAmount));
		
		System.out.println(builder.toString());

		basket.clear();
		totalAmount = Consts.zero;
		totalTaxes = Consts.zero;
		
		return builder.toString();

	}

}
