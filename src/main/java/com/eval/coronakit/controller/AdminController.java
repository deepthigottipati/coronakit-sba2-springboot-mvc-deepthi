package com.eval.coronakit.controller;



import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.eval.coronakit.entity.ProductMaster;
import com.eval.coronakit.exception.CoronaException;
import com.eval.coronakit.service.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	ProductService productService;
		
	@GetMapping("/home")
	public String home() {
		return "admin-home";
	}
	
	@GetMapping("/product-entry")
	public String productEntry(Model model) {
		
		ProductMaster theProduct=new ProductMaster();
		model.addAttribute("product",theProduct);
		
		return "add-new-item";
	}
	
	@PostMapping("/product-save")
	
	public String productSave(@Valid @ModelAttribute ("product") ProductMaster theproduct,Errors errors,Model model) throws CoronaException {
		
		if(errors.hasErrors())
		{
			//model.addAttribute("product",theproduct);
			
			return "add-new-item";
		}
		
		productService.addNewProduct(theproduct);
				
				return "redirect:/admin/product-list";
		

	}
	

	@GetMapping("/product-list")
	public String productList(Model model) throws CoronaException {
		
		List<ProductMaster> theProducts=productService.getAllProducts();

		model.addAttribute("products",theProducts);
		
		return "show-all-item-admin";

	}
	
	@GetMapping("/product-delete/{productId}")
	public String productDelete(@PathVariable("productId") int productId) throws CoronaException {
		
		
		String tempProduct = productService.deleteProduct(productId);
		
		// throw exception if null
		
		if (tempProduct == null) {
			throw new CoronaException("Product id not found - " + productId);
		}
		
		
		return "redirect:/admin/product-list";
	}
	
}
