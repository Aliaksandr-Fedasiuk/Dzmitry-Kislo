package com.kd.pack.repository;

import com.kd.pack.model.Address;
import com.kd.pack.model.Employee;
import org.junit.Before;
import org.junit.Test;
import org.springframework.orm.hibernate3.HibernateOperations;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by dima on 7.12.14.
 */
public class EmployeeRepositoryTest {
    EmployeeRepository repo = new EmployeeRepository();

    @Before
    public void initMocks() {
        repo.hibernate = mock(HibernateOperations.class);
    }

    @Test
    public void getAllEmployeesFromDBTest() {
        when(repo.hibernate.loadAll(Employee.class)).thenReturn(asList(new Employee("Dima", new Address("Brest"))));

        List<Employee> employeeList = repo.getAllEmployees();
        assertThat(employeeList.size(), is(1));
        assertThat(employeeList.get(0).getName(), is("Dima"));
    }
}
