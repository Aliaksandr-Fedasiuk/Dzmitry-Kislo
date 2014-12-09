package com.kd.pack.model;

import javax.persistence.*;

import static javax.persistence.AccessType.FIELD;
import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by dima on 7.12.14.
 */
@Entity @Access(FIELD)
public class PersonalInfo {
    @GeneratedValue(strategy = IDENTITY)
    @Id Long id;

    int age;
    String description;
//    @OneToOne(cascade = {CascadeType.ALL}) @JoinColumn(name = "employee_id")
//    Employee employee;

    public PersonalInfo() {
    }

    public PersonalInfo(int age, String description) {
        this.age = age;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getDescription() {
        return description;
    }

//    public void setEmployee(Employee employee) {
//        this.employee = employee;
//    }
}
