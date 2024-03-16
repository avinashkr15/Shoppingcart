package Com.jsp.shoopingcart.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import Com.jsp.shoopingcart.dao.CartDao;
import Com.jsp.shoopingcart.dao.CustomerDao;
import Com.jsp.shoopingcart.dao.OrderDao;
import Com.jsp.shoopingcart.dao.ProductDao;
import Com.jsp.shoopingcart.dto.Cart;
import Com.jsp.shoopingcart.dto.Customer;
import Com.jsp.shoopingcart.dto.Items;
import Com.jsp.shoopingcart.dto.Orders;
import Com.jsp.shoopingcart.dto.Product;

@Controller
public class OrderController {
	@Autowired
	OrderDao dao;
	@Autowired
	CustomerDao cdao;
	@Autowired
	ProductDao pdao;
	@Autowired
	CartDao crdao;

	@RequestMapping("/addorder")
	public ModelAndView addOrder() {
		Orders o = new Orders();

		ModelAndView mav = new ModelAndView();
		mav.addObject("ordersobj", o);
		mav.setViewName("ordersform");
		return mav;

	}

	@RequestMapping("/saveorders")
	public ModelAndView saveOrder(@ModelAttribute("ordersobj") Orders o, HttpSession session) {
		Customer c = (Customer) session.getAttribute("customerinfo");

		Customer customer = cdao.findCustomerById(c.getId());
		Cart cart = customer.getCart();
		List<Items> items = cart.getItems();
		o.setTotle_price(cart.getTotal_Price());
		List<Items> itemsList = new ArrayList<>();
		List<Items> itemsswithGeraterQuantity = new ArrayList<Items>();

		for (Items i : items) {
			Product p = pdao.findProductById(i.getP_id());
			if (i.getQuantity() < p.getStock()) {
				itemsList.add(i);
				p.setStock(p.getStock() - i.getQuantity());

				pdao.updateProduct(p);
			} else {
				itemsswithGeraterQuantity.add(i);
			}
		}
		o.setItems(itemsList);
		cart.setItems(itemsswithGeraterQuantity);

		double totalprice = 0;
		for (Items i : itemsswithGeraterQuantity) {
			totalprice += i.getPrice();

		}
		o.setTotle_price(totalprice);
		cart.setTotal_Price(totalprice);
		Cart updatedCart = crdao.removeAllItemsFromCart(cart.getId());

		List<Orders> orders = customer.getOrders();
		if (orders.size() > 0) {
			customer.setOrders(orders);

		} else {
			List<Orders> orders1 = new ArrayList<>();
			orders1.add(o);
			customer.setOrders(orders1);

		}
		customer.setCart(updatedCart);

		dao.saveOrderProduct(o);
		cdao.updateCustomer(customer);

		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "order placed Successfully");
		mav.addObject("orderdetails", o);
		mav.setViewName("Orderbill");
		return mav;

	}

}
