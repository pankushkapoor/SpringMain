package com.cg.mobilebilling.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.cg.mobilebilling.beans.Customer;
import com.cg.mobilebilling.beans.Plan;
import com.cg.mobilebilling.beans.PostpaidAccount;


@Controller
public class URIController {
	Customer customer;
	Plan plan;
	PostpaidAccount account;
		
	@RequestMapping("/")
	public String getIndexPage() {
		return "indexPage";
	}
	
	@RequestMapping("/registration")
	public String getRegistrationPage() {
		return "registrationPage";
	}
	@ModelAttribute
	public Customer getCustomer() {
		customer=new Customer();
		return customer;
	}
	@RequestMapping("/planRegistration")
	public String getPlanRegistrationPage() {
		return "planRegistrationPage";
	}
	@ModelAttribute
	public Plan getPlan() {
		plan=new Plan();
		return plan;
	}
	@ModelAttribute
	public PostpaidAccount getPostpaidAccount() {
		account=new PostpaidAccount();
		return account;
	}
}