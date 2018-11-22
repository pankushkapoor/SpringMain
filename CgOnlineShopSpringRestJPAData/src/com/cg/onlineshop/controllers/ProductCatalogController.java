package com.cg.onlineshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineshop.beans.Product;
import com.cg.onlineshop.exceptions.ProductDetailsNotFoundException;
import com.cg.onlineshop.services.OnlineShopServices;

@RestController
public class ProductCatalogController {

	@Autowired
	OnlineShopServices onlineShopServices;

	@RequestMapping("/hello")
	public ResponseEntity<String> sayHello(){
		ResponseEntity<String> response = new ResponseEntity<String>("Hello to All",HttpStatus.OK);
		return response;
	}

	@RequestMapping(value="acceptProductDetails",method=RequestMethod.POST, consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<String> acceptproductDetails(@ModelAttribute Product product){
		onlineShopServices.acceptProductDetails(product);
		return new ResponseEntity<>("Product details successfully added",HttpStatus.OK);
	}
	
	@RequestMapping(value={"/getProductDetails"}, produces=MediaType.APPLICATION_JSON_VALUE, headers="Accept=application/json")
	public ResponseEntity<Product> getProductDetails(@RequestParam("productId") int productId) throws ProductDetailsNotFoundException {
		return new ResponseEntity<Product>(onlineShopServices.getProductDetails(productId),HttpStatus.OK);
		
	}
	/*@RequestMapping(value="getProductDetails")
	public ResponseEntity<String> getProductDetails(@ModelAttribute Product product) throws ProductDetailsNotFoundException {
		return new ResponseEntity<String>(onlineShopServices.getProductDetails(product.getProductId()).toString(),HttpStatus.OK);
		
	}*/
	@RequestMapping(value= {"allProductDetails"},method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE, headers="Accept=application/json")
	public ResponseEntity<List<Product>> getAllproductDetails(){
		List<Product> productList = onlineShopServices.getAllProductDetails();
		return new ResponseEntity<>(productList,HttpStatus.OK);
	}
	@RequestMapping(value= {"/deleteProductDetails"},method=RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_VALUE, headers="Accept=application/json")
	public ResponseEntity<List<String>> getAllproductDetails(@RequestParam("productId") int productId) throws ProductDetailsNotFoundException{
		List<Product> productList = onlineShopServices.getAllProductDetails();
		return null;
	}
}
