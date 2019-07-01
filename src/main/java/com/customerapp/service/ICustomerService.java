package com.customerapp.service;

import java.util.Map;
import com.customerapp.dto.CustomerDetailsDto;
import com.customerapp.model.CustomerDetails;

public interface ICustomerService {

	
	public Map addCustomer(CustomerDetails customerDetails);
	public CustomerDetails updateCustomer(CustomerDetailsDto customerDetailsdto);
	public Map<Integer, CustomerDetails> deleteCustomer(int customerId);
	public CustomerDetails searchCustomer(int customerId);
	}
