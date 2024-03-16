package Com.jsp.shoopingcart.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.cj.Session;

import Com.jsp.shoopingcart.dao.Merchantdao;
import Com.jsp.shoopingcart.dao.ProductDao;
import Com.jsp.shoopingcart.dto.Merchant;
import Com.jsp.shoopingcart.dto.Product;

@Controller

public class ProductController {
	@Autowired
	ProductDao dao;

	@Autowired
	Merchantdao mdao;

	@RequestMapping("/addproduct")
	public ModelAndView addProduct() {
		Product p = new Product();

		ModelAndView mav = new ModelAndView();
		mav.addObject("productobj", p);
		mav.setViewName("productform");
		return mav;

	}

	@RequestMapping("/saveproduct")
	public ModelAndView saveProduct(@ModelAttribute("productobj") Product p, HttpSession session) {
		Merchant Merchant = (Merchant) session.getAttribute("merchantinfo");
		List<Product> products = Merchant.getProduct();
		if (products.size() > 0) {
			products.add(p);

		} else {
			List<Product> productslist = new ArrayList<Product>();
			productslist.add(p);
			Merchant.setProduct(productslist);
		}
		dao.saveProduct(p);
		mdao.updateMerchant(Merchant);
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "Data saved SUccessFully");
		mav.setViewName("MerchantOptions");
		return mav;

	}

	@RequestMapping("/deleteproduct")
	public ModelAndView deleteProduct(@RequestParam("id") int id, HttpSession session) {
		Merchant Merchant = (Merchant) session.getAttribute("merchantinfo");
		Merchant m = mdao.deleteProductFormMerchant(Merchant.getId(), id);

		mdao.updateMerchant(m);
		dao.deleteProductById(id);
		session.setAttribute("merchantinfo", m);
		// dao.deleteProductById(id);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("viewallproduct");
		return mav;

	}
	@RequestMapping("/displayproduct")
	public ModelAndView displayProduct() {
		List<Product>products= dao.fetchAllProducts();
		
		ModelAndView mav=new ModelAndView();
		
		mav.addObject("productlist", products);
		mav.setViewName("AllProduct");
		return mav;
	}
	
	@RequestMapping("/displayproductbybrand")
	public ModelAndView displayProductsBrand(ServletRequest req) {
		String brand=req.getParameter("brand");
		List<Product>products=dao.findProductByBrand(brand);
		ModelAndView mav=new ModelAndView();
		mav.addObject("productlist",products);
		mav.setViewName("AllProduct");
		return mav;
	}
	@RequestMapping("/displayproductbycategory")
	public ModelAndView displayProductsCategory(ServletRequest req) {
		String category=req.getParameter("category");
		List<Product>products=dao.findProductByCategory(category);
		ModelAndView mav=new ModelAndView();
		mav.addObject("productlist",products);
		mav.setViewName("AllProduct");
		return mav;
		
	}
	

}
