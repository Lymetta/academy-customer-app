package com.academy.service;

import com.academy.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerValidator {

    private final CountryCodeValidator countryCodeValidator = new CountryCodeValidator();
    private final CustomerAdultValidator customerAdultValidator = new CustomerAdultValidator();
    private final MandatoryCustomerValuesValidator mandatoryCustomerValuesValidator = new MandatoryCustomerValuesValidator();

    public void validate(Customer customer) {
        //isBlank - trims empty space and then checks if it's empty
        mandatoryCustomerValuesValidator.validate(customer);
        customerAdultValidator.validate(customer.getAge());
        countryCodeValidator.validate(customer.getCountryCode());

    }
}
