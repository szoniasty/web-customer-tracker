package com.darekbojanek.com.darekbojanek.service;

import com.darekbojanek.DBCustomer.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getCustomers();
    List<Customer> getCustomers(String searchParam);

    void saveCustomer(Customer customer);

    Customer getCustomer(int id);

    void deleteCustomer(int id);

}
