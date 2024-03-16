package Com.jsp.shoopingcart.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import Com.jsp.shoopingcart.dao.CartDao;
import Com.jsp.shoopingcart.dao.CustomerDao;
import Com.jsp.shoopingcart.dao.ItemsDao;
import Com.jsp.shoopingcart.dao.ProductDao;
import Com.jsp.shoopingcart.dto.Cart;
import Com.jsp.shoopingcart.dto.Customer;
import Com.jsp.shoopingcart.dto.Items;
import Com.jsp.shoopingcart.dto.Product;

@Controller
public class ItemsController {
	@Autowired
	ItemsDao dao;
	@Autowired
	ProductDao pdao;
	@Autowired
	CartDao cdao;
	@Autowired
	CustomerDao custdao;
	
	@RequestMapping("/additem")
	public ModelAndView addItems(@RequestParam("id")int id) {
		Product p=pdao.findProductById(id);
	
		ModelAndView mav =new ModelAndView();
		mav.addObject("prodobj",p);
		mav.setViewName("itemform");
		return mav;
		
		
	}
	@RequestMapping("/saveitemtocart")
	public  ModelAndView addItemToCart(ServletRequest req, HttpSession session) {
	 int product_id= Integer.parseInt(req.getParameter("id"));
	 String  brand=req.getParameter("brand");
	 double price=Double.parseDouble(req.getParameter("price"));
	 String model=req.getParameter("model");
	 String category=req.getParameter("category");
	 int quantity=Integer.parseInt(req.getParameter("quantity"));
	 
	 Items item=new Items();
	 item.setBrand(brand);
	 item.setCategory(category);
	 item.setModel(model);
	 item.setQuantity(quantity);
	item.setP_id(product_id);
	 item.setPrice(quantity*price);
	 
	 Customer customer=(Customer)session.getAttribute("customerinfo");
	 Cart c= customer.getCart();
	 if(c==null) {
		 double totalprice=0;
		 Cart cart=new Cart();
		 
		 List<Items> items=new ArrayList<>();
		 items.add(item);
		 
		 
		 cart.setItems(items);
		 cart.setName(customer.getName());
		 for(Items i: items) {totalprice+=i.getPrice();}
//		 for(Items i:items) {
//			 price=price+i.getPrice();
//			 
//		 }
//		 cart.setTotal_Price(price);
		 
		 cart.setTotal_Price(totalprice);
		 
		 customer.setCart(cart);
		 
		 dao.saveItems(item);
		 cdao.saveCartDao(cart);
		 
		 custdao.updateCustomer(customer);
	 }
	 else {
		  List<Items>items=c.getItems();
		  if(items.size()>0)
		  {
			  items.add(item);
			  c.setItems(items);
			  double totalprice=0;
			  for(Items i: items) {totalprice= totalprice+i.getPrice();}
			  c.setTotal_Price(totalprice);
			  customer.setCart(c);
			  
			  dao.saveItems(item);
			  cdao.updateCart(c);
			  custdao.updateCustomer(customer);
		  }
		  else {
			  
			  List<Items>itemlist=new ArrayList<>();
			  itemlist.add(item);
			  c.setItems(itemlist);
			  c.setTotal_Price(item.getPrice());
			  customer.setCart(c) ;
			  dao.saveItems(item);
			  cdao.updateCart(c);
			  custdao.updateCustomer(customer);
			  
		  }
		 
	 }
	 ModelAndView mav=new  ModelAndView();
	 mav.setViewName("redirect://displayproduct");
	return mav;
	}

}
