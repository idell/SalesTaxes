package id.salesTaxes.manager;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

	@RunWith(Suite.class)
	@SuiteClasses({ ImportedItemTaxesCalculatorTest.class, ReceiptCalculatorTest.class, TaxesCalculatorTest.class })
	public class AllManagerTests {
	
	}
