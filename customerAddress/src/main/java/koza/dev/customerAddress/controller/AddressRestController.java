package koza.dev.customerAddress.controller;

import koza.dev.customerAddress.dto.AddressDto;
import koza.dev.customerAddress.dto.request.AddressSearchRequest;
import koza.dev.customerAddress.dto.request.CreateAddressRequest;
import koza.dev.customerAddress.dto.response.AddressListResponse;
import koza.dev.customerAddress.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/address")
@RestController
@RequiredArgsConstructor
public class AddressRestController {
    private final AddressService addressService;

    @PostMapping("/save")
    public ResponseEntity<AddressListResponse> saveAddress(@RequestBody CreateAddressRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(addressService.createAddress(request));
    }
    @GetMapping("/list/{id}")
    public ResponseEntity<List<AddressDto>> listAddress(@PathVariable("id") Long id, @RequestBody AddressSearchRequest addressSearchRequest) throws ChangeSetPersister.NotFoundException {
        return ResponseEntity.ok(addressService.listAddress(id));
    }
}
