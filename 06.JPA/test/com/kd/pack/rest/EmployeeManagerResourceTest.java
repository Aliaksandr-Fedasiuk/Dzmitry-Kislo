package com.kd.pack.rest;

import com.kd.pack.model.Address;
import com.kd.pack.model.Employee;
import com.kd.pack.repository.EmployeeRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.hamcrest.CoreMatchers.is;

/**
 * Created by dima on 7.12.14.
 */
public class EmployeeManagerResourceTest {
    EmployeeManagerResource resource = new EmployeeManagerResource();

    @Before
    public void initMocks() {
        resource.repo = mock(EmployeeRepository.class);
    }

    @Test
    public void createNewEmployeeTest() {
//        resource.createNewEmployee("Dima", "Brest");
//
//        ArgumentCaptor<Employee> captor = ArgumentCaptor.forClass(Employee.class);
//        verify(resource.repo).saveEmployee(captor.capture());
//
//        Employee employee = captor.getValue();
//        assertThat(employee.getName(), is("Dima"));
//        assertThat(employee.getAddress(), is(new Address("Brest")));
    }
}
