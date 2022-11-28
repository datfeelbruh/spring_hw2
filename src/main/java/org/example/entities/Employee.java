package org.example.entities;

import lombok.Data;
import lombok.NonNull;


@Data
public class Employee {
    @NonNull
    private String name;
    @NonNull
    private Integer age;
    @NonNull
    private Double salary;
}
