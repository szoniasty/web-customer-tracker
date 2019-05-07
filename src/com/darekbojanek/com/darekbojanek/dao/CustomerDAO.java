package com.darekbojanek.com.darekbojanek.dao;

import com.darekbojanek.DBCustomer.Customer;

import java.util.List;

public interface CustomerDAO {
    List<Customer> getCustomers();
    List<Customer> getCustomers(String searchParam);

    void saveCustomer(Customer customer);

    Customer getCustomer(int id);

    void deleteCustomer(int id);
}
