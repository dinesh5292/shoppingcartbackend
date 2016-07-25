package com.niit.shoppingcart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.model.Product;

public class ProductTest {
	
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.scan("com.niit.shoppingcart");
		context.refresh();
		
		
	   ProductDAO productDAO = 	(ProductDAO) context.getBean("productDAO");
	   
	   Product product = 	(Product) context.getBean("product");
	   product.setId("CG120");
	   product.setName("CGName120");
	   product.setDescription("CGDesc120");
	   
	   
	   productDAO.saveOrUpdate(product);
	   
	   
	   
	   
	  if(   productDAO.get("sdfsf") ==null)
	  {
		  System.out.println("Product does not exist");
	  }
	  else
	  {
		  System.out.println("Product exist .. the details are ..");
		  System.out.println();
	  }
		
		
		
	}

}

