package com.customerapp.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.customerapp.exception.CustmoreDetailsNotFound;
import com.customerapp.model.CustomerDetails;


@Service
public class CustomerServiceImpl implements ICustomerService{
	
	public static Map<Integer,CustomerDetails> mapcustomer =new HashMap<>();

	
	
	@Override
	public Map<Integer, CustomerDetails> addCustomer(CustomerDetails customerDetails) {

		if(mapcustomer.get(customerDetails.getId())==null) {
		mapcustomer.put(customerDetails.getId(), customerDetails);
		return mapcustomer;
		}else {
			throw new CustmoreDetailsNotFound(customerDetails.getId()+" already added");

		}
	}

	@Override
	public CustomerDetails updateCustomer(CustomerDetails customerDetails) {

		CustomerDetails customerDetails2 = mapcustomer.get(customerDetails.getId());
		if(customerDetails2!=null) {
			mapcustomer.replace(customerDetails.getId(), customerDetails);
			return mapcustomer.get(customerDetails.getId());

		}else {
			throw new CustmoreDetailsNotFound(customerDetails.getId()+" customer details NotFound");

		}
	}
	
	@Override
	public Map<Integer, CustomerDetails> deleteCustomer(int customerId) {

		CustomerDetails customerDetails2 = mapcustomer.get(customerId);
		if(customerDetails2!=null) {
			mapcustomer.remove(customerId);
			return mapcustomer;

		}else {
			throw new CustmoreDetailsNotFound(customerId+" customer details NotFound");
		}
	}

	@Override
	public CustomerDetails searchCustomer(int customerId) {

		CustomerDetails customerDetails2 = mapcustomer.get(customerId);
		if(customerDetails2!=null) {
			
			return customerDetails2;

		}else {
			throw new CustmoreDetailsNotFound(customerId+" customer details NotFound");
		}
	}
}
