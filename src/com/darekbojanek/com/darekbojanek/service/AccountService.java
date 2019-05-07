package com.darekbojanek.com.darekbojanek.service;

import com.darekbojanek.com.darekbojanek.dao.AccountDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService implements IAccountService {
    private AccountDAO accountDAO;

    public AccountService() {
    }

    @Autowired
    public AccountService(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    @Transactional
    public void addAccount() {
        accountDAO.addAccount();
    }

    @Override
    public void printMe() {
        System.out.println("Hi there fella!");
    }
}
