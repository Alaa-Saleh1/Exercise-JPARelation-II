package com.example.school_management_software.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "area must not be empty")
    @Column(nullable = false)
    private String area;

    @NotEmpty(message = "street must not be empty")
    @Column(nullable = false)
    private String street;

    @NotNull (message = "building number must not be empty")
    @Positive (message = "building number must be positive number")
    @Column(nullable = false)
    private Integer buildingNumber;

    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher;
}
