package com.kd.pack.model;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

import static javax.persistence.AccessType.FIELD;
import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by dima on 7.12.14.
 */
@NamedQuery(name = "findProjectById", query = "select p from Project p where p.id= :projectId")
@Entity @Access(FIELD)
public class Project {
    @GeneratedValue(strategy = IDENTITY)
    @Id Long id;

    String name;
    String description;
    @ManyToMany(mappedBy = "projects", fetch = FetchType.EAGER)
    Set<Employee> employees = new HashSet<Employee>();

    public Project() {
    }

    public Project(String name, String description) {
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

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }
}
