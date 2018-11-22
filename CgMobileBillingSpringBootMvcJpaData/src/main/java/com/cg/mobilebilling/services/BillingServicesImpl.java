package com.cg.mobilebilling.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cg.mobilebilling.beans.Address;
import com.cg.mobilebilling.beans.Bill;
import com.cg.mobilebilling.beans.Customer;
import com.cg.mobilebilling.beans.Plan;
import com.cg.mobilebilling.beans.PostpaidAccount;
import com.cg.mobilebilling.daoservices.BillingDAOServices;
import com.cg.mobilebilling.daoservices.CustomerDAO;
import com.cg.mobilebilling.daoservices.PlanDAO;
import com.cg.mobilebilling.daoservices.PostpaidAccountDAO;
import com.cg.mobilebilling.exceptions.BillDetailsNotFoundException;
import com.cg.mobilebilling.exceptions.BillingServicesDownException;
import com.cg.mobilebilling.exceptions.CustomerDetailsNotFoundException;
import com.cg.mobilebilling.exceptions.InvalidBillMonthException;
import com.cg.mobilebilling.exceptions.PlanDetailsNotFoundException;
import com.cg.mobilebilling.exceptions.PostpaidAccountNotFoundException;

@Component("service")
public class BillingServicesImpl implements BillingServices {

	@Autowired
	BillingDAOServices billingDAOServices;
	@Autowired
	PlanDAO planDAO;
	@Autowired
	CustomerDAO customerDAO;
	@Autowired
	PostpaidAccountDAO postpaidAccountDAO;

	@Override
	public List<Plan> getPlanAllDetails() throws BillingServicesDownException {
		List<Plan> planList = planDAO.findAll();
		return planList;
	}

	@Override
	public int acceptCustomerDetails(String firstName, String lastName, String emailID, String dateOfBirth,
			String billingAddressCity, String billingAddressState, int billingAddressPinCode)
					throws BillingServicesDownException {

		Customer customer = new Customer(firstName, lastName, emailID, dateOfBirth, 
				new Address(billingAddressPinCode, billingAddressCity, billingAddressState));
		customer = customerDAO.save(customer);
		return customer.getCustomerID();
	}

	@Override
	public long openPostpaidMobileAccount(int customerID, int planID)
			throws PlanDetailsNotFoundException, CustomerDetailsNotFoundException, BillingServicesDownException {

		Plan plan1 = new Plan(147, 250, 200, 150, 500, 500, 1024, 1.0f, 1.50f, 1.0f, 2.0f, 0.10f, "GOA", "G250");
		plan1= planDAO.save(plan1);
		Plan plan2 = new Plan(158, 350, 400, 300, 1000, 800, 2048, 1.0f, 1.50f, 1.0f, 2.0f, 0.10f, "GOA", "G350");
		plan2 = planDAO.save(plan2);

		PostpaidAccount account = new PostpaidAccount();
		account.setPlan(planDAO.findById(planID).get());
		account.setCustomer(customerDAO.findById(customerID).get());
		PostpaidAccount postpaidAccount = postpaidAccountDAO.save(account);
		return postpaidAccount.getMobileNo();
	}

	@Override
	public int generateMonthlyMobileBill(int customerID, long mobileNo, String billMonth, int noOfLocalSMS,
			int noOfStdSMS, int noOfLocalCalls, int noOfStdCalls, int internetDataUsageUnits)
					throws CustomerDetailsNotFoundException, PostpaidAccountNotFoundException, InvalidBillMonthException,
					BillingServicesDownException, PlanDetailsNotFoundException {

		//Bill bill1 = new Bill(postpaidAccountDAO.findOne(mobileNo)., 50, 50, 50, 50, 1024, 1, 2.5f, 2.5f);
		
		return 0;
	}

	@Override
	public Customer getCustomerDetails(int customerID)
			throws CustomerDetailsNotFoundException, BillingServicesDownException {
		Customer customer = customerDAO.findById(customerID).get();
		return customer;
	}

	@Override
	public List<Customer> getAllCustomerDetails() throws BillingServicesDownException {
		List<Customer> customers = customerDAO.findAll();
		return customers;
	}

	@Override
	public PostpaidAccount getPostPaidAccountDetails(int customerID, long mobileNo)
			throws CustomerDetailsNotFoundException, PostpaidAccountNotFoundException, BillingServicesDownException {
		PostpaidAccount account = postpaidAccountDAO.findById(mobileNo).get();

		return account;
	}

	@Override
	public List<PostpaidAccount> getCustomerAllPostpaidAccountsDetails(int customerID)
			throws CustomerDetailsNotFoundException, BillingServicesDownException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bill getMobileBillDetails(int customerID, long mobileNo, String billMonth)
			throws CustomerDetailsNotFoundException, PostpaidAccountNotFoundException, InvalidBillMonthException,
			BillDetailsNotFoundException, BillingServicesDownException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bill> getCustomerPostPaidAccountAllBillDetails(int customerID, long mobileNo)
			throws CustomerDetailsNotFoundException, PostpaidAccountNotFoundException, BillingServicesDownException,
			BillDetailsNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean changePlan(int customerID, long mobileNo, int planID) throws CustomerDetailsNotFoundException,
	PostpaidAccountNotFoundException, PlanDetailsNotFoundException, BillingServicesDownException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean closeCustomerPostPaidAccount(int customerID, long mobileNo)
			throws CustomerDetailsNotFoundException, PostpaidAccountNotFoundException, BillingServicesDownException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCustomer(int customerID)
			throws BillingServicesDownException, CustomerDetailsNotFoundException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Plan getCustomerPostPaidAccountPlanDetails(int customerID, long mobileNo)
			throws CustomerDetailsNotFoundException, PostpaidAccountNotFoundException, BillingServicesDownException,
			PlanDetailsNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}



}