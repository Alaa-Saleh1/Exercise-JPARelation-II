package com.example.school_management_software.Service;

import com.example.school_management_software.ApiResponse.ApiException;
import com.example.school_management_software.DTO.AddressDTO;
import com.example.school_management_software.Model.Address;
import com.example.school_management_software.Model.Teacher;
import com.example.school_management_software.Repository.AddressRepository;
import com.example.school_management_software.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;


    public List<Address> getAllAddress(){
        return addressRepository.findAll();
    }

    public void addTeacherAddress(AddressDTO addressDTO){
        Teacher teacher= teacherRepository.findTeacherById(addressDTO.getTeacher_id());
        if(teacher == null){
            throw new ApiException("Teacher Not Found");
        }
        Address address = new Address(null,addressDTO.getArea(),addressDTO.getStreet(),addressDTO.getBuildingNumber(),teacher);
        addressRepository.save(address);

    }


    public void updateTeacherAddress(AddressDTO addressDTO){
        Address oldAddress = addressRepository.findAddressById(addressDTO.getTeacher_id());
        if(oldAddress == null){
            throw new ApiException("Teacher Not Found");
        }
        oldAddress.setArea(addressDTO.getArea());
        oldAddress.setStreet(addressDTO.getStreet());
        oldAddress.setBuildingNumber(addressDTO.getBuildingNumber());
        addressRepository.save(oldAddress);
    }

    public void deleteTeacherAddress(AddressDTO addressDTO){
        Address address = addressRepository.findAddressById(addressDTO.getTeacher_id());
        Teacher teacher= teacherRepository.findTeacherById(addressDTO.getTeacher_id());
        if(address == null){
            throw new ApiException("Address Not Found");
        }
        if(teacher == null){
            throw new ApiException("Teacher Not Found");
        }
        teacher.setAddress(null);
        teacherRepository.save(teacher);
        addressRepository.delete(address);

    }
}
