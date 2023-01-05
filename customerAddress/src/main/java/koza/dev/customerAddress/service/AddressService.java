package koza.dev.customerAddress.service;

import koza.dev.customerAddress.dto.AddressDto;
import koza.dev.customerAddress.dto.AddressDtoConverter;
import koza.dev.customerAddress.dto.request.AddressSearchRequest;
import koza.dev.customerAddress.dto.request.CreateAddressRequest;
import koza.dev.customerAddress.dto.response.AddressListResponse;
import koza.dev.customerAddress.model.Address;
import koza.dev.customerAddress.model.Customer;
import koza.dev.customerAddress.repository.AddressRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressService {
    private final AddressRepository addressRepository;
    private final CustomerService customerService;

    private static final AddressDtoConverter addressDtoConverter = new AddressDtoConverter();

    public AddressService(AddressRepository addressRepository, CustomerService customerService) {
        this.addressRepository = addressRepository;
        this.customerService = customerService;
    }
    @Transactional
    public AddressListResponse createAddress(CreateAddressRequest createAddressRequest){
        Customer customer = customerService.loadCustomer(createAddressRequest.getId());
        final Address address = Address.builder()
                .customer(customer)
                .addressName(createAddressRequest.getAddressName())
                .city(createAddressRequest.getCity())
                .district(createAddressRequest.getDistrict())
                .build();
        final Address savedAddress = addressRepository.save(address);
        return AddressListResponse.builder()
                .customer(address.getCustomer())
                .id(savedAddress.getId())
                .addressName(savedAddress.getAddressName())
                .district(savedAddress.getDistrict())
                .city(savedAddress.getCity())
                .build();
    }

    public List<AddressDto> listAddress(Long id){
        return addressRepository.findById(id).stream().map(addressDtoConverter::convertToDto).collect(Collectors.toList());
    }


}
