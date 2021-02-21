package com.wt.pojo;

import java.util.Date;

public class Employee {
    private int id;
    private String lastName;
    private String Email;
    private int gender;
    private Department department;
    private Date birth;

    public Employee(int id, String lastName, String email, int gender, Department department, Date birth) {
        this.id = id;
        this.lastName = lastName;
        Email = email;
        this.gender = gender;
        this.department = department;
        this.birth = birth;
    }

    public Employee() {
    }

    public Employee(String lastName, String email, int gender, Department department, Date birth) {
        this.lastName = lastName;
        Email = email;
        this.gender = gender;
        this.department = department;
        this.birth = birth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", Email='" + Email + '\'' +
                ", gender=" + gender +
                ", department=" + department +
                ", birth=" + birth +
                '}';
    }
}
