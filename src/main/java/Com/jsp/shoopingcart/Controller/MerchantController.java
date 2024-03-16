package Com.jsp.shoopingcart.Controller;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import Com.jsp.shoopingcart.dao.Merchantdao;
import Com.jsp.shoopingcart.dto.Merchant;

@Controller
public class MerchantController {
	@Autowired
	Merchantdao dao;
	
	@RequestMapping("/addMerchant")
	public ModelAndView addMerchant() {
		Merchant  m=new Merchant ();
		 ModelAndView mav=new ModelAndView();
		 mav.addObject("merchentobj",m);
		 mav.setViewName("Merchant");
		return mav;
		 
	}
	@RequestMapping("/savemerchant")
	public ModelAndView saveMerchant(@ModelAttribute("merchentobj")Merchant m) {
		dao.saveMerchant (m);
		ModelAndView mav=new ModelAndView();
		mav.addObject("msg","Data Saved Seccussfully");
		mav.setViewName("Menu");
		return mav;
	}
	
	@RequestMapping("/loginvalidation")
	public ModelAndView login(ServletRequest req , HttpSession session) {
	String email=req.getParameter("email");
	String password=req.getParameter("password");
	
	Merchant  m=dao.login(email, password);
	ModelAndView mav=new  ModelAndView();
	if(m != null) {
		mav.addObject("msg","Successfully login");
		mav.setViewName("MerchantOptions");
		session.setAttribute("merchantinfo", m);
		return mav;
		
	}
	else {
		mav.addObject("msg","Invild credentials");
		mav.setViewName("merchantLoginForm");
		return mav;
	}
			
	}

}
