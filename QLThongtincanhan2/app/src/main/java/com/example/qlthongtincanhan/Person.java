package com.example.qlthongtincanhan;

import java.io.Serializable;

public class Person implements Serializable {
    private String id,name,PhoneNumber,address,country;

    public Person(String id, String name, String phoneNumber, String address, String country) {
        this.id = id;
        this.name = name;
        PhoneNumber = phoneNumber;
        this.address = address;
        this.country = country;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getCountry() {
        return country;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
