package com.ilhan.webapp.service;

import java.util.List;

import com.ilhan.webapp.entity.Customer;

public interface iCustomerService {
	public List<Customer> getCustomers();
	public void saveCustomer(Customer theCustomer);
	public Customer getCustomer(int theId);
	public void deleteCustomer(int theId);
}
