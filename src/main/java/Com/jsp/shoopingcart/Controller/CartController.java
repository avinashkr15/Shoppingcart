package Com.jsp.shoopingcart.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import Com.jsp.shoopingcart.dao.CartDao;
import Com.jsp.shoopingcart.dao.CustomerDao;
import Com.jsp.shoopingcart.dto.Cart;
import Com.jsp.shoopingcart.dto.Customer;
import Com.jsp.shoopingcart.dto.Items;

       @Controller
       public class CartController {
	   @Autowired
	   CartDao dao;
	   @Autowired
	   CustomerDao cdao;
	
	   @RequestMapping("/fetchitemsfromcart")
	    public ModelAndView fetchItemsFromCart(HttpSession session) {
		Customer c=(Customer)session.getAttribute("customerinfo");
		
		Customer customer=cdao.findCustomerById(c.getId());
		Cart cart=customer.getCart();
		List<Items>item=cart.getItems();
		
		ModelAndView mav=new ModelAndView();
		
		mav.addObject("itemslist",item);
		mav.addObject("totalprice",cart.getTotal_Price());
		mav.setViewName("displaycarditemstocustomer");
		return mav;
		
		
	}
	

}
