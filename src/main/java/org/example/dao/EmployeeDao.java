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

    public void updateEmployee(Integer id, Employee employee) {
        Employee updatedEmployee = employees.get(id);
        updatedEmployee.setName(employee.getName());
        updatedEmployee.setAge(employee.getAge());
        updatedEmployee.setSalary(employee.getSalary());
    }

    public void deleteEmployee(Integer id) {
        employees.remove(id);
    }

    public static Map<Integer, Employee> getEmployees() {
        return employees;
    }
}
