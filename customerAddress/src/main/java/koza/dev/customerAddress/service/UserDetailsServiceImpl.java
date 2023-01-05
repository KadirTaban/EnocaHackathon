package koza.dev.customerAddress.service;

import koza.dev.customerAddress.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {
    private final CustomerService customerService;
    private final Collection<SimpleGrantedAuthority> authoritiesList;


    public UserDetailsServiceImpl(CustomerService customerService, Collection<SimpleGrantedAuthority> authoritiesList){
        this.customerService = customerService;
        this.authoritiesList = authoritiesList;
    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Customer customer = customerService.findCustomerByEmail(email);
        authoritiesList.add(new SimpleGrantedAuthority("USER"));
        return new org.springframework.security.core.userdetails.User(customer.getEmail(),customer.getPassword(),authoritiesList);


    }
}
