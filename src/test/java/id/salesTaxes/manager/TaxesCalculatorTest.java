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
	public void testGetSalesTaxes_exempt() {
		IItem book = new Item(12.49, Categories.BOOK, false);
		Assert.assertEquals(0, TaxesCalculator.getInstance().getSalesTaxes(book), delta);
	}

	@Test
	public void testGetSalesTaxes_unexempt() {
		IItem musicCD = new Item(14.99, Categories.MUSIC, false);
		Assert.assertEquals(1.50, TaxesCalculator.getInstance().getSalesTaxes(musicCD), delta);
	}

	@Test(expected = UnableToCalculateTaxesException.class)
	public void testGetSalesTaxes_input0Imported() {
		IItem book = new Item(12.49, Categories.BOOK, true);
		TaxesCalculator.getInstance().getSalesTaxes(book);
	}

	@Test
	public void testGetSalesTaxes_nullInput() {
		Assert.assertEquals(0, TaxesCalculator.getInstance().getSalesTaxes(null), delta);
	}

}
