package id.salesTaxes.manager;

import org.junit.Assert;
import org.junit.Test;

import id.salesTaxes.bean.Categories;
import id.salesTaxes.bean.Item;
import id.salesTaxes.bean.interfaces.IItem;
import id.salesTaxes.exception.UnableToCalculateTaxesException;

public class ImportedItemTaxesCalculatorTest {

	private final double delta = 0.0;

	@Test
	public void testGetSalesTaxes_choccolate() throws UnableToCalculateTaxesException {
		IItem importedChoccolate = new Item(10.00, Categories.FOOD, true, "box of choccolates");

		Assert.assertEquals(0.50, ImportedItemTaxesCalculator.getInstance().getSalesTaxes(importedChoccolate), delta);
	}

	@Test(expected = UnableToCalculateTaxesException.class)
	public void testGetSalesTaxes_choccolateNotImported() throws UnableToCalculateTaxesException {
		IItem importedChoccolate = new Item(10.00, Categories.FOOD, false, "box of choccolates");

		ImportedItemTaxesCalculator.getInstance().getSalesTaxes(importedChoccolate);
	}

	@Test
	public void testGetSalesTaxes_null() throws UnableToCalculateTaxesException {
		Assert.assertEquals(0.0, ImportedItemTaxesCalculator.getInstance().getSalesTaxes(null), delta);
	}

}
