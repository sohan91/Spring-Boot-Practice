package com.mvc.SpringMVC.entity;

public class Student {
    private String firstName;

    private String lastName;

    private String country;

    private String favLang;

    private String favSystem;
    
    public Student()
    {

    }

    public Student(String fName,String lName,String theCountry,String lang,String system)
    {
        this.firstName = fName;
        this.lastName = lName;
        this.country = theCountry;
        this.favLang = lang;
        this.favSystem = system;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFavLang() {
        return favLang;
    }

    public void setFavLang(String favLang) {
        this.favLang = favLang;
    }

    public String getFavSystem() {
        return favSystem;
    }

    public void setFavSystem(String favSystem) {
        this.favSystem = favSystem;
    }
}
