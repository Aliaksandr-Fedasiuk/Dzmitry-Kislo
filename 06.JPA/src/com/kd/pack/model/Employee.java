package com.kd.pack.model;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

import static javax.persistence.AccessType.*;
import static javax.persistence.GenerationType.*;

/**
 * Created by dima on 7.12.14.
 */
@NamedQuery(name = "findEmployeeById", query = "select e from Employee e where e.id= :employeeId")
@Entity @Access(FIELD)
public class Employee {
    @GeneratedValue(strategy = IDENTITY)
    @Id Long id;

    String name;
    Address address;
    @Enumerated(EnumType.STRING)
    EmployeeStatus status;
    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinTable(name = "Employee_Project",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id"))
    Set<Project> projects= new HashSet<Project>();
    @ManyToOne(cascade= {CascadeType.REFRESH}, fetch=FetchType.EAGER)
    @JoinColumn(name="unit_id")
    Unit unit;

    @OneToOne(cascade = {CascadeType.ALL}) @JoinColumn(name = "info_id")
    PersonalInfo personalInfo;

    public Employee() {
    }

    public Employee(String name, Address address) {
        this.name = name;
        this.address = address;
        this.status = EmployeeStatus.EMPLOYEE;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public EmployeeStatus getStatus() {
        return status;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setPersonalInfo(PersonalInfo personalInfo) {
        this.personalInfo = personalInfo;
    }

    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    public void addProject(Project project) {
        project.addEmployee(this);
        projects.add(project);
    }
}
