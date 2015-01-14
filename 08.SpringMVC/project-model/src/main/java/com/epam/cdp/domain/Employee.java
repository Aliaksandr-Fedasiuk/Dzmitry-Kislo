package com.epam.cdp.domain;

/**
 * Created by dima on 14.1.15.
 */
public class Employee {

    private Integer empId;
    private String empName;
    private String empAddress;
    private Long salary;
    private Integer empAge;

    public Employee() {
    }

    public Employee(Integer empId, String empName, String empAddress, Long salary, Integer empAge) {
        this.empId = empId;
        this.empName = empName;
        this.empAddress = empAddress;
        this.salary = salary;
        this.empAge = empAge;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpAddress() {
        return empAddress;
    }

    public void setEmpAddress(String empAddress) {
        this.empAddress = empAddress;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public Integer getEmpAge() {
        return empAge;
    }

    public void setEmpAge(Integer empAge) {
        this.empAge = empAge;
    }
}
