package com.demo.demo01.controller;

import com.demo.demo01.entity.Customer;
import com.demo.demo01.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping
    public List<Customer> hello() {
        return customerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Customer getOne(@PathVariable("id") Long id) {
        return customerRepository.findById(id).orElseGet(Customer::new);
    }

    @GetMapping("/new/{name}")
    public Customer save(@PathVariable("name") String name) {
        return customerRepository.save(new Customer(name));
    }
}
