package com.epam.cdp.service.impl;

import com.epam.cdp.dao.EmployeeDao;
import com.epam.cdp.domain.Employee;
import com.epam.cdp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by dima on 14.1.15.
 */
@Service("employeeService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public void addEmployee(Employee employee) {
        employeeDao.addEmployee(employee);
    }

    @Override
    public List<Employee> listEmployees() {
        return employeeDao.getAllEmploees();
    }

    @Override
    public Employee getEmployee(int empid) {
        return employeeDao.getEmployeeById(empid);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        employeeDao.deleteEmployee(employee);
    }
}
