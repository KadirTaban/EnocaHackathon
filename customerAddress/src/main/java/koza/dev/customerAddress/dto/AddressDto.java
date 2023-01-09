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
public class AddressDto {
    private Long id;
    private String addressName;
    private String city;
    private String district;
    private CustomerDto customer;

}