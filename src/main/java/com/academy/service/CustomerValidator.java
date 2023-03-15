package com.academy.service;

import com.academy.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerValidator {

    private CountryCodeValidator countryCodeValidator = new CountryCodeValidator();
    private CustomerAdultValidator customerAdultValidator = new CustomerAdultValidator();
    private MandatoryCustomerValuesValidator mandatoryCustomerValuesValidator = new MandatoryCustomerValuesValidator();

    public void validate(Customer customer) {
        //isBlank - trims empty space and then checks if it's empty
        mandatoryCustomerValuesValidator.validate(customer.getFirstName());
        mandatoryCustomerValuesValidator.validate(customer.getLastName());
        mandatoryCustomerValuesValidator.validate(customer.getPersonalNumber());
        customerAdultValidator.validate(customer.getAge());
        countryCodeValidator.validate(customer.getCountryCode());

    }
}
