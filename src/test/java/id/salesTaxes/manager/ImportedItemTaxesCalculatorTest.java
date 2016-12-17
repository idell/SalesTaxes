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
	public void testGetSalesTaxes_choccolate() {
		IItem importedChoccolate = new Item(10.00, Categories.FOOD, true);

		Assert.assertEquals(10.50, ImportedItemTaxesCalculator.getInstance().getSalesTaxes(importedChoccolate), delta);
	}

	@Test(expected = UnableToCalculateTaxesException.class)
	public void testGetSalesTaxes_choccolateNotImported() {
		IItem importedChoccolate = new Item(10.00, Categories.FOOD, false);

		ImportedItemTaxesCalculator.getInstance().getSalesTaxes(importedChoccolate);
	}

	@Test
	public void testGetSalesTaxes_null() {
		Assert.assertEquals(0.0, ImportedItemTaxesCalculator.getInstance().getSalesTaxes(null), delta);
	}

}