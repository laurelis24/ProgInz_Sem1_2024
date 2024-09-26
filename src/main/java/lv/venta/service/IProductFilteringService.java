package lv.venta.service;

import java.util.ArrayList;

import lv.venta.model.Product;

public interface IProductFilteringService {
	public abstract ArrayList<Product> filterByPriceLess(float threshold) throws Exception;
	
	public abstract ArrayList<Product> filterByQuantityLess(int threshold) throws Exception;
	
	public abstract ArrayList<Product> filterByTitleOrDescription(String phrase) throws Exception;
	
	public abstract float calculateTotalValueOfProducts() throws Exception;

	//public abstract ArrayList<Product> priceBetween(int from, int to) throws Exception;
	
}
