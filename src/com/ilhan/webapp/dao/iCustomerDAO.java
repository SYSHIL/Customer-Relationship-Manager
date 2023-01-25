package com.ilhan.webapp.dao;

import java.util.List;

import com.ilhan.webapp.entity.Customer;

public interface iCustomerDAO {
	public List<Customer> getCustomers();
	public void saveCustomer(Customer theCustomer);
	public Customer getCustomer(int theId);
	public void deleteCustomer(int theId);
	
}
