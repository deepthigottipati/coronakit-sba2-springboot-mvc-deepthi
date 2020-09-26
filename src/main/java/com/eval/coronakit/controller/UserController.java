package com.eval.coronakit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.eval.coronakit.entity.CoronaKit;
import com.eval.coronakit.entity.KitDetail;
import com.eval.coronakit.entity.ProductMaster;
import com.eval.coronakit.exception.CoronaException;
import com.eval.coronakit.service.CoronaKitService;
import com.eval.coronakit.service.KitDetailService;
import com.eval.coronakit.service.ProductService;

@Controller
@RequestMapping("/user")
@SessionAttributes("thekit")
public class UserController {
	
	
	@Autowired
	ProductService productService;

	@Autowired
	CoronaKitService coronaKitService;

	@Autowired
	KitDetailService kitDetailService;

	@RequestMapping("/home")
	public String home() {
		return "user-home";
	}

	@RequestMapping("/show-kit")
	public String showKit(Model model) {
		
		List<KitDetail> kit=kitDetailService.getAllKitItemsOfAKit();

		model.addAttribute("theKit",kit);
		return "show-cart";
	}

	@RequestMapping("/show-list")
	public String showList(Model model) throws CoronaException {

		List<ProductMaster> theProducts = productService.getAllProducts();

		model.addAttribute("products", theProducts);

		return "show-all-item-user";

	}

	
	@RequestMapping("/add-to-cart/{productId}")
	public String showKit(@PathVariable("productId") int productId) throws CoronaException {

	ModelAndView mv = new ModelAndView();

		
	KitDetail kit=new KitDetail();
		ProductMaster theProduct=productService.getProductById(productId);
		
		kit.setId(theProduct.getId());
		kit.setAmount(theProduct.getCost());
		kit.setCoronaKitId(1);
		kit.setProductId(theProduct.getId());
		kit.setQuantity(1);
		
		
		kitDetailService.addKitItem(kit);
		
		return "redirect:/user/show-list";
	}

	@RequestMapping("/checkout")
	public String checkout(Model model) throws CoronaException {
		
		//coronaKitService.saveKit(coronankit);
		model.addAttribute("coronakit", new CoronaKit());
		//coronaKitService.saveKit(CoronaKit);
		
		return "show-summary";	
	}

	@RequestMapping("/finalize")
	public String finalizeOrder(Model model) throws CoronaException {
			
	
		return "checkout-address";
	}

	@RequestMapping("/delete/{itemId}")
	public String deleteItem(@PathVariable("itemId") int itemId) throws CoronaException {

		String tempProduct = kitDetailService.deleteKitItem(itemId);

		// throw exception if null

		if (tempProduct == null) {
			throw new CoronaException("Product id not found - " + itemId);
		}

		return "redirect:/user/show-kit";

	}
}