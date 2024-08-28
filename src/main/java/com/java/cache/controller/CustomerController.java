package com.java.cache.controller;

import com.java.cache.Customer;
import com.java.cache.service.CustomerService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Resource
    CustomerService customerService;

    @GetMapping("customer/{id}")
    public Customer getCustomer(@PathVariable String id){
        return customerService.getCustomerById(id);
    }
}
