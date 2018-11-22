package com.cg.mobilebilling.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cg.mobilebilling.beans.Customer;
import com.cg.mobilebilling.beans.Plan;
import com.cg.mobilebilling.beans.PostpaidAccount;
import com.cg.mobilebilling.daoservices.PostpaidAccountDAO;
import com.cg.mobilebilling.exceptions.BillingServicesDownException;
import com.cg.mobilebilling.exceptions.CustomerDetailsNotFoundException;
import com.cg.mobilebilling.exceptions.PlanDetailsNotFoundException;
import com.cg.mobilebilling.exceptions.PostpaidAccountNotFoundException;
import com.cg.mobilebilling.services.BillingServices;

@Controller
public class CustomerController {
	@Autowired 
	BillingServices service;
	Customer cust;
	PostpaidAccount account;
	
	@RequestMapping("/registerCustomer")
	public ModelAndView registerCustomerAction(@ModelAttribute Customer customer) throws BillingServicesDownException {
		
		int customerID=	service.acceptCustomerDetails(customer.getFirstName(), customer.getLastName(), customer.getEmailID(),customer.getDateOfBirth(),customer.getBillingAddress().getCity(), customer.getBillingAddress().getState(), customer.getBillingAddress().getPinCode());
		cust = customer;
		cust.setCustomerID(customerID);
		return new ModelAndView("registrationSuccessPage", "customer", customer);
	}
	
	@RequestMapping("/registerPlan")
	public ModelAndView registerPlanAction(@ModelAttribute Plan plan) throws BillingServicesDownException, PlanDetailsNotFoundException, CustomerDetailsNotFoundException, PostpaidAccountNotFoundException {
		long mobileNo = service.openPostpaidMobileAccount(cust.getCustomerID(), plan.getPlanID());
		account = service.getPostPaidAccountDetails(cust.getCustomerID(), mobileNo);
		System.out.println(account);
		return new ModelAndView("planRegistrationSuccessPage", "account", service.getPostPaidAccountDetails(cust.getCustomerID(), mobileNo));
		
			
	}
	
}
