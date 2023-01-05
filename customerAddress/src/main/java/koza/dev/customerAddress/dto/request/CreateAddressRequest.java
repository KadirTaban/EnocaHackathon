package koza.dev.customerAddress.dto.request;

import koza.dev.customerAddress.dto.CustomerDto;
import koza.dev.customerAddress.model.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CreateAddressRequest {
    private Long id;
    @NotBlank(message = "address not be empty")
    private String addressName;
    @NotEmpty
    private String city;
    @NotEmpty
    private String district;
    private CustomerDto customer;

}
