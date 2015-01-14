package com.epam.cdp.service;

import com.epam.cdp.domain.Employee;

import java.util.List;

/**
 * Created by dima on 14.1.15.
 */
public interface EmployeeService {

    public void addEmployee(Employee employee);

    public List<Employee> listEmployees();

    public Employee getEmployee(int empid);

    public void deleteEmployee(Employee employee);
}
