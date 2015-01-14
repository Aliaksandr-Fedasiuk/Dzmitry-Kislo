package com.epam.cdp.dao;

import com.epam.cdp.domain.Employee;

import java.util.List;

/**
 * Created by dima on 14.1.15.
 */
public interface EmployeeDao {

    public void addEmployee(Employee employee);

    public List<Employee> getAllEmploees();

    public Employee getEmployeeById(int empid);

    public void deleteEmployee(Employee employee);
}
