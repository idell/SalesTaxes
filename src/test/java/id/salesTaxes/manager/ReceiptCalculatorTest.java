package id.salesTaxes.manager;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import id.salesTaxes.bean.Categories;
import id.salesTaxes.bean.Item;
import id.salesTaxes.bean.interfaces.IItem;
import id.salesTaxes.exception.UnableToCalculateTaxesException;

public class ReceiptCalculatorTest {

	private final double delta = 0.0;

	@Test
	public void testCalculateTotal_emptyItems() throws UnableToCalculateTaxesException {
		ReceiptCalculator receiptCalculator = new ReceiptCalculator();
		List<IItem> items = new ArrayList<IItem>();
		Assert.assertEquals(0.0, receiptCalculator.calculateTotal(items), delta);
	}

	@Test
	public void testCalculateTotal_nullItems() throws UnableToCalculateTaxesException {
		ReceiptCalculator receiptCalculator = new ReceiptCalculator();
		Assert.assertEquals(0.0, receiptCalculator.calculateTotal(null), delta);
	}

	@Test
	public void testCalculateTotal_Input1() throws UnableToCalculateTaxesException {
		ReceiptCalculator receiptCalculator = new ReceiptCalculator();
		List<IItem> items = new ArrayList<IItem>();

		IItem book = new Item(12.49, Categories.BOOK, false);
		IItem musicCd = new Item(14.99, Categories.MUSIC, false);
		IItem choccolateBar = new Item(0.85, Categories.FOOD, false);

		items.add(book);
		items.add(musicCd);
		items.add(choccolateBar);

		Assert.assertEquals(29.83, receiptCalculator.calculateTotal(items), delta);
	}

	@Test
	public void testCalculateTotal_Input2() throws UnableToCalculateTaxesException {
		ReceiptCalculator receiptCalculator = new ReceiptCalculator();
		List<IItem> items = new ArrayList<IItem>();

		IItem perfume = new Item(47.50, Categories.COSMETICS, true);
		IItem choccolateBox = new Item(10.00, Categories.FOOD, true);

		items.add(perfume);
		items.add(choccolateBox);

		Assert.assertEquals(65.15, receiptCalculator.calculateTotal(items), delta);
	}

	@Test
	public void testPrintReceipt_Input3() throws UnableToCalculateTaxesException {
		ReceiptCalculator receiptCalculator = new ReceiptCalculator();
		List<IItem> items = new ArrayList<IItem>();

		IItem importedPerfume = new Item(27.99, Categories.COSMETICS, true);
		IItem perfume = new Item(18.99, Categories.COSMETICS, false);
		IItem headachePills = new Item(9.75, Categories.MEDICAL_PRODUCTS, false);
		IItem choccolateBox = new Item(11.25, Categories.FOOD, true);

		items.add(importedPerfume);
		items.add(perfume);
		items.add(headachePills);
		items.add(choccolateBox);

		Assert.assertEquals(74.68, receiptCalculator.calculateTotal(items), delta);
	}

	@Test
	public void testPrintRecepit_nullItems() throws UnableToCalculateTaxesException {
		ReceiptCalculator receiptCalculator = new ReceiptCalculator();
		List<IItem> items = new ArrayList<IItem>();

		IItem importedPerfume = new Item(27.99, Categories.COSMETICS, true);
		IItem perfume = new Item(18.99, Categories.COSMETICS, false);
		IItem headachePills = new Item(9.75, Categories.MEDICAL_PRODUCTS, false);
		IItem choccolateBox = new Item(11.25, Categories.FOOD, true);

		items.add(importedPerfume);
		items.add(perfume);
		items.add(headachePills);
		items.add(choccolateBox);
		
		Assert.assertNull(receiptCalculator.printReceipt());
		receiptCalculator.calculateTotal(items);
		Assert.assertNotNull(receiptCalculator.printReceipt());
	}

}
