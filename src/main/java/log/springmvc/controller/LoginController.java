package log.springmvc.controller;

//import javax.validation.Valid;
import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import log.springmvc.dao.AccountDao;
import log.springmvc.dao.CustomerDao;
import log.springmvc.model.Accounts;
import log.springmvc.model.Customer;

//import com.dbms.dao.Userdao;
//import com.dbms.model.User;

@Controller
public class LoginController {

	int decider1=0;
	int decider2=0;
	int decider3=0;
	int decider4=0;
	@Autowired
//	public Userdao userdao;
	public AccountDao accdao;
	
	@Autowired
	public CustomerDao custdao;
	
	
	
	
	@RequestMapping(value = {"/","/welcome","/home","/log/","/dashboard"})
	public ModelAndView welcome(Principal principal) {
		ModelAndView mv=new ModelAndView();
		if(principal!=null) {
			System.out.println("principal is not null, principal is "+principal.getName());
			mv.addObject("user_name",principal.getName());
			mv.addObject("user_role", accdao.getUserRole(principal.getName()));
			mv.setViewName("dashboard"); //after login, automatically redirects here
			return mv;
		}
		System.out.println("reached welcome()");
		mv.setViewName("welcome");
		mv.addObject("acc",new Accounts());
		return mv;

	}
	
//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	public ModelAndView login() {
//		ModelAndView model = new ModelAndView("login");
//		return model;
//
//	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		System.out.println("reached login()");
		return "login";
	}
	
	
	@RequestMapping(value = "/accessdenied", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {
		System.out.println("reached loginerror()");
		model.addAttribute("error", "true");
		return "login";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(ModelMap model,HttpSession session) {
		System.out.println("reached logout()");
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String register(Model model) {
		System.out.println("reached registerfn()");
		System.out.println("dec1:"+decider1);
		System.out.println("dec2:"+decider2);
		System.out.println("dec3:"+decider3);
		if(decider1==1)
			model.addAttribute("msg","please enter valid entry");
		if(decider2==1)
			model.addAttribute("new_msg","phone no. should be a number");
		if(decider3==1)
			model.addAttribute("user_error","that username is already taken.");
		decider1=0;
		decider2=0;
		decider3=0;
		model.addAttribute("user",new Customer());
		return "NewRegister";
	}
	
	@RequestMapping(value="/registerprocess",method=RequestMethod.POST)
	public String registerprocess(@ModelAttribute(value = "user") Customer cust,BindingResult result) {
		
		System.out.println("reached registerprocess()");
		Accounts acc  = new Accounts();
		String myuser = cust.getUsername();
		System.out.println("myuser: "+myuser);
		System.out.println("Address:"+cust.getAddress());
		System.out.println("Name:"+cust.getName());
		System.out.println("Phone:"+cust.getPhone());
		System.out.println("dec1:"+decider1);
		System.out.println("dec2:"+decider2);
		System.out.println("dec3:"+decider3);
		if(cust.getAddress().isEmpty() || cust.getName().isEmpty() || cust.getPhone().isEmpty() || cust.getUsername().isEmpty() || cust.getEmail().isEmpty() || cust.getAddress().isBlank() || cust.getName().isBlank() || cust.getUsername().isBlank() ||cust.getPassword().isBlank() || cust.getEmail().isBlank())
		{   decider1=1;
		return "redirect:/register";
		}
		
		try {
			Integer.parseInt(cust.getPhone());
		} catch (Exception e) {
			// TODO: handle exception
			decider2=1;
		}
		if(decider1==1 || decider2==1)
			return "redirect:/register";
		if(accdao.validateCustomer(myuser)!=null )
		{
			
			decider3=1;
			return "redirect:/register";
		}
		System.out.println("hello");
		System.out.println("dec1:"+decider1);
		System.out.println("dec2:"+decider2);
		System.out.println("dec3:"+decider3);
		System.out.println("hello");
		acc.setUsername(cust.getUsername());
		acc.setPassword(cust.getPassword());
		acc.setUserRole("ROLE_USER");
        accdao.registerAcc(acc);
		custdao.registerCustomer(cust);	
        return "redirect:/";
	}
	
	
	

}
	
	
    	

