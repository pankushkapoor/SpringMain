package com.cg.onlineshop.services;

import java.util.List;

import com.cg.onlineshop.beans.Product;
import com.cg.onlineshop.exceptions.ProductDetailsNotFoundException;

public interface OnlineShopServices {
	public Product acceptProductDetails(Product product);
	public List<Product> getAllProductDetails();
	public Product getProductDetails(int productId) throws ProductDetailsNotFoundException;
	public void removeProductDetails(int productId);
}
