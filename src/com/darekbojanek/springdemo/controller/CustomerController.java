package com.darekbojanek.springdemo.controller;

import com.darekbojanek.DBCustomer.Customer;
import com.darekbojanek.com.darekbojanek.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
//@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model model) {
        model.addAttribute("customers", customerService.getCustomers());
        return "list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.saveCustomer(customer);
        return "redirect:/list";
    }

    @GetMapping("/showFormForUpdate")
    public String updateCustomer(@RequestParam("customerId") int id, Model model) {
        Customer customer = customerService.getCustomer(id);
        model.addAttribute("customer", customer);
        return "customer-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int id) {
        customerService.deleteCustomer(id);
        return "redirect:/list";
    }

    @GetMapping("/showFormForSearch")
    public String searchCustomers(Model model, @RequestParam("searchParam") String searchParam) {
        if(searchParam == null || searchParam.trim().length() == 0) {
//            model.addAttribute("customers", customerService.getCustomers());
            listCustomers(model);
        }
        else {
            model.addAttribute("customers", customerService.getCustomers(searchParam));
        }
        return "list-customers";
    }
}
