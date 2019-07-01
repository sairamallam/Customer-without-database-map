package com.customerapp;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.customerapp.model.CustomerDetails;
import com.customerapp.service.CustomerServiceImpl;


@RunWith(SpringRunner.class)
//@SpringBootTest
public class CustomerServiceTest {

	@InjectMocks CustomerServiceImpl customerServiceImpl;
	
	public  Map<Integer,CustomerDetails> mapcustomer ;
	
	@MockBean
	CustomerDetails customerDetails;
	
	@Before
	public void init() {
		customerDetails=new CustomerDetails();
		customerDetails.setId(1);
		customerDetails.setName("guru");
		customerDetails.setPhone(999999);
		customerDetails.setRole("SW");
		
		mapcustomer =new HashMap<>();
		mapcustomer.put(customerDetails.getId(), customerDetails);
		
	}
	
	@Test
	public void addCustomerTest() {
		
		assertEquals(customerServiceImpl.addCustomer(customerDetails), mapcustomer);
		
	}
	
	/*
	 * @Test public void updateCustomerTest() {
	 * 
	 * assertEquals(customerServiceImpl.updateCustomer(customerDetails),
	 * customerDetails);
	 * 
	 * }
	 * 
	 * 
	 * @Test public void deleteCustomerTest() {
	 * 
	 * assertEquals(customerServiceImpl.addCustomer(customerDetails), mapcustomer);
	 * 
	 * }
	 */
	
	
	
}
