package com.academy.service;

import com.academy.entity.Customer;
import com.academy.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.management.MalformedObjectNameException;
import java.util.List;

@Service
public class CustomerService {

    @Autowired //automatically chooses which instance to use
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerValidator validator;


    public List<Customer> fetchCustomers() {
        return customerRepository.findAll();
    }

    public void insertCustomer(@RequestBody Customer customer) throws MalformedObjectNameException {
        //customer = capitaliseFirstLetter(customer);

        validator.validate(customer);
        Customer formattedCustomer = new Customer.Builder
                        (capitaliseFirstLetter(customer.getFirstName()),
                        capitaliseFirstLetter(customer.getLastName()),
                        personalNumberWithDash(customer.getPersonalNumber()))
                .withAge(customer.getAge())
                .withCountryCode(customer.getCountryCode())
                .withMaritalStatus(customer.getMaritalStatus()).
                withMiddleName(customer.getMiddleName()).build();


        customerRepository.insert(formattedCustomer);
    }

    public void deleteCustomer(@PathVariable String customerId) {
        customerRepository.deleteById(customerId);
    }

    public String capitaliseFirstLetter(String name) {
        // if (!customer.getFirstName().isEmpty()) {
        String firstLetterFirstName = name.substring(0, 1).toUpperCase();
        String restOfNameFirst = name.substring(1);

        // }
        //if (!customer.getLastName().isEmpty()) {

        // }

        //or customer.setFirstName(String.valueOf(customer.getFirstName().charAt(0)).toUpperCase()
        //+ String.valueOf(customer.getFirstName().substring(1)
        return firstLetterFirstName + restOfNameFirst;

    }
//    public Customer capitaliseFirstLetterLastName(Customer customer) {
//        // if (!customer.getFirstName().isEmpty()) {
//
//        String firstLetterLastName = customer.getLastName().substring(0, 1).toUpperCase();
//        String restOfNameLast = customer.getLastName().substring(1);
//        customer.setLastName(firstLetterLastName + restOfNameLast);
//        // }
//
//        //or customer.setFirstName(String.valueOf(customer.getFirstName().charAt(0)).toUpperCase()
//        //+ String.valueOf(customer.getFirstName().substring(1)
//        return customer;
//
//    }

    public String personalNumberWithDash(String number) {
        if (number.length() > 4) {
            number = number.substring(0, 4) + "-"
                    + number.substring(4);

        }
        return number;
    }
}
