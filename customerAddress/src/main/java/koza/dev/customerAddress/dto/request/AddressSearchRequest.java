package koza.dev.customerAddress.dto.request;

import lombok.Data;
import lombok.Getter;

@Getter
public class AddressSearchRequest {
    private Long id;
    private String addressName;
    private String city;
    private String district;

}
