package org.example.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dao.EmployeeDao;
import org.example.dto.EmployeeDtoRq;
import org.example.entities.Employee;
import org.example.mapper.EmployeeMapper;
import org.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@Slf4j
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class EmployeeController {

    private EmployeeMapper mapper;
    private EmployeeService service;

    @PostMapping(path = "/employee")
    public void createEmployee(@RequestBody EmployeeDtoRq request) {
        service.createEmployee(request);
    }

    @GetMapping(path = "/employee/{id}")
    public void getEmployee(@PathVariable Integer id) {
        service.getEmployee(id);
    }

    @PatchMapping(path = "/employee/{id}")
    public void patchEmployee(@RequestBody EmployeeDtoRq request, @PathVariable Integer id) {
        service.updateEmployee(id, request);
    }

    @DeleteMapping(path = "/employee/{id}")
    public void deleteEmployee(@PathVariable Integer id) {
        service.deleteEmployee(id);
    }

    @GetMapping(path = "/employees")
    public Map<Integer, Employee> getEmployees() {
        return EmployeeDao.getEmployees();
    }
}
