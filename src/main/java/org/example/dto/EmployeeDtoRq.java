package org.example.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class EmployeeDtoRq {
    @NonNull
    private String name;
    @NonNull
    private Integer age;
    @NonNull
    private Double salary;
}
