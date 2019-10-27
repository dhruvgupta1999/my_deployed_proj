package log.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import log.springmvc.dao.AccountDao;
import log.springmvc.dao.Answered_questionDao;
import log.springmvc.dao.CartDao;
import log.springmvc.dao.CustomerDao;
import log.springmvc.dao.OrdersDao;
import log.springmvc.dao.Pending_QuestionDao;
import log.springmvc.dao.ProductDao;
import log.springmvc.dao.SupplierDao;
import log.springmvc.model.Accounts;
import log.springmvc.model.Answered_question;
import log.springmvc.model.Employee;
import log.springmvc.model.PendingOrderdisplay;
import log.springmvc.model.Product;
import log.springmvc.model.Productform;

@Controller
public class EmpController {
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
	
	
	public Accounts acc;
	@Autowired
	SupplierDao supplierDao;
	
	public Employee emp;
	
	int x=0;
	int decider1 =0;
	int decider2=0;
	int decider3=0;
	
	@RequestMapping(value = "/emp/ans_q/{Q_id}")
	public String answercreatefn(@PathVariable(value="Q_id") int Q_id,@RequestParam("Answer") String answer) {
		String question = pq.q_details(Q_id).getQuestion();
		pq.delPending_question(Q_id);
		Answered_question obj = new Answered_question();
		obj.setQuestion(question);
		obj.setAnswer(answer);
		aq.addAns(obj);
		return "redirect:/emp/faq";
		
	}
	@RequestMapping(value = "/emp/del_q/{Q_id}")
	public String delpendingfn(@PathVariable(value="Q_id") int Q_id) {
		pq.delPending_question(Q_id);
		return "redirect:/emp/faq";
		
	}
	
	@RequestMapping(value="/emp/addproduct")
	public String empproductform(Model model) {
		System.out.println("reached empproductformfn()");
		model.addAttribute("product",new Product());
		model.addAttribute("update_iter",x);
		x=0;
		model.addAttribute("Companylist",supplierDao.getAllSupplierNames() );
		if (decider1==1) {
			model.addAttribute("error_message","Please enter valid input");
		}
		if(decider2==1)
			model.addAttribute("error_message2","Please enter a valid price using decimal digits");
		decider1=0;
		decider2=0;
		return "empproductform";
	}
	
	@RequestMapping(value = "/emp/addproductprocess") //shows price,net price and availability 
	public String addproduct(@ModelAttribute(value = "product") Product product)
	{
		
		String P_id = product.getP_id();
		String type = product.getType();
		String size = product.getSize();
		String company = product.getCompany();
		if( P_id.isEmpty() || type.isEmpty() || size.isEmpty() || company.isEmpty())
		{
			decider1=1;
			return "redirect:/emp/addproduct";
		}
		if(product.getPrice()<0.1)
		{
			decider2=1;
			return "redirect:/emp/addproduct";
		}
		prod_dao.addProduct(product);
		x=1;
		return "redirect:/emp/addproduct";
	}
	
	@RequestMapping(value = "/emp/pendingorders")
	public ModelAndView getpendingorders()
	{
		ModelAndView mv = new ModelAndView();
		List<PendingOrderdisplay> pv =  ordersdao.showPendingOrders();
		
		mv.addObject("pending_orders", ordersdao.showPendingOrders());
		mv.setViewName("pendingorders");
		return mv;
	}
	
	@RequestMapping(value="/emp/setorderstatus/{ord_id}")
	public String setorderstatus(@PathVariable("ord_id") int ord_id)
	{
		ordersdao.setOrderstatustocompleted(ord_id);
		return "redirect:/emp/pendingorders";
	}
	
}
