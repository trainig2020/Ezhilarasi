package com.spring.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;

import com.spring.model.Employee;
import com.spring.service.EmployeeService;
import com.spring.service.EmployeeServiceImpl;

@Controller
public class EmployeeController {
	
	@Autowired
	 private EmployeeService employeeService = new EmployeeServiceImpl();
	 
	 @RequestMapping(value = "list", method=RequestMethod.GET)
	    public String listEmployee(Model model) throws IOException {
	        List<Employee> listEmployee = employeeService.getAllEmployees();
	        model.addAttribute("listEmployee", listEmployee);
	        
	        return "listEmployees";
	    }
	 
	 @RequestMapping("showForm")
	    public String showFormForAdd(Model theModel) {
	        Employee employee = new Employee();
	        theModel.addAttribute("employee", employee);
	        return "employeeForm";
	    }

	 @RequestMapping(value = "save", method = RequestMethod.POST)
	    public ModelAndView saveCustomer(@Valid @ModelAttribute("employee") Employee employee,BindingResult result){
		 if(result.hasErrors()){
				ModelAndView modelAndView = new ModelAndView("employeeForm");
				
				return modelAndView;
		 }
		 else{
		 employeeService.insertEmployee(employee);
	        return new ModelAndView("redirect:/list");
	    }
	 }
	 
	 @RequestMapping(value="update/{empId}",method = RequestMethod.GET)
	    public String updateEmployee(@PathVariable("empId") int id,Model theModel) {
	        Employee employee = employeeService.getEmployees(id);
	        theModel.addAttribute("employee", employee);
	        return "employeeForm";
	    }
	 @RequestMapping(value = "/delete", method = RequestMethod.GET)
		public ModelAndView deleteEmployee(HttpServletRequest request) {
			int employeeId = Integer.parseInt(request.getParameter("empId"));
			employeeService.deleteEmployee(employeeId);
			return new ModelAndView("redirect:/list");
		}

}
