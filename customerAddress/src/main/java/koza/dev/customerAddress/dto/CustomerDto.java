package koza.dev.customerAddress.dto;

import koza.dev.customerAddress.model.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
    private Long id;
    private String email;
    private String password;
    private Set<Address> addresses;
}
