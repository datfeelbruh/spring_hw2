package org.example.dao;

import org.example.entities.Employee;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class EmployeeDao {
    private static int employeeId = 1;
    private static Map<Integer, Employee> employees = new HashMap<>();

    private static int getNextId() {
        return employeeId++;
    }

    public void createEmployee(Employee employee) {
        employees.put(getNextId(), employee);
    }

    public Employee getEmployee(Integer id) {
        return employees.getOrDefault(id, null);
    }

    public Employee updateEmployee(Integer id, Employee employee) {
        Employee updatedEmployee = employees.get(id);
        updatedEmployee.setName(employee.getName());
        updatedEmployee.setAge(employee.getAge());
        updatedEmployee.setSalary(employee.getSalary());

        return updatedEmployee;
    }

    public Employee deleteEmployee(Integer id) {
        Employee deletedEmployee = getEmployee(id);
        employees.remove(id);
        return deletedEmployee;
    }

    public static Map<Integer, Employee> getEmployees() {
        return employees;
    }
}
