package koza.dev.customerAddress.dto.response;

import koza.dev.customerAddress.model.Customer;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class AddressListResponse {
    private Long id;
    private String addressName;
    private String city;
    private String district;
    private Customer customer;
}
