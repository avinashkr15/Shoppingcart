package Com.jsp.shoopingcart.Controller;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import Com.jsp.shoopingcart.dao.CustomerDao;
import Com.jsp.shoopingcart.dto.Customer;

@Controller
public class CustomerController {
	@Autowired
	CustomerDao dao;
	@RequestMapping("/addcustomer")
	public ModelAndView addCustomer() {
		Customer c=new Customer();
		ModelAndView mav=new ModelAndView();
		mav.addObject("customerobj",c);
		mav.setViewName("Customer");
		return mav;
		
	}
	
	@RequestMapping("/savecustomer")
	public ModelAndView saveCustomer(@ModelAttribute("customerobj")Customer c) {
		dao.saveCustomer(c);
		ModelAndView mav=new ModelAndView();
		mav.addObject("msg","Data Saved Seccussfully");
		mav.setViewName("CustomerLoginForm");
		return mav;
	}
	
	@RequestMapping("/cloginvalidation")
	public ModelAndView login(ServletRequest req , HttpSession session) {
	String email=req.getParameter("email");
	String password=req.getParameter("password");
     Customer c=dao.login(email, password);
	ModelAndView mav=new  ModelAndView();
	if(c != null) {
		mav.addObject("msg","Successfully login");
		mav.setViewName("CustomerOptions");
		session.setAttribute("customerinfo", c);
		return mav;
		
	}
	else {
		mav.addObject("msg","Invild credentials");
		mav.setViewName("CustomerLoginForm");
		return mav;
	}
			
	}

}
