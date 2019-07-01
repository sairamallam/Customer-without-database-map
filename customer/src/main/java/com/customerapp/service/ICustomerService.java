package com.customerapp.service;

import java.util.List;
import java.util.Map;

import com.customerapp.model.CustomerDetails;

public interface ICustomerService {

	
	public Map addCustomer(CustomerDetails customerDetails);
	public CustomerDetails updateCustomer(CustomerDetails customerDetails);
	public Map<Integer, CustomerDetails> deleteCustomer(int customerId);
	public CustomerDetails searchCustomer(int customerId);
	}
