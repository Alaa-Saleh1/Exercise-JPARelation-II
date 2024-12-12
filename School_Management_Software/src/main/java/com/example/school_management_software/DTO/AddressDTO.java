package com.example.school_management_software.DTO;

import com.example.school_management_software.Model.Teacher;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {

    @NotNull(message = "address id must not be null")
    private Integer teacher_id;


    @NotEmpty(message = "area must not be empty")
    private String area;

    @NotEmpty(message = "street must not be empty")
    private String street;

    @NotNull(message = "building number must not be empty")
    @Positive(message = "building number must be positive number")
    private Integer buildingNumber;

}
