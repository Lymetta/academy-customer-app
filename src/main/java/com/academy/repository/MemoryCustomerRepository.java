package com.academy.repository;

import com.academy.entity.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository //spring finds this repository by this annotation
public class MemoryCustomerRepository implements CustomerRepository{
    static final List<Customer> customers = new ArrayList<>();
    @Override
    public List<Customer> findAll() {
              return customers;
    }

    @Override
    public void insert(Customer customer) {
        customer.setId(customer.toString());
        customers.add(customer);
    }

    @Override
    public void deleteById(String customerId) {
        Optional<Customer> customerToDelete = customers.stream()
                .filter(customer -> customer.getId().equals(customerId))
                .findFirst();
        customerToDelete.ifPresent(customers::remove);
    }
}
