package org.example.service;

import org.example.dao.EmployeeDao;
import org.example.dto.EmployeeDtoRq;
import org.example.entities.Employee;
import org.example.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeService {
    @Autowired
    private EmployeeDao data;
    @Autowired
    private EmployeeMapper mapper;

    public void createEmployee(EmployeeDtoRq request) {
        Employee employee = mapper.getEmployeeFromRequest(request);
        data.createEmployee(employee);
    }

    public void getEmployee(Integer id) {
        mapper.getEmployeeFromDao(id);
    }

    public void deleteEmployee(Integer id) {
        data.deleteEmployee(id);
    }

    public void updateEmployee(Integer id, EmployeeDtoRq request) {
        Employee employee = mapper.getEmployeeFromRequest(request);
        data.updateEmployee(id, employee);
    }
}
