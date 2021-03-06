
package com.test;

import org.junit.jupiter.api.Test;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;

import com.cg.go.entity.Address;
import com.cg.go.entity.Customer;
import com.cg.go.service.CustomerServiceImpl;
import com.cg.go.service.ICustomerService;
import com.cg.go.util.JpaUtil;

public class CustomerTest {
	
	@Test
	public void testAddCustomer() {
		ICustomerService customerService=new CustomerServiceImpl();
		Address address=new Address(11,6,"bankcolony", "wgl", "wgl","Telangana",506002);
		Customer customerEntity=new Customer(10,"Aravind","8179563708","thon@gmail.com",address,"retailer");
		Customer customer=customerService.addCustomer(customerEntity);
		Assertions.assertEquals(10,customer.getCustomerId());
		Assertions.assertEquals("Aravind",customer.getCustomerName());
		Assertions.assertEquals("8179563708",customer.getMobileNo());
		Assertions.assertEquals("Arvi@gmail.com",customer.getEmail());
		Assertions.assertEquals(address,customer.getAddress());
		Assertions.assertEquals("retailer",customer.getRole());
		
	}
	
	
	@Test
	public void testUpdateCustomer() {
		ICustomerService customerService=new CustomerServiceImpl();
		Address address=new Address(11,6,"bankcolony", "wgl", "wgl","Telangana",506002);
		Customer customerEntity=new Customer(10,"naresh","8179563708","thon@gmail.com",address,"retailer");
		Customer customer=customerService.addCustomer(customerEntity);
		customerEntity.setCustomerName("Suresh");
		customerEntity.setRole("Sales Representive");
		customer=customerService.updateCustomer(customerEntity);
		Assertions.assertEquals(10,customer.getCustomerId());
		Assertions.assertEquals("Suresh",customer.getCustomerName());
		Assertions.assertEquals("Sales Representive",customer.getRole());
		
	}
	
	 @AfterAll
	    static void close() {
	        JpaUtil util = JpaUtil.getInstance();
	        util.close();
	    }
}
