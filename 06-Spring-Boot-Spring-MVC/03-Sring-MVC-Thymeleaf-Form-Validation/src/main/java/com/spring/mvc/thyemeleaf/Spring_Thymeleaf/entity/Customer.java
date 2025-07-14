package com.spring.mvc.thyemeleaf.Spring_Thymeleaf.entity;

import com.spring.mvc.thyemeleaf.Spring_Thymeleaf.customvalidation.CustomValidation;
import jakarta.validation.constraints.*;

public class Customer {

    private String firstName;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String lastName;

    @NotNull(message = "is required")
    @Min(value = 0,message = "must be greater than or equal to zero")
    @Max(value = 100, message = "must be less than or equal to 100")
    private Integer freePasses;

    @Pattern(regexp="^[a-zA-Z0-9]{5}",message = "accepts 5 chars/digits")
    private String postalCode;

    @NotNull(message = "required")
    @CustomValidation(value = "myCode",message = "starts with myCode")
    private String courseCode;

    public Customer() {
    }

    public Customer(String fName, String lName,Integer freePasses,String postalCode,String courseCode) {
        this.firstName = fName;
        this.lastName = lName;
        this.freePasses = freePasses;
        this.postalCode = postalCode;
        this.courseCode = courseCode;
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
    public void setFreePasses(Integer freePasses)
    {
        this.freePasses = freePasses;
    }
    public Integer getFreePasses()
    {
        return freePasses;
    }
    public void setPostalCode(String postalCode)
    {
        this.postalCode = postalCode;
    }
    public String getPostalCode()
    {
        return postalCode;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
