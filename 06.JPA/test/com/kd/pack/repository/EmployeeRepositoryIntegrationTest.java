package com.kd.pack.repository;

import com.kd.pack.model.*;
import org.hibernate.dialect.H2Dialect;
import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.matchers.Any;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by dzmitry on 9.12.14.
 */
public class EmployeeRepositoryIntegrationTest {
    DataSource dataSource;
    EmployeeRepository repo = new EmployeeRepository();
    UnitRepository unitRepository = new UnitRepository();
    PersonalInfoRepository personalInfoRepository = new PersonalInfoRepository();

    @Before
    public void setUp() throws Exception {
        dataSource = new DriverManagerDataSource("jdbc:h2:mem:hibernate;DB_CLOSE_DELAY=-1", "sa", "");

        System.setProperty("hibernate.dialect", H2Dialect.class.getName());
        System.setProperty("hibernate.hbm2ddl.auto", "create-drop");
        AnnotationSessionFactoryBean sessionFactory = new AnnotationSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setAnnotatedClasses(new Class[]{Employee.class, Address.class, Unit.class, Project.class, PersonalInfo.class});
        sessionFactory.afterPropertiesSet();

        repo.hibernate = unitRepository.hibernate = personalInfoRepository.hibernate = new HibernateTemplate(sessionFactory.getObject());
        repo.unitRepository = unitRepository;
    }

    @Test
    public void getAllEmployeesTest() throws Exception {
        dataSource.getConnection().createStatement()
                .execute("insert into Employee (id, name, city, status) values (1, 'Dima', 'Brest', 'MANAGER')");

        List<Employee> employees = repo.getAllEmployees();
        assertThat(employees.size(), is(1));

        Employee employee = employees.get(0);
        assertThat(employee.getName(), is("Dima"));
        assertThat(employee.getAddress().getCity(), is("Brest"));
    }

    @Test
    public void fullCycle() throws SQLException {
        dataSource.getConnection().createStatement()
                .execute("insert into Unit (id, name, description) values (1, 'Test-Unit', 'Test-Unit-description')");

        Unit unit = new Unit("Unit-test-name", "Unit-test-description");
        unit.setId(1L);
//        repo.unitRepository = mock(UnitRepository.class);
//        when(repo.unitRepository.findUnitById(anyLong())).thenReturn(new Unit("Unit-test-name", "Unit-test-description"));

        Employee employee = new Employee("Alex", new Address("Minsk"));
        PersonalInfo personalInfo = new PersonalInfo(25, "description_test");
        repo.saveEmployee(employee, personalInfo);
        repo.hibernate.clear();

        Employee employeeById = repo.findEmployeeById(1L);
        assertThat(employee.getName(), is("Alex"));
        assertThat(employee.getPersonalInfo().getAge(), is(25));
        assertThat(employee.getUnit().getName(), is("Test-Unit"));

        List<Employee> employees = repo.getAllEmployees();
        assertThat(employees.size(), is(1));
    }

    @Test
    public void deleteTest() throws SQLException {
        dataSource.getConnection().createStatement()
                .execute("insert into PersonalInfo (id, age, description) values (1, 25, 'Test-Info-description')");
        dataSource.getConnection().createStatement()
                .execute("insert into Unit (id, name, description) values (1, 'Test-Unit', 'Test-Unit-description')");
        dataSource.getConnection().createStatement()
                .execute("insert into Employee (id, name, city, status, unit_id, info_id) values (1, 'Dima', 'Brest', 'MANAGER', 1, 1)");

        List<Employee> employeesBeforeDel = repo.getAllEmployees();
        assertThat(employeesBeforeDel.size(), is(1));

        List<PersonalInfo> allPersonalInfoBefore = personalInfoRepository.getAllPersonalInfo();
        assertThat(allPersonalInfoBefore.size(), is(1));

        Unit unitByIdBefore = unitRepository.findUnitById(1L);
        assertNotNull(unitByIdBefore);

        repo.deleteEmployee(1L);

        List<Employee> employeesAfterDel = repo.getAllEmployees();
        assertThat(employeesAfterDel.size(), is(0));

        List<PersonalInfo> allPersonalInfoAfter = personalInfoRepository.getAllPersonalInfo();
        assertThat(allPersonalInfoAfter.size(), is(0));

        Unit unitByIdAfter = unitRepository.findUnitById(1L);
        assertNotNull(unitByIdAfter);


    }


}
