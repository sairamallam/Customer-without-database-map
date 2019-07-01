package com.customerapp.service;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.customerapp.dto.CustomerDetailsDto;
import com.customerapp.exception.CustmoreDetailsNotFound;
import com.customerapp.exception.ResponseDto;
import com.customerapp.model.CustomerDetails;

@Service
public class CustomerServiceImpl implements ICustomerService{
	
	Map<Integer,CustomerDetails> mapcustomer = new HashMap<Integer,CustomerDetails>();

	public CustomerServiceImpl()
	{
		ReadJsonData readJsonData = new ReadJsonData();
		try {
			mapcustomer = readJsonData.jsonToMap();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Map<Integer,CustomerDetails> addCustomer(CustomerDetails customerDetails) {

		if(mapcustomer.get(customerDetails.getId())==null) {
		mapcustomer.put(customerDetails.getId(), customerDetails);
		return mapcustomer;
		}else {
			throw new CustmoreDetailsNotFound(customerDetails.getId()+" already added");
		}
	}

	@Override
	public CustomerDetails updateCustomer(CustomerDetailsDto customerDetailsdto) {

		CustomerDetails customerDetails2 = mapcustomer.get(customerDetailsdto.getId());
		if(customerDetails2!=null) {
			if(customerDetailsdto.getName()!=null)
				customerDetails2.setName(customerDetailsdto.getName());
			if(customerDetailsdto.getPhone()!=0)
				customerDetails2.setPhone(customerDetailsdto.getPhone());
			if(customerDetailsdto.getRole()!=null)
				customerDetails2.setRole(customerDetailsdto.getRole());
			
			mapcustomer.replace(customerDetailsdto.getId(), customerDetails2);
			return mapcustomer.get(customerDetailsdto.getId());

		}else {
			throw new CustmoreDetailsNotFound(customerDetailsdto.getId()+" customer details NotFound");

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
