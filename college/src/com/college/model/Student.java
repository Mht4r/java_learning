package com.college.model;

public class Student {
    private String name;
    private int age;
    private String branch;

    public Student() {}

    public Student(String name, int age, String branch) {
        this.name = name;
        this.age = age;
        this.branch = branch;
    }


    public String getName() { return name; }
    public int getAge() { return age; }
    public String getBranch() { return branch; }

    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setBranch(String branch) { this.branch = branch; }
}
