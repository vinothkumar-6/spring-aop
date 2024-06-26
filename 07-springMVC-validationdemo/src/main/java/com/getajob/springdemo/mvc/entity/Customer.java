package com.getajob.springdemo.mvc.entity;

import com.getajob.springdemo.mvc.validation.VinothCode;
import jakarta.validation.constraints.*;

public class Customer {


    private String firstName;

    @NotNull(message = "is required")
    @Size(min=1, message = "is required")
    private String lastName;


    @Min(value = 0, message = "value must me greater than or equal to 0")
    @Max(value= 10,message = "value must me less than or equal to 10")
    @NotNull(message = "is required")
    private Integer freePasses;

    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "Only 5 character or Letters")
    private String postalCode;


    @VinothCode(value = "VINO", message = "must start with VINO")
    private String vinothCode;

    public String getVinothCode() {
        return vinothCode;
    }

    public void setVinothCode(String vinothCode) {
        this.vinothCode = vinothCode;
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

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
