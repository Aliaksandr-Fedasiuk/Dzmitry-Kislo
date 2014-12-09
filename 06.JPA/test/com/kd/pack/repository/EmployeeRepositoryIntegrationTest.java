package com.kd.pack.repository;

import com.kd.pack.model.*;
import org.hibernate.dialect.H2Dialect;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;

import javax.sql.DataSource;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
/**
 * Created by dzmitry on 9.12.14.
 */
public class EmployeeRepositoryIntegrationTest {
    DataSource dataSource;
    EmployeeRepository repo = new EmployeeRepository();

    @Before
    public void setUp() throws Exception {
        dataSource = new DriverManagerDataSource("jdbc:h2:mem:hibernate;DB_CLOSE_DELAY=-1", "sa", "");

        System.setProperty("hibernate.dialect", H2Dialect.class.getName());
        System.setProperty("hibernate.hbm2ddl.auto", "create-drop");
        AnnotationSessionFactoryBean sessionFactory = new AnnotationSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setAnnotatedClasses(new Class[]{Employee.class, Address.class, Unit.class, Project.class, PersonalInfo.class});
        sessionFactory.afterPropertiesSet();

        repo.hibernate = new HibernateTemplate(sessionFactory.getObject());
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

}
