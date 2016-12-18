package id.salesTaxes.bean.interfaces;

import id.salesTaxes.bean.Categories;

public interface IItem {

	public double getNetPrice();

	public Categories getCategory();

	public boolean isImported();
	
	public String getDescription();

}
