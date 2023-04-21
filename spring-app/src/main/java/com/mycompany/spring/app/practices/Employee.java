package com.mycompany.spring.app.practices;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan
public class Employee {

    private int employeeId;
    private String empName;
    private String email;
    private Department department;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Employee() {
        super();
    }

    public Employee(int employeeId, String empName, String email, Department department) {
        this.employeeId = employeeId;
        this.empName = empName;
        this.email = email;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" + "employeeId=" + employeeId + ", empName=" + empName + ", email=" + email + ", department=" + department + '}';
    }
}
