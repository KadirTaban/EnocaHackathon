package koza.dev.customerAddress.service;

import koza.dev.customerAddress.dto.TokenResponseDto;
import koza.dev.customerAddress.dto.request.LoginRequest;
import koza.dev.customerAddress.dto.request.SignUpRequest;
import koza.dev.customerAddress.exception.GenericException;
import koza.dev.customerAddress.model.Address;
import koza.dev.customerAddress.model.Customer;
import koza.dev.customerAddress.utils.TokenGenerator;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final CustomerService customerService;
    private final TokenGenerator tokenGenerator;
    private final AuthenticationManager authenticationManager;

    public AuthService(CustomerService customerService, TokenGenerator tokenGenerator, AuthenticationManager authenticationManager) {
        this.customerService = customerService;
        this.tokenGenerator = tokenGenerator;
        this.authenticationManager = authenticationManager;
    }


    public TokenResponseDto login(LoginRequest loginRequest){
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

            return TokenResponseDto.builder()
                    .accessToken(tokenGenerator.generateToken(authentication))
                    .customerDto(customerService.getUser(loginRequest.getEmail()))
                    .build();
        }catch (final BadCredentialsException badCredentialsException){
            throw GenericException.builder()
                    .httpStatus(HttpStatus.NOT_FOUND)
                    .errorMessage("invalid email or password")
                    .build();
        }
    }

    public void signUp(SignUpRequest signUpRequest){
        final Customer customer = Customer.builder()
                .email(signUpRequest.getEmail())
                .password(signUpRequest.getPassword())
                .build();
        customerService.createUser(customer);
    }
}
