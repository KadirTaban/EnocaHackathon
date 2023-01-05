package koza.dev.customerAddress.config;


import koza.dev.customerAddress.model.Customer;
import koza.dev.customerAddress.service.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupConfig implements CommandLineRunner {
    private final CustomerService customerService;

    public StartupConfig(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public void run(String... args)throws Exception{
        customerService.createUser(Customer.builder().email("kadir@kadir.com").password("1234qwer").build());
    }
}
