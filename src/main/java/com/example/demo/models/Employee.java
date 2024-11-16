package com.example.demo.models;

import java.util.Objects;

public class Employee {

    final private String firstName;
    final private String lastName;
    final private int salary;
    final private int departmentID;

    public Employee(String firstName, String lastName, int salary, int departmentID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.departmentID = departmentID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {return firstName + " " + lastName;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    public int getSalary() {
        return salary;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", departmentID=" + departmentID +
                '}';
    }
}
