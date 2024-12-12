package com.example.school_management_software.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull ( message = "age must not be null")
    @Min(value = 23, message = "age must be at least 23")
    @Max(value = 65, message = "age must be below 65")
    @Column(nullable = false)
    private Integer age;

    @NotEmpty(message = "name must not be empty")
    @Column(nullable = false)
    private String name;

    @NotEmpty(message = "email must not be empty")
    @Email (message = "email format")
    @Column(nullable = false)
    private String email;

    @Positive (message = "salary must be positive number")
    @Column(nullable = false)
    private Double salary;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Address address;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher")
    private Set<Course> courses;

}
