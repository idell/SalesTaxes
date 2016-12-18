package id.salesTaxes.manager;

import id.salesTaxes.bean.interfaces.IItem;
import id.salesTaxes.manager.interfaces.ITaxesCalculator;

public class TaxesManagerFactory {

	
	public static ITaxesCalculator getCalculator(IItem item){
		if (item.isImported()){
			return ImportedItemTaxesCalculator.getInstance();
		}
		return TaxesCalculator.getInstance();
	}
}
