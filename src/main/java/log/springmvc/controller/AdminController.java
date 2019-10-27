package log.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import log.springmvc.dao.CustomerDao;
import log.springmvc.dao.EmployeeDao;
import log.springmvc.dao.OrdersDao;
import log.springmvc.dao.Pending_QuestionDao;
import log.springmvc.dao.ProductDao;
import log.springmvc.dao.SupplierDao;
import log.springmvc.model.Accounts;
import log.springmvc.model.Customer;
import log.springmvc.model.Employee;
import log.springmvc.model.Stringholder;
import log.springmvc.model.Supplier;

@Controller
public class AdminController {
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
    CustomerDao custdao;
	
	@Autowired
	EmployeeDao empdao;
	
	@Autowired
	ProductDao prod_dao;
	
	@Autowired
	SupplierDao supplierdao;
	
	int decider_1 =0;
	int decider1=0;
	int decider2=0;
	int decider3=0;
	int decider4=0;
	
	@RequestMapping(value= {"/admin/custdetails","admin/custdetails","/log/admin/custdetails"},method=RequestMethod.GET)
	public ModelAndView customerdetails()
	{
		System.out.println("reached customerdetails()");
		ModelAndView mv = new ModelAndView();
		List<Customer> c = custdao.getallcustomers();
		System.out.println(c.get(0).getEmail());
		System.out.println(c.get(0).getName());
		mv.addObject("customers", c) ;
		mv.setViewName("customerdetails");
		return mv;
	}
	@RequestMapping(value="admin/empdetails")
	public ModelAndView employeedetails()
	{
		System.out.println("reached employeedetails()");
		ModelAndView mv = new ModelAndView();
		mv.addObject("employees", empdao.showEmployee() ) ;
		mv.setViewName("employeedetails");
		return mv;
	}
	
	@RequestMapping(value="admin/newempsalary/{username}")
	public String updateempsalary(@PathVariable(value="username") String username,@RequestParam("newsalary") String newsalary )
	{
		System.out.println("reached updateemployeesalary()");
		System.out.println("newsalary"+newsalary);
		int salary = Integer.parseInt( newsalary );
		empdao.updateempsalary(username, salary);
		return "redirect:/admin/empdetails";
	}
	
	@RequestMapping(value="admin/registeremp",method=RequestMethod.GET)
	public String register(Model model) {
		System.out.println("reached registerempfn()");
		model.addAttribute("user",new Employee());
		if(decider1==1)
			model.addAttribute("msg","please enter valid entry");
		if(decider2==1)
			model.addAttribute("new_msg","phone no. should be a number");
		if(decider4==1)
			model.addAttribute("new_msg_1","Enter valid salary using digits");
		if(decider3==1)
			model.addAttribute("user_error","that username is already taken.");
		if(decider_1==1)
		{
			model.addAttribute("num_reg",1);
		}
		System.out.println("decider1 is"+decider1);
		System.out.println("decider2 is"+decider2);
		System.out.println("decider3 is"+decider3);
		System.out.println("decider4 is"+decider4);
		System.out.println("decider_1 is"+decider_1);
		decider1=0;
		decider2=0;
		decider3=0;
		decider4=0;
		decider_1=0;
		return "registeremp";
	}
	
	@RequestMapping(value="/admin/empregisterprocess",method=RequestMethod.POST)
	public String registerprocess(@ModelAttribute(value = "user") Employee e,BindingResult result) {
		
		System.out.println("reached empregisterprocess()");
		Employee cust = e;
		if(cust.getAddress().isEmpty() || cust.getName().isEmpty() || cust.getPhone().isEmpty() || cust.getUsername().isEmpty() || cust.getSalary().isEmpty() || cust.getAddress().isBlank() || cust.getName().isBlank() || cust.getUsername().isBlank() ||cust.getPassword().isBlank() || cust.getSalary().isBlank())
		{   decider1=1;
		return "redirect:/admin/registeremp";
		
		}
		try {
			Integer.parseInt(cust.getPhone());
			
		} catch (Exception e1) {
			// TODO: handle exception
			decider2=1;
			return "redirect:/admin/registeremp";
		}
		try {
            Integer.parseInt(cust.getSalary());
		} catch (Exception e2) {
			// TODO: handle exception
			decider4=1;
			return "redirect:/admin/registeremp";
		}
		if(decider1==1 || decider2==1 || decider4==1)
			return "redirect:/register";
		if(accdao.validateEmployee(cust.getUsername())!=null )
		{
			decider3=1;
			return "redirect:/admin/registeremp";
		}
		Accounts acc  = new Accounts();
		acc.setUsername(e.getUsername());
		acc.setPassword(e.getPassword());
		acc.setUserRole("ROLE_EMP");
        accdao.registerAcc(acc);
        empdao.addemp(e);
        decider_1=1;
        return "redirect:/admin/registeremp";
	}
	
	@RequestMapping(value="/admin/showsupplierdetails")
	public ModelAndView ShowSupplierDetails()
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("supplierdetails", supplierdao.getAllSupplierDetails());
		mv.setViewName("supplierdetails");
		return mv;
	}
	
	@RequestMapping(value="admin/addsupplier",method=RequestMethod.GET)
	public String registersupplier(Model model) {
		System.out.println("reached registersupplierfn()");
		model.addAttribute("supplier",new Supplier());
		if(decider1==1)
			model.addAttribute("msg","please enter valid entry");
		
		decider1=0;
		
		return "addnewsupplierform";
	}
	
	@RequestMapping(value="/admin/registersupplierprocess",method=RequestMethod.POST)
	public String registersupplierprocess(@ModelAttribute(value = "supplier") Supplier supplier,BindingResult result) {
		
		System.out.println("reached empregistersupplierprocess()");
		Supplier cust = supplier;
		if(cust.getLocation().isEmpty() || cust.getComp_id().isEmpty() || cust.getCompany().isEmpty() || cust.getLocation().isBlank() || cust.getCompany().isBlank() || cust.getComp_id().isBlank() )
		{  
			decider1=1;
		return "redirect:/admin/addsupplier";
		}
		
		supplierdao.addSupplier(supplier);
       
        return "redirect:/";
	}
	

}
