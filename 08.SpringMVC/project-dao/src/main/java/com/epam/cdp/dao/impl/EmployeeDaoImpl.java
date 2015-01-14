package com.epam.cdp.dao.impl;

import com.epam.cdp.dao.EmployeeDao;
import com.epam.cdp.domain.Employee;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

/**
 * Created by dima on 14.1.15.
 */
@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public void addEmployee(Employee employee) {

    }

    @Override
    public List<Employee> getAllEmploees() {
        return Arrays.asList(new Employee(1, "Stive Anders", "New York", 1000L, 25));
    }

    @Override
    public Employee getEmployeeById(int empid) {
        return new Employee();
    }

    @Override
    public void deleteEmployee(Employee employee) {

    }
}
