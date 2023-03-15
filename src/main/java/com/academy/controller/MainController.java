package com.academy.controller;

import com.academy.entity.Customer;
import com.academy.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import javax.management.MalformedObjectNameException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {

    //    @Autowired //automatically chooses which instance to use
    //    private CustomerRepository customerRepository;
    private CustomerService customerService;

    public MainController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping("/customer/all")
    public List<Customer> fetchCustomers() {
        return customerService.fetchCustomers();
    }

    @PostMapping("/customer/insert")
    public void insertCustomer(@RequestBody Customer customer) throws MalformedObjectNameException {
        customerService.insertCustomer(customer);
    }

    @DeleteMapping("/customer/delete/{customerId}")
    public void deleteCustomer(@PathVariable String customerId) {
        customerService.deleteCustomer(customerId);
    }
}