package log.springmvc.controller;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import log.springmvc.dao.AccountDao;
import log.springmvc.dao.Answered_questionDao;
import log.springmvc.dao.CartDao;
import log.springmvc.dao.Colordao;
import log.springmvc.dao.CustomerDao;
import log.springmvc.dao.OrdersDao;
import log.springmvc.dao.Pending_QuestionDao;
import log.springmvc.dao.ProductDao;
import log.springmvc.dao.SupplierDao;
import log.springmvc.model.Accounts;
import log.springmvc.model.Answered_question;
import log.springmvc.model.Cart;
import log.springmvc.model.Cartdisplay;
import log.springmvc.model.Customer;
import log.springmvc.model.Employee;
import log.springmvc.model.Orderdisplay;
import log.springmvc.model.Product;
import log.springmvc.model.Productform;
import log.springmvc.model.Stringholder;

@Controller
public class UserController {
	@Autowired
	public AccountDao accdao;
	
	@Autowired
	CartDao cartdao;
	
	@Autowired
	OrdersDao ordersdao;
	
	@Autowired
	Pending_QuestionDao pq;
	
	@Autowired
	Answered_questionDao aq;
	
	@Autowired
	public CustomerDao custdao;
	
	@Autowired
	ProductDao prod_dao;
	
	@Autowired
	SupplierDao supplierDao;
	
	
	public Accounts acc;
	
	
	public Employee emp;
	
	Model model;
	
	int decider1 =0;
	int decider2=0;
	int decider3=0;
	int decider4=0;
	int decider5=0;
	@Autowired
	Colordao coldao;
	
//	@RequestMapping(value = "dashboard", method = RequestMethod.GET)
//	public String dashview(Principal principal, Authentication authentication)
//	{
//	String logged_user = principal.getName();
//	model.addAttribute("user",logged_user);
//	Set<String> authority = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
//	if (authority.contains("ROLE_ADMIN")) {
//		return "/admin";
//	}
//	else if(authority.contains("ROLE_EMP"))
//	{
//		return "/emp";
//	}
//	
//	return "/user";
//	
//	}
	@RequestMapping(value="user/details")
	public ModelAndView showuserdetails(Principal principal)
	{
		String myusername=principal.getName();
		Customer mycust= custdao.getcustomerdetails(myusername);
		ModelAndView mv = new ModelAndView();
		mv.addObject("custdetails",mycust);
		mv.setViewName("myuserdetails");
		return mv;
	}
	
	@RequestMapping(value = "user/updateprofile")
	public String showupdateform(Model model)
	{
		model.addAttribute("user",new Customer());
		return "userupdateform";
	}
	
	@RequestMapping(value="user/updateprofileprocess")
	public String updatemyprofile(Principal principal,@ModelAttribute("user") Customer cust)
	{
		System.out.println("reached userupdateprofileprocess()");
		custdao.updatecustomerdetails(cust, principal.getName());	
		System.out.println("myname:"+principal.getName());
		return "redirect:/user/details";
	}
	
	@RequestMapping(value = "user/cart")
	public ModelAndView displaycart(Principal principal, Authentication authentication)
	{
		System.out.println("reached displaycart()");
		String logged_user = principal.getName();
		ModelAndView mv = new ModelAndView();
		List<Cartdisplay> l = cartdao.showCart(logged_user);
//		System.out.println(l.get(0).getCompany());
		mv.addObject("cartlist",l);
		mv.setViewName("cart");
		return mv;
	}
	
	@RequestMapping(value = "user/orders")
	public ModelAndView displayorders(Principal principal, Authentication authentication)
	{
	    OrderComparator comp = new OrderComparator();
		System.out.println("reached displayorders()");
		String logged_user = principal.getName();
		ModelAndView mv = new ModelAndView();
		List<Orderdisplay> myord =ordersdao.showOrders(logged_user);
		Collections.sort(myord, new OrderComparator()); 
		mv.addObject("orderlist",myord);
		mv.setViewName("orders");
		return mv;
	}
	
	@RequestMapping(value = "user/delcart/{C_id}")
	public String removeitemfromcart(@PathVariable(value="C_id") int C_id,Principal principal )
	{
		System.out.println("reached delfromcart()");
		cartdao.removefromCart(principal.getName(), C_id);
//		return "redirect:user/cart";
		return "redirect:/user/cart";
	}
	
	@RequestMapping(value = "user/buy")
	public String purchaseitems(Principal principal)
	{
		String username = principal.getName();
	    ordersdao.addCarttoOrders(username);
	    return "redirect:/user/orders";
	}
	
	@RequestMapping(value = {"user/faq","emp/faq"})
	public ModelAndView faqfn (Principal principal) {
		ModelAndView mv=new ModelAndView();
//		mv.addObject("user_name",principal.getName());
		mv.addObject("user_role", accdao.getUserRole(principal.getName()));
		mv.addObject("pending_questions",pq.showPending_questions());
		mv.addObject("answered_questions",aq.showAns());
		mv.setViewName("faq"); 
		return mv;
		
	}
	
	@RequestMapping(value="/user/productform",method=RequestMethod.GET)
	public String productform(Model model) {
		System.out.println("reached productformfn()");
		model.addAttribute("product",new Productform());
		model.addAttribute("Companylist",supplierDao.getAllSupplierNames() );
		if (decider1==1) {
			model.addAttribute("error_message","Please enter valid input");
		}
		if(decider2==1)
			model.addAttribute("error_message2","Product not currently available");
		decider1=0;
		decider2=0;
		return "Newaddproductform";
	}	
	
	@RequestMapping(value = "/user/getproduct") //shows price,net price and availability 
	public ModelAndView addproduct(@ModelAttribute(value = "product") Productform product)
	{
		ModelAndView mv  = new ModelAndView();
		System.out.println("reached getproductfn()");
		 try {
			 product.getType();
		 }
		 catch(Exception e){
			 System.out.println("product is null");
		 }
			String type = product.getType();
			String size = product.getSize();
			String company = product.getCompany();
			int  quty= product.getQuantity();
		
		
		
		if(type.isEmpty() || type.isBlank() || size.isEmpty() || size.isBlank() || company.isBlank() || company.isEmpty())
		{
			decider1=1;
			mv.setViewName("redirect:/user/productform");
			return mv;
		}
		int qty = product.getQuantity();
		
		
		if(prod_dao.getProd(type, size, company)==null)
		{
			decider2=1;
			mv.setViewName("redirect:/user/productform");
			return mv;
		}
		Product pr=prod_dao.getProd(type, size, company);
		double price = pr.getPrice();
		price = Math.round(price*100)/100.0;
		double tprice = Math.round(price*100*qty)/100.0;
		
		if(qty>0)
		{
		
		mv.addObject("pid",pr.getP_id());
		mv.addObject("price",price);
		mv.addObject("tprice",tprice);
		mv.addObject("type",type);
		mv.addObject("company",company);
		mv.addObject("size",size);
		mv.addObject("qty",qty);
		System.out.println("mv has added objects!");
		}
		else
		{
			mv.addObject("error_message","please enter a valid quantity!");
		}
		mv.setViewName("productdetails");
		return mv;
		
	}
	
	@RequestMapping(value = "/user/addtocart" ,method=RequestMethod.GET)
	public String addtocart(Principal principal,@RequestParam("pid") String pid, @RequestParam("qty") int qty ){
		Cart cart = new Cart();
		cart.setP_id(pid);
		cart.setQty(qty);
		cart.setUsername(principal.getName());
		cartdao.addtoCart(cart);
		return "redirect:/user/productform";
	}
	
	@RequestMapping(value = "/user/ask_q", method = RequestMethod.GET)
	public String askq(Model model) {
		System.out.println("reached askqfn()");
		model.addAttribute("myquestion",new Stringholder());
		return "askqform";
	}
	
	
	
	@RequestMapping(value = "/user/add_q/", method = RequestMethod.POST)
	public ModelAndView addq(@ModelAttribute(value = "myquestion") Stringholder question ,BindingResult result) {
		System.out.println("reached addq()");
		pq.addPending_question(question.getMystring());
		ModelAndView mv = new ModelAndView();
		mv.addObject("q_done","true");
		mv.setViewName("askqform");
		return mv;
	}
	
	@RequestMapping(value = "user/expertadvice", method = RequestMethod.GET)
	public String expertadvice() {
		return "expertadvice";
	}
	
	
	
	@RequestMapping(value = "/user/color_comb/", method = RequestMethod.GET)
	public String colorform(Model model) {
		System.out.println("reached colorformfn()");
		model.addAttribute("mywallcolor",new Stringholder());
		if (decider4==1) {
			model.addAttribute("error_msg","Can't really say for that color. Please try some other..");
		}
		decider4=0;
		return "colorform";
	}
	
	
	
	@RequestMapping(value = "/user/colorforsubmit/", method = RequestMethod.POST)
	public ModelAndView mygetceilcolor(@ModelAttribute(value = "wallcolor") Stringholder wallcolor ,BindingResult result) {
		System.out.println("reached colorforsubmit()");
		
		ModelAndView mv = new ModelAndView();
		String s = coldao.getceilcolor(wallcolor.getMystring());
		if(s==null)
		{
			decider4=1;
			mv.setViewName("redirect:/user/color_comb/");
			return mv;
		}
		mv.addObject("ceilcolor",s);
		mv.addObject("wallcolor",wallcolor.getMystring());
		mv.setViewName("colorform");
		return mv;
	}
	
	@RequestMapping(value = "/user/areaform/", method = RequestMethod.GET)
	public String areaform(Model model) {
		System.out.println("reached areaformfn()");
		model.addAttribute("myareaholder",new Stringholder());
		if (decider4==1) {
			model.addAttribute("error_msg","Please enter a valid number in digits");
		}
		decider4=0;
		return "areaform";
	}
	
	
	
	@RequestMapping(value = "/user/materialprint/", method = RequestMethod.POST)
	public ModelAndView materialprinter(@ModelAttribute(value = "areaholder") Stringholder areaholder ,BindingResult result) {
		System.out.println("reached materialprint()");
		ModelAndView mv = new ModelAndView();
		try {
			Double.parseDouble(areaholder.getMystring());
	
		} catch (Exception e) {
			// TODO: handle exception
			decider4=1;
			mv.setViewName("redirect:/user/areaform/");
			return mv;
		}
		double area = Double.parseDouble(areaholder.getMystring());
		double putty = Math.round(area*0.09143*100) /100;
		double plaster = Math.round(area*0.118*100) /100;
		double paint = Math.round(area*0.0772*100) /100;
		
		mv.addObject("putty",putty);
		mv.addObject("plaster",plaster);
		mv.addObject("paint",paint);
		mv.addObject("area",area);
		mv.setViewName("areaform");
		return mv;
	}
	
}

class OrderComparator implements Comparator<Orderdisplay> {
    public int compare(Orderdisplay m1, Orderdisplay m2) {
       //possibly check for nulls to avoid NullPointerException
    	String sDate1=m1.getDate();
    	String sDate2=m2.getDate();
    	Date date1 = null;
    	Date date2= null;
		try {
			date1 = new SimpleDateFormat("dd/MM/yyyy hh:mm").parse(sDate1);
			date2 = new SimpleDateFormat("dd/MM/yyyy hh:mm").parse(sDate2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
//    	    System.out.println(sDate1+"\t"+date1);  
//    	    System.out.println(sDate2+"\t"+date2);
       return date2.compareTo(date1);
    }
}
	
	

