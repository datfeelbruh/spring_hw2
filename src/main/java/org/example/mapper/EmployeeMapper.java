package org.example.mapper;

import org.example.dao.EmployeeDao;
import org.example.dto.EmployeeDtoRq;
import org.example.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {
    @Autowired
    private EmployeeDao data;

    public Employee getEmployeeFromRequest(EmployeeDtoRq request) {
        return new Employee(request.getName(), request.getAge(), request.getSalary());
    }

    public EmployeeDtoRq getEmployeeFromDao(Integer id) {
        Employee employee = data.getEmployee(id);
        return new EmployeeDtoRq(employee.getName(), employee.getAge(), employee.getSalary());
    }
}
