package com.darekbojanek.com.darekbojanek;

import com.darekbojanek.com.darekbojanek.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args) {
        //read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        //get the bean from the spring container
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        //call the business method
        accountDAO.addAccount();
        //close the context
        context.close();
    }
}
