package com;

public class Employee{
    private String id;
    private String name;
    private String gender;
    private String department;
    private String hireDate;

    // Getters và Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getHireDate() { return hireDate; }
    public void setHireDate(String hireDate) { this.hireDate = hireDate; }
    
    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", gender=" + gender +
               ", department=" + department + ", hireDate=" + hireDate + "]";
    }

}
