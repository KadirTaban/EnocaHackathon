package koza.dev.customerAddress.dto.response;

import koza.dev.customerAddress.model.Customer;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class AddressListResponse {
    private Long id;
    private String addressName;
    private String city;
    private String district;
    private long customerId;
}