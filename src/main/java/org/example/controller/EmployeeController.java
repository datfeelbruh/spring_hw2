package org.example.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dao.EmployeeDao;
import org.example.dto.EmployeeDtoRq;
import org.example.entities.Employee;
import org.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@Slf4j
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class EmployeeController {
    private EmployeeService service;

    @PostMapping(path = "/employee")
    public void createEmployee(@RequestBody EmployeeDtoRq request) {
        service.createEmployee(request);
    }

    @GetMapping(path = "/employee/{id}")
    public Employee getEmployee(@PathVariable Integer id) {
        return service.getEmployee(id);
    }

    @PatchMapping(path = "/employee/{id}")
    public Employee patchEmployee(@RequestBody EmployeeDtoRq request, @PathVariable Integer id) {
        return service.updateEmployee(id, request);
    }

    @DeleteMapping(path = "/employee/{id}")
    public Employee deleteEmployee(@PathVariable Integer id) {
        return service.deleteEmployee(id);
    }

    @GetMapping(path = "/employees")
    public Map<Integer, Employee> getEmployees() {
        return EmployeeDao.getEmployees();
    }
}
