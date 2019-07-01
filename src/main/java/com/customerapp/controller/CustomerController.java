package com.customerapp.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customerapp.dto.CustomerDetailsDto;
import com.customerapp.model.CustomerDetails;
import com.customerapp.service.ICustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired ICustomerService iCustomerService;
	
	@PostMapping("/add")
	public Map addCustomer(@RequestBody CustomerDetails customerDetails) {
		return iCustomerService.addCustomer(customerDetails);
	}
	
	@PostMapping("/update")
	public CustomerDetails updateCustomer(@RequestBody CustomerDetailsDto customerDetailsdto) {
		return iCustomerService.updateCustomer(customerDetailsdto);
	}
	
	@DeleteMapping("/delete/{customerId}")
	public Map deleteCustomer(@PathVariable("customerId") int customerId) {
		return iCustomerService.deleteCustomer(customerId);
	}
	
	@GetMapping("/search/{customerId}/")
	public CustomerDetails searchCustomer(@PathVariable("customerId") int customerId)
	{
		return iCustomerService.searchCustomer(customerId);
	}

}
