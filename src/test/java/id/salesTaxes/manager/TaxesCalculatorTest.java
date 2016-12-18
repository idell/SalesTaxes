package id.salesTaxes.manager;

import org.junit.Assert;
import org.junit.Test;

import id.salesTaxes.bean.Categories;
import id.salesTaxes.bean.Item;
import id.salesTaxes.bean.interfaces.IItem;
import id.salesTaxes.exception.UnableToCalculateTaxesException;

public class TaxesCalculatorTest {

	private final double delta = 0.0;

	@Test
	public void testGetSalesTaxes_exempt() throws UnableToCalculateTaxesException {
		IItem book = new Item(12.49, Categories.BOOK, false, "book");

		Assert.assertEquals(0, TaxesCalculator.getInstance().getSalesTaxes(book), delta);
	}

	@Test
	public void testGetSalesTaxes_unexempt() throws UnableToCalculateTaxesException {
		IItem musicCD = new Item(14.99, Categories.MUSIC, false, "music CD");
		Assert.assertEquals(1.50, TaxesCalculator.getInstance().getSalesTaxes(musicCD), delta);
	}

	@Test(expected = UnableToCalculateTaxesException.class)
	public void testGetSalesTaxes_input1Imported() throws UnableToCalculateTaxesException {
		IItem book = new Item(12.49, Categories.BOOK, true, "book");
		TaxesCalculator.getInstance().getSalesTaxes(book);
	}

	@Test
	public void testGetSalesTaxes_nullInput() throws UnableToCalculateTaxesException {

		Assert.assertEquals(0, TaxesCalculator.getInstance().getSalesTaxes(null), delta);
	}

}
