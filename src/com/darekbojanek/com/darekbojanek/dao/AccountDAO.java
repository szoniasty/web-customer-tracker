package com.darekbojanek.com.darekbojanek.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAO implements IAccountDAO {
//    @Autowired
//    private SessionFactory sessionFactory;

    @Override
    public void addAccount() {
        System.out.println("Adding: " + getClass());
    }
}
