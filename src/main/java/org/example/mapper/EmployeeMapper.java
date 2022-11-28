package org.example.mapper;

import org.example.dto.EmployeeDtoRq;
import org.example.entities.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {
    public Employee getEmployeeFromRequest(EmployeeDtoRq request) {
        return new Employee(request.getName(), request.getAge(), request.getSalary());
    }
}
