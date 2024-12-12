package com.example.school_management_software.Controller;

import com.example.school_management_software.ApiResponse.ApiResponse;
import com.example.school_management_software.DTO.AddressDTO;
import com.example.school_management_software.Model.Address;
import com.example.school_management_software.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/address")
public class AddressController {
    private final AddressService addressService;



    @GetMapping("/get")
    public ResponseEntity<?> getAllAddress() {
        List<Address> addressList = addressService.getAllAddress();
        return ResponseEntity.status(200).body(addressList);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addAddress(@RequestBody @Valid AddressDTO address) {
        addressService.addTeacherAddress(address);
        return ResponseEntity.status(200).body(new ApiResponse("address added successfully"));
    }


    @PutMapping("/update")
    public ResponseEntity<?> updateAddress(@RequestBody @Valid AddressDTO address) {
        addressService.updateTeacherAddress(address);
        return ResponseEntity.status(200).body(new ApiResponse("address updated successfully"));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteAddress(@RequestBody @Valid AddressDTO address) {
        addressService.deleteTeacherAddress(address);
        return ResponseEntity.status(200).body(new ApiResponse("address deleted successfully"));
    }



}
