package koza.dev.customerAddress.service;

import jdk.jfr.Category;
import koza.dev.customerAddress.dto.CustomerDto;
import koza.dev.customerAddress.exception.GenericException;
import koza.dev.customerAddress.model.Customer;
import koza.dev.customerAddress.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;


    public Customer loadCustomer(long Id){
        return customerRepository.findById(Id).orElseThrow();
    }

    public Customer saveRepository(Customer customer){
        return customerRepository.save(customer);
    }

    public CustomerDto createUser(Customer customer){
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        var savedCustomer =  customerRepository.save(customer);
        return CustomerDto.builder()
                .email(savedCustomer.getEmail())
                .build();
    }
    public CustomerDto getUser(String email){
        var savedCustomer =  findCustomerByEmail(email);
        return CustomerDto.builder()
                .email(savedCustomer.getEmail())
                .build();
    }


    public Customer findCustomerByEmail(String email){
        return customerRepository.findCustomerByEmail(email).orElseThrow(() -> GenericException.builder()
                .httpStatus(HttpStatus.NOT_FOUND)
                .errorMessage("Customer is not found.")
                .build());

    }

}
