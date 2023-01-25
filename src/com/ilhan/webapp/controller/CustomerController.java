package com.ilhan.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;
import com.ilhan.webapp.dao.CustomerDAO;
import com.ilhan.webapp.dao.iCustomerDAO;
import com.ilhan.webapp.entity.*;
import com.ilhan.webapp.service.iCustomerService;
@Controller
@RequestMapping("/customer")
public class CustomerController {
	// inject the customer dao
	@Autowired
	private iCustomerService customerService;
	// spring will scan for a component that implements customerDAO interface
	
	@GetMapping("/")
	public String hello() {
		return "hello";
	}

	@RequestMapping("/list")
	public String listCustomers(Model theModel) {
		// get customers from dao
		List<Customer> customers = customerService.getCustomers();
		// add customers to model
		theModel.addAttribute("customers",customers);
		return "list-customers";
	}
	
	@GetMapping("/addCustomerForm")
	public String  addCustomerForm(Model theModel) {
		Customer theCustomer = new Customer();
		theModel.addAttribute("customer",theCustomer);
		return "customer-form";
	}
	@PostMapping("saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		customerService.saveCustomer(theCustomer);
		return "redirect:/customer/list";
	}
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId")int theId, Model theModel) {
		// get the customer from database
		Customer theCustomer = customerService.getCustomer(theId);
		theModel.addAttribute("customer",theCustomer);
		return "customer-form";
	}
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId") int theId) {
		customerService.deleteCustomer(theId);
		return "redirect:/customer/list";
	}
}
