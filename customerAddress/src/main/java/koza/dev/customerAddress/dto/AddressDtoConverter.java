package koza.dev.customerAddress.dto;

import koza.dev.customerAddress.model.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressDtoConverter {

    public AddressDto convertToDto(Address from){
        return AddressDto.builder()
                .id(from.getId())
                .addressName(from.getAddressName())
                .city(from.getCity())
                .district(from.getDistrict())
                .build();

    }

}
