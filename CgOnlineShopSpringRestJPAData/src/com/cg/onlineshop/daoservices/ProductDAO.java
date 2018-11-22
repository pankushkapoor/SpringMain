package com.cg.onlineshop.daoservices;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.onlineshop.beans.Product;

public interface ProductDAO extends JpaRepository<Product, Integer>{
	 
}