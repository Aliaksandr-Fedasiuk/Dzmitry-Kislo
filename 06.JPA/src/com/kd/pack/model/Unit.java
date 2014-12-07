package com.kd.pack.model;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

import static javax.persistence.AccessType.FIELD;
import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by dima on 7.12.14.
 */
@NamedQuery(name = "findUnitById", query = "select u from Unit u where u.id= :unitId")
@Entity @Access(FIELD)
public class Unit {
    @GeneratedValue(strategy = IDENTITY)
    @Id Long id;

    String name;
    String description;
//    @OneToMany(mappedBy = "unit", fetch=FetchType.EAGER)
//    Set<Employee> employees = new HashSet<Employee>();

    public Unit() {
    }

    public Unit(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

//    public void addEmployee(Employee employee) {
//        employee.unit = this;
//        employees.add(employee);
//    }
}
