package com.kd.pack.repository;

import com.kd.pack.model.Address;
import com.kd.pack.model.Employee;
import com.kd.pack.model.PersonalInfo;
import com.kd.pack.model.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateOperations;
import org.springframework.stereotype.Repository;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by dima on 7.12.14.
 */
@Repository
public class EmployeeRepository {
    @Autowired HibernateOperations hibernate;
    @Autowired UnitRepository unitRepository;
    @Autowired PersonalInfoRepository personalInfoRepository;

    public List<Employee> getAllEmployees() {
        return hibernate.loadAll(Employee.class);
    }

    public Long saveEmployee(Employee employee, PersonalInfo personalInfo) {
        if (employee.getUnit() == null) {
            Unit unit = unitRepository.findUnitById(1L);
            employee.setUnit(unit);
        }
        hibernate.saveOrUpdate(employee);
        personalInfoRepository.savePersonalInfo(personalInfo, employee.getId());
        return employee.getId();
    }

    public Employee findEmployeeById(Long id) {
        if (id != null) {
            try {
                return (Employee) hibernate.findByNamedQueryAndNamedParam("findEmployeeById", "employeeId", id).get(0);
            } catch (IndexOutOfBoundsException e) {
                return null;
            }
        } else {
            return null;
        }
    }

    public void deleteEmployee(Long id) {
        Employee delEmpl = findEmployeeById(id);
        if (delEmpl != null) {
            hibernate.delete(delEmpl);
        }
    }
}
