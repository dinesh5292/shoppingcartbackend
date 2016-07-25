package com.niit.shoppingcart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;

public class CategoryTest {
	
	
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.scan("com.niit.shoppingcart");
		context.refresh();
		
		
	   CategoryDAO categoryDAO = 	(CategoryDAO) context.getBean("categoryDAO");
	   
	   Category category = 	(Category) context.getBean("category");
	   category.setId("CG120");
	   category.setName("CGName120");
	   category.setDescription("CGDesc120");
	   
	   
	   categoryDAO.saveOrUpdate(category);
	   System.out.println(" no of categories"+ categoryDAO.list().size());
	   
	   
	
	  if(   categoryDAO.get("sdfsf") ==null)
	  {
		  System.out.println("Category exist .. the details are ..");
	  }
	  else
	  {
		  System.out.println("");
		  System.out.println("Category doesnot exist");
	  }
		
	
		
	}

}
