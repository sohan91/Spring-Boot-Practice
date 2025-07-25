package com.example.security.SecurityFlow.entity;

public class Student {

    private String name;
    private int id;
    private int marks;

    public Student()
    {

    }
    public Student(int id,String name,int marks)
    {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
}
