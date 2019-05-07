package com.darekbojanek.com.darekbojanek.dao;

import com.darekbojanek.DBCustomer.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {
        Session session = sessionFactory.getCurrentSession();
        Query<Customer> customerQuery = session.createQuery("from Customer order by firstName asc ", Customer.class);

        return customerQuery.getResultList();
    }

    @Override
    public List<Customer> getCustomers(String searchParam) {
        Session session = sessionFactory.getCurrentSession();
        String hqlQuery = "from Customer c where lower(c.firstName) like '" + searchParam.toLowerCase() + "%' or lower(c.lastName) like '" + searchParam.toLowerCase() + "%'";
        return session.createQuery(hqlQuery, Customer.class).list();
    }

    @Override
    public void saveCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(customer);
    }

    @Override
    public Customer getCustomer(int id) {
        Session session = sessionFactory.getCurrentSession();
        Customer customer = session.get(Customer.class, id);
        return customer;
    }

    @Override
    public void deleteCustomer(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(session.get(Customer.class, id));
    }
}
