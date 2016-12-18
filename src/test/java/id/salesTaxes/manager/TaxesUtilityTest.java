package id.salesTaxes.manager;

import org.junit.Assert;
import org.junit.Test;

import id.salesTaxes.util.TaxesUtility;

public class TaxesUtilityTest {

	private final double delta = 0.0;
	
	@Test
	public void testRoundTaxes_positive() {
		Assert.assertEquals(0.05, TaxesUtility.roundTaxes(0.03), delta);
	}

	@Test
	public void testRoundTaxes_negative() {
		Assert.assertEquals(0.00, TaxesUtility.roundTaxes(-0.0001), delta);
	}
	
	@Test
	public void testRoundTotal_positive() {
		Assert.assertEquals(23.00, TaxesUtility.roundTotal(23.0000004), delta);
	}
	
	@Test
	public void testRoundTotal_negative() {
		Assert.assertEquals(-1.00, TaxesUtility.roundTotal(-1.000000001), delta);
	}

}
